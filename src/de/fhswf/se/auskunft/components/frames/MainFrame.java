package de.fhswf.se.auskunft.components.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

import de.fhswf.se.auskunft.components.custom.FachComponent;
import de.fhswf.se.auskunft.components.panels.MainFooter;
import de.fhswf.se.auskunft.components.panels.MainHeader;
import de.fhswf.se.auskunft.data.Pflichtmodul;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setResizable(false);
		
		this.setTitle("Prüfungsauskunft");
		this.setSize(300, 700);
		this.setMinimumSize(new Dimension(300, 700));
		
		MainHeader mainHeader = new MainHeader();
		this.add(mainHeader, BorderLayout.PAGE_START);
		
		FachComponent test = new FachComponent(new Pflichtmodul("Frontend-Frameworks für Webanwendungen", 6, new ArrayList<Float>(), 5, new Date(System.currentTimeMillis())));
		
		this.add(test, BorderLayout.CENTER);
		
		MainFooter mainFooter = new MainFooter();
		this.add(mainFooter, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}
	
}
