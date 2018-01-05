package com.rotato.gui.controller;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.rotato.aim.KeyAction;
import com.rotato.aim.KeyGrabber;
import com.rotato.aim.KeyPressTask;
import com.rotato.aim.Mouse;
import com.rotato.gui.model.Hotkey;
import com.rotato.gui.view.HotkeyView;

public class HotkeyController {
	private Hotkey model;
	private HotkeyView view;
	private KeyGrabber grabber;
	private CounterController counterController;

	public HotkeyController(Hotkey model, HotkeyView view, CounterController counterController) throws AWTException {
		this.model = model;
		this.view = view;
		this.counterController = counterController;

		initModel();
		initListeners();
		Mouse.setMaxMultiplier(10);

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		this.grabber = new KeyGrabber(updateHotkey());
		this.view.addHotkeyListener(new HotkeyListener(grabber));
		this.view.addDialogCloseListener(new CloseDialogListener());
	}

	// Setup model's hashmap. A not so great way of defining which buttons
	// are related to a specific action.
	private void initModel() throws AWTException {
		this.model.setAction("Move Left", moveLeft(57419));
		this.model.setAction("Move Down", moveDown(57424));
		this.model.setAction("Reset Counter", resetCounter(14));
	}

	private void initListeners() {
		Collection<KeyAction> actions = this.model.getAllActions();
		for (KeyAction action : actions) {
			GlobalScreen.addNativeKeyListener(action);
		}
	}

	private KeyPressTask updateHotkey() {
		KeyPressTask update = (e) -> {
			String key = this.view.getDialogText();
			KeyAction action = this.model.getAction(key);
			action.setKeycode(e.getKeyCode());
			cleanDialog();
		};

		return update;
	}

	private KeyAction resetCounter(int keyCode) throws AWTException {
		Runnable action = () -> {
			counterController.setCounters(0, 0);
		};
		return new KeyAction(action, keyCode);
	}

	private KeyAction moveLeft(int keyCode) throws AWTException {
		Runnable action = () -> {
			try {
				int delta = Mouse.translateX(-1);
				Mouse.increaseMultiplier();

				counterController.incrementLeftCounter(delta);
			} catch (InterruptedException e) {
				System.out.println("Interrupted during move");
			}
		};
		return new KeyAction(action, resetAction(), keyCode);
	}

	private KeyAction moveDown(int keyCode) throws AWTException {
		Runnable action = () -> {
			try {
				int delta = Mouse.translateY(1);
				Mouse.increaseMultiplier();

				counterController.incrementDownCounter(delta);
			} catch (InterruptedException e) {
				System.out.println("Interrupted during move");
			}
		};
		return new KeyAction(action, resetAction(), keyCode);
	}

	private Runnable resetAction() {
		Runnable action = () -> {
			Mouse.resetMultiplier();
		};

		return action;
	}

	private void cleanDialog() {
		view.hideDialog();
		GlobalScreen.removeNativeKeyListener(grabber);
	}

	class CloseDialogListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			cleanDialog();
		}
	}

	class HotkeyListener implements ActionListener {
		private KeyGrabber grabber;

		public HotkeyListener(KeyGrabber grabber) {
			this.grabber = grabber;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			GlobalScreen.addNativeKeyListener(grabber);
		}
	}
}