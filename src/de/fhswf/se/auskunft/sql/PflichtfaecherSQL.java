package de.fhswf.se.auskunft.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhswf.se.auskunft.data.Pflichtmodul;

public class PflichtfaecherSQL {

	public static void init() {
		MySql.execute("CREATE TABLE IF NOT EXISTS Pflichtfaecher ("
				+ "Name varchar(255) NOT NULL,"
				+ "Ects int,"
				+ "Note1 DECIMAL(2, 1),"
				+ "Note2 DECIMAL(2, 1),"
				+ "Note3 DECIMAL(2, 1),"
				+ "Semester int,"
				+ "AddDatum Date,"
				+ "PRIMARY KEY(Name));");
	}
	
	public static void addNew(Pflichtmodul modul) {
		Float note1 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note2 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note3 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		MySql.execute("INSERT INTO Pflichtfaecher VALUES ("
				+ "'" + modul.getName() + "',"
				+ modul.getEcts() + ","
				+ note1 + ","
				+ note2 + ","
				+ note3 + ","
				+ modul.getSemester() + ","
				+ "'" + modul.getAddDatum().toString() + "');");
	}
	
	public static void update(Pflichtmodul modul) {
		Float note1 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note2 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		Float note3 = (modul.getNotenListe().size() > 0) ? modul.getNotenListe().get(0) : null;
		MySql.execute("UPDATE Pflichtfaecher SET "
				+ "Ects=" + modul.getEcts() + ","
				+ "Note1=" + note1 + ","
				+ "Note2=" + note2 + ","
				+ "Note3=" + note3 + ","
				+ "Semester=" + modul.getSemester() + ","
				+ "AddDatum='" + modul.getAddDatum().toString() + "'"
						+ "WHERE Name=" + modul.getName() + ";");
	}
	
	public static void delete(Pflichtmodul modul) {
		MySql.execute("DELETE FROM Pflichtfaecher WHERE Name='" + modul.getName() + "';");
	}
	
	public static List<Pflichtmodul> getAll(){
		ResultSet rs = MySql.executeQuery("SELECT * FROM Pflichtfaecher;");
		List<Pflichtmodul> l = new ArrayList<Pflichtmodul>();
		
		try {
			while(rs.next()) {
				List<Float> noten = new ArrayList<Float>();
				if(rs.getBigDecimal("Note1") != null)
					noten.add(rs.getBigDecimal("Note1").floatValue());
				if(rs.getBigDecimal("Note2") != null)
					noten.add(rs.getBigDecimal("Note2").floatValue());
				if(rs.getBigDecimal("Note3") != null)
					noten.add(rs.getBigDecimal("Note3").floatValue());
				
				l.add(new Pflichtmodul(rs.getString("Name"), rs.getInt("Ects"), noten, rs.getInt("Semester"), rs.getDate("AddDatum")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
}
