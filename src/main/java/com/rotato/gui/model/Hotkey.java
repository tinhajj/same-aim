package com.rotato.gui.model;

import java.util.Collection;
import java.util.HashMap;

import com.rotato.aim.KeyAction;

public class Hotkey {
	private HashMap<String, KeyAction> Hotkeys = new HashMap<String, KeyAction>();

	public void setKey(String key, KeyAction action) {
		Hotkeys.put(key, action);
	}

	public KeyAction getAction(String key) {
		return Hotkeys.get(key);
	}

	public Collection<KeyAction> getAllActions() {
		return Hotkeys.values();
	}

	public void setAction(String key, KeyAction action) {
		Hotkeys.put(key, action);
	}
}
