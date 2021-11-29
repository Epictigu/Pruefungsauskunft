package de.fhswf.se.auskunft.components.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFooter extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton finalExamButton;
	private JLabel ectsLabel;
	private JLabel averageLabel;
	
	public MainFooter() {
		this.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		
		ectsLabel = new JLabel("ECTS: ...");
		add(ectsLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridy = 1;
		c.gridx = 1;
		averageLabel = new JLabel("Durchschnitt: ...");
		add(averageLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 2;
		
		finalExamButton = new JButton("Abschlussprüfung / Kolloquium");
		add(finalExamButton, c);
	}

}
