package com.jacobarchambault.swingdemo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CenterPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton[] rBs;
	void addRadioButtonsToCenterPanel() {
		for (int i = 0; i < rBs.length; i++) {
			add(
					rBs[i]);
			rBs[i].addActionListener(
					this);
		}
	}

	CenterPanel() {
		setLayout(
				new GridLayout(
						1,
						2));
		for (int i = 0; i < rBs.length; i++)
			add(
					rBs[i]);
	}
	public void createRadioButtons() {
		// construct the radio buttons and Button Group
		ButtonGroup rBGroup = new ButtonGroup();
		rBs = new JRadioButton[] { new JRadioButton("Show Labels/Fields", true),
				new JRadioButton("Hide Labels/Fields", false) };
		for (int i = 0; i < rBs.length; i++) {
			rBGroup.add(rBs[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
