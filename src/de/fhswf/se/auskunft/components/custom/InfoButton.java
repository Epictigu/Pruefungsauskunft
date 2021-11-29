package de.fhswf.se.auskunft.components.custom;

import java.awt.Graphics;

public class InfoButton extends CustomButton{

	private static final long serialVersionUID = 1L;
	
	public InfoButton() {
		super("ℹ");
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillOval(0, 0, getWidth(), getHeight());
		
		paintText(g, 30);
	}
	
}
