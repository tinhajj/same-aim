package com.rotato;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Hooker implements NativeKeyListener {
	public int counter;
	public MouseTranslator mover;
	public WindowCapture screenGrabber;

	public Hooker() throws AWTException {
		counter = 0;
		mover = new MouseTranslator();
		screenGrabber = new WindowCapture();
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == 57421) {
			try {
				mover.translate(1, 0);
				counter++;
			} catch (InterruptedException err) {
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
			BufferedImage bufferedImage = screenGrabber.screenshot();
			File outputfile = new File("C:\\Users\\water\\image.jpg");
			try {
				ImageIO.write(bufferedImage, "jpg", outputfile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {	}

	public void nativeKeyTyped(NativeKeyEvent e) {	}
}