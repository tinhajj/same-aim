package com.rotato.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class HotkeyView extends JLayeredPane {

	/**
	 * Create the panel.
	 */
	public HotkeyView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 50, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnMoveLeft = new JButton("Move Left");
		setLayer(btnMoveLeft, 1);
		GridBagConstraints gbc_btnMoveLeft = new GridBagConstraints();
		gbc_btnMoveLeft.fill = GridBagConstraints.BOTH;
		gbc_btnMoveLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveLeft.gridx = 0;
		gbc_btnMoveLeft.gridy = 0;
		add(btnMoveLeft, gbc_btnMoveLeft);

		JButton btnResetCounter = new JButton("Reset Counter");
		setLayer(btnResetCounter, 1);
		GridBagConstraints gbc_btnResetCounter = new GridBagConstraints();
		gbc_btnResetCounter.fill = GridBagConstraints.BOTH;
		gbc_btnResetCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetCounter.gridx = 1;
		gbc_btnResetCounter.gridy = 0;
		add(btnResetCounter, gbc_btnResetCounter);

		JButton btnPrintCounter = new JButton("Print Counter");
		setLayer(btnPrintCounter, 1);
		GridBagConstraints gbc_btnPrintCounter = new GridBagConstraints();
		gbc_btnPrintCounter.fill = GridBagConstraints.BOTH;
		gbc_btnPrintCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrintCounter.gridx = 1;
		gbc_btnPrintCounter.gridy = 1;
		add(btnPrintCounter, gbc_btnPrintCounter);

		JButton btnNewButton_2 = new JButton("Move Down");
		setLayer(btnNewButton_2, 1);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton = new JButton("Not Implemented");
		setLayer(btnNewButton, 1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);

		JButton btnNotImplemented = new JButton("Not Implemented");
		setLayer(btnNotImplemented, 1);
		btnNotImplemented.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNotImplemented = new GridBagConstraints();
		gbc_btnNotImplemented.fill = GridBagConstraints.BOTH;
		gbc_btnNotImplemented.gridx = 1;
		gbc_btnNotImplemented.gridy = 2;
		add(btnNotImplemented, gbc_btnNotImplemented);

	}
}
