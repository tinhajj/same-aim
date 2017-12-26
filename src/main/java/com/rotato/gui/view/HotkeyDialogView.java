package com.rotato.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HotkeyDialogView extends JDialog {
	private JLabel lblNewLabel;
	private JFrame owner;
	private String message;

	HotkeyDialogView(JFrame owner) {
		super(owner, true);
		setSize(new Dimension(214, 170));

		getContentPane().setLayout(new BorderLayout());

		this.owner = owner;

		setTitle("Set a Hotkey");

		lblNewLabel = new JLabel("Press A Key");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		getContentPane().add(lblNewLabel, BorderLayout.SOUTH);

		this.setLocationRelativeTo(owner);
	}

	public void hideDialog() {
		lblNewLabel.setText(null);
		setVisible(false);
	}

	public void showDialog(String message) {
		this.message = message;
		setLocationRelativeTo(owner);
		lblNewLabel.setText("Set a hotkey for: [" + message + "]");
		setVisible(true);
	}

	public String getMessage() {
		return message;
	}

}
