package de.game.curve.controller;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.game.curve.model.Spielfeld;
import de.game.curve.model.count;
import de.game.curve.model.my_Jlabel;
import de.game.curve.model.Snake;
import de.game.curve.view.Window;


public class Controller {
	
	private count counter = new count();
	private Window w_StartMenu = null;

	
	// Singleton Design Pattern
	private static Controller instance;
	
	public static Controller getInstance() {
		if(instance==null)
			instance=new Controller();
		return instance;
	}
	
	
	//Konstruktor
	public Controller() {
		w_StartMenu = Window.getInstance();
	}
	
	//Panel_Wechsel---------------------------------------
	public void changePanel(JPanel p){
		w_StartMenu.changePanel(p);
	}
	
	public JPanel getP_game(){
		return w_StartMenu.getW_Game();
	}
	
	public JPanel getP_option(){
		return w_StartMenu.getW_Option().getP_option();
	}
	
	public JPanel getP_main(){
		return w_StartMenu.getW_Main().getP_main();
	}
	//----------------------------------------------------
	
	// Test-----------------------------------
	public void set_count(int a){
		counter.setA(a);
	}
	public int get_count(){
		return counter.getA();
	}
	//---------------------------------------
	
	//Model_Controller------------------------------------
	public void model_Start(){
		//if(snake == null){
			//snake = new Snake();
		//}
	}
	
	public Point getStart_Position(int i){
		return w_StartMenu.getW_Game().getSnake().get(i).getCurrent_Position();
	}
	//----------------------------------------------------
	
	//View_Controller-------------------------------------
	public Window getW_StartMenu() {
		return w_StartMenu;
	}

	public void setW_StartMenu(Window w_StartMenu) {
		this.w_StartMenu = w_StartMenu;
	}
	
	public Rectangle getSpielfeldgroesse(){
		return w_StartMenu.getW_Game().getSpielfeldgroesse();
	}
	//----------------------------------------------------
	
	

}
