package de.fhswf.se.auskunft.components.frames;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.fhswf.se.auskunft.components.custom.GradeField;
import de.fhswf.se.auskunft.data.Modul;

public class AddGradeFrame extends JDialog{

	private static final long serialVersionUID = 1L;
	
	
	private JComboBox<Float> gradeComboBox;
	
	public AddGradeFrame(Modul modul, GradeField gradeField) {
		this.setTitle("Note hinzufügen");
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
		
		Float[] grades = { 1.0F, 1.3F, 1.7F, 2.0F, 2.3F, 2.7F, 3.0F, 3.3F, 3.7F, 4.0F, 5.0F };
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 10, 5, 10);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridwidth = 2;
		
		JLabel typeLabel = new JLabel(modul.getName(), SwingConstants.CENTER);
		typeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		typeLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		header.add(typeLabel);
		JLabel tryLabel = new JLabel((modul.getNotenListe().size() + 1) + ". Versuch", SwingConstants.CENTER);
		tryLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		tryLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
		header.add(tryLabel);
		
		this.add(header, c);
		
		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 0;
		JLabel gradeLabel = new JLabel("Note:", SwingConstants.RIGHT);
		this.add(gradeLabel, c);
		
		c.gridx = 1;
		gradeComboBox = new JComboBox<Float>(grades);
		this.add(gradeComboBox, c);
		
		c.gridwidth = 2;
		c.gridy = 3;
		c.gridx = 0;
		JButton addGrade = new JButton("Hinzufügen");
		this.add(addGrade, c);
		
		
		addGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modul.addNote((Float) gradeComboBox.getSelectedItem());
					gradeField.updateGrades();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		this.setVisible(true);
	}
	
}
