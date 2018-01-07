package com.rotato.gui.view;

import java.awt.Font;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.rotato.aim.Mouse;

public class MouseView extends JPanel {

	public MouseView() {
		setBorder(new EmptyBorder(25, 10, 25, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Consumer<Integer> updateMouseDelay = (x) -> Mouse.setDelay(x);
		Consumer<Integer> updateMouseMax = (x) -> Mouse.setMaxMultiplier(x);

		JLabel delayLabel = new JLabel("Mouse Movement Delay");
		delayLabel.setToolTipText(
				"Increase this setting if you are noticing you get different values for 360s in the same game");
		delayLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		delayLabel.setAlignmentX(0.5f);
		add(delayLabel);

		JSlider delay = new JSlider();
		delay.setPaintTicks(true);
		delay.setSnapToTicks(true);
		delay.setMinorTickSpacing(1);
		delay.setMaximum(20);
		delay.setFocusable(false);
		delay.setMinimum(1);
		delay.setValue(1);
		delay.setBorder(new EmptyBorder(10, 0, 10, 0));
		add(delay);
		delay.addChangeListener(
				new LabelUpdate(delayLabel, "ms", updateMouseDelay));

		JLabel speedLabel = new JLabel("Max Mouse Movement Speed");
		speedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		speedLabel.setAlignmentX(0.5f);
		add(speedLabel);

		JSlider speed = new JSlider();
		speed.setSnapToTicks(true);
		speed.setPaintLabels(true);
		speed.setPaintTicks(true);
		speed.setFocusable(false);
		speed.setMinimum(1);
		speed.setValue(10);
		speed.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(speed);
		speed.addChangeListener(
				new LabelUpdate(speedLabel, "px", updateMouseMax));
	}
}

class LabelUpdate implements ChangeListener {
	private JLabel label;
	private String template;
	private String unit;
	private Consumer<Integer> action;

	public LabelUpdate(JLabel label, String unit, Consumer<Integer> action) {
		this.label = label;
		this.template = label.getText();
		this.unit = unit;
		this.action = action;
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		JSlider source = (JSlider) event.getSource();
		label.setText(template + " (" + source.getValue() + unit + ")");
		action.accept(source.getValue());
	}
}