package de.game.curve.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.game.curve.controller.Controller;
import de.game.curve.model.my_Jlabel;

public class W_Main{
	
	//Fenster_Elemente - Main
	private JPanel p_main = new JPanel(null);
	
	//label
	private my_Jlabel l_start = new my_Jlabel("Start",50,0,100,40);
	private my_Jlabel l_option = new my_Jlabel("Option",50,50,100,40);
	private my_Jlabel l_ende = new my_Jlabel("Ende",50,100,100,40);
	private my_Jlabel l_text = new my_Jlabel("Text",50,150,100,40);
	
	
	public W_Main (){
		
		//Labelzuweisung zu Panel
		p_main.setBackground(Color.black);
		p_main.add(l_option);
		p_main.add(l_ende);
		p_main.add(l_text);
		p_main.add(l_start);
		
		//Actio-Listeners
		
		
		l_start.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().getW_StartMenu().setW_Game(new W_Game());
				Controller.getInstance().changePanel(Controller.getInstance().getP_game());
			}
		});
		
		
		l_text.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l_text.setText(Integer.toString(Controller.getInstance().get_count()));
				l_text.revalidate();
			}
		});
		
		l_option.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().changePanel(Controller.getInstance().getP_option());
			}
		});
		
		l_ende.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}


	public JPanel getP_main() {
		return p_main;
	}
}
