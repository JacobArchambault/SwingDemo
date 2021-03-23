package com.jacobarchambault.swingdemo;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TopPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JButton clearButton = new JButton(
			"Clear");
	JTextField topField = new JTextField();
	JLabel topLabel = new JLabel(
			"Testing Label ",
			SwingConstants.RIGHT);

	TopPanel() {
		setBorder(
				BorderFactory.createEmptyBorder(
						20,
						20,
						20,
						20));
		setLayout(
				new GridLayout(
						1,
						3));
		add(
				topLabel);
		add(
				topField);
		add(
				clearButton);
		clearButton.addActionListener(
				e -> topField.setText(
						""));
	}
}
