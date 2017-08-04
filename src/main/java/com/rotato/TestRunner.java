package com.rotato;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class TestRunner {

	public static void main(String[] args) throws AWTException, InterruptedException {
		MouseTranslator mover = new MouseTranslator();
		mover.setRobot();
		
		mover.translate(1, 2, 100, 20);
	}

}

class MouseTranslator {
	private Robot robot;
	
	public MouseTranslator() {
	}
	
	public void setRobot() throws AWTException {
		robot = new Robot();
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
			
			robot.mouseMove(xPos + x, yPos + y);
			Thread.sleep(sleep);
		}
	}
}