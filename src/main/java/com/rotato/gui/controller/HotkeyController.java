package com.rotato.gui.controller;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

	// This is a little brittle, but should be good enough.
	// A functional interface might make more sense here for integrity.
	private Method previousTranslate;
	private Method previousIncrement;
	private int previousDirection;

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
		this.model.setAction("Reset Counter", resetCounter(3667));
		this.model.setAction("Move Reverse", moveReverse(14));
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

				this.previousTranslate = Mouse.class.getMethod("translateX", int.class);
				this.previousIncrement = CounterController.class.getMethod("incrementLeftCounter", int.class);
				this.previousDirection = -1;
			} catch (InterruptedException | NoSuchMethodException | SecurityException e) {
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

				this.previousTranslate = Mouse.class.getMethod("translateY", int.class);
				this.previousIncrement = CounterController.class.getMethod("incrementDownCounter", int.class);
				this.previousDirection = 1;
			} catch (InterruptedException | NoSuchMethodException | SecurityException e) {
				System.out.println("Interrupted during move");
			}
		};
		return new KeyAction(action, resetAction(), keyCode);
	}

	private KeyAction moveReverse(int keyCode) throws AWTException {
		Runnable action = () -> {
			try {
				if (this.previousIncrement == null | this.previousTranslate == null) {
					return;
				}

				int delta = (int) previousTranslate.invoke(Mouse.class, this.previousDirection * -1);
				Mouse.increaseMultiplier();

				this.previousIncrement.invoke(counterController, delta * -1);
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
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