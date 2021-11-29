package de.fhswf.se.auskunft.data;

import java.util.ArrayList;

/**
 * Abschlussnoten, die in seperaten Fenster angezeigt werden sollen.
 */
public class Abschluss {

	private ArrayList<Float> kolloquiumNoten;
	private ArrayList<Float> abschlussNoten;

	public Abschluss() {
		this(new ArrayList<Float>(), new ArrayList<Float>());
	}
	
	public Abschluss(ArrayList<Float> kolloquiumNoten, ArrayList<Float> abschlussNoten) {
		this.kolloquiumNoten = kolloquiumNoten;
		this.abschlussNoten = abschlussNoten;
	}
	
	public ArrayList<Float> getKolloquiumNoten() {
		return this.kolloquiumNoten;
	}

	/**
	 * 
	 * @param kolloquiumNoten
	 */
	public void setKolloquiumNoten(ArrayList<Float> kolloquiumNoten) {
		this.kolloquiumNoten = kolloquiumNoten;
	}

	public ArrayList<Float> getAbschlussNoten() {
		return this.abschlussNoten;
	}

	/**
	 * 
	 * @param abschlussNoten
	 */
	public void setAbschlussNoten(ArrayList<Float> abschlussNoten) {
		this.abschlussNoten = abschlussNoten;
	}

	/**
	 * 
	 * @param kolloquiumNote
	 * @throws IllegalAccessException 
	 */
	public void addKolloquiumNote(Float kolloquiumNote) throws IllegalAccessException {
		if(kolloquiumNoten.size() >= 2) {
			throw new IllegalAccessException("Es dürfen maximal 2 Kolloquiumnoten hinzugefügt werden!");
		}
		Integer i = kolloquiumNote.intValue();
		Float noteBack = kolloquiumNote - i;
		if(!(noteBack == 0.0 || (noteBack >=  0.2999999 && noteBack <= 0.3000009) || (noteBack >= 0.6999999 && noteBack <= 0.7000009)))
			throw new IllegalArgumentException("Ungültige Notenendung! Muss .0, .3 oder .7 sein!");
		if(i < 1 || i > 5 || (i == 4 && noteBack != 0.0))
			throw new IllegalArgumentException("Ungültige Note! Die Note darf nur von 1 bis 5 gehen und die 4 darf keinen Nachkommaanteil haben!");
		kolloquiumNoten.add(kolloquiumNote);
	}

	/**
	 * 
	 * @param abschlussNote
	 * @throws IllegalAccessException 
	 */
	public void addAbschlussNote(Float abschlussNote) throws IllegalAccessException {
		if(abschlussNoten.size() >= 2) {
			throw new IllegalAccessException("Es dürfen maximal 2 Abschlussnoten hinzugefügt werden!");
		}
		Integer i = abschlussNote.intValue();
		Float noteBack = abschlussNote - i;
		if(!(noteBack == 0.0 || (noteBack >=  0.2999999 && noteBack <= 0.3000009) || (noteBack >= 0.6999999 && noteBack <= 0.7000009)))
			throw new IllegalArgumentException("Ungültige Notenendung! Muss .0, .3 oder .7 sein!");
		if(i < 1 || i > 5 || (i == 4 && noteBack != 0.0))
			throw new IllegalArgumentException("Ungültige Note! Die Note darf nur von 1 bis 5 gehen und die 4 darf keinen Nachkommaanteil haben!");
		abschlussNoten.add(abschlussNote);
	}
	
	@Override
	public String toString() {
		return ("{Kolloquiumnoten: \"" + kolloquiumNoten + "\", Abschlussnoten: \"" + abschlussNoten + "\"}");
	}

}