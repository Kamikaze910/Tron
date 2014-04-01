package de.game.curve.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.game.curve.controller.Controller;

public class W_StartMenu extends JFrame{

	private static W_StartMenu instance = null;
	W_Main w_Main = null;
	W_Option w_Option = null;
	W_Game w_Game = null;

	public static W_StartMenu getInstance() {
		if(instance==null)
			instance=new W_StartMenu();
		
		return instance;
	}

	
	public W_StartMenu(){
		w_Main = new W_Main();
		w_Option = new W_Option();
		setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setContentPane(w_Main.getP_main());
        setVisible(true);
        repaint();
	}
	
	public void changePanel(JPanel panel){
		setContentPane(panel);
		repaint();
		revalidate();
	}
	

	public W_Main getW_Main() {
		return w_Main;
	}

	public void setW_Main(W_Main w_Main) {
		this.w_Main = w_Main;
	}

	public W_Option getW_Option() {
		return w_Option;
	}

	public void setW_Option(W_Option w_Option) {
		this.w_Option = w_Option;
	}

	public W_Game getW_Game() {
		return w_Game;
	}

	public void setW_Game(W_Game w_Game) {
		this.w_Game = w_Game;
	}
	
	
}
