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

public class P_Game extends JPanel{
	//Fenster_Elemente - Game
	ArrayList <Snake> snake = new ArrayList <Snake>();
	private JLabel feld = new JLabel("");
	private JLabel info = new JLabel();
	private int anzahlSpieler = 4;
	private Rectangle spielfeld;
	private Spielfeld gameField;
	private ArrayList<Integer> ergebnispunkte = new ArrayList<Integer>();
	private ArrayList<JLabel> ergebnisliste = new ArrayList<JLabel>();
	private boolean rundeBeendet = false;
	
	private int ergebniskastengroesse;
	private int x_Ausrichtung;
	
	private Font ergebnisFont = new Font("MV Boli", Font.PLAIN, 70);
	//Castellar

	Color[] color = {Color.white, Color.cyan, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink};

	public P_Game (){
		setLayout(null);

		//Einstellung Spielfeldrand
		int abstand_Links = 15;
		int abstand_Oben = 15;
		int abstand_Rechts = 150;
		int abstand_Unten = 60;
		spielfeld = new Rectangle(abstand_Links, abstand_Oben, Window.getInstance().getWidth()-abstand_Rechts-abstand_Links, Window.getInstance().getHeight()-abstand_Unten-abstand_Oben);

		//Infoleiste_unten
		info.setBounds(abstand_Links, Window.getInstance().getHeight()-abstand_Unten, Window.getInstance().getWidth()-abstand_Rechts-abstand_Links, abstand_Unten);
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
		
		//Ergebnisanzeige rechts
		ergebniskastengroesse = abstand_Rechts-50;
		x_Ausrichtung = Window.getInstance().getWidth()-abstand_Rechts+25;
		for(int i=0; i<anzahlSpieler; i++){
			ergebnispunkte.add(0);
			ergebnisliste.add(new JLabel());
			ergebnisliste.get(i).setBounds(x_Ausrichtung, ergebniskastengroesse*i+25, ergebniskastengroesse, ergebniskastengroesse);
			ergebnisliste.get(i).setForeground(color[i]);
			ergebnisliste.get(i).setFont(ergebnisFont);
			ergebnisliste.get(i).setText(String.valueOf(ergebnispunkte.get(i)));
			add(ergebnisliste.get(i));
		}

		add(feld);

		game_Start();
	}

	public void spieler_Erstellen(){
		for(int i=0; i<anzahlSpieler; i++){
			snake.add(i, new Snake(i+1, spielfeld, color[i], 37, 39, 38));
			add(snake.get(i).getSnake_draw());
		}
	}

	public void game_Start(){
		
		//Snakes erstellen
		spieler_Erstellen();

		//Spielermitteilung erstellen
		infoLeiste_Aendern("Spiel läuft...");
	}
	
	public void game_NextRound(){		
		//Alte Snakes löschen
		for(int i=0; i<anzahlSpieler; i++){
			snake.remove(0);
		}

		//Spielfeld bereinigen
		repaint();
		Controller.getInstance().getW_StartMenu().getW_Game().getGameField().clear();
		gameField.setCurrent_SpielerAnzahl(anzahlSpieler);
		//Spiel neu starten
		game_Start();
	}
	
	public void game_End(){
		
	}

	public void infoLeiste_Aendern(String text){
		info.setText(text);
	}


	//Getter & Setter
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

	public ArrayList<JLabel> getErgebnisliste() {
		return ergebnisliste;
	}

	public void setErgebnisliste(ArrayList<JLabel> ergebnisliste) {
		this.ergebnisliste = ergebnisliste;
	}

	public void ergebnisListeAktualisieren(){
		for(int i=0; i<anzahlSpieler; i++)
			ergebnisliste.get(i).setText(String.valueOf(ergebnispunkte.get(i)));
		for(int i=0; i<anzahlSpieler; i++)
		ergebnisliste.get(i).setBounds(x_Ausrichtung, ergebniskastengroesse*gameField.getRankPosition(i)+25, ergebniskastengroesse, ergebniskastengroesse);
	}
	
	public ArrayList<Integer> getErgebnispunkte() {
		return ergebnispunkte;
	}

	public void setErgebnispunkte(ArrayList<Integer> ergebnispunkte) {
		this.ergebnispunkte = ergebnispunkte;
	}

	public boolean isRundeBeendet() {
		return rundeBeendet;
	}

	public void setRundeBeendet(boolean rundeBeendet) {
		this.rundeBeendet = rundeBeendet;
	}

	
}