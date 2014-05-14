package de.game.curve.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import de.game.curve.controller.Controller;

public class Spielfeld {

	int laenge = 0;
	int hoehe = 0;
	int feld [][];
	Rectangle spielfeld;
	int current_SpielerAnzahl;
	int spielerAnzahl;
	private ArrayList<Integer> ergebnispunkte = new ArrayList<Integer>();
	private ArrayList<Integer> ergebnisrank = new ArrayList<Integer>();

	public Spielfeld(Rectangle spielfeld, int spielerAnzahl){
		this.spielfeld = spielfeld;
		laenge = spielfeld.width;
		hoehe = spielfeld.height;
		feld = new int [laenge][hoehe];
		this.current_SpielerAnzahl = spielerAnzahl;
		this.spielerAnzahl = spielerAnzahl;
		
		for(int i=0; i<spielerAnzahl; i++){
			ergebnispunkte.add(0);
			ergebnisrank.add(-1);
		}
	}

	public void clear(){
		for(int y = 0; y < hoehe; y++){
			for(int x = 0; x < laenge; x++){
				feld[x][y] = 0;
			}
		}
	}
	

	public boolean snake_isPunktBelegt(Snake snake){
		if(snake.getCurrent_Position().x > spielfeld.width-10 || snake.getCurrent_Position().x < 13 || snake.getCurrent_Position().y < 14 || snake.getCurrent_Position().y > spielfeld.height-10 ||
					( !(feld[snake.getCurrent_Position().x][snake.getCurrent_Position().y] == 0)))
			return true;
		
		else
			return false;
	}

	public void spieler_Rausgeflogen(Snake snake){
		player_End(snake);
		if(--current_SpielerAnzahl == 1){
			round_End();
		}
		System.out.println(snake.getSpielerNr()+" rausgeflogen");
		for(int i=0; i<spielerAnzahl; i++){
			if(Controller.getInstance().getW_StartMenu().getW_Game().getSnake().get(i).isLebt()){
				ergebnispunkte.set(i, ergebnispunkte.get(i)+1);
				Controller.getInstance().getW_StartMenu().getW_Game().setErgebnispunkte(ergebnispunkte);
			}
		}
		System.out.println("");
		
		for(int i=0;i<spielerAnzahl;i++)
			System.out.print(ergebnispunkte.get(i)+" ");
		System.out.println("");
		
		for(int i=0;i<spielerAnzahl;i++)
			ergebnisrank.set(i, -1);
		
		for(int i=0; i<spielerAnzahl; i++){
			int highest = -1;
			int pos = -1;
			for(int j=0; j<ergebnispunkte.size(); j++){
				if(highest < ergebnispunkte.get(j) && isNichtVorhanden(j)){
					highest = ergebnispunkte.get(j);
					pos = j;
				}
			}
			ergebnisrank.set(i, pos);
			System.out.print(ergebnisrank.get(i)+" ");
		}
		
		System.out.println("");
		
		Controller.getInstance().getW_StartMenu().getW_Game().ergebnisListeAktualisieren();
	}
	
	private boolean isNichtVorhanden(int vorhanden) {
		boolean ok = true;
		for(int i=0; i<ergebnisrank.size(); i++)
			if(ergebnisrank.get(i) == vorhanden)
				ok = false;
		
		if(ok)
			return true;
		else
			return false;
	}

	public void snake_BelegtPunkt(Snake snake){
//		for(int y=-5; y<5; y++)
//			for(int x=-5; x<5; x++)
				feld[(snake.getCurrent_Position().x)][(snake.getCurrent_Position().y)] = snake.getSpielerNr();
	}

	public void player_End(Snake snake){
		snake.getT().cancel();
		snake.getSnake_draw().getT().cancel();
		Controller.getInstance().getW_StartMenu().getW_Game().infoLeiste_Aendern("Spieler "+snake.getSpielerNr()+" ist raus");
	}

	public void round_End(){
		Controller.getInstance().getW_StartMenu().getW_Game().setRundeBeendet(true);
		Controller.getInstance().getW_StartMenu().getW_Game().infoLeiste_Aendern("Runde beendet...");
		clear();
	}

	public int getCurrent_SpielerAnzahl() {
		return current_SpielerAnzahl;
	}

	public void setCurrent_SpielerAnzahl(int current_SpielerAnzahl) {
		this.current_SpielerAnzahl = current_SpielerAnzahl;
	}

	public ArrayList<Integer> getErgebnispunkte() {
		return ergebnispunkte;
	}

	public void setErgebnispunkte(ArrayList<Integer> ergebnispunkte) {
		this.ergebnispunkte = ergebnispunkte;
	}

	public ArrayList<Integer> getErgebnisrank() {
		return ergebnisrank;
	}

	public void setErgebnisrank(ArrayList<Integer> ergebnisrank) {
		this.ergebnisrank = ergebnisrank;
	}
	
	public int getRankPosition(int spieler){
		for(int i=0; i<spielerAnzahl; i++)
			if(ergebnisrank.get(i) == spieler)
				return i;
		return -1;
	}

	
}
