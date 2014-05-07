package de.game.curve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import de.game.curve.controller.Controller;
import de.game.curve.model.Snake;

public class Snake_draw extends JLabel{
	
	Point pos;
	Snake snake;
	boolean start = true;
	int snake_Groesse = 10;
	
	boolean links = false;
	boolean rechts = false;
	boolean gerade = false;
	
	Timer t = new Timer();
	
	TimerTask move = new TimerTask() {
		public void run() {
			setPos(getSnake().getCurrent_Position());
			repaint();
		}
	};
	
	public Snake_draw(Rectangle spielfeld, Snake player){
		//Spielfeld
		snake = player;
		pos = new Point (snake.getCurrent_Position());
		setBounds(spielfeld);
		setOpaque(true);
		
		System.out.println("ja");
	}

	public void paint(Graphics g)
	{
		g.setColor(snake.getFarbe());
		g.fillOval(pos.x, pos.y , snake_Groesse, snake_Groesse);
		if(start){
			t.schedule(move, 0, 10);
			start = false;
		}
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}
	
	

}
