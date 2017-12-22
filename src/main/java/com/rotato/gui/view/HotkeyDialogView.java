package com.rotato.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HotkeyDialogView extends JDialog {
	private JLabel lblNewLabel;
	private JFrame owner;

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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("jdialog window closed event received");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("jdialog window closing event received");
			}
		});
	}

	public void hideDialog() {
		lblNewLabel.setText(null);
		setVisible(false);
	}

	public void showDialog(String message) {
		setLocationRelativeTo(owner);
		lblNewLabel.setText("Set a hotkey for: [" + message + "]");
		setVisible(true);
	}

}
