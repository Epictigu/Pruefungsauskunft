package de.fhswf.se.auskunft.components.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.Pflichtmodul;
import de.fhswf.se.auskunft.data.Wahlmodul;
import de.fhswf.se.auskunft.sql.PflichtfaecherSQL;
import de.fhswf.se.auskunft.sql.WahlfaecherSQL;

public class AddExamFrame extends JDialog{
		
	/** TODO Add comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 1L;
	private static AddExamFrame instance = null;
	public static AddExamFrame getInstance() {
		if(instance == null)
			instance = new AddExamFrame();
		return instance;
	}
	
	private JComboBox<String> fachTypBox;
	private JTextField fachNameField;
	private JSpinner fachEctsSpinner;
	private JSpinner fachSemesterSpinner;
	
	private AddExamFrame() {
		this.setTitle("Fach hinzufügen");
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setModal(true);
		this.setResizable(false);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		
		
		
		String[] types = { "Pflichtfach", "Wahlfach" };
		
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
		fachTypBox = new JComboBox<String>(types);
		fachTypBox.setSelectedIndex(0);
		this.add(fachTypBox, c);
		fachTypBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fachTypBox.getSelectedIndex() == 1) {
					fachEctsSpinner.setEnabled(false);
					fachEctsSpinner.setValue(0);
				} else {
					fachEctsSpinner.setEnabled(true);
				}
			}
		});
		
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		JLabel nameLabel = new JLabel("Fachname: ", SwingConstants.RIGHT);
		this.add(nameLabel, c);
		fachNameField = new JTextField();
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
		this.add(fachEctsSpinner, c);
		
		c.gridy = 3;
		c.gridx = 0;
		c.weightx = 0;
		JLabel semesterLabel = new JLabel("Semester: ", SwingConstants.RIGHT);
		this.add(semesterLabel, c);
		c.gridx = 1;
		c.weightx = 1;
		fachSemesterSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		this.add(fachSemesterSpinner, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 2;
		JButton confirmButton = new JButton("Hinzufügen");
		this.add(confirmButton, c);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveExam();
			}
		});
	}
	
	public void openFrame() {
		fachTypBox.setSelectedIndex(0);
		fachNameField.setText("");
		fachEctsSpinner.setValue(0);
		fachSemesterSpinner.setValue(1);
		
		this.setVisible(true);
	}
	
	private void saveExam() {
		Modul m = null;
		if(fachTypBox.getSelectedIndex() == 0) { 
			m = new Pflichtmodul(fachNameField.getText(), (Integer) fachEctsSpinner.getValue(), new ArrayList<Float>(), (Integer) fachSemesterSpinner.getValue(), new Date(System.currentTimeMillis()));
			PflichtfaecherSQL.addNew((Pflichtmodul) m);
		} else { 
			m = new Wahlmodul(fachNameField.getText(), new ArrayList<Float>(), (Integer) fachSemesterSpinner.getValue(), new Date(System.currentTimeMillis()));
			WahlfaecherSQL.addNew((Wahlmodul)m);
		}
		MainFrame.getInstance().addExam(m);
		setVisible(false);
	}
	
}
