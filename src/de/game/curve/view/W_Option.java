package de.game.curve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.xml.bind.ValidationEvent;

import de.game.curve.controller.Controller;
import de.game.curve.model.my_Jlabel;

public class W_Option{
	
	// Werte
	private Color 	color;
	private int		speed;
	private int     holesize;
	private int		holespace;
	private int		playercount;
	private int		turnangle;
	private int		keys;
	private int		skill;
	
	//Fenster Elemente
	private JPanel p_option = new JPanel(null);
	// Erstellung der Labels 
	private my_Jlabel l_test = new my_Jlabel("Test", 50, 100, 100, 40);
	private my_Jlabel l_test2 = new my_Jlabel("Test2", 50, 150, 100, 40);
	private my_Jlabel l_zurueck = new my_Jlabel("Zurück", 50, 200, 100, 40);
	
	// Fenster
	public W_Option (){
		p_option.setBackground(Color.black);

		//Buttonzuweisung zu Panel
		p_option.add(l_test);
		p_option.add(l_test2);
		p_option.add(l_zurueck);
		
		
		// Action listener
		l_zurueck.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					Controller.getInstance().changePanel(Controller.getInstance().getP_main());
				}
			});
		
		l_test.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().set_count(1);
			}
		});
	}	
	
	public JPanel getP_option() {
		return p_option;
	}
}