package de.fhswf.se.auskunft.manager;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ResourceLoader {

	public static Map<String, Font> customFonts = new HashMap<String, Font>();
	
	public static void loadFonts() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			
			URL dir_url = ClassLoader.getSystemResource("fonts");
			File dir = new File(dir_url.toURI());
			String[] files = dir.list();
			for(String s : files) {
				Font font = Font.createFont(Font.TRUETYPE_FONT, new File(dir.getAbsolutePath() + "/" + s)).deriveFont(12f);
				
				ge.registerFont(font);
				customFonts.put(s.replaceAll(".ttf", ""), font);
			}
		} catch (FontFormatException | IOException | URISyntaxException e) {
			System.out.println("[ERROR] Konnte Custom-Fonts nicht hinzufügen!");
			e.printStackTrace();
		}
		
	}
	
}
