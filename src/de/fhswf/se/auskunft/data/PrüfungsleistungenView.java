package de.fhswf.se.auskunft.data;

import java.util.ArrayList;
import java.util.List;

/**
 * View, der die einzelnen F�cher beinhaltet und darstellen soll.
 */
public class Pr�fungsleistungenView {

	private List<Pflichtmodul> pflichtModule;
	private List<Wahlmodul> wahlModule;
	private Abschluss abschluss;

	private static Pr�fungsleistungenView instance = null;
	
	public static Pr�fungsleistungenView getInstance() {
		if(instance == null)
			instance = new Pr�fungsleistungenView();
		return instance;
	}
	
	private Pr�fungsleistungenView() {
		this.pflichtModule = new ArrayList<Pflichtmodul>();
		this.wahlModule = new ArrayList<Wahlmodul>();
		this.abschluss = new Abschluss();
	}
	
	public List<Pflichtmodul> getPflichtModule() {
		return this.pflichtModule;
	}

	/**
	 * 
	 * @param list
	 */
	public void setPflichtModule(List<Pflichtmodul> list) {
		this.pflichtModule = list;
	}

	/**
	 * 
	 * @param pflichtModul
	 */
	public void addPflichtModul(Pflichtmodul pflichtModul) {
		pflichtModule.add(pflichtModul);
	}

	public List<Wahlmodul> getWahlModule() {
		return this.wahlModule;
	}

	/**
	 * 
	 * @param wahlModule
	 */
	public void setWahlModule(List<Wahlmodul> wahlModule) {
		this.wahlModule = wahlModule;
	}

	/**
	 * 
	 * @param wahlModul
	 */
	public void addWahlModul(Wahlmodul wahlModul) {
		wahlModule.add(wahlModul);
	}

	public Abschluss getAbschluss() {
		return this.abschluss;
	}

	/**
	 * 
	 * @param abschluss
	 */
	public void setAbschluss(Abschluss abschluss) {
		this.abschluss = abschluss;
	}
	
	@Override
	public String toString() {
		String pL = "Pflichtmodule: \n";
		for(Pflichtmodul modul : pflichtModule) {pL = pL + modul + "\n";}
		pL = pL + "Wahlmodule: \n";
		for(Wahlmodul modul : wahlModule) {pL = pL + modul + "\n";}
		return "{Pr�fungsleistungen: \n" + pL + "}";
	}

}