package de.game.curve.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import de.game.curve.controller.Controller;
import de.game.curve.view.Snake_draw;


public class Snake{

	//Snake Eigenschaften
	private int spielerNr;
	private Color farbe;
	private Faehigkeit special;
	private int speed;
	private int drehwinkel;
	private boolean lebt = true;

	//Steuerelemente
	private int links;
	private int rechts;
	private int oben;
	boolean druck_links = false;
	boolean druck_rechts = false;
	boolean druck_oben = false;

	//Snake Bewegung
	protected Point current_Position;
	private int r = 2;
	private int genauigkeit = 60;
	private double winkel = 2*Math.PI/genauigkeit;
	private int grad;

	//Sonstige
	private Rectangle spielfeldgroesse;
	private Snake_draw snake_draw;
	private Timer t = new Timer();


	TimerTask bewegen = new TimerTask() {
		public void run() {
			if(druck_links){
				current_Position.x += Math.round((Math.cos(grad--*winkel)*r));
				current_Position.y += Math.round((Math.sin(grad*winkel)*r));
				if(grad==0 || grad<0)
					grad=genauigkeit;
			}

			else if(druck_rechts){
				current_Position.x += Math.round((Math.cos(grad++*winkel)*r));
				current_Position.y += Math.round((Math.sin(grad*winkel)*r));
				if(grad==genauigkeit)
					grad=0;
			}

			else{
				current_Position.x += Math.round((Math.cos(grad*winkel)*r));
				current_Position.y += Math.round((Math.sin(grad*winkel)*r));
			}
			//Kontrolle ob Punkt belegt ist, wenn ja fliegt Spieler raus / wenn nein bewegt sich die Snake ein Feld weiter
			if(Controller.getInstance().getW_StartMenu().getW_Game().getGameField().snake_isPunktBelegt(getSnake()))
			{
				lebt = false;
				System.out.println("tot");
				Controller.getInstance().getW_StartMenu().getW_Game().getGameField().spieler_Rausgeflogen(getSnake());
			}
			else
				Controller.getInstance().getW_StartMenu().getW_Game().getGameField().snake_BelegtPunkt(getSnake());
			
			//Falls nur noch ein Spieler vorhanden ist, wird die letzte Snake auch deaktiviert
			if(Controller.getInstance().getW_StartMenu().getW_Game().getGameField().getCurrent_SpielerAnzahl() == 1){
				getT().cancel();
				getSnake_draw().getT().cancel();
			}
			
		}
	};

	public Snake(Color farbe, Faehigkeit special, int speed, int drehwinkel, final int links, final int rechts, int oben){

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

	public Snake(int spielerNr, Rectangle spielfeld, Color color, final int links, final int rechts, int oben){

		this.spielerNr = spielerNr;
		this.links = links;
		this.rechts = rechts;
		this.oben = oben;
		spielfeldgroesse = spielfeld;
		farbe = color;

		snake_Start();
	}

	public void snake_Start(){

		platzieren();
		snake_draw = new Snake_draw(spielfeldgroesse, this);

		t.schedule(bewegen, 2000, 10);
	}

	public void snake_Ende(){

		t.cancel();
		snake_draw = null;
	}

	public void platzieren(){
		int abstandZumRand = 200;
		int x = (int) ((double)Math.random() * (spielfeldgroesse.width-abstandZumRand*2) + abstandZumRand);
		int y = (int) ((double)Math.random() * (spielfeldgroesse.height-abstandZumRand*2) + abstandZumRand);
		current_Position = new Point(x, y);
		grad = (int)((double)Math.random() * 360);
	}


	//Getter & Setter
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

	public boolean isDruck_links() {
		return druck_links;
	}

	public void setDruck_links(boolean druck_links) {
		this.druck_links = druck_links;
	}

	public boolean isDruck_rechts() {
		return druck_rechts;
	}

	public void setDruck_rechts(boolean druck_rechts) {
		this.druck_rechts = druck_rechts;
	}

	public boolean isDruck_oben() {
		return druck_oben;
	}

	public void setDruck_oben(boolean druck_oben) {
		this.druck_oben = druck_oben;
	}

	public Snake_draw getSnake_draw() {
		return snake_draw;
	}

	public void setSnake_draw(Snake_draw snake_draw) {
		this.snake_draw = snake_draw;
	}

	public Snake getSnake(){
		return this;
	}

	public int getSpielerNr() {
		return spielerNr;
	}

	public void setSpielerNr(int spielerNr) {
		this.spielerNr = spielerNr;
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}

	public boolean isLebt(){
		if(lebt)
			return true;
		else
			return false;
	}


}
