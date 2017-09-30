package com.rotato.gui.view;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GlassPane extends JPanel {

	public GlassPane() {
		setBackground(SystemColor.info);
	}

	@Override
	public void setVisible(boolean on) {
		JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,
				this);
		frame.setGlassPane(this);
		super.setVisible(on);
	}
}