package com.jacobarchambault.swingdemo;

import javax.swing.JFrame;

public class Program {
	public static void main(
			String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(
				true);
		SwingDemo frameInfo = new SwingDemo();
		frameInfo.setSize(
				350,
				250);
		frameInfo.setVisible(
				true);
		frameInfo.setTitle(
				"Chapter 17 Lab 1");
	}

}