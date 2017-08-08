package com.rotato;
import java.awt.AWTException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class TestRunner {

	public static void main(String[] args) throws AWTException, InterruptedException, NativeHookException {
		//MouseTranslator mover = new MouseTranslator();
		
		//mover.translate(1, 2, 100, 20);

		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new Hooker());
	}

}