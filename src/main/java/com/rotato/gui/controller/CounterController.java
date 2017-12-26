package com.rotato.gui.controller;

import javax.swing.SwingUtilities;

import com.rotato.gui.model.Counter;
import com.rotato.gui.view.CounterView;

public class CounterController {
	private Counter counterModel;
	private CounterView counterView;

	public CounterController(Counter counterModel, CounterView counterView) {
		this.counterModel = counterModel;
		this.counterView = counterView;
	}

	public void resetCounters() {
		counterModel.setUp(0);
		counterModel.setDown(0);
		counterModel.setLeft(0);
		counterModel.setRight(0);

		SwingUtilities.invokeLater(() -> {
			counterView.setCounters(counterModel.getLeft(), counterModel.getDown());
		});
	}

	public void setCounters(int down, int left) {
		counterModel.setDown(down);
		counterModel.setLeft(left);

		SwingUtilities.invokeLater(() -> {
			counterView.setCounters(counterModel.getLeft(), counterModel.getDown());
		});
	}

	public void incrementLeftCounter(int increment) {
		counterModel.setLeft(counterModel.getLeft() + increment);

		SwingUtilities.invokeLater(() -> {
			counterView.setCounters(counterModel.getLeft(), counterModel.getDown());
		});
	}

	public void incrementDownCounter(int increment) {
		counterModel.setDown(counterModel.getDown() + increment);

		SwingUtilities.invokeLater(() -> {
			counterView.setCounters(counterModel.getLeft(), counterModel.getDown());
		});
	}
}
