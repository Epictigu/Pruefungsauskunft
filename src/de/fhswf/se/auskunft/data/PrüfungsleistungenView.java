package de.fhswf.se.auskunft.data;

import java.util.ArrayList;

/**
 * View, der die einzelnen Fächer beinhaltet und darstellen soll.
 */
public class PrüfungsleistungenView {

	private ArrayList<Pflichtmodul> pflichtModule;
	private ArrayList<Wahlpflichtmodul> wahlpflichtModule;
	private ArrayList<Wahlmodul> wahlModule;
	private Abschluss abschluss;

	private static PrüfungsleistungenView instance = null;
	
	public static PrüfungsleistungenView getInstance() {
		if(instance == null)
			instance = new PrüfungsleistungenView();
		return instance;
	}
	
	private PrüfungsleistungenView() {
		this.pflichtModule = new ArrayList<Pflichtmodul>();
		this.wahlpflichtModule = new ArrayList<Wahlpflichtmodul>();
		this.wahlModule = new ArrayList<Wahlmodul>();
		this.abschluss = new Abschluss();
	}
	
	public ArrayList<Pflichtmodul> getPflichtModule() {
		return this.pflichtModule;
	}

	/**
	 * 
	 * @param pflichtModule
	 */
	public void setPflichtModule(ArrayList<Pflichtmodul> pflichtModule) {
		this.pflichtModule = pflichtModule;
	}

	/**
	 * 
	 * @param pflichtModul
	 */
	public void addPflichtModul(Pflichtmodul pflichtModul) {
		pflichtModule.add(pflichtModul);
	}

	public ArrayList<Wahlpflichtmodul> getWahlpflichtModule() {
		return this.wahlpflichtModule;
	}

	/**
	 * 
	 * @param wahlpflichtModule
	 */
	public void setWahlpflichtModule(ArrayList<Wahlpflichtmodul> wahlpflichtModule) {
		this.wahlpflichtModule = wahlpflichtModule;
	}

	/**
	 * 
	 * @param wahlpflichtModul
	 */
	public void addWahlpflichtModul(Wahlpflichtmodul wahlpflichtModul) {
		wahlpflichtModule.add(wahlpflichtModul);
	}

	public ArrayList<Wahlmodul> getWahlModule() {
		return this.wahlModule;
	}

	/**
	 * 
	 * @param wahlModule
	 */
	public void setWahlModule(ArrayList<Wahlmodul> wahlModule) {
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
		pL = pL + "Wahlpflichtmodule: \n";
		for(Wahlpflichtmodul modul : wahlpflichtModule) {pL = pL + modul + "\n";}
		pL = pL + "Wahlmodule: \n";
		for(Wahlmodul modul : wahlModule) {pL = pL + modul + "\n";}
		return "{Prüfungsleistungen: \n" + pL + "}";
	}

}