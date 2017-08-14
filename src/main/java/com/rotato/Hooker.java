package com.rotato;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.util.function.Function;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.google.common.collect.EvictingQueue;

public class Hooker implements NativeKeyListener {
	public int counter;
	public MouseTranslator mover;
	public WindowCapture screenGrabber;
	public EvictingQueue<BufferedImage> screenshots;

	public Hooker() throws AWTException {
		counter = 0;
		mover = new MouseTranslator();
		screenGrabber = new WindowCapture();
		screenshots = EvictingQueue.create(2);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == 57421) {
			try {
				//mover.translate(1, 0);

				BufferedImage img1 = screenGrabber.screenshot();
				mover.translate( sin(), (x) -> ( (x <= 25) ? -x + 100 : 25), 500);
				mover.translate( negsin(), (x) -> ( (x <= 25) ? -x + 100 : 25), 500);
				BufferedImage img2 = screenGrabber.screenshot();
				System.out.println(ImageUtils.compare(img1, img2));

				counter++;
			} catch (Exception err) {
				err.printStackTrace();
			}
		}

		if (e.getKeyCode() == 57419) {
			System.out.println("The number of calls is: " + counter);
		}

		if (e.getKeyCode() == 57416) {
			System.out.println("Reset counter to zero");
			counter = 0;
		}

		if (e.getKeyCode() == 57424) {
			BufferedImage bufferedImage = screenGrabber.screenshot();
			screenshots.add(bufferedImage);

			if (screenshots.size() == 2) {
				BufferedImage img1;
				BufferedImage img2;

				img1 = screenshots.poll();
				img2 = screenshots.poll();

				try {
					System.out.println(ImageUtils.compare(img1, img2));
				} catch (DimensionsMismatchException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public Function<Integer, XY> sin() {
		return step -> {
			double x = (double) step / 10;
			int y = (int) ( 30 * Math.sin(x) );
			return new XY( (int) x, y );
		};
	}

	// Delete this later, just add more parameters to sin()
	public Function<Integer, XY> negsin() {
		return step -> {
			double x = (double) step / 10;
			int y = (int) ( -30 * Math.sin(x) );
			return new XY( (int) -x, -y );
		};
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {	}
}