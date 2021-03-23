package com.jacobarchambault.swingdemo;

import javax.swing.JFrame;

public class Program {
	public static void main(
			final String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(
				true);
		final var frameInfo = new SwingDemo();
		frameInfo.setSize(
				350,
				250);
		frameInfo.setVisible(
				true);
		frameInfo.setTitle(
				"Swing Demo");
	}

}
