package de.fhswf.se.auskunft.components.custom;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JButton;

import de.fhswf.se.auskunft.Constants;

public class CustomButton extends JButton {
	
	private static final long serialVersionUID = 1L;

	private boolean hovered = false;
	
	public CustomButton(String text) {
		
		this.setText(text);
		
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hovered = true;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hovered = false;
			}
		});
	}
	
	@Override
	public boolean contains(int x, int y) {
		int radius = getHeight() / 2;
		return Point2D.distance(x, y, getWidth() / 2, getHeight() / 2) < radius;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(!isEnabled())
			g.setColor(Constants.COLOR_DISABLED_NORMAL);
		else if(hovered)
			g.setColor(Constants.COLOR_ENABLED_HOVER);
		else
			g.setColor(Constants.COLOR_ENABLED_NORMAL);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
	}
	
	protected void paintText(Graphics g, int fontsize) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font(Font.DIALOG, Font.PLAIN, fontsize));
		
		FontMetrics metrics = g2.getFontMetrics();
		int textX = (getWidth() - metrics.stringWidth(getText())) / 2;
		int textY = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
		
		if(isEnabled())
			g2.setColor(Constants.COLOR_ENABLED_FONT);
		else
			g2.setColor(Constants.COLOR_DISABLED_FONT);
		g2.drawString(getText(), textX, textY);
	}
	
}
