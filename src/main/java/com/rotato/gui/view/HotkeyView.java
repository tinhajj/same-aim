package com.rotato.gui.view;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
		setBorder(new EmptyBorder(5, 5, 25, 5));
		buttons = new ArrayList<HotkeyButton>();

		hotkeyDialogView = new HotkeyDialogView(frmSameAim);

		Dimension buttonSize = new Dimension(105, 50);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100};
		gridBagLayout.rowHeights = new int[]{50, 50};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);

		HotkeyButton btnMoveLeft = new HotkeyButton("Move Left",
				hotkeyDialogView);
		btnMoveLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMoveLeft.setPreferredSize(buttonSize);
		GridBagConstraints gbc_btnMoveLeft = new GridBagConstraints();
		gbc_btnMoveLeft.fill = GridBagConstraints.BOTH;
		gbc_btnMoveLeft.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMoveLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveLeft.gridx = 0;
		gbc_btnMoveLeft.gridy = 0;
		add(btnMoveLeft, gbc_btnMoveLeft);
		buttons.add(btnMoveLeft);

		HotkeyButton btnMoveDown = new HotkeyButton("Move Down",
				hotkeyDialogView);
		btnMoveDown.setPreferredSize(buttonSize);
		btnMoveDown.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.fill = GridBagConstraints.BOTH;
		gbc_btnMoveDown.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveDown.gridx = 1;
		gbc_btnMoveDown.gridy = 0;
		add(btnMoveDown, gbc_btnMoveDown);
		buttons.add(btnMoveDown);

		HotkeyButton btnMoveReverse = new HotkeyButton("Reverse",
				hotkeyDialogView);
		btnMoveReverse.setToolTipText(
				"This moves in the opposite direction of your last movement, and decrements the counter");
		btnMoveReverse.setPreferredSize(new Dimension(105, 50));
		btnMoveReverse.setAlignmentX(0.5f);
		GridBagConstraints gbc_btnMoveReverse = new GridBagConstraints();
		gbc_btnMoveReverse.fill = GridBagConstraints.BOTH;
		gbc_btnMoveReverse.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMoveReverse.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveReverse.gridx = 0;
		gbc_btnMoveReverse.gridy = 1;
		add(btnMoveReverse, gbc_btnMoveReverse);
		buttons.add(btnMoveReverse);

		HotkeyButton btnResetCounter = new HotkeyButton("Reset Counter",
				hotkeyDialogView);
		btnResetCounter.setPreferredSize(new Dimension(105, 50));
		btnResetCounter.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnResetCounter = new GridBagConstraints();
		gbc_btnResetCounter.fill = GridBagConstraints.BOTH;
		gbc_btnResetCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetCounter.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnResetCounter.gridx = 1;
		gbc_btnResetCounter.gridy = 1;
		add(btnResetCounter, gbc_btnResetCounter);
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
