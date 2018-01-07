package com.rotato.gui.view;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

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
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
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
					System.out.println(e);
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
		frmSameAim.setBounds(100, 100, 275, 410);
		frmSameAim.setLocationRelativeTo(null);
		frmSameAim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel container = new JPanel();
		Hotkey hotkeyModel = new Hotkey();
		Counter counterModel = new Counter();

		frmSameAim.getContentPane().add(container, BorderLayout.CENTER);
		GridBagLayout gbl_container = new GridBagLayout();
		gbl_container.columnWidths = new int[] { 259 };
		gbl_container.rowHeights = new int[] { 75, 75, 132 };
		gbl_container.columnWeights = new double[] { 0.0 };
		gbl_container.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		container.setLayout(gbl_container);

		CounterView counterView = new CounterView();
		CounterController counterController = new CounterController(counterModel, counterView);

		HotkeyView hotkeyView = new HotkeyView(frmSameAim);
		hotkeyView.setBorder(null);
		HotkeyController hotkeyController = new HotkeyController(hotkeyModel, hotkeyView, counterController);

		GridBagConstraints gbc_hotkeyView = new GridBagConstraints();
		gbc_hotkeyView.insets = new Insets(0, 0, 5, 0);
		gbc_hotkeyView.gridx = 0;
		gbc_hotkeyView.gridy = 0;
		container.add(hotkeyView, gbc_hotkeyView);

		GridBagLayout gridBagLayout = (GridBagLayout) counterView.getLayout();
		gridBagLayout.columnWidths = new int[] { 50 };
		gridBagLayout.rowHeights = new int[] { 10, 10 };
		counterView.setBorder(new EmptyBorder(0, 0, 10, 0));

		GridBagConstraints gbc_counterView = new GridBagConstraints();
		gbc_counterView.insets = new Insets(0, 0, 5, 0);
		gbc_counterView.gridx = 0;
		gbc_counterView.gridy = 1;
		container.add(counterView, gbc_counterView);

		MouseView mouseView = new MouseView();
		mouseView.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_mouseView = new GridBagConstraints();
		gbc_mouseView.gridx = 0;
		gbc_mouseView.gridy = 2;
		container.add(mouseView, gbc_mouseView);
	}

}
