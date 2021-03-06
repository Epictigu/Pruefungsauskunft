package de.fhswf.se.auskunft.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.fhswf.se.auskunft.sql.PflichtfaecherSQL;

/**
 * Modul, dass die Studierenden auf jeden Fall belegen m?ssen.
 */
public class Pflichtmodul extends Modul{

	public Pflichtmodul() {
		this("", 0,  new ArrayList<Float>(), 1, new Date(System.currentTimeMillis()));
	}
	
	public Pflichtmodul(String name, Integer ects, List<Float> notenListe, Integer semester, Date addDatum) {
		this.name = name;
		this.ects = ects;
		this.notenListe = notenListe;
		this.semester = semester;
		this.addDatum = addDatum;
	}

	@Override
	protected void update() {
		PflichtfaecherSQL.update(this);
	}

	@Override
	protected void updateName(String oldName) {
		PflichtfaecherSQL.updateName(this, oldName);
	}

}