package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyGrabber implements NativeKeyListener {
	public KeyGrabber() throws AWTException {
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		e.getKeyCode();
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}
}