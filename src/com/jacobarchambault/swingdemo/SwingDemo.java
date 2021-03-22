package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	JRadioButton[] rBs;
	TopPanel topPanel = new TopPanel();
	JPanel centerPanel;

	public SwingDemo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createRadioButtons();
		createCenterPanel();
		addRadioButtonsToCenterPanel();
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(new BottomPanel(), BorderLayout.SOUTH);
	}

	private void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < rBs.length; i++) {
			centerPanel.add(rBs[i]);
		}
		rBs[0].addActionListener(e -> topPanel.showTopLabel());
		rBs[1].addActionListener(e -> topPanel.showHiddenLabel());
	}


	private void createCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 2));
	}

	public void createRadioButtons() {
		// construct the radio buttons and Button Group
		ButtonGroup rBGroup = new ButtonGroup();
		rBs = new JRadioButton[] { new JRadioButton("Show Labels/Fields", true),
				new JRadioButton("Hide Labels/Fields", false) };
		for (int i = 0; i < rBs.length; i++) {
			rBGroup.add(rBs[i]);
		}
	}
}
