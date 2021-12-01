package de.fhswf.se.auskunft.components.custom;

import de.fhswf.se.auskunft.data.Abschlusspr�fung;
import de.fhswf.se.auskunft.data.Kolloquium;
import de.fhswf.se.auskunft.data.Modul;
import de.fhswf.se.auskunft.data.Pr�fungsleistungenView;
import de.fhswf.se.auskunft.manager.EctsManager;

public class AbschlussGradeField extends GradeField{

	private static final long serialVersionUID = 1L;

	public AbschlussGradeField(Modul modul, FachComponent container) {
		super(modul, container);
		
		updateGrades();
	}
	
	@Override
	public void updateGrades() {
		if(modul instanceof Abschlusspr�fung) {
			if(EctsManager.getSumEcts() < 165) {
				gradeAddButton.setEnabled(false);
			} else {
				gradeAddButton.setEnabled(true);
			}
		} else if(modul instanceof Kolloquium) {
			Abschlusspr�fung abschluss = Pr�fungsleistungenView.getInstance().getAbschluss().getAbschluss();
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
