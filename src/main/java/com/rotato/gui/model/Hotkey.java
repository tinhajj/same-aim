package com.rotato.gui.model;

import java.util.HashMap;

public class Hotkey {
	private HashMap<String, String> Hotkeys = new HashMap<String, String>();
	private String action;

	public void setKey(String key, String name) {
		Hotkeys.put(key, name);
	}

	public String getAction(String key) {
		return Hotkeys.get(key);
	}

	public void setAction(String key, String action) {
		Hotkeys.put(key, action);
	}
}
