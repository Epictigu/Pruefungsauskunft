package de.fhswf.se.auskunft.components.frames;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import de.fhswf.se.auskunft.components.custom.FachComponent;
import de.fhswf.se.auskunft.data.Abschluss;
import de.fhswf.se.auskunft.manager.EctsManager;

public class AbschlussFrame extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel average;
	private JLabel ects;
	
	private FachComponent kolloquium;
	private FachComponent abschlussPrüfung;
	
	public static AbschlussFrame currentOpenDialog = null;
	public AbschlussFrame(Abschluss abschluss) {
		currentOpenDialog = this;
		
		this.setTitle("Abschlussarbeit/Kolloquium");
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setResizable(false);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 10, 5, 10);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		
		JLabel mainLabel = new JLabel("Abschlussprüfung / Kolloquium", SwingConstants.CENTER);
		mainLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		this.add(mainLabel, c);
		
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.ipady = 30;
		kolloquium = new FachComponent(abschluss.getKolloquium(), false);
		this.add(kolloquium, c);
		abschlussPrüfung = new FachComponent(abschluss.getAbschluss(), false);
		c.gridy = 2;
		this.add(abschlussPrüfung, c);
		
		c.ipady = 0;
		c.gridy = 3;
		average = new JLabel(String.format("Durchschnittsnote: %.2f", EctsManager.getAverage()));
		average.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		average.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		this.add(average, c);
		
		c.gridy = 4;
		ects = new JLabel("Erreichte ECTS-Punkte: " + EctsManager.getSumEcts());
		ects.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		ects.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		this.add(ects, c);
		
		this.setVisible(true);
	}
	
	public void updateAverage() {
		average.setText(String.format("Durchschnittsnote: %.2f", EctsManager.getAverage()));
		ects.setText("Erreichte ECTS-Punkte: " + EctsManager.getSumEcts());
		
		kolloquium.updateComponent();
		abschlussPrüfung.updateComponent();
	}
	
}
