package com.rotato.gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HotkeyButton extends JButton {
	public HotkeyButton(String title, HotkeyDialogView dialog) {
		super(title);

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.showDialog(title);
			}
		});
	}
}
