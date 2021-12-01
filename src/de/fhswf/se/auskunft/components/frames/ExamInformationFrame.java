package de.fhswf.se.auskunft.components.frames;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import de.fhswf.se.auskunft.components.custom.FachComponent;
import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.Pflichtmodul;
import de.fhswf.se.auskunft.data.PrüfungsleistungenView;
import de.fhswf.se.auskunft.data.Wahlmodul;
import de.fhswf.se.auskunft.manager.EctsManager;

public class ExamInformationFrame extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField fachNameField;
	private JSpinner fachEctsSpinner;
	private JSpinner fachSemesterSpinner;
	
	public ExamInformationFrame(Modul modul, FachComponent component) {
		this.setTitle("Fachinformationen");
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setModal(true);
		this.setResizable(false);
		this.setSize(300, 310);
		this.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 10, 5, 10);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;
		JLabel typeLabel = new JLabel("Fachart: ", SwingConstants.RIGHT);
		this.add(typeLabel, c);
		c.gridx = 1;
		c.weightx = 1;
		JLabel fachTypLabel = new JLabel((modul instanceof Pflichtmodul) ? "Pflichtfach" : "Wahlfach");
		this.add(fachTypLabel, c);
		
		
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		JLabel nameLabel = new JLabel("Fachname: ", SwingConstants.RIGHT);
		this.add(nameLabel, c);
		fachNameField = new JTextField(modul.getName());
		fachNameField.setEnabled(false);
		c.gridx = 1;
		c.weightx = 1;
		this.add(fachNameField, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.weightx = 0;
		JLabel ectsLabel = new JLabel("ECTS-Punkte: ", SwingConstants.RIGHT);
		this.add(ectsLabel, c);
		c.gridx = 1;
		c.weightx = 1;
		fachEctsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
		fachEctsSpinner.setValue(modul.getEcts());
		fachEctsSpinner.setEnabled(false);
		this.add(fachEctsSpinner, c);
		
		c.gridy = 3;
		c.gridx = 0;
		c.weightx = 0;
		JLabel semesterLabel = new JLabel("Semester: ", SwingConstants.RIGHT);
		this.add(semesterLabel, c);
		c.gridx = 1;
		c.weightx = 1;
		fachSemesterSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		fachSemesterSpinner.setValue(modul.getSemester());
		fachSemesterSpinner.setEnabled(false);
		this.add(fachSemesterSpinner, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.weightx = 0;
		JLabel gradeLabel = new JLabel("Noten: ", SwingConstants.RIGHT);
		this.add(gradeLabel, c);
		c.gridx = 1;
		c.weightx = 1;
		
		for(int i = 1; i <= 3; i++) {
			if(modul.getNotenListe().size() >= i) {
				this.add(new JLabel(modul.getNotenListe().get(i - 1) +"    " + i + ". Versuch"), c);
			} else {
				this.add(new JLabel("-        " + i + ". Versuch"), c);
			}
			c.gridy++;
		}
		
		c.gridx = 0;
		c.gridwidth = 2;
		
		JCheckBox checkBox = new JCheckBox("Bearbeiten");
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					fachNameField.setEnabled(true);
					if(modul instanceof Pflichtmodul)
						fachEctsSpinner.setEnabled(true);
					fachSemesterSpinner.setEnabled(true);
				} else {
					fachNameField.setEnabled(false);
					fachEctsSpinner.setEnabled(false);
					fachSemesterSpinner.setEnabled(false);
				}
			}
		});
		this.add(checkBox, c);
		
		c.gridy++;
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton cancelButton = new JButton("Abbrechen");
		buttonPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JButton saveButton = new JButton("Speichern");
		buttonPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!fachNameField.getText().equals(modul.getName()))
					modul.setName(fachNameField.getText());
				if((Integer) fachEctsSpinner.getValue() != modul.getEcts()) {
					modul.setEcts((Integer)fachEctsSpinner.getValue());
					EctsManager.update();
				}
				if((Integer) fachSemesterSpinner.getValue() != modul.getSemester()) {
					MainFrame.getInstance().removeExam(modul);
					modul.setSemester((Integer)fachSemesterSpinner.getValue());
					MainFrame.getInstance().addExam(modul);
				}
				component.updateComponent();
				dispose();
			}
		});
		JButton deleteButton = new JButton("Löschen");
		buttonPanel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int del = JOptionPane.showConfirmDialog(null, "Soll das ausgewählte Fach wirklich gelöscht werden?");
				if(del == 0) {
					if(modul instanceof Pflichtmodul) {
						PrüfungsleistungenView.getInstance().removePflichtModul((Pflichtmodul) modul);
					} else {
						PrüfungsleistungenView.getInstance().removeWahlModul((Wahlmodul) modul);
					}
					dispose();
					EctsManager.update();
				} else if(del == 2) {
					dispose();
				}
			}
		});
		
		this.add(buttonPanel, c);
		
		this.setVisible(true);
	}
	
}
