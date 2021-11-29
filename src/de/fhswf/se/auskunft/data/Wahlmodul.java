package de.fhswf.se.auskunft.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Module, die die Studierenden frei wählen können und keine ECTS Punkte bringen.
 */
public class Wahlmodul extends Modul{
	
	public Wahlmodul() {
		this("", new ArrayList<Float>(), 1, new Date(System.currentTimeMillis()));
	}
	
	public Wahlmodul(String name, ArrayList<Float> notenListe, Integer semester, Date addDatum) {
		this.name = name;
		this.notenListe = notenListe;
		this.semester = semester;
		this.addDatum = addDatum;
		this.ects = 0;
	}
	
	@Override
	public void setEcts(Integer ects) {
		this.ects = 0;
	}
	
}