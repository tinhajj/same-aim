package com.rotato.gui.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoView extends JPanel {
	public LogoView() {
		URL url = ClassLoader.getSystemResource("SameAim215.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(url);
		ImageIcon icon = new ImageIcon(img);

		JLabel label = new JLabel(icon);
		this.add(label);
	}
}
