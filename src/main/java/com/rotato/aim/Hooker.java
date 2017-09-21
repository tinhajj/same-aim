package com.rotato.aim;

import java.awt.AWTException;
import java.awt.image.BufferedImage;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.google.common.collect.EvictingQueue;

public class Hooker implements NativeKeyListener {
	public int counter;
	public MouseTranslator mover;
	public WindowCapture screenGrabber;
	public EvictingQueue<BufferedImage> screenshots;

	public Hooker() throws AWTException {
		counter = 0;
		mover = new MouseTranslator();
		screenGrabber = new WindowCapture();
		screenshots = EvictingQueue.create(2);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == 57421) {
			try {
				mover.translate(0, 5);
				counter++;
			} catch (Exception err) {
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

		if (e.getKeyCode() == 57424) {
			try {
				mover.translate(5, 0);
				counter++;
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {	}
}