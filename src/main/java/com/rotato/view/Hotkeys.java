package com.rotato.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Hotkeys extends JPanel {

	/**
	 * Create the panel.
	 */
	public Hotkeys() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);

		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}
}
