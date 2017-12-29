package com.rotato.aim;

import org.jnativehook.keyboard.NativeKeyEvent;

@FunctionalInterface
public interface KeyPressTask {
	void run(NativeKeyEvent e);
}
