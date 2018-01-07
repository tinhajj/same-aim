package com.rotato.gui.view;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HotkeyView extends JPanel {
	private ArrayList<HotkeyButton> buttons;
	private HotkeyDialogView hotkeyDialogView;

	/**
	 * Create the panel.
	 *
	 * @param frmSameAim
	 */
	public HotkeyView(JFrame frmSameAim) {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBorder(new EmptyBorder(25, 10, 25, 5));
		buttons = new ArrayList<HotkeyButton>();

		hotkeyDialogView = new HotkeyDialogView(frmSameAim);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Dimension buttonSize = new Dimension(105, 50);

		HotkeyButton btnMoveLeft = new HotkeyButton("Move Left", hotkeyDialogView);
		btnMoveLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMoveLeft.setPreferredSize(buttonSize);
		add(btnMoveLeft);
		buttons.add(btnMoveLeft);

		HotkeyButton btnMoveDown = new HotkeyButton("Move Down", hotkeyDialogView);
		btnMoveDown.setPreferredSize(buttonSize);
		btnMoveDown.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnMoveDown);
		buttons.add(btnMoveDown);

		HotkeyButton btnMoveReverse = new HotkeyButton("Reverse", (HotkeyDialogView) null);
		btnMoveReverse.setToolTipText(
				"This moves in the opposite direction of your last movement, and decrements the counter");
		btnMoveReverse.setPreferredSize(new Dimension(105, 50));
		btnMoveReverse.setAlignmentX(0.5f);
		add(btnMoveReverse);

		HotkeyButton btnResetCounter = new HotkeyButton("Reset Counter", hotkeyDialogView);
		btnResetCounter.setPreferredSize(buttonSize);
		btnResetCounter.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnResetCounter);
		buttons.add(btnResetCounter);
	}

	public void addHotkeyListener(ActionListener listener) {
		for (HotkeyButton button : buttons) {
			button.addActionListener(listener);
		}
	}

	public void hideDialog() {
		hotkeyDialogView.hideDialog();
	}

	public void addDialogCloseListener(WindowListener listener) {
		hotkeyDialogView.addWindowListener(listener);
	}

	public String getDialogText() {
		return hotkeyDialogView.getMessage();
	}
}
