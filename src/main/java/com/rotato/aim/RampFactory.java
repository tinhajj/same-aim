package com.rotato.aim;

import java.util.function.Function;

public class RampFactory {
	public static Function<Integer, Integer> stepFunction(int max) {
		Function<Integer, Integer> func = (x) -> {
			int rem = x % 10;

			if (rem < 1) {
				return 1;
			}

			if (rem > max) {
				return max;
			}

			return rem;
		};

		return func;
	}
}
