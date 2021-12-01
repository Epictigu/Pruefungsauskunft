package de.fhswf.se.auskunft.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Abschlussnoten, die in seperaten Fenster angezeigt werden sollen.
 */
public class Abschluss {

	private Abschlussprüfung abschluss;
	private Kolloquium kolloquium;

	public Abschluss() {
		this(new ArrayList<Float>(), new ArrayList<Float>());
	}
	
	public Abschluss(List<Float> kolloquiumNoten, List<Float> abschlussNoten) {
		this.abschluss = new Abschlussprüfung(abschlussNoten);
		this.kolloquium = new Kolloquium(kolloquiumNoten);
	}
	
	public List<Float> getKolloquiumNoten() {
		return kolloquium.getNotenListe();
	}

	/**
	 * 
	 * @param kolloquiumNoten
	 */
	public void setKolloquiumNoten(ArrayList<Float> kolloquiumNoten) {
		kolloquium.setNotenListe(kolloquiumNoten);
	}

	public List<Float> getAbschlussNoten() {
		return abschluss.getNotenListe();
	}

	/**
	 * 
	 * @param abschlussNoten
	 */
	public void setAbschlussNoten(ArrayList<Float> abschlussNoten) {
		abschluss.setNotenListe(abschlussNoten);
	}

	/**
	 * 
	 * @param kolloquiumNote
	 * @throws IllegalAccessException 
	 */
	public void addKolloquiumNote(Float kolloquiumNote) throws IllegalAccessException {
		kolloquium.addNote(kolloquiumNote);
	}

	/**
	 * 
	 * @param abschlussNote
	 * @throws IllegalAccessException 
	 */
	public void addAbschlussNote(Float abschlussNote) throws IllegalAccessException {
		abschluss.addNote(abschlussNote);
	}
	
	public Abschlussprüfung getAbschluss() {
		return abschluss;
	}
	
	public Kolloquium getKolloquium() {
		return kolloquium;
	}
	
	@Override
	public String toString() {
		return ("{Kolloquiumnoten: \"" + kolloquium + "\", Abschlussnoten: \"" + abschluss + "\"}");
	}

}