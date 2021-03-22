package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class SwingDemo extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Border emptyBdr = BorderFactory.createEmptyBorder(
			20,
			20,
			20,
			20);
	JRadioButton[] rBs;
	TopField topField;
	// construct the labels
	HiddenLabel hiddenLabel = new HiddenLabel(
			"Now something different displays",
			SwingConstants.CENTER);
	TopLabel topLabel = new TopLabel(
			"Testing Label ",
			SwingConstants.RIGHT);
	JPanel topPanel;
	JPanel centerPanel; 
	JPanel bottomPanel;

	public SwingDemo() {
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		createTextField();
		createRadioButtons();
		createPanels();
		addRadioButtonsToCenterPanel();
		addButtonsToBottomPanel();
		add(
				topPanel,
				BorderLayout.NORTH);
		add(
				centerPanel,
				BorderLayout.CENTER);
		add(
				bottomPanel,
				BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(
			ActionEvent e) {
		if (e.getSource() == rBs[0]) {
			showTopLabel();
		}
		if (e.getSource() == rBs[1]) {
			showHiddenLabel();
		}
		String arg = e.getActionCommand();
		if (arg == "Clear") {
			topField.clearText();
		}
		if (arg == "Exit") {
			System.exit(
					0);
		}
	}

	private void showHiddenLabel() {
		topPanel.remove(
				topLabel);
		topPanel.remove(
				topField);
		topPanel.add(
				hiddenLabel);
		topPanel.setBorder(
				new CompoundBorder(
						LineBorder.createBlackLineBorder(),
						emptyBdr));
		topPanel.revalidate();
		topPanel.repaint();
	}

	private void showTopLabel() {
		topPanel.remove(
				hiddenLabel);
		topPanel.setBorder(
				emptyBdr);
		topPanel.revalidate();
		topPanel.repaint();
		topPanel.add(
				topLabel);
		topPanel.add(
				topField);
	}

	private void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < rBs.length; i++) {
			centerPanel.add(
					rBs[i]);
			rBs[i].addActionListener(
					this);
		}
	}

	private void addButtonsToBottomPanel() {
		JButton buttons[] = new JButton[] { new JButton(
				"Clear"),
				new JButton(
						"Exit") };
		// add the buttons to the bottom panel
		for (int i = 0; i < buttons.length; i++) {
			bottomPanel.add(
					buttons[i]);
			buttons[i].addActionListener(
					this);
		}
	}

	public void createPanels() {
		// construct the different panels
		createTopPanel();
		createCenterPanel();
		bottomPanel = new JPanel();
	}

	private void createCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(
				new GridLayout(
						1,
						2));
		for (int i = 0; i < rBs.length; i++)
			centerPanel.add(
					rBs[i]);
	}

	private void createTopPanel() {
		topPanel = new JPanel();
		topPanel.setBorder(
				emptyBdr);
		topPanel.setLayout(
				new GridLayout(
						1,
						2));
		topPanel.add(
				topLabel);
		topPanel.add(
				topField);
	}

	public void createRadioButtons() {
		// construct the radio buttons and Button Group
		ButtonGroup rBGroup = new ButtonGroup();
		rBs = new JRadioButton[] { new JRadioButton(
				"Show Labels/Fields",
				true),
				new JRadioButton(
						"Hide Labels/Fields",
						false) };
		for (int i = 0; i < rBs.length; i++) {
			rBGroup.add(
					rBs[i]);
		}
	}

	public void createTextField() {
		// construct the text field
		topField = new TopField();
	}
}
