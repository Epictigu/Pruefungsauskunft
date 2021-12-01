package de.fhswf.se.auskunft.components.custom;

import de.fhswf.se.auskunft.data.Abschlussprüfung;
import de.fhswf.se.auskunft.data.Kolloquium;
import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.PrüfungsleistungenView;
import de.fhswf.se.auskunft.manager.EctsManager;

public class AbschlussGradeField extends GradeField{

	private static final long serialVersionUID = 1L;

	public AbschlussGradeField(Modul modul, FachComponent container) {
		super(modul, container);
		
		updateGrades();
	}
	
	@Override
	public void updateGrades() {
		if(modul instanceof Abschlussprüfung) {
			if(EctsManager.getSumEcts() < 165) {
				gradeAddButton.setEnabled(false);
			} else {
				gradeAddButton.setEnabled(true);
			}
		} else if(modul instanceof Kolloquium) {
			Abschlussprüfung abschluss = PrüfungsleistungenView.getInstance().getAbschluss().getAbschluss();
			gradeAddButton.setEnabled(false);
			if(!abschluss.getNotenListe().isEmpty()) {
				if(abschluss.getNotenListe().get(abschluss.getNotenListe().size() - 1) <= 4.0) {
					gradeAddButton.setEnabled(true);
				}
			}
		}
		
		super.updateGrades();
	}

}
