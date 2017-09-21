package com.rotato.aim;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class WindowCapture extends Robot {

	public WindowCapture() throws AWTException {
		super();
	}

	public BufferedImage screenshot() {
		return createScreenCapture(new Rectangle(1920, 1080));
	}
}