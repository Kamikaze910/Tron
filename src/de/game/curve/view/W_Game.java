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
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import de.game.curve.controller.Controller;
import de.game.curve.model.Snake;

public class W_Game extends JPanel{
	//Fenster_Elemente - Game
	private JButton b_test = new JButton("test");
	ArrayList <Snake_draw> snake_draw = new ArrayList <Snake_draw>();
	ArrayList <Snake> snake = new ArrayList <Snake>();
	private Map <Snake, Snake_draw> snakes = new HashMap <Snake, Snake_draw>();
	private JLabel feld = new JLabel("");
	private JLabel info = new JLabel("Spiel läuft...");
	private int anzahlSpieler = 20;
	
	Color[] color = {Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink, Color.white, Color.blue, Color.red, Color.yellow, Color.gray, Color.green, Color.cyan, Color.pink};
	
	public W_Game (){
		setLayout(null);
		//Buttonzuweisung zu Panel
		b_test.setBounds(50, 50, 50, 25);
		add(b_test);
		
		//Einstellung Spielfeldrand
		int abstand_Links = 15;
		int abstand_Oben = 15;
		int abstand_Rechts = 150;
		int abstand_Unten = 60;
		Rectangle spielfeld = new Rectangle(abstand_Links, abstand_Oben, W_StartMenu.getInstance().getWidth()-abstand_Rechts-abstand_Links, W_StartMenu.getInstance().getHeight()-abstand_Unten-abstand_Oben);
		
		//Spielfeld
		setBackground(Color.blue);
		feld.setBackground(Color.black);
		feld.setBounds(spielfeld);
		feld.setOpaque(true);
		
		for(int i=0; i<anzahlSpieler; i++)
			snake.add(i, new Snake(spielfeld, color[i], 37, 39, 38));
		
		for(int i=0; i<anzahlSpieler; i++){
			snake_draw.add(i, new Snake_draw(spielfeld, snake.get(i)));
			snakes.put(snake.get(i), snake_draw.get(i));
			add(snake_draw.get(i));
		}
		
		
		add(feld);
		
		//Infoleiste_unten
		info.setBounds(abstand_Links, W_StartMenu.getInstance().getHeight()-abstand_Unten, W_StartMenu.getInstance().getWidth()-abstand_Rechts-abstand_Links, abstand_Unten);
		info.setForeground(Color.orange);
		info.setFont(new Font("Arial", Font.BOLD, 30));
		add(info);
		
		//ActionListener
		b_test.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().changePanel(Controller.getInstance().getP_main());
			}
		});
	}

	public JButton getB_test() {
		return b_test;
	}

	public void setB_test(JButton b_test) {
		this.b_test = b_test;
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

	public ArrayList<Snake_draw> getSnake_draw() {
		return snake_draw;
	}

	public void setSnake_draw(ArrayList<Snake_draw> snake_draw) {
		this.snake_draw = snake_draw;
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

	public Map<Snake, Snake_draw> getSnakes() {
		return snakes;
	}

	public void setSnakes(Map<Snake, Snake_draw> snakes) {
		this.snakes = snakes;
	}
	
	
	
}