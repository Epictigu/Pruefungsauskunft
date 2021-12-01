package de.fhswf.se.auskunft.components.custom;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import de.fhswf.se.auskunft.components.frames.ExamInformationFrame;
import de.fhswf.se.auskunft.data.Abschlussprüfung;
import de.fhswf.se.auskunft.data.Kolloquium;
import de.fhswf.se.auskunft.data.Modul;

public class FachComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Modul modul;
	
	private JPanel nameEctsGroup;
	private JLabel nameLabel;
	private JLabel ectsLabel;
	
	private InfoButton infoButton;
	private GradeField gradeField;
	
	public FachComponent(Modul modul, boolean showInfoButton) {
		this.modul = modul;
		
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		nameEctsGroup = new JPanel();
		nameEctsGroup.setLayout(new BoxLayout(nameEctsGroup, BoxLayout.PAGE_AXIS));
		
		nameLabel = new JLabel(modul.getName());
		nameLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		nameEctsGroup.add(nameLabel);
		
		ectsLabel = new JLabel(modul.getEcts() + " ECTS");
		nameEctsGroup.add(ectsLabel);
		
		this.add(nameEctsGroup);
		
		if(showInfoButton) {
			infoButton = new InfoButton();
			
			infoButton.setPreferredSize(new Dimension(30, 30));
			
			FachComponent instance = this;
			infoButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new ExamInformationFrame(modul, instance);
				}
			});
			this.add(infoButton);
		}
		
		if(modul instanceof Abschlussprüfung || modul instanceof Kolloquium)
			gradeField = new AbschlussGradeField(modul, this);
		else 
			gradeField = new GradeField(modul, this);
		gradeField.setPreferredSize(new Dimension(60, 30));
		this.add(gradeField);
		
		if(showInfoButton) {
			layout.putConstraint(SpringLayout.EAST, infoButton, 0, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.NORTH, infoButton, 5, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.EAST, gradeField, -5, SpringLayout.WEST, infoButton);
			layout.putConstraint(SpringLayout.NORTH, gradeField, 5, SpringLayout.NORTH, this);
		} else {
			layout.putConstraint(SpringLayout.EAST, gradeField, 0, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.NORTH, gradeField, 5, SpringLayout.NORTH, this);
		}
		
		layout.putConstraint(SpringLayout.WEST, nameEctsGroup, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nameEctsGroup, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, nameEctsGroup, -5, SpringLayout.WEST, gradeField);
	}
	
	public Modul getModul() {
		return modul;
	}
	
	public void updateComponent() {
		nameLabel.setText(modul.getName());
		ectsLabel.setText(modul.getEcts() + " ECTS");
		
		gradeField.updateGrades();
	}
	
}
