package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class SwingDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton[] rBs = new JRadioButton[] { new JRadioButton(
			"Show Labels/Fields",
			true),
			new JRadioButton(
					"Hide Labels/Fields",
					false) };
	TopPanel topPanel = new TopPanel();
	CenterPanel centerPanel = new CenterPanel();

	SwingDemo() {
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		createRadioButtons();
		addRadioButtonsToCenterPanel();
		add(
				topPanel,
				BorderLayout.NORTH);
		add(
				centerPanel,
				BorderLayout.CENTER);
		add(
				new BottomPanel(),
				BorderLayout.SOUTH);
	}

	private void addRadioButtonsToCenterPanel() {
		for (JRadioButton rB : rBs) {
			centerPanel.add(
					rB);
		}
		rBs[0].addActionListener(
				e -> topPanel.showTopLabel());
		rBs[1].addActionListener(
				e -> topPanel.showHiddenLabel());
	}

	public void createRadioButtons() {
		// construct the radio buttons and Button Group
		ButtonGroup rBGroup = new ButtonGroup();
		for (JRadioButton rB : rBs) {
			rBGroup.add(
					rB);
		}
	}
}
