package de.fhswf.se.auskunft;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.fhswf.se.auskunft.components.frames.MainFrame;
import de.fhswf.se.auskunft.data.Pflichtmodul;
import de.fhswf.se.auskunft.data.PrüfungsleistungenView;
import de.fhswf.se.auskunft.data.Wahlmodul;
import de.fhswf.se.auskunft.data.Wahlpflichtfaecher;
import de.fhswf.se.auskunft.data.Wahlpflichtmodul;
import de.fhswf.se.auskunft.manager.ResourceLoader;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		new MainFrame();
		ResourceLoader.loadFonts();
		
		try {
			PrüfungsleistungenView view = PrüfungsleistungenView.getInstance();
			Pflichtmodul mathematik = new Pflichtmodul("Mathematik 1", 6, new ArrayList<Float>(), 1, new Date(System.currentTimeMillis()));
			mathematik.addNote(5.0f);
			mathematik.addNote(2.3f);
			view.addPflichtModul(mathematik);
			view.addPflichtModul(new Pflichtmodul("Grundlagen der Informatik 3", 6, new ArrayList<Float>(), 3, new Date(System.currentTimeMillis())));
			view.addPflichtModul(new Pflichtmodul("Sotware Enginnering", 6, new ArrayList<Float>(), 5, new Date(System.currentTimeMillis())));
			
			view.addWahlpflichtModul(new Wahlpflichtmodul(Wahlpflichtfaecher.FrontendFrameworksFuerWebanwendungen, new ArrayList<Float>(), 5, new Date(System.currentTimeMillis())));
			Wahlpflichtmodul virtualisierung = new Wahlpflichtmodul(Wahlpflichtfaecher.Virtualisierung, new ArrayList<Float>(), 5, new Date(System.currentTimeMillis()));
			virtualisierung.addNote(2.0f);
			view.addWahlpflichtModul(virtualisierung);
			
			view.addWahlModul(new Wahlmodul("Business English", new ArrayList<Float>(), 6, new Date(System.currentTimeMillis())));
		
			view.getAbschluss().addAbschlussNote(5.0f);
			view.getAbschluss().addAbschlussNote(3.0f);
			view.getAbschluss().addKolloquiumNote(3.7f);
			
			System.out.println(view);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
