package de.fhswf.se.auskunft.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhswf.se.auskunft.data.Abschluss;
import de.fhswf.se.auskunft.data.Modul;

public class AbschlussSQL {

	public static void init() {
		MySql.execute("CREATE TABLE IF NOT EXISTS Abschluss ("
				+ "Name varchar(255) NOT NULL,"
				+ "Note1 DECIMAL(2, 1),"
				+ "Note2 DECIMAL(2, 1),"
				+ "PRIMARY KEY(Name));");
		
		try {
			if(!MySql.executeQuery("SELECT * FROM Abschluss WHERE Name='Abschlussprüfung';").next())
				MySql.execute("INSERT INTO Abschluss (Name) VALUES ('Abschlussprüfung');");
			if(!MySql.executeQuery("SELECT * FROM Abschluss WHERE Name='Kolloquium';").next())
				MySql.execute("INSERT INTO Abschluss (Name) VALUES ('Kolloquium');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Abschluss getAbschluss() {
		ResultSet abschlussPruefung = MySql.executeQuery("SELECT * FROM Abschluss WHERE Name='Abschlussprüfung';");
		ResultSet kolloquium = MySql.executeQuery("SELECT * FROM Abschluss WHERE Name='Kolloquium';");
		
		List<Float> aPNoten = new ArrayList<Float>();
		List<Float> kNoten = new ArrayList<Float>();
		
		try {
			while(abschlussPruefung.next()) {
				if(abschlussPruefung.getBigDecimal("Note1") != null)
					aPNoten.add(abschlussPruefung.getBigDecimal("Note1").floatValue());
				if(abschlussPruefung.getBigDecimal("Note2") != null)
					aPNoten.add(abschlussPruefung.getBigDecimal("Note2").floatValue());
			}
			while(kolloquium.next()) {
				if(kolloquium.getBigDecimal("Note1") != null)
					kNoten.add(kolloquium.getBigDecimal("Note1").floatValue());
				if(kolloquium.getBigDecimal("Note2") != null)
					kNoten.add(kolloquium.getBigDecimal("Note2").floatValue());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Abschluss(aPNoten, kNoten);
	}
	
	public static void updateAbschluss(Modul modul) {
		Float note1 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note2 = (modul.getNotenListe().size() > 1) ? modul.getNotenListe().get(1) : null;
		
		MySql.execute("UPDATE Abschluss SET "
				+ "Note1=" + note1 + ","
				+ "Note2=" + note2 + ""
				+ " WHERE Name='Abschlussprüfung';");
	}
	
	public static void updateKolloquium(Modul modul) {
		Float note1 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note2 = (modul.getNotenListe().size() > 1) ? modul.getNotenListe().get(1) : null;
		
		MySql.execute("UPDATE Abschluss SET "
				+ "Note1=" + note1 + ","
				+ "Note2=" + note2 + ""
				+ " WHERE Name='Kolloquium';");
	}
	
}
