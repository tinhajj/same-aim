package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyAction implements NativeKeyListener {
	private Runnable action;
	private int keycode;

	public KeyAction(Runnable action, int keycode) throws AWTException {
		this.action = action;
		this.keycode = keycode;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			action.run();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}

	public void setKeycode(int k) {
		this.keycode = k;
	}
}
