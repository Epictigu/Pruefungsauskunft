package de.fhswf.se.auskunft.components.panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.fhswf.se.auskunft.components.custom.FachComponent;
import de.fhswf.se.auskunft.data.Modul;

public class ExamList extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public static Map<Integer, List<FachComponent>> modulBySemester = new HashMap<Integer, List<FachComponent>>();
	public static Map<Integer, Integer> semesterGridY = new HashMap<Integer, Integer>();
	
	public ExamList() {
		setLayout(new GridBagLayout());
		
		JPanel emptySpace = new JPanel();
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridy = 99999;
		
		add(emptySpace, c);
	}
	
	public void addModul(Modul modul) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		FachComponent fach = new FachComponent(modul);
		addModulToMap(fach);
		c.gridx = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridy = modul.getSemester() * 1000 + semesterGridY.get(modul.getSemester());
		c.ipady = 30;
		
		add(fach, c);
		
		revalidate();
	}
	
	private void addSemesterLabel(Integer semester) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel label = new JLabel(semester + ". Semester");
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		
		c.gridx = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridy = semester * 1000;
		
		add(label, c);
		repaint();
	}
	
	private void addModulToMap(FachComponent fach) {
		List<FachComponent> l = new ArrayList<FachComponent>();
		if(modulBySemester.containsKey(fach.getModul().getSemester()))
			l = modulBySemester.get(fach.getModul().getSemester());
		else
			addSemesterLabel(fach.getModul().getSemester());
		l.add(fach);
		
		modulBySemester.put(fach.getModul().getSemester(), l);
		
		Integer gridY = 0;
		if(semesterGridY.containsKey(fach.getModul().getSemester()))
			gridY = semesterGridY.get(fach.getModul().getSemester());
		gridY++;
		
		semesterGridY.put(fach.getModul().getSemester(), gridY);
	}
	
}
