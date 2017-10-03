package com.rotato.gui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

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
		frmSameAim.setBounds(100, 100, 259, 336);
		frmSameAim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HotkeyView hotkeys = new HotkeyView();
		GridBagLayout gridBagLayout = (GridBagLayout) hotkeys.getLayout();
		gridBagLayout.columnWidths = new int[]{100, 100};
		gridBagLayout.rowHeights = new int[]{50, 50, 50};
		frmSameAim.getContentPane().add(hotkeys, BorderLayout.NORTH);

		ConsoleView console = new ConsoleView();
		frmSameAim.getContentPane().add(console, BorderLayout.SOUTH);
	}

}
