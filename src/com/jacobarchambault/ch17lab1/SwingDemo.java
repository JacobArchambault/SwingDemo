package com.jacobarchambault.ch17lab1;

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
	JButton buttons[] = new JButton[] {new JButton("Clear"), new JButton("Exit")};
	Border emptyBdr = BorderFactory.createEmptyBorder(20, 20, 20, 20);
	Border compoundBorder = new CompoundBorder(LineBorder.createBlackLineBorder(), emptyBdr);
	ButtonGroup RBGroup;
	JRadioButton[] RBs;
	JTextField topField;
	JLabel topLabel, hiddenLabel;

	JPanel topPanel, centerPanel, bottomPanel;

	public SwingDemo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createLabels();
		createTextField();
		createButtons();
		createRadioButtons();
		createPanels();
		addPanelComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			System.exit(0);
		}

	}

	private void clearText() {
		topField.setText("");
		topField.setBackground(Color.white);
	}

	private void showHiddenLabel() {
		topPanel.remove(topLabel);
		topPanel.remove(topField);
		topPanel.add(hiddenLabel);
		topPanel.setBorder(compoundBorder);
		topPanel.revalidate();
		topPanel.repaint();
	}

	private void showTopLabel() {
		topPanel.remove(hiddenLabel);
		topPanel.setBorder(emptyBdr);
		topPanel.revalidate();
		topPanel.repaint();
		topPanel.add(topLabel);
		topPanel.add(topField);
	}

	public void addPanelComponents() {
		for (int i = 0; i < RBs.length; i++) {
			centerPanel.add(RBs[i]);
			RBs[i].addActionListener(this);
		}
		// add the buttons to the bottom panel
		for (int i = 0; i < buttons.length; i++) {
			bottomPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	public void createButtons() {
	}

	public void createLabels() {
		// construct the labels
		hiddenLabel = new JLabel("Now something different displays", SwingConstants.CENTER);
		topLabel = new JLabel("Testing Label ", SwingConstants.RIGHT);
	}

	public void createPanels() {
		// construct the different panels
		topPanel = new JPanel();
		topPanel.setBorder(emptyBdr);
		topPanel.setLayout(new GridLayout(1, 2));
		topPanel.add(topLabel);
		topPanel.add(topField);
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 2));
		for (int i = 0; i < RBs.length; i++)
			centerPanel.add(RBs[i]);
		bottomPanel = new JPanel();
		JPanel hiddenPanel = new JPanel(new GridLayout(1, 2));
	}

	public void createRadioButtons() {
		// construct the radio buttons and Button Group
		RBGroup = new ButtonGroup();
		RBs = new JRadioButton[2];
		RBs[0] = new JRadioButton("Show Labels/Fields", true);
		RBs[1] = new JRadioButton("Hide Labels/Fields", false);
		for (int i = 0; i < RBs.length; i++) {
			RBGroup.add(RBs[i]);
		}
	}

	public void createTextField() {
		// construct the text field
		topField = new JTextField();
	}
}
