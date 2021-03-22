package com.jacobarchambault.swingdemo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class TopPanel extends JPanel {
	TopField topField = new TopField();

	JButton clearButton = new JButton("Clear");
	Border emptyBdr = BorderFactory.createEmptyBorder(20, 20, 20, 20);
	TopLabel topLabel = new TopLabel("Testing Label ", SwingConstants.RIGHT);
	HiddenLabel hiddenLabel = new HiddenLabel("Now something different displays", SwingConstants.CENTER);

	TopPanel() {
		setBorder(emptyBdr);
		setLayout(new GridLayout(1, 3));
		add(topLabel);
		add(topField);
		add(clearButton);
		clearButton.addActionListener(e -> topField.clearText());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	void showHiddenLabel() {
		remove(topLabel);
		remove(topField);
		remove(clearButton);
		add(hiddenLabel);
		setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), emptyBdr));
		revalidate();
		repaint();
	}

	void showTopLabel() {
		remove(hiddenLabel);
		setBorder(emptyBdr);
		revalidate();
		repaint();
		add(topLabel);
		add(topField);
		add(clearButton);
	}
}
