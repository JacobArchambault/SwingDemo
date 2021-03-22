package com.jacobarchambault.swingdemo;

import java.awt.Color;

import javax.swing.JTextField;

public class TopField extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	void clearText() {
		setText(
				"");
		setBackground(
				Color.white);
	}

}
