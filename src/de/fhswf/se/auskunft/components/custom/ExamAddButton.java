package de.fhswf.se.auskunft.components.custom;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.fhswf.se.auskunft.components.frames.AddExamFrame;

public class ExamAddButton extends CustomButton{

	private static final long serialVersionUID = 1L;
	
	public ExamAddButton() {
		super("+");
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddExamFrame.getInstance().openFrame();
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillOval(0, 0, getWidth(), getHeight());
		
		paintText(g, 30);
	}
	
}
