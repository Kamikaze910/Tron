package de.game.curve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import de.game.curve.controller.Controller;
import de.game.curve.model.my_Jlabel;

public class P_Main{
	
	//Fenster_Elemente - Main
	private JPanel p_main = new JPanel(null);
	
	//my_label
	private my_Jlabel l_start = new my_Jlabel("Start",50,100,100,40);
	private my_Jlabel l_option = new my_Jlabel("Option",50,150,100,40);
	private my_Jlabel l_ende = new my_Jlabel("Ende",50,200,200,40);
	
	//JLabel
	private JLabel l_titel = new JLabel("Curve");

	public P_Main (){
		
		//l_titel.setBounds(x, y, width, height);
		l_titel.setForeground(Color.orange);
		l_titel.setBounds(800, 50, 500, 40);
		l_titel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		l_titel.setVisible(true);
		
		//Labelzuweisung zu Panel
		p_main.setBackground(Color.black);
		p_main.add(l_option);
		p_main.add(l_ende);
		p_main.add(l_start);
		p_main.add(l_titel);

		//Actio-Listeners
	
		l_start.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().getW_StartMenu().setW_Game(new P_Game());
				Controller.getInstance().changePanel(Controller.getInstance().getP_game());
			}
		});
		
		
//		l_text.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				l_text.setText(Integer.toString(Controller.getInstance().get_count()));
//				l_text.revalidate();
//			}
//		});
		
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
		l_start.setForeground(Color.orange);
		l_option.setForeground(Color.orange);
		l_ende.setForeground(Color.orange);
		return p_main;
	}
}
