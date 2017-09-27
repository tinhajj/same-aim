package com.rotato.gui.controller;

import com.rotato.gui.model.Hotkey;
import com.rotato.gui.view.HotkeyView;

public class HotkeyController {
	private Hotkey model;
	private HotkeyView view;

	public HotkeyController(Hotkey model, HotkeyView view) {
		this.model = model;
		this.view = view;
	}
}