package com.rotato.aim;

import java.util.function.Function;

public class RampFactory {
	public static Function<Integer, Integer> stepFunction() {
		Function<Integer, Integer> func = (x) -> {
			if (x > 100) {
				return 10;
			} else if (x > 70) {
				return 8;
			} else if (x > 40) {
				return 4;
			} else if (x > 20) {
				return 2;
			} else {
				return 1;
			}
		};

		return func;
	}

	public static Function<Integer, Integer> linearFunction(int max) {
		Function<Integer, Integer> func = (x) -> {
			double ratio = (double) x / 100;
			int amount = (int) (ratio * max);

			if (amount < 1) {
				return 1;
			}

			if (ratio > 1) {
				return max;
			}

			return amount;
		};

		return func;
	}
}
