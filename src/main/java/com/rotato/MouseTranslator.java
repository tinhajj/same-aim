package com.rotato;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

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