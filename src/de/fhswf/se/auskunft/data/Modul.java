package de.fhswf.se.auskunft.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Modul {

	protected String name;
	protected Integer ects;
	protected List<Float> notenListe;
	protected Integer semester;
	protected Date addDatum;
	
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		update();
	}

	public Integer getEcts() {
		return this.ects;
	}

	/**
	 * 
	 * @param ects
	 */
	public void setEcts(Integer ects) {
		this.ects = ects;
		update();
	}

	public List<Float> getNotenListe() {
		return this.notenListe;
	}

	/**
	 * 
	 * @param notenListe
	 */
	public void setNotenListe(ArrayList<Float> notenListe) {
		this.notenListe = notenListe;
		update();
	}

	/**
	 * 
	 * @param note
	 * @throws IllegalAccessException 
	 */
	public void addNote(Float note) throws IllegalAccessException {
		if(notenListe.size() >= 3) {
			throw new IllegalAccessException("Es dürfen maximal 3 Noten hinzugefügt werden!");
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

	public Integer getSemester() {
		return this.semester;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(Integer semester) {
		this.semester = semester;
		update();
	}

	public Date getAddDatum() {
		return this.addDatum;
	}

	/**
	 * 
	 * @param addDatum
	 */
	public void setAddDatum(Date addDatum) {
		this.addDatum = addDatum;
		update();
	}
	
	protected abstract void update();
	
	@Override
	public String toString() {
		return ("{Name: \"" + name + "\", ECTS: \"" + ects + "\", Noten: \"" + notenListe + "\", Semester: \"" + semester + "\", AddDatum: \"" + addDatum + "\"}");
	}
	
}
