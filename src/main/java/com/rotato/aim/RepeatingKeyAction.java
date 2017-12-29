package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;

public class RepeatingKeyAction extends KeyAction {
	RampUpFunction rampUp;

	public RepeatingKeyAction(Runnable action, int keycode, RampUpFunction ramp)
			throws AWTException {
		super(action, keycode);

		rampUp = ramp;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			int speed = rampUp.getSpeed();
			for (int x = 0; x < speed; x++) {
				action.run();
			}

			rampUp.faster();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			rampUp.resetSpeed();
		}
	}

}
