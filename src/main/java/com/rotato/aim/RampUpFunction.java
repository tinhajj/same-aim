package com.rotato.aim;

import java.util.function.Function;

public class RampUpFunction {
	Function<Integer, Integer> function;
	private int currentX;

	public RampUpFunction(Function<Integer, Integer> func) {
		function = func;
		currentX = 1;
	}

	public void faster() {
		currentX++;
	}

	public int getSpeed() {
		return function.apply(currentX);
	}

	public void resetSpeed() {
		currentX = 1;
	}
}
