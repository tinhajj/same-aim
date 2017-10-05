package com.rotato.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotkeyView extends JPanel {
	private JFrame frame;

	/**
	 * Create the panel.
	 *
	 * @param frmSameAim
	 */
	public HotkeyView(JFrame frmSameAim) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100};
		gridBagLayout.rowHeights = new int[]{50, 50};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);

		HotkeyDialogView hotkeyDialogView = new HotkeyDialogView(frmSameAim);

		JButton btnMoveLeft = new JButton("Move Left");
		btnMoveLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hotkeyDialogView.showDialog("Move Left");
			}
		});
		GridBagConstraints gbc_btnMoveLeft = new GridBagConstraints();
		gbc_btnMoveLeft.fill = GridBagConstraints.BOTH;
		gbc_btnMoveLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveLeft.gridx = 0;
		gbc_btnMoveLeft.gridy = 0;
		add(btnMoveLeft, gbc_btnMoveLeft);

		JButton btnResetCounter = new JButton("Reset Counter");
		GridBagConstraints gbc_btnResetCounter = new GridBagConstraints();
		gbc_btnResetCounter.fill = GridBagConstraints.BOTH;
		gbc_btnResetCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetCounter.gridx = 1;
		gbc_btnResetCounter.gridy = 0;
		add(btnResetCounter, gbc_btnResetCounter);

		JButton btnPrintCounter = new JButton("Print Counter");
		GridBagConstraints gbc_btnPrintCounter = new GridBagConstraints();
		gbc_btnPrintCounter.fill = GridBagConstraints.BOTH;
		gbc_btnPrintCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrintCounter.gridx = 1;
		gbc_btnPrintCounter.gridy = 1;
		add(btnPrintCounter, gbc_btnPrintCounter);

		JButton btnNewButton_2 = new JButton("Move Down");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		add(btnNewButton_2, gbc_btnNewButton_2);
	}
}
