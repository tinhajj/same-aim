package com.rotato.aim;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class Mouse {
	static Robot robot;
	static int multiplier = 1;
	static int max = 1;

	static {
		try {
			robot = new Robot();
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

	public static int translateX(int x) throws InterruptedException {
		XY curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		robot.mouseMove(xPos + (x * multiplier), yPos);
		return Math.abs(x * multiplier);
	}

	public static int translateY(int y) throws InterruptedException {
		XY curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		robot.mouseMove(xPos, yPos + (y * multiplier));
		return Math.abs(y * multiplier);
	}

	public static void setDelay(int ms) {
		robot.setAutoDelay(ms);
	}

	public static void setMultiplier(int mult) {
		multiplier = mult;
	}

	public static void increaseMultiplier() {
		multiplier++;
	}

	public static void resetMultiplier() {
		multiplier = 1;
	}

	public static void setMaxMultiplier(int m) {
		max = m;
	}
}