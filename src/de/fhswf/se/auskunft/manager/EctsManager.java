package de.fhswf.se.auskunft.manager;

import java.util.ArrayList;
import java.util.List;

import de.fhswf.se.auskunft.components.frames.MainFrame;
import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.Pr�fungsleistungenView;

public class EctsManager {

	private static Integer sumEcts = 0;
	private static Float average = 0.0f;

	public static void update() {
		sumEcts = 0;
		List<Modul> module = new ArrayList<Modul>();
		module.addAll(Pr�fungsleistungenView.getInstance().getPflichtModule());
		module.add(Pr�fungsleistungenView.getInstance().getAbschluss().getAbschluss());
		module.add(Pr�fungsleistungenView.getInstance().getAbschluss().getKolloquium());
		for (Modul modul : module) {
			if (modul.getEcts() <= 0)
				continue;
			if (modul.getNotenListe().isEmpty())
				continue;
			if (modul.getNotenListe().get(modul.getNotenListe().size() - 1) != 5.0f) {
				sumEcts += modul.getEcts();
			}
		}
		average = 0.0f;
		for (Modul modul : module) {
			if (modul.getEcts() <= 0)
				continue;
			if (modul.getNotenListe().isEmpty())
				continue;
			if (modul.getNotenListe().get(modul.getNotenListe().size() - 1) != 5.0f) {
				average += modul.getNotenListe().get(modul.getNotenListe().size() - 1) * modul.getEcts() / sumEcts;
			}
		}
		
		MainFrame.getInstance().updateFooter();
	}

	public static Integer getSumEcts() {
		return sumEcts;
	}

	public static Float getAverage() {
		return average;
	}

}
