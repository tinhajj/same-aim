package com.rotato;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Hooker implements NativeKeyListener {
	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}
}