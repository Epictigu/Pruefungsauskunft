package de.fhswf.se.auskunft;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.fhswf.se.auskunft.components.frames.MainFrame;
import de.fhswf.se.auskunft.data.PrüfungsleistungenView;
import de.fhswf.se.auskunft.manager.EctsManager;
import de.fhswf.se.auskunft.sql.AbschlussSQL;
import de.fhswf.se.auskunft.sql.MySql;
import de.fhswf.se.auskunft.sql.PflichtfaecherSQL;
import de.fhswf.se.auskunft.sql.WahlfaecherSQL;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		MySql.connect("pruefungsauskunft", "student", "1234");
		PflichtfaecherSQL.init();
		WahlfaecherSQL.init();
		AbschlussSQL.init();
		
		PrüfungsleistungenView view = PrüfungsleistungenView.getInstance();
		
		view.setPflichtModule(PflichtfaecherSQL.getAll());
		view.setWahlModule(WahlfaecherSQL.getAll());
		view.setAbschluss(AbschlussSQL.getAbschluss());
		
		MainFrame.getInstance();
		
		EctsManager.update();
	}
	
}
