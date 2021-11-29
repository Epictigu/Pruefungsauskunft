package de.fhswf.se.auskunft.data;
/**
 * Auflistung der verfügbaren Wahlpflichfächer.
 */
public enum Wahlpflichtfaecher {
	TechnikUndEthik(6, "Technik und Ethik"),
	FrontendFrameworksFuerWebanwendungen(6, "Frontend-Framework für Webawnendungen"),
	ITRecht(6, "IT-Recht"),
	Skriptsprachen(6, "Skriptsprachen"),
	TheoretischeInformatik(6, "Theoretische Informatik"),
	Virtualisierung(6, "Virtualisierung"),
	GenderUndDiversity(6, "Gender und Diversity in der Informatik");

	private Integer ects;
	private String name;

	
	private Wahlpflichtfaecher(Integer ects, String name) {
		this.ects = ects;
		this.name = name;
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
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ("{Name: \"" + name + "\", ECTS: \"" + ects + "\"}");
	}

}