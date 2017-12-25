package com.rotato.gui.controller;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.rotato.aim.KeyGrabber;
import com.rotato.gui.KeypressTaskFunction;
import com.rotato.gui.model.Hotkey;
import com.rotato.gui.view.HotkeyView;

public class HotkeyController {
	private Hotkey model;
	private HotkeyView view;
	private KeyGrabber grabber;

	public HotkeyController(Hotkey model, HotkeyView view) throws AWTException {
		this.model = model;
		this.view = view;

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

	private KeypressTaskFunction updateHotkey() {
		KeypressTaskFunction update = (e) -> {
			// update model
			cleanDialog();
		};

		return update;
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