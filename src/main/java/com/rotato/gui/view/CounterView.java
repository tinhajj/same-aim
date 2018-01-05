package com.rotato.gui.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CounterView extends JPanel {
	private JLabel lblLeftCounter;
	private JLabel lblDownCounter;

	public CounterView() {
		setBorder(new EmptyBorder(25, 10, 25, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100 };
		gridBagLayout.rowHeights = new int[] { 50, 50 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblLeft = new JLabel("Left");
		lblLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLeft = new GridBagConstraints();
		gbc_lblLeft.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeft.gridx = 0;
		gbc_lblLeft.gridy = 0;
		add(lblLeft, gbc_lblLeft);

		lblLeftCounter = new JLabel("0");
		lblLeftCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUpCounterLabel = new GridBagConstraints();
		gbc_lblUpCounterLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblUpCounterLabel.gridx = 1;
		gbc_lblUpCounterLabel.gridy = 0;
		add(lblLeftCounter, gbc_lblUpCounterLabel);

		JLabel lblDown = new JLabel("Down");
		lblDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDown = new GridBagConstraints();
		gbc_lblDown.insets = new Insets(0, 0, 0, 5);
		gbc_lblDown.gridx = 0;
		gbc_lblDown.gridy = 1;
		add(lblDown, gbc_lblDown);

		lblDownCounter = new JLabel("0");
		lblDownCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDownCounterLabel = new GridBagConstraints();
		gbc_lblDownCounterLabel.gridx = 1;
		gbc_lblDownCounterLabel.gridy = 1;
		add(lblDownCounter, gbc_lblDownCounterLabel);
	}

	public void setCounters(int left, int down) {
		lblLeftCounter.setText(Integer.toString(left));
		lblDownCounter.setText(Integer.toString(down));
	}
}
