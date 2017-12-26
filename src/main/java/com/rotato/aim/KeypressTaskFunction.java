package com.rotato.aim;

import org.jnativehook.keyboard.NativeKeyEvent;

@FunctionalInterface
public interface KeypressTaskFunction {
	void run(NativeKeyEvent e);
}
