package de.game.curve.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class count implements MouseMotionListener{
	
	private int a = 3;
	
	public count() {
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a2) {
		
		a += a2;
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
