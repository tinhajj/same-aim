package com.rotato.gui.model;

public class Counter {
	private int up;
	private int down;
	private int left;
	private int right;

	public Counter() {
		this.setUp(0);
		this.setDown(0);
		this.setLeft(0);
		this.setRight(0);
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
}
