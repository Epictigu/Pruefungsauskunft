package de.fhswf.se.auskunft.components.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.fhswf.se.auskunft.components.frames.AddGradeFrame;
import de.fhswf.se.auskunft.data.Modul;

public class GradeField extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Modul modul;
	
	private JLabel gradeLabel;
	private GradeAddButton gradeAddButton;
	
	public GradeField(Modul modul) {
		this.modul = modul;
		setLayout(null);
		
		gradeAddButton = new GradeAddButton();
		
		
		GradeField instance = this;
		gradeAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddGradeFrame(modul, instance);
			}
		});
		
		gradeLabel = new JLabel("-", SwingConstants.CENTER);
		add(gradeLabel);
		
		add(gradeAddButton);
		
		updateGrades();
	}
	
	public void updateGrades() {
		String grade = "-";
		if(!modul.getNotenListe().isEmpty()) {
			Float gradeFloat = modul.getNotenListe().get(modul.getNotenListe().size() - 1);
			if(gradeFloat <= 4.0 || modul.getNotenListe().size() >= 3)
				gradeAddButton.setEnabled(false);
			grade = "" + gradeFloat;
		}
		gradeLabel.setText(grade);
		repaint();
	}
	
	@Override
	public void setPreferredSize(Dimension preferredSize) {
		gradeLabel.setBounds(0, 0, preferredSize.width / 2, preferredSize.height);
		gradeAddButton.setBounds(preferredSize.width / 2 + 1, 0, preferredSize.width / 2 - 1, preferredSize.height);
		super.setPreferredSize(preferredSize);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		g2d.setColor(new Color(230, 230, 230));
		g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		
		g2d.setColor(new Color(176, 176, 176));
		g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		
		g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
	}
	
}
