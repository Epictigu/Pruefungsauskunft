package de.fhswf.se.auskunft.components.custom;

import java.awt.Graphics;
import java.awt.geom.Point2D;

public class GradeAddButton extends CustomButton{

	private static final long serialVersionUID = 1L;
	
	public GradeAddButton() {
		super("+");
	}
	
	@Override
	public boolean contains(int x, int y) {
		int radius = getHeight() / 2;
		if(x > getWidth() / 2)
			return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
		if(x < 0)
			return false;
		return true;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillRoundRect(0, 1, getWidth() - 1, getHeight() - 2, 20, 20);
		g.fillRect(0, 1, getWidth() / 2, getHeight() - 2);
		
		paintText(g, 20);
	}
	
}
