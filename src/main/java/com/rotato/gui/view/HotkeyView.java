package com.rotato.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotkeyView extends JPanel {
	private JFrame frame;
	private ArrayList<HotkeyButton> buttons;
	private HotkeyDialogView hotkeyDialogView;

	/**
	 * Create the panel.
	 *
	 * @param frmSameAim
	 */
	public HotkeyView(JFrame frmSameAim) {
		buttons = new ArrayList<HotkeyButton>();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100 };
		gridBagLayout.rowHeights = new int[] { 50, 50 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		setLayout(gridBagLayout);

		hotkeyDialogView = new HotkeyDialogView(frmSameAim);

		HotkeyButton btnMoveLeft = new HotkeyButton("Move Left", hotkeyDialogView);
		GridBagConstraints gbc_btnMoveLeft = new GridBagConstraints();
		gbc_btnMoveLeft.fill = GridBagConstraints.BOTH;
		gbc_btnMoveLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveLeft.gridx = 0;
		gbc_btnMoveLeft.gridy = 0;
		add(btnMoveLeft, gbc_btnMoveLeft);
		buttons.add(btnMoveLeft);

		HotkeyButton btnResetCounter = new HotkeyButton("Reset Counter", hotkeyDialogView);
		GridBagConstraints gbc_btnResetCounter = new GridBagConstraints();
		gbc_btnResetCounter.fill = GridBagConstraints.BOTH;
		gbc_btnResetCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetCounter.gridx = 1;
		gbc_btnResetCounter.gridy = 0;
		add(btnResetCounter, gbc_btnResetCounter);
		buttons.add(btnResetCounter);

		HotkeyButton btnPrintCounter = new HotkeyButton("Print Counter", hotkeyDialogView);
		GridBagConstraints gbc_btnPrintCounter = new GridBagConstraints();
		gbc_btnPrintCounter.fill = GridBagConstraints.BOTH;
		gbc_btnPrintCounter.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrintCounter.gridx = 1;
		gbc_btnPrintCounter.gridy = 1;
		add(btnPrintCounter, gbc_btnPrintCounter);
		buttons.add(btnPrintCounter);

		HotkeyButton btnMoveDown = new HotkeyButton("Move Down", hotkeyDialogView);
		GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.fill = GridBagConstraints.BOTH;
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveDown.gridx = 0;
		gbc_btnMoveDown.gridy = 1;
		add(btnMoveDown, gbc_btnMoveDown);
		buttons.add(btnMoveDown);
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
