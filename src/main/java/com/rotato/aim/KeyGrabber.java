package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyGrabber implements NativeKeyListener {
	private Runnable task;

	public KeyGrabber(Runnable task) throws AWTException {
		this.task = task;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		e.getKeyCode();
		task.run();
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}
}