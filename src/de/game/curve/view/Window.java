package de.game.curve.view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.game.curve.controller.Controller;




public class Window extends JFrame implements KeyListener{

	private static Window instance = null;
	P_Main w_Main = null;
	P_Option w_Option = null;
	P_Game w_Game = null;

	public static Window getInstance() {
		if(instance==null)
			instance=new Window();

		return instance;
	}


	public Window(){
		w_Main = new P_Main();
		w_Option = new P_Option();
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
		validate();
	}


	public P_Main getW_Main() {
		return w_Main;
	}

	public void setW_Main(P_Main w_Main) {
		this.w_Main = w_Main;
	}

	public P_Option getW_Option() {
		return w_Option;
	}

	public void setW_Option(P_Option w_Option) {
		this.w_Option = w_Option;
	}

	public P_Game getW_Game() {
		return w_Game;
	}

	public void setW_Game(P_Game w_Game) {
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
		if(e.getKeyCode() == 32 && Controller.getInstance().getW_StartMenu().getW_Game().isRundeBeendet()){
			Controller.getInstance().getW_StartMenu().getW_Game().setRundeBeendet(false);
			Controller.getInstance().getW_StartMenu().getW_Game().game_NextRound();
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
