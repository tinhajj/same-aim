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