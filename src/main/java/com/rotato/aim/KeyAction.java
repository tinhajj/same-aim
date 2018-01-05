package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyAction implements NativeKeyListener {
	protected Runnable pressAction;
	protected Runnable releaseAction;
	protected int keycode;

	public KeyAction(Runnable pressAction, Runnable releaseAction, int keycode) throws AWTException {
		this.pressAction = pressAction;
		this.releaseAction = releaseAction;
		this.keycode = keycode;
	}

	public KeyAction(Runnable pressAction, int keycode) throws AWTException {
		this.pressAction = pressAction;
		this.keycode = keycode;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			pressAction.run();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (releaseAction != null) {
			if (e.getKeyCode() == keycode) {
				releaseAction.run();
			}
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
	}

	public void setKeycode(int k) {
		this.keycode = k;
	}
}
