package com.jacobarchambault.swingdemo;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CenterPanel() {
		setLayout(
				new GridLayout(
						1,
						2));
	}

}
