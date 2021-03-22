package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class SwingDemo extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton[] rBs;
	TopPanel topPanel = new TopPanel();
	JPanel centerPanel;
	JPanel bottomPanel;

	public SwingDemo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createRadioButtons();
		createPanels();
		addRadioButtonsToCenterPanel();
		addExitButtonToBottomPanel();
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rBs[0]) {
			topPanel.showTopLabel();
		}
		if (e.getSource() == rBs[1]) {
			topPanel.showHiddenLabel();
		}
	}

	private void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < rBs.length; i++) {
			centerPanel.add(rBs[i]);
			rBs[i].addActionListener(this);
		}
	}

	private void addExitButtonToBottomPanel() {
		JButton exitButton = new JButton("Exit");
		bottomPanel.add(exitButton);
		exitButton.addActionListener(e -> System.exit(0));
	}

	public void createPanels() {
		// construct the different panels
		createCenterPanel();
		bottomPanel = new JPanel();
	}

	private void createCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 2));
		for (int i = 0; i < rBs.length; i++)
			centerPanel.add(rBs[i]);
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
