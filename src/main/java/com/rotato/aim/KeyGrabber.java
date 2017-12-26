package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyGrabber implements NativeKeyListener {
	private KeypressTaskFunction task;

	public KeyGrabber(KeypressTaskFunction task) throws AWTException {
		this.task = task;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		task.run(e);
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}
}