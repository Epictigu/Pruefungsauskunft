package de.fhswf.se.auskunft.components.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.fhswf.se.auskunft.components.custom.ExamAddButton;


public class MainHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel mainLabel;
	private ExamAddButton addButton;
	private JCheckBox completedExams;
	
	public MainHeader() {
		this.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		this.setLayout(new BorderLayout());
		
		mainLabel = new JLabel("Prüfungsleistungen");
		mainLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		
		addButton = new ExamAddButton();
		addButton.setPreferredSize(new Dimension(40, 40));
		
		completedExams = new JCheckBox("Abgeschlossene Fächer anzeigen", true);
		completedExams.setFocusable(false);
		
		add(mainLabel, BorderLayout.LINE_START);
		add(addButton, BorderLayout.LINE_END);
		add(completedExams, BorderLayout.PAGE_END);
	}

}
