package com.jacobarchambault.swingdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
	JRadioButton[] RBs;
	JTextField topField;
	JLabel topLabel, hiddenLabel;

	JPanel topPanel, centerPanel, bottomPanel;

	public SwingDemo() {
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		createLabels();
		createTextField();
		createRadioButtons();
		createPanels();
		addPanelComponents();
	}

	@Override
	public void actionPerformed(
			ActionEvent e) {
		if (e.getSource() == RBs[0]) {
			showTopLabel();
		}
		if (e.getSource() == RBs[1]) {
			showHiddenLabel();
		}
		String arg = e.getActionCommand();
		if (arg == "Clear") {
			clearText();
		}
		if (arg == "Exit") {
			System.exit(
					0);
		}
	}

	private void clearText() {
		topField.setText(
				"");
		topField.setBackground(
				Color.white);
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

	public void addPanelComponents() {
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

	private void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < RBs.length; i++) {
			centerPanel.add(
					RBs[i]);
			RBs[i].addActionListener(
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

	public void createLabels() {
		// construct the labels
		hiddenLabel = new JLabel(
				"Now something different displays",
				SwingConstants.CENTER);
		topLabel = new JLabel(
				"Testing Label ",
				SwingConstants.RIGHT);
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
		for (int i = 0; i < RBs.length; i++)
			centerPanel.add(
					RBs[i]);
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
		ButtonGroup RBGroup = new ButtonGroup();
		RBs = new JRadioButton[] { new JRadioButton(
				"Show Labels/Fields",
				true),
				new JRadioButton(
						"Hide Labels/Fields",
						false) };
		for (int i = 0; i < RBs.length; i++) {
			RBGroup.add(
					RBs[i]);
		}
	}

	public void createTextField() {
		// construct the text field
		topField = new JTextField();
	}
}
