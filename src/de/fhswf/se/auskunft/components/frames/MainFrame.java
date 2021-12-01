package de.fhswf.se.auskunft.components.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import de.fhswf.se.auskunft.components.panels.ExamList;
import de.fhswf.se.auskunft.components.panels.MainFooter;
import de.fhswf.se.auskunft.components.panels.MainHeader;
import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.Pflichtmodul;
import de.fhswf.se.auskunft.data.PrüfungsleistungenView;
import de.fhswf.se.auskunft.data.Wahlmodul;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static MainFrame instance = null;
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private ExamList examList;
	private MainFooter mainFooter;
	
	private MainFrame() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Prüfungsauskunft");
		this.setSize(300, 700);
		this.setMinimumSize(new Dimension(300, 700));
		this.setLocationRelativeTo(null);
		
		MainHeader mainHeader = new MainHeader();
		this.add(mainHeader, BorderLayout.PAGE_START);
		
		examList = new ExamList();
		
		for(Pflichtmodul modul : PrüfungsleistungenView.getInstance().getPflichtModule()) {
			examList.addModul(modul);
		}
		
		for(Wahlmodul modul : PrüfungsleistungenView.getInstance().getWahlModule()) {
			examList.addModul(modul);
		}
		
		this.add(examList, BorderLayout.CENTER);
		
		mainFooter = new MainFooter();
		this.add(mainFooter, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
	
	public void addExam(Modul modul) {
		examList.addModul(modul);
	}
	
	public void removeExam(Modul modul) {
		examList.removeModul(modul);
	}
	
	public void setShowFinishedExams(boolean b) {
		if(b)
			examList.showAllExams();
		else
			examList.hideFinishedExams();
	}
	
	public boolean finishedExamsShown(){
		return examList.finishedExamsShown();
	}
	
	public void updateFooter() {
		mainFooter.updateFooter();
	}
	
}
