package com.jacobarchambault.swingdemo;

import java.awt.CardLayout;

import javax.swing.JPanel;

class CardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	CardPanel(
			final CardLayout cardLayout) {
		super(
				cardLayout);
		add(
				new TopPanel());
		add(
				new HiddenPanel());

	}
}
