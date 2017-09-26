package com.rotato.gui.model;

public class Hotkey {
	private String name = "Not Set";
	private String action;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
