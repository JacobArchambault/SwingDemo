package com.jacobarchambault.swingdemo;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	BottomPanel() {
		JButton exitButton = new JButton("Exit");
		add(exitButton);
		exitButton.addActionListener(e -> System.exit(0));
	}

}
