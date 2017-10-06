package com.rotato.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rotato.gui.model.Hotkey;
import com.rotato.gui.view.HotkeyView;

public class HotkeyController {
	private Hotkey model;
	private HotkeyView view;

	public HotkeyController(Hotkey model, HotkeyView view) {
		this.model = model;
		this.view = view;
	}

	class HotkeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Boiler Plate");
		}

	}
}