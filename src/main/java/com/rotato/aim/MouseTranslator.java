package com.rotato.aim;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.function.Function;

public class MouseTranslator extends Robot {

	public MouseTranslator() throws AWTException {
		super();
	}

	public XY currentPos() {
		java.awt.Point pointer = MouseInfo.getPointerInfo().getLocation();
		int x = (int) pointer.getX();
		int y = (int) pointer.getY();

		return new XY(x, y);
	}

	public void translate(Function<Integer, XY> func, Function<Integer, Integer> accel, int steps) throws InterruptedException {
		XY curPos;

		for (int x = 0; x < steps; x++) {
			curPos = currentPos();
			int xPos = curPos.getX();
			int yPos = curPos.getY();

			XY delta = func.apply(x);

			mouseMove(xPos + delta.getX(), yPos + delta.getY());
			Thread.sleep(accel.apply(x));
		}
	}

	public void translate(int x, int y) throws InterruptedException {
		XY curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		mouseMove(xPos + x, yPos + y);
	}

	public void translate(int x, int y, int steps, int sleep) throws InterruptedException {
		for (int z = 0; z < steps; z++) {
			XY curPos = currentPos();
			int xPos = curPos.getX();
			int yPos = curPos.getY();

			mouseMove(xPos + x, yPos + y);
			Thread.sleep(sleep);
		}
	}
}