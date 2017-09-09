package com.rotato;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.rotato.view.Console;
import com.rotato.view.Hotkeys;

public class Gui {

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
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSameAim = new JFrame();
		frmSameAim.setTitle("Same Aim");
		frmSameAim.setBounds(100, 100, 450, 300);
		frmSameAim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Hotkeys hotkeys = new Hotkeys();
		frmSameAim.getContentPane().add(hotkeys, BorderLayout.NORTH);

		Console console = new Console();
		frmSameAim.getContentPane().add(console, BorderLayout.SOUTH);
	}

}
