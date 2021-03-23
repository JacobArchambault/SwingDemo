package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class SwingDemo extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	CenterPanel centerPanel = new CenterPanel();
	JRadioButton[] rBs = new JRadioButton[] { new JRadioButton(
			"Show Labels/Fields",
			true),
			new JRadioButton(
					"Hide Labels/Fields",
					false) };
	TopPanel topPanel = new TopPanel();
	HiddenPanel hiddenPanel = new HiddenPanel();
	JPanel cards = new JPanel(new CardLayout());

	
	SwingDemo() {
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		cards.add(topPanel);
		cards.add(hiddenPanel); 
		add(cards, BorderLayout.NORTH);
		addRadioButtonsToCenterPanel();
		add(
				centerPanel,
				BorderLayout.CENTER);
		add(
				new BottomPanel(),
				BorderLayout.SOUTH);
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
				e -> {topPanel.setVisible(true); hiddenPanel.setVisible(false);});
		rBs[1].addActionListener(
				e -> {hiddenPanel.setVisible(true); topPanel.setVisible(false);});
	}
}
