package com.rotato;

import java.awt.AWTException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Hooker implements NativeKeyListener {
	int counter = 0; 
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == 57421) {
			try {
				MouseTranslator mover = new MouseTranslator();
				mover.translate(1, 0);
				counter++;
			} catch (AWTException | InterruptedException err) {
				err.printStackTrace();
			}
		}
		
		if (e.getKeyCode() == 57419) {
			System.out.println("The number of calls is: " + counter);
		}
		
		if (e.getKeyCode() == 57416) {
			System.out.println("Reset counter to zero");
			counter = 0;
		}
		
		if (e.getKeyCode() == 57416) {	}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {	}

	public void nativeKeyTyped(NativeKeyEvent e) {	}
}