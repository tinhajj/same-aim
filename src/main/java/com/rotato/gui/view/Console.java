package com.rotato.gui.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Console extends JPanel {

	/**
	 * Create the panel.
	 */
	public Console() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

	}

}
