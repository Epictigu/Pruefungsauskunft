package de.fhswf.se.auskunft.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Modul, von denen die Studierenden einzelne auswählen müssen um ECTS Mindestpunkte zu erreichen.
 */
public class Wahlpflichtmodul {

	private Wahlpflichtfaecher fach;
	private ArrayList<Float> notenListe;
	private Integer semester;
	private Date addDatum;

	public Wahlpflichtmodul() {
		this(null, new ArrayList<Float>(), 1, new Date(System.currentTimeMillis()));
	}
	
	public Wahlpflichtmodul(Wahlpflichtfaecher fach, ArrayList<Float> notenListe, Integer semester, Date addDatum) {
		this.fach = fach;
		this.notenListe = notenListe;
		this.semester = semester;
		this.addDatum = addDatum;
	}
	
	public Wahlpflichtfaecher getFach() {
		return this.fach;
	}

	/**
	 * 
	 * @param fach
	 */
	public void setFach(Wahlpflichtfaecher fach) {
		this.fach = fach;
	}

	public ArrayList<Float> getNotenListe() {
		return this.notenListe;
	}

	/**
	 * 
	 * @param notenListe
	 */
	public void setNotenListe(ArrayList<Float> notenListe) {
		this.notenListe = notenListe;
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
	}
	
	@Override
	public String toString() {
		return ("{Fach: \"" + fach + "\", Noten: \"" + notenListe + "\", Semester: \"" + semester + "\", AddDatum: \"" + addDatum + "\"}");
	}

}