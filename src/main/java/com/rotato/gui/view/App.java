package com.rotato.gui.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jnativehook.GlobalScreen;

import com.rotato.gui.controller.CounterController;
import com.rotato.gui.controller.HotkeyController;
import com.rotato.gui.model.Counter;
import com.rotato.gui.model.Hotkey;

public class App {

	private JFrame frmSameAim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Logger logger = Logger
				.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		logger.setUseParentHandlers(false);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			System.out.println("Couldn't set look and feel");
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					App window = new App();
					window.frmSameAim.setVisible(true);
				} catch (Exception e) {
					System.out.println("Something went wrong initializing gui");
					System.exit(1);
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	 * @throws AWTException
	 */
	public App() throws AWTException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 * @throws AWTException
	 */
	private void initialize() throws AWTException {
		frmSameAim = new JFrame();
		frmSameAim.setTitle("Same Aim");
		frmSameAim.setBounds(100, 100, 311, 382);
		frmSameAim.setLocationRelativeTo(null);
		frmSameAim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HotkeyView hotkeyView = new HotkeyView(frmSameAim);
		Hotkey hotkeyModel = new Hotkey();

		CounterView counterView = new CounterView();
		Counter counterModel = new Counter();

		CounterController counterController = new CounterController(
				counterModel, counterView);
		HotkeyController hotkeyController = new HotkeyController(hotkeyModel,
				hotkeyView, counterController);

		GridBagLayout gridBagLayout = (GridBagLayout) hotkeyView.getLayout();
		gridBagLayout.columnWidths = new int[]{100, 100};
		gridBagLayout.rowHeights = new int[]{50, 50, 50};

		frmSameAim.getContentPane().add(hotkeyView, BorderLayout.NORTH);
		frmSameAim.getContentPane().add(counterView, BorderLayout.SOUTH);
	}

}
