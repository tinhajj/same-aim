package com.rotato.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class HotkeyView extends JLayeredPane {

	/**
	 * Create the panel.
	 */
	public HotkeyView() {

		GlassPane glassPane = new GlassPane();
		glassPane.setVisible(false);

		JPanel panel = new JPanel();
		setLayer(panel, 0);
		panel.setBounds(10, 11, 232, 140);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 10, 10};
		gbl_panel.rowHeights = new int[]{40, 40, 40};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);

		JButton button = new JButton("Move Left");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);

		JButton button_2 = new JButton("Print Counter");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 0;
		panel.add(button_2, gbc_button_2);

		JButton button_3 = new JButton("Move Down");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.BOTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 1;
		panel.add(button_3, gbc_button_3);

		JButton button_1 = new JButton("Reset Counter");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.gridx = 1;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridy = 1;
		panel.add(button_1, gbc_button_1);

		JButton button_4 = new JButton("Not Implemented");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				glassPane.setVisible(true);
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.BOTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 2;
		panel.add(button_4, gbc_button_4);

		JButton button_5 = new JButton("Not Implemented");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.BOTH;
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.gridx = 1;
		gbc_button_5.gridy = 2;
		panel.add(button_5, gbc_button_5);
		setLayer(glassPane, 1);
		glassPane.setBounds(10, 11, 232, 140);
		add(glassPane);

	}
}
