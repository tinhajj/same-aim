package com.rotato.aim;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

import org.jnativehook.GlobalScreen;
import org.jnativehook.mouse.NativeMouseEvent;

public class Mouse {
	static Robot robot;
	static XY lastXY;

	static {
		try {
			robot = new Robot();
			lastXY = currentPos();
			robot.setAutoWaitForIdle(true);
			robot.setAutoDelay(1);
		} catch (AWTException e) {
			System.out.println("Could not initialize robot");
			System.exit(1);
		}
	}

	private static XY currentPos() {
		java.awt.Point pointer = MouseInfo.getPointerInfo().getLocation();
		int x = (int) pointer.getX();
		int y = (int) pointer.getY();

		return new XY(x, y);
	}

	public static void translate(int x, int y) throws InterruptedException {
		XY curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		if (lastXY.getX() == xPos) {
			System.out.println("didn't move anywhere on x");
		}

		lastXY = curPos;

		robot.mouseMove(xPos + x, yPos + y);
	}

	public static void hookTranslate(int x, int y) {
		GlobalScreen.postNativeEvent(new NativeMouseEvent(
				NativeMouseEvent.NATIVE_MOUSE_MOVED, 1, 1, 1, 1));
	}
}