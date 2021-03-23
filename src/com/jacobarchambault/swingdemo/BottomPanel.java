package com.jacobarchambault.swingdemo;

import javax.swing.JButton;
import javax.swing.JPanel;

class BottomPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	BottomPanel() {
		final var exitButton = new JButton(
				"Exit");
		add(
				exitButton);
		exitButton.addActionListener(
				e -> System.exit(
						0));
	}

}
