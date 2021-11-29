package de.fhswf.se.auskunft.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Modul, dass die Studierenden auf jeden Fall belegen müssen.
 */
public class Pflichtmodul extends Modul{

	public Pflichtmodul() {
		this("", 0,  new ArrayList<Float>(), 1, new Date(System.currentTimeMillis()));
	}
	
	public Pflichtmodul(String name, Integer ects, ArrayList<Float> notenListe, Integer semester, Date addDatum) {
		this.name = name;
		this.ects = ects;
		this.notenListe = notenListe;
		this.semester = semester;
		this.addDatum = addDatum;
	}

}