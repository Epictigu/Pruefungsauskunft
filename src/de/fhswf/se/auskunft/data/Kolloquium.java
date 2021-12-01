package de.fhswf.se.auskunft.data;

import java.util.List;

import de.fhswf.se.auskunft.Constants;
import de.fhswf.se.auskunft.sql.AbschlussSQL;

public class Kolloquium extends Modul{
	
	public Kolloquium(List<Float> notenListe) {
		this.notenListe = notenListe;
		this.name = "Kolloquium";
		
		MAX_GRADES = 2;
	}
	
	@Override
	protected void update() {
		AbschlussSQL.updateKolloquium(this);
	}

	@Override
	protected void updateName(String oldName) {
		System.err.println("Ungültiger Zugriff! UpdateName-Funktion steht nicht zur Verfügung für die Kolloquium.");
	}
	
	@Override
	public void setName(String name) {
		System.err.println("Ungültiger Zugriff! UpdateName-Funktion steht nicht zur Verfügung für die Kolloquium.");
	}
	
	@Override
	public Integer getEcts() {
		return Constants.ECTS_KOLLOQUIUM;
	}
	
	@Override
	public void addNote(Float note) throws IllegalAccessException {
		if(notenListe.size() >= 2) {
			throw new IllegalAccessException("Es dürfen maximal 2 Kolloquiumnoten hinzugefügt werden!");
		}
		Integer i = note.intValue();
		Float noteBack = note - i;
		if(!(noteBack == 0.0 || (noteBack >=  0.2999999 && noteBack <= 0.3000009) || (noteBack >= 0.6999999 && noteBack <= 0.7000009)))
			throw new IllegalArgumentException("Ungültige Notenendung! Muss .0, .3 oder .7 sein!");
		if(i < 1 || i > 5 || (i == 4 && noteBack != 0.0))
			throw new IllegalArgumentException("Ungültige Note! Die Note darf nur von 1 bis 5 gehen und die 4 darf keinen Nachkommaanteil haben!");
		notenListe.add(note);
		update();
	}
	
}
