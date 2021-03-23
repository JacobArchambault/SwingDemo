package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

class SwingDemo extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cardLayout = new CardLayout();
	CardPanel cards = new CardPanel(
			cardLayout);
	CenterPanel centerPanel = new CenterPanel();
	JRadioButton[] rBs = new JRadioButton[] { new JRadioButton(
			"Show Labels/Fields",
			true),
			new JRadioButton(
					"Hide Labels/Fields",
					false) };

	SwingDemo(String title) {
		super(title);
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		add(
				cards,
				BorderLayout.NORTH);
		addRadioButtonsToCenterPanel();
		add(
				centerPanel,
				BorderLayout.CENTER);
		add(
				new BottomPanel(),
				BorderLayout.SOUTH);
		setSize(
				350,
				250);
		setVisible(
				true);
	}

	private void addRadioButtonsToCenterPanel() {
		final var rBGroup = new ButtonGroup();
		for (final JRadioButton rB : rBs) {
			rBGroup.add(
					rB);
			centerPanel.add(
					rB);
		}
		rBs[0].addActionListener(
				e -> {
					cardLayout.first(
							cards);
				});
		rBs[1].addActionListener(
				e -> {
					cardLayout.last(
							cards);
				});
	}
}
