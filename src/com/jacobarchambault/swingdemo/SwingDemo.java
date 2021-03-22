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

	public SwingDemo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createRadioButtons();
		createCenterPanel();
		addRadioButtonsToCenterPanel();
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(new BottomPanel(), BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rBs[0]) {
//			topPanel.setVisible(true);
			topPanel.showTopLabel();
		}
		if (e.getSource() == rBs[1]) {
//			topPanel.setVisible(false);
			topPanel.showHiddenLabel();
		}
	}

	private void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < rBs.length; i++) {
			centerPanel.add(rBs[i]);
			rBs[i].addActionListener(this);
		}
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
