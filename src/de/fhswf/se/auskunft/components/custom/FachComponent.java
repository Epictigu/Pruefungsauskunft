package de.fhswf.se.auskunft.components.custom;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.fhswf.se.auskunft.data.Modul;

public class FachComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Modul modul;
	
	private JPanel nameEctsGroup;
	private JLabel nameLabel;
	private JLabel ectsLabel;
	
	private InfoButton infoButton;
	private GradeField gradeField;
	
	public FachComponent(Modul modul) {
		this.modul = modul;
		
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = c.gridwidth = 1;
		c.weightx = 50;
		c.gridx = 0;
		c.gridy = 0;
		
		nameEctsGroup = new JPanel();
		nameEctsGroup.setLayout(new BoxLayout(nameEctsGroup, BoxLayout.PAGE_AXIS));
		
		nameLabel = new JLabel(modul.getName());
		nameLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		nameEctsGroup.add(nameLabel);
		
		ectsLabel = new JLabel(modul.getEcts() + " ECTS");
		nameEctsGroup.add(ectsLabel);
		
		
		this.add(nameEctsGroup);
		
		infoButton = new InfoButton();
		infoButton.setPreferredSize(new Dimension(30, 30));
		c.weightx = 25;
		c.gridx = 1;
		this.add(infoButton);
		
		gradeField = new GradeField(modul);
		gradeField.setPreferredSize(new Dimension(60, 30));
		c.gridx = 2;
		this.add(gradeField);
		
		layout.putConstraint(SpringLayout.EAST, infoButton, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, infoButton, 5, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.EAST, gradeField, -5, SpringLayout.WEST, infoButton);
		layout.putConstraint(SpringLayout.NORTH, gradeField, 5, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, nameEctsGroup, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nameEctsGroup, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, nameEctsGroup, -5, SpringLayout.WEST, gradeField);
	}
	
	public Modul getModul() {
		return modul;
	}
	
}
