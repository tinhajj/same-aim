package com.rotato.aim;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class Mouse {
	static Robot robot;

	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.out.println("Could not initialize robot");
			System.exit(1);
		}
	}

	public static XY currentPos() {
		java.awt.Point pointer = MouseInfo.getPointerInfo().getLocation();
		int x = (int) pointer.getX();
		int y = (int) pointer.getY();

		return new XY(x, y);
	}

	public static void translate(int x, int y) throws InterruptedException {
		XY curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		robot.mouseMove(xPos + x, yPos + y);
	}
}