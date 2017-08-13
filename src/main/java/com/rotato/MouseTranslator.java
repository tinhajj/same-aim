package com.rotato;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.function.IntUnaryOperator;

public class MouseTranslator extends Robot {

	public MouseTranslator() throws AWTException {
		super();
	}

	public Point currentPos() {
		java.awt.Point pointer = MouseInfo.getPointerInfo().getLocation();
		int x = (int) pointer.getX();
		int y = (int) pointer.getY();

		return new Point(x, y);
	}

	public void translate(IntUnaryOperator func, int steps) throws InterruptedException {
		Point curPos;

		for (int x = 0; x < steps; x++) {
			curPos = currentPos();
			int xPos = curPos.getX();
			int yPos = curPos.getY();

			int y = func.applyAsInt(x);

			mouseMove(xPos + 1, yPos + y);
			Thread.sleep(20);
		}
	}

	public void translate(int x, int y) throws InterruptedException {
		Point curPos = currentPos();
		int xPos = curPos.getX();
		int yPos = curPos.getY();

		mouseMove(xPos + x, yPos + y);
	}

	public void translate(int x, int y, int steps, int sleep) throws InterruptedException {
		for (int z = 0; z < steps; z++) {
			Point curPos = currentPos();
			int xPos = curPos.getX();
			int yPos = curPos.getY();

			mouseMove(xPos + x, yPos + y);
			Thread.sleep(sleep);
		}
	}
}