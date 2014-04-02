package de.game.curve.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.game.curve.controller.Controller;

public class my_Jlabel extends JLabel implements MouseListener {

	public my_Jlabel(String text,int x,int y, int width, int height){

		super(text);
		
		// Setzen der Werte des Labels
		this.setBounds(x, y, width, height);
		this.setForeground(Color.orange);
		this.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		this.setOpaque(true);
		this.setBackground(Color.black);


		// Noch Umbekannt was MouseAdapter macht
		this.addMouseListener(new MouseAdapter() {
			// Funktionen des Mouselisteners
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.green);
				revalidate();
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Color.orange);
				revalidate();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
