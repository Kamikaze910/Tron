package de.game.curve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import de.game.curve.controller.Controller;
import de.game.curve.model.Snake;
import de.game.curve.model.Spielfeld;

public class W_Game extends JPanel{
	//Fenster_Elemente - Game
	ArrayList <Snake> snake = new ArrayList <Snake>();
	private JLabel feld = new JLabel("");
	private JLabel info = new JLabel();
	private int anzahlSpieler = 4;
	private Rectangle spielfeld;
	private Spielfeld gameField;
	
	Color[] color = {Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink};
	
	public W_Game (){
		setLayout(null);
		
		//Einstellung Spielfeldrand
		int abstand_Links = 15;
		int abstand_Oben = 15;
		int abstand_Rechts = 150;
		int abstand_Unten = 60;
		spielfeld = new Rectangle(abstand_Links, abstand_Oben, W_StartMenu.getInstance().getWidth()-abstand_Rechts-abstand_Links, W_StartMenu.getInstance().getHeight()-abstand_Unten-abstand_Oben);
		
		//Infoleiste_unten
		info.setBounds(abstand_Links, W_StartMenu.getInstance().getHeight()-abstand_Unten, W_StartMenu.getInstance().getWidth()-abstand_Rechts-abstand_Links, abstand_Unten);
		info.setForeground(Color.orange);
		info.setFont(new Font("Arial", Font.BOLD, 30));
		add(info);
		
		//Spielfeld
		//Darstellung
		setBackground(Color.blue);
		feld.setBackground(Color.black);
		feld.setBounds(spielfeld);
		feld.setOpaque(true);
		//Berechnung
		gameField = new Spielfeld(spielfeld, anzahlSpieler);
		
		add(feld);
		
		game_Start();
	}
	
	public void spieler_Erstellen(){
		for(int i=0; i<anzahlSpieler; i++){
			snake.add(i, new Snake(i+1, spielfeld, color[i], 37, 39, 38));
			add(snake.get(i).getSnake_draw());
		}
	}

	public JLabel getFeld() {
		return feld;
	}

	public void setFeld(JLabel feld) {
		this.feld = feld;
	}
	
	public Rectangle getSpielfeldgroesse(){
		return feld.getBounds();
	}


	public ArrayList<Snake> getSnake() {
		return snake;
	}

	public void setSnake(ArrayList<Snake> snake) {
		this.snake = snake;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}

	public int getAnzahlSpieler() {
		return anzahlSpieler;
	}

	public void setAnzahlSpieler(int anzahlSpieler) {
		this.anzahlSpieler = anzahlSpieler;
	}

	public Spielfeld getGameField() {
		return gameField;
	}

	public void setGameField(Spielfeld gameField) {
		this.gameField = gameField;
	}

	public void infoLeiste_Aendern(String text){
		info.setText(text);
	}
	
	public void addSnake_draw(Snake_draw snake_draw){
		add(snake_draw);
		
	}
	
	public void game_Start(){
		for(int i=0; i<snake.size(); i++){
			snake.set(i, null);
			snake.remove(i);
		}
		repaint();
		spieler_Erstellen();
		infoLeiste_Aendern("Spiel läuft...");
	}
	
	
}