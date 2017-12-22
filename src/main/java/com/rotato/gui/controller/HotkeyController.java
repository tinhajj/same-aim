package com.rotato.gui.controller;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.rotato.aim.KeyGrabber;
import com.rotato.gui.model.Hotkey;
import com.rotato.gui.view.HotkeyView;

public class HotkeyController {
	private Hotkey model;
	private HotkeyView view;

	public HotkeyController(Hotkey model, HotkeyView view) {
		this.model = model;
		this.view = view;

		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		logger.setUseParentHandlers(false);

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		this.view.addHotkeyListener(new HotkeyListener());
	}

	class HotkeyListener implements ActionListener {
		private KeyGrabber grabber;

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				GlobalScreen.addNativeKeyListener(new KeyGrabber());
			} catch (AWTException g) {
				// TODO Auto-generated catch block
				g.printStackTrace();
			}
		}
	}
}