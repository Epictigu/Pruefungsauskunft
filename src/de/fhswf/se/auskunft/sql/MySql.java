package de.fhswf.se.auskunft.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {
	
	private static Connection connection = null;
	
	public static void connect(String database, String user, String password) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database 
					+ "?user=" + user + "&password=" + password);
		} catch (SQLException e) {
			System.err.println("[ERROR] Konnte keine Verbindung mit der Datenbank aufnehmen!");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static ResultSet executeQuery(String sql) {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.err.println("[ERROR] SQL-Anfrage konnte nicht ausgeführt werden!");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void execute(String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
		} catch (SQLException e) {
			System.err.println("[ERROR] SQL-Befehl konnte nicht ausgeführt werden!");
			e.printStackTrace();
		}
	}
	
}
