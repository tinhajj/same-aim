package com.rotato.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Hotkeys extends JPanel {

	/**
	 * Create the panel.
	 */
	public Hotkeys() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 100, 0};
		gridBagLayout.rowHeights = new int[] {50, 50, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

						JButton button_2 = new JButton("New button");
						GridBagConstraints gbc_button_2 = new GridBagConstraints();
						gbc_button_2.fill = GridBagConstraints.BOTH;
						gbc_button_2.insets = new Insets(0, 0, 5, 5);
						gbc_button_2.gridx = 0;
						gbc_button_2.gridy = 0;
						add(button_2, gbc_button_2);

						JButton button_3 = new JButton("New button");
						GridBagConstraints gbc_button_3 = new GridBagConstraints();
						gbc_button_3.fill = GridBagConstraints.BOTH;
						gbc_button_3.insets = new Insets(0, 0, 5, 0);
						gbc_button_3.gridx = 1;
						gbc_button_3.gridy = 0;
						add(button_3, gbc_button_3);

						JButton button = new JButton("New button");
						GridBagConstraints gbc_button = new GridBagConstraints();
						gbc_button.fill = GridBagConstraints.BOTH;
						gbc_button.insets = new Insets(0, 0, 5, 0);
						gbc_button.gridx = 1;
						gbc_button.gridy = 1;
						add(button, gbc_button);

						JButton btnNewButton_2 = new JButton("New button");
						GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
						gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
						gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
						gbc_btnNewButton_2.gridx = 0;
						gbc_btnNewButton_2.gridy = 1;
						add(btnNewButton_2, gbc_btnNewButton_2);

				JButton btnNewButton = new JButton("New button");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton.gridx = 0;
				gbc_btnNewButton.gridy = 2;
				add(btnNewButton, gbc_btnNewButton);

				JButton button_1 = new JButton("New button");
				button_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					}
				});
				GridBagConstraints gbc_button_1 = new GridBagConstraints();
				gbc_button_1.fill = GridBagConstraints.BOTH;
				gbc_button_1.gridx = 1;
				gbc_button_1.gridy = 2;
				add(button_1, gbc_button_1);

	}
}
