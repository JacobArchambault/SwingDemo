package com.jacobarchambault.swingdemo;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class TopPanel extends JPanel {
	TopField topField = new TopField();

	Border emptyBdr = BorderFactory.createEmptyBorder(20, 20, 20, 20);
	TopLabel topLabel = new TopLabel("Testing Label ", SwingConstants.RIGHT);
	HiddenLabel hiddenLabel = new HiddenLabel("Now something different displays", SwingConstants.CENTER);

	TopPanel() {
		setBorder(emptyBdr);
		setLayout(new GridLayout(1, 2));
		add(topLabel);
		add(topField);
	};

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	void showHiddenLabel() {
		remove(topLabel);
		remove(topField);
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
	}

	void clearText() {
		topField.clearText();
	}
}
