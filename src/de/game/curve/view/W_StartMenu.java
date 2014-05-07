package de.game.curve.view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.game.curve.controller.Controller;




public class W_StartMenu extends JFrame implements KeyListener{

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
		addKeyListener(this);
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


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37)
			Controller.getInstance().getW_StartMenu().getW_Game().getSnake().get(0).setDruck_links(true);
		if(e.getKeyCode() == 39)
			Controller.getInstance().getW_StartMenu().getW_Game().getSnake().get(0).setDruck_rechts(true);
		if(e.getKeyCode() == 27){
			w_Game = null;
			Controller.getInstance().getW_StartMenu().changePanel(Controller.getInstance().getP_main());
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
	if(e.getKeyCode() == 37)
		Controller.getInstance().getW_StartMenu().getW_Game().getSnake().get(0).setDruck_links(false);
	if(e.getKeyCode() == 39)
		Controller.getInstance().getW_StartMenu().getW_Game().getSnake().get(0).setDruck_rechts(false);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
