package com.rotato.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class CounterView extends JPanel {
	private JLabel lblLeftCounter;
	private JLabel lblDownCounter;

	public CounterView() {
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100 };
		gridBagLayout.rowHeights = new int[] { 10, 10 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		setLayout(gridBagLayout);

		JPanel down = new JPanel();
		down.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), " ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 102, 0)));
		GridBagConstraints gbc_down = new GridBagConstraints();
		gbc_down.anchor = GridBagConstraints.NORTH;
		gbc_down.gridx = 0;
		gbc_down.gridy = 1;
		add(down, gbc_down);
		GridBagLayout gbl_down = new GridBagLayout();
		gbl_down.columnWidths = new int[] { 100, 100 };
		gbl_down.rowHeights = new int[] { 10 };
		gbl_down.columnWeights = new double[] { 0.0, 0.0 };
		gbl_down.rowWeights = new double[] { 0.0 };
		down.setLayout(gbl_down);

		JLabel lblDown = new JLabel("Down");
		GridBagConstraints gbc_lblDown = new GridBagConstraints();
		gbc_lblDown.gridx = 0;
		gbc_lblDown.gridy = 0;
		down.add(lblDown, gbc_lblDown);
		lblDown.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDownCounter = new JLabel("0");
		GridBagConstraints gbc_lblDownCounter = new GridBagConstraints();
		gbc_lblDownCounter.gridx = 1;
		gbc_lblDownCounter.gridy = 0;
		down.add(lblDownCounter, gbc_lblDownCounter);
		lblDownCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel left = new JPanel();
		left.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), " ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 102, 0)));
		GridBagConstraints gbc_left = new GridBagConstraints();
		gbc_left.anchor = GridBagConstraints.NORTH;
		gbc_left.gridx = 0;
		gbc_left.gridy = 0;
		add(left, gbc_left);
		GridBagLayout gbl_left = new GridBagLayout();
		gbl_left.columnWidths = new int[] { 100, 100 };
		gbl_left.rowHeights = new int[] { 10 };
		gbl_left.columnWeights = new double[] { 0.0, 0.0 };
		gbl_left.rowWeights = new double[] { 0.0 };
		left.setLayout(gbl_left);

		JLabel lblLeft = new JLabel("Left");
		GridBagConstraints gbc_lblLeft = new GridBagConstraints();
		gbc_lblLeft.gridx = 0;
		gbc_lblLeft.gridy = 0;
		left.add(lblLeft, gbc_lblLeft);
		lblLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblLeftCounter = new JLabel("0");
		GridBagConstraints gbc_lblLeftCounter = new GridBagConstraints();
		gbc_lblLeftCounter.gridx = 1;
		gbc_lblLeftCounter.gridy = 0;
		left.add(lblLeftCounter, gbc_lblLeftCounter);
		lblLeftCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));

		down.addMouseListener(new ClipboardCopy(lblDownCounter, down));
		left.addMouseListener(new ClipboardCopy(lblLeftCounter, left));
	}

	public void setCounters(int left, int down) {
		lblLeftCounter.setText(Integer.toString(left));
		lblDownCounter.setText(Integer.toString(down));
	}
}

class ClipboardCopy extends MouseAdapter {
	private JLabel label;
	private JPanel panel;
	private TitledBorder border;
	private Timer timer;

	public ClipboardCopy(JLabel label, JPanel panel) {
		this.label = label;
		this.panel = panel;
		this.border = (TitledBorder) panel.getBorder();
		this.timer = new Timer(3000, clearTitle());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TitledBorder border = (TitledBorder) panel.getBorder();
		String originalText = border.getTitle();

		StringSelection stringSelection = new StringSelection(label.getText());
		Clipboard clpboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpboard.setContents(stringSelection, null);

		border.setTitle("Copied to Clipboard");
		panel.setBorder(border);
		panel.repaint();

		timer.restart();
	}

	public ActionListener clearTitle() {
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				border.setTitle(" ");
				panel.setBorder(border);
				panel.repaint();
			}
		};

		return taskPerformer;
	}
}
