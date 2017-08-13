package com.rotato;

import java.awt.image.BufferedImage;

public class ImageUtils {

	public static boolean sameSize(BufferedImage img1, BufferedImage img2) throws DimensionsMismatchException {
		int width1 = img1.getWidth(null);
		int width2 = img2.getWidth(null);
		int height1 = img1.getHeight(null);
		int height2 = img2.getHeight(null);

		return (width1 == width2) && (height1 == height2);
	}

	public static double compare(BufferedImage img1, BufferedImage img2) throws DimensionsMismatchException {
		int width = img1.getWidth(null);
		int height = img1.getHeight(null);

		if (sameSize(img1, img2) == false) {
			throw new DimensionsMismatchException(img1, img2);
		}

		long diff = 0;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int rgb1 = img1.getRGB(x, y);
				int rgb2 = img2.getRGB(x, y);
				int r1 = (rgb1 >> 16) & 0xff;
				int g1 = (rgb1 >>  8) & 0xff;
				int b1 = (rgb1      ) & 0xff;
				int r2 = (rgb2 >> 16) & 0xff;
				int g2 = (rgb2 >>  8) & 0xff;
				int b2 = (rgb2      ) & 0xff;
				diff += Math.abs(r1 - r2);
				diff += Math.abs(g1 - g2);
				diff += Math.abs(b1 - b2);
			}
		}

	    double n = width * height * 3;
	    double p = diff / n / 255.0;
		return p * 100.0;
	}
}

class DimensionsMismatchException extends Exception{
	public DimensionsMismatchException(BufferedImage img1, BufferedImage img2) {
		super("Image 1 is " + img1.getWidth(null) + " x " + img1.getHeight(null) + " and Image 2 is " + img2.getWidth(null) + " x " + img2.getHeight(null));
	}
}
