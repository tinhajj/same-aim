package com.rotato.gui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.rotato.gui.controller.HotkeyController;
import com.rotato.gui.model.Hotkey;

public class App {

	private JFrame frmSameAim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					App window = new App();
					window.frmSameAim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSameAim = new JFrame();
		frmSameAim.setTitle("Same Aim");
		frmSameAim.setBounds(100, 100, 311, 382);
		frmSameAim.setLocationRelativeTo(null);
		frmSameAim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HotkeyView hotkeyView = new HotkeyView(frmSameAim);
		Hotkey hotkeyModel = new Hotkey();

		HotkeyController hotkeyController = new HotkeyController(hotkeyModel,
				hotkeyView);

		GridBagLayout gridBagLayout = (GridBagLayout) hotkeyView.getLayout();
		gridBagLayout.columnWidths = new int[]{100, 100};
		gridBagLayout.rowHeights = new int[]{50, 50, 50};
		frmSameAim.getContentPane().add(hotkeyView, BorderLayout.NORTH);

		ConsoleView console = new ConsoleView();
		frmSameAim.getContentPane().add(console, BorderLayout.SOUTH);
	}

}
