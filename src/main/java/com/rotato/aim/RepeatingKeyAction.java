package com.rotato.aim;

import java.awt.AWTException;

import org.jnativehook.keyboard.NativeKeyEvent;

public class RepeatingKeyAction extends KeyAction {
	RampFunction rampUp;

	public RepeatingKeyAction(Runnable action, int keycode, RampFunction ramp) throws AWTException {
		super(action, keycode);

		rampUp = ramp;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			int speed = rampUp.current();
			for (int x = 0; x < speed; x++) {
				action.run();
			}

			rampUp.increase();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (e.getKeyCode() == keycode) {
			rampUp.reset();
		}
	}

}
