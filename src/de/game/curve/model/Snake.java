package de.game.curve.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import de.game.curve.controller.Controller;
import de.game.curve.view.KeyListener;

public class Snake implements java.awt.event.KeyListener{
	
	
	protected Color farbe;
	protected Faehigkeit special;
	protected int speed;
	protected int drehwinkel;
	
	protected int links;
	protected int rechts;
	protected int oben;
	
	boolean druck_links = false;
	boolean druck_rechts = false;
	boolean druck_oben = false;
	
	protected Point current_Position;
	protected Rectangle spielfeldgroesse;
	
	Timer t = new Timer();
	TimerTask bewegen = new TimerTask() {
		int i=0;
		public void run() {
			if(druck_links){
				
			}
			else if(druck_rechts){
				
			}
			else{
			current_Position.x += 1;  
			current_Position.y += 0;
			}
			
			
		}
	};
	
	public Snake(Color farbe, Faehigkeit special, int speed, int drehwinkel, int links, int rechts, int oben){
		this.farbe = farbe;
		this.special = special;
		this.speed = speed;
		this.drehwinkel = drehwinkel;
		this.links = links;
		this.rechts = rechts;
		this.oben = oben;
		platzieren();
		t.schedule(bewegen, speed);
	}
	
	public Snake(Rectangle spielfeld, Color color, int links, int rechts, int oben){
		
		this.links = links;
		this.rechts = rechts;
		this.oben = oben;
		spielfeldgroesse = spielfeld;
		farbe = color;
		platzieren();
		t.schedule(bewegen, 100, 20);
	}
	
	public void platzieren(){
		int x = (int) ((double)Math.random() * spielfeldgroesse.width);
		int y = (int) ((double)Math.random() * spielfeldgroesse.height);
		current_Position = new Point(x, y);
		System.out.println(current_Position);
	}
	
	public void run(){
	

	}
	
	public void attack(){
		
	}

	public Color getFarbe() {
		return farbe;
	}

	public void setFarbe(Color farbe) {
		this.farbe = farbe;
	}

	public Faehigkeit getSpecial() {
		return special;
	}

	public void setSpecial(Faehigkeit special) {
		this.special = special;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDrehwinkel() {
		return drehwinkel;
	}

	public void setDrehwinkel(int drehwinkel) {
		this.drehwinkel = drehwinkel;
	}

	public int getLinks() {
		return links;
	}

	public void setLinks(int links) {
		this.links = links;
	}

	public int getRechts() {
		return rechts;
	}

	public void setRechts(int rechts) {
		this.rechts = rechts;
	}

	public int getOben() {
		return oben;
	}

	public void setOben(int oben) {
		this.oben = oben;
	}

	public Point getCurrent_Position() {
		return current_Position;
	}

	public void setCurrent_Position(Point current_Position) {
		this.current_Position = current_Position;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ja");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("druck");
		if(links == e.getKeyCode())
			System.out.println("Links");
		if(rechts == e.getKeyCode())
			System.out.println("Rechts");
		if(oben == e.getKeyCode())
			System.out.println("Special");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("nein");
	}

	

	
	
	
	
}
