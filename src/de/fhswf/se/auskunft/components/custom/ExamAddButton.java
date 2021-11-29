package de.fhswf.se.auskunft.components.custom;

import java.awt.Graphics;

public class ExamAddButton extends CustomButton{

	private static final long serialVersionUID = 1L;
	
	public ExamAddButton() {
		super("+");
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillOval(0, 0, getWidth(), getHeight());
		
		paintText(g, 30);
	}
	
}
