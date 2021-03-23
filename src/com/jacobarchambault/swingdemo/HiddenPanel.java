package com.jacobarchambault.swingdemo;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

class HiddenPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JLabel hiddenLabel = new JLabel(
			"Now something different displays",
			SwingConstants.CENTER);

	HiddenPanel() {
		add(
				hiddenLabel);
		setBorder(
				new CompoundBorder(
						LineBorder.createBlackLineBorder(),
						BorderFactory.createEmptyBorder(
								20,
								20,
								20,
								20)));
	}
}
