package de.game.curve.model;

import java.awt.Point;
import java.awt.Rectangle;

import de.game.curve.controller.Controller;

public class Spielfeld {

	int laenge = 0;
	int hoehe = 0;
	int genauigkeit = 1;
	int feld [][];
	Rectangle spielfeld;
	int current_SpielerAnzahl;
	
	public Spielfeld(Rectangle spielfeld, int spielerAnzahl){
		this.spielfeld = spielfeld;
		laenge = spielfeld.width/genauigkeit;
		hoehe = spielfeld.height/genauigkeit;
		feld = new int [laenge][hoehe];
		this.current_SpielerAnzahl = spielerAnzahl;
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
					( !(feld[snake.getCurrent_Position().x/genauigkeit][snake.getCurrent_Position().y/genauigkeit] == 0)
					)
				)
		{
			player_End(snake);
			if(--current_SpielerAnzahl == 1){
				round_End();
				System.out.println("runde");
			}
			return true;
		}
		else
			return false;
	}
	
	public void snake_BelegtPunkt(Snake snake){
//		for(int y=-5; y<5; y++)
//			for(int x=-5; x<5; x++)
				feld[(snake.getCurrent_Position().x)/genauigkeit][(snake.getCurrent_Position().y)/genauigkeit] = snake.getSpielerNr();
	}
	
	public void player_End(Snake snake){
		snake.t.cancel();
		snake.getSnake_draw().getT().cancel();
		Controller.getInstance().getW_StartMenu().getW_Game().infoLeiste_Aendern("Spieler "+snake.getSpielerNr()+" ist raus");
	}
	
	public void round_End(){
		Controller.getInstance().getW_StartMenu().getW_Game().infoLeiste_Aendern("Runde beendet");
		clear();
		Controller.getInstance().getW_StartMenu().getW_Game().game_Start();
	}
	
}
