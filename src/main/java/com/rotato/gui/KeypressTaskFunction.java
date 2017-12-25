package com.rotato.gui;

import org.jnativehook.keyboard.NativeKeyEvent;

@FunctionalInterface
public interface KeypressTaskFunction {
	void run(NativeKeyEvent e);
}
