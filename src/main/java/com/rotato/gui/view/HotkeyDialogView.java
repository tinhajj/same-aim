package com.rotato.gui.view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotkeyDialogView extends JDialog {
	private JLabel lblNewLabel;

	HotkeyDialogView(Frame owner) {
		super(owner, true);
		setTitle("Set a Hotkey");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("Press A Key");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(lblNewLabel);

		pack();
		setLocationRelativeTo(owner);
	}

	public void hideDialog() {
		lblNewLabel.setText(null);
		setVisible(false);
	}

	public void showDialog(String message) {
		lblNewLabel.setText("Set a hotkey for: [" + message + "]");
		setVisible(true);
	}

}
