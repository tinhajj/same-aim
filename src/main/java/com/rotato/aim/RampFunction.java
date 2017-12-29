package com.rotato.aim;

import java.util.function.Function;

public class RampFunction {
	private Function<Integer, Integer> func;
	private int currentX;

	public RampFunction(Function<Integer, Integer> func) {
		this.func = func;
		currentX = 1;
	}

	public void increase() {
		currentX++;
	}

	public int current() {
		return func.apply(currentX);
	}

	public void reset() {
		currentX = 1;
	}

	public int getX() {
		return currentX;
	}
}
