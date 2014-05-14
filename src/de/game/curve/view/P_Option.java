package de.game.curve.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalLabelUI;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.xml.bind.ValidationEvent;
import de.game.curve.controller.Controller;
import de.game.curve.model.my_Jlabel;

public class P_Option{
	
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
	private JLabel l_keysP1 = new JLabel();
	private JLabel l_keysP2 = new JLabel();
	private JLabel l_keysP3 = new JLabel();
	private JLabel l_keysP4 = new JLabel();
	private JLabel l_spedtext = new JLabel();
	private JLabel l_holesizetext = new JLabel();
	private JLabel l_holespacetext = new JLabel();
	private JLabel l_turnangletext = new JLabel();
	private JLabel l_anzahlspilertext = new JLabel();
	private JLabel l_speedvalue = new JLabel();
	private JLabel l_holesizevalue = new JLabel();
	private JLabel l_holespacevalue = new JLabel();
	private JLabel l_turnanglevalue = new JLabel();
	private JLabel l_option = new JLabel();
	private JLabel l_keyleft = new JLabel();
	private JLabel l_keyright = new JLabel();
	private JLabel l_keyspecial = new JLabel();
	private JLabel l_specialtext = new JLabel();
	private JLabel l_specialbild = new JLabel();
	private JLabel l_button = new JLabel();
	private JLabel l_specials = new JLabel();
	private my_Jlabel l_zurueck = new my_Jlabel("Zurück", 50, 900, 100, 40);
	private JSlider sl_speed = new JSlider(0,100,50);
	private JSlider sl_holesize = new JSlider(0,100,50);
	private JSlider sl_holespace = new JSlider(0,100,50);
	private JSlider sl_turnangle = new JSlider(0,100,50);
	private JProgressBar p_speed = new JProgressBar(0, 100);
	private JProgressBar p_holesize = new JProgressBar(0, 100);
	private JProgressBar p_holespace = new JProgressBar(0, 100);
	private JProgressBar p_turnangle = new JProgressBar(0, 100);
	private JSpinner sp_playercount = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));
			
	// Fenster
	public P_Option (){
		p_option.setBackground(Color.black);
	
		sl_speed.setBounds(150, 100, 500, 40);
		sl_speed.setOpaque(false);
		sl_speed.setPaintTrack(false);
		sl_speed.setPaintLabels(false);
		sl_speed.setValue(0);
		
		sl_holesize.setBounds(150, 150, 500, 40);
		sl_holesize.setOpaque(false);
		sl_holesize.setPaintTrack(false);
		sl_holesize.setPaintLabels(false);
		sl_holesize.setValue(0);
		
		sl_holespace.setBounds(150, 200, 500, 40);
		sl_holespace.setOpaque(false);
		sl_holespace.setPaintTrack(false);
		sl_holespace.setPaintLabels(false);
		sl_holespace.setValue(0);
		
		sl_turnangle.setBounds(150, 250, 500, 40);
		sl_turnangle.setOpaque(false);
		sl_turnangle.setPaintTrack(false);
		sl_turnangle.setPaintLabels(false);
		sl_turnangle.setValue(0);
		
		p_speed.setBounds(150, 100, 500, 40);
		p_speed.setForeground(Color.cyan);
		
		p_holesize.setBounds(150, 150, 500, 40);
		p_holesize.setForeground(Color.green);
		
		p_holespace.setBounds(150, 200, 500, 40);
		p_holespace.setForeground(Color.yellow);
		
		p_turnangle.setBounds(150, 250, 500, 40);
		p_turnangle.setForeground(Color.orange);
		
		sp_playercount.setBounds(1050, 105, 50, 25);
		
		l_anzahlspilertext.setBounds(950, 100, 500, 40);
		l_anzahlspilertext.setText("Player Count");
		l_anzahlspilertext.setForeground(Color.white);
		
		l_spedtext.setBounds(50, 100, 500, 40);
		l_spedtext.setText("Speed");
		l_spedtext.setForeground(Color.white);
		
		l_holesizetext.setBounds(50, 150, 500, 40);
		l_holesizetext.setText("Hole size");
		l_holesizetext.setForeground(Color.white);
		
		l_holespacetext.setBounds(50, 200, 500, 40);
		l_holespacetext.setText("Hole space");
		l_holespacetext.setForeground(Color.white);
		
		l_turnangletext.setBounds(50, 250, 500, 40);
		l_turnangletext.setText("Turnangle");
		l_turnangletext.setForeground(Color.white);
		
		l_speedvalue.setBounds(655, 100, 500, 40);
		l_speedvalue.setText("0");
		l_speedvalue.setForeground(Color.cyan);
		
		l_holesizevalue.setBounds(655, 150, 500, 40);
		l_holesizevalue.setText("0");
		l_holesizevalue.setForeground(Color.green);
		
		l_holespacevalue.setBounds(655, 200, 500, 40);
		l_holespacevalue.setText("0");
		l_holespacevalue.setForeground(Color.yellow);
		
		l_turnanglevalue.setBounds(655, 250, 500, 40);
		l_turnanglevalue.setText("0");
		l_turnanglevalue.setForeground(Color.orange);
		
		l_button.setBounds(350, 420, 50, 40);
		l_button.setText("Buttons");
		l_button.setForeground(Color.white);
		
		l_keyleft.setBounds(150, 450, 50, 40);
		l_keyleft.setText("Left");
		l_keyleft.setForeground(Color.white);
		
		l_keyright.setBounds(250, 450, 50, 40);
		l_keyright.setText("Right");
		l_keyright.setForeground(Color.white);
		
		l_keyspecial.setBounds(350, 450, 50, 40);
		l_keyspecial.setText("Special-Taste");
		l_keyspecial.setForeground(Color.white);
		
		l_specialtext.setBounds(550, 450, 50, 40);
		l_specialtext.setText("Special");
		l_specialtext.setForeground(Color.white);
		
		l_specialbild.setBounds(650, 450, 50, 40);
		l_specialbild.setText("Special");
		l_specialbild.setForeground(Color.white);
		
		l_specials.setBounds(600, 400, 50, 40);
		l_specials.setText("Special");
		l_specials.setForeground(Color.white);
		
		l_keysP1.setBounds(50, 500, 50, 40);
		l_keysP1.setText("Spieler 1");
		l_keysP1.setForeground(Color.white);
		
		l_keysP2.setBounds(50, 550, 50, 40);
		l_keysP2.setText("Spieler 2");
		l_keysP2.setForeground(Color.white);
		
		l_keysP3.setBounds(50, 600, 50, 40);
		l_keysP3.setText("Spieler 3");
		l_keysP3.setForeground(Color.white);
		
		l_keysP4.setBounds(50, 650, 50, 40);
		l_keysP4.setText("Spieler 4");
		l_keysP4.setForeground(Color.white);
		
		l_option.setBounds(50, 50, 50, 40);
		l_option.setText("Option");
		l_option.setForeground(Color.orange);
		
		//Buttonzuweisung zu Panel
		
		p_option.add(l_option);
		p_option.add(sl_speed);
		p_option.add(sl_holesize);
		p_option.add(sl_holespace);
		p_option.add(sl_turnangle);
		p_option.add(p_speed);
		p_option.add(p_holesize);
		p_option.add(p_holespace);
		p_option.add(p_turnangle);
		p_option.add(l_spedtext);
		p_option.add(l_holesizetext);
		p_option.add(l_holespacetext);
		p_option.add(l_turnangletext);
		p_option.add(l_speedvalue);
		p_option.add(l_holesizevalue);
		p_option.add(l_holespacevalue);
		p_option.add(l_turnanglevalue);
		p_option.add(l_anzahlspilertext);
		
		p_option.add(l_keysP1);
		p_option.add(l_keysP2);
		p_option.add(l_keysP3);
		p_option.add(l_keysP4);
		p_option.add(l_zurueck);
		p_option.add(sp_playercount);
		p_option.add(l_keyleft);
		p_option.add(l_keyright);
		p_option.add(l_keyspecial);
		p_option.add(l_specialtext);
		p_option.add(l_specialbild);
		p_option.add(l_button);
		p_option.add(l_specials);
		
		sl_speed.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int direction) {
				//scollByBlock(direction);
				sl_speed.setValue(this.valueForXPosition(sl_speed.getMousePosition().x));
			}
		});
		
		sl_holespace.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int direction) {
				//scollByBlock(direction);
				sl_holespace.setValue(this.valueForXPosition(sl_holespace.getMousePosition().x));
			}
		});
		
		sl_holesize.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int direction) {
				//scollByBlock(direction);
				sl_holesize.setValue(this.valueForXPosition(sl_holesize.getMousePosition().x));
			}
		});
		
		sl_turnangle.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int direction) {
				//scollByBlock(direction);
				sl_turnangle.setValue(this.valueForXPosition(sl_turnangle.getMousePosition().x));
			}
		});
		
	
		// Action listener
		
		sl_speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				p_speed.setValue(sl_speed.getValue());
				l_speedvalue.setText(Integer.toString(sl_speed.getValue()));
			}
		});
		
		sl_holespace.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				p_holespace.setValue(sl_holespace.getValue());
				l_holespacevalue.setText(Integer.toString(sl_holespace.getValue()));
			}
		});
		
		sl_holesize.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				p_holesize.setValue(sl_holesize.getValue());
				l_holesizevalue.setText(Integer.toString(sl_holesize.getValue()));
			}
		});
		
		sl_turnangle.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				p_turnangle.setValue(sl_turnangle.getValue());
				l_turnanglevalue.setText(Integer.toString(sl_turnangle.getValue()));
			}
		});
		

			
		l_zurueck.addMouseListener(new MouseAdapter() {
				
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().changePanel(Controller.getInstance().getP_main());
			}
		});
		
//		l_test.addMouseListener(new MouseAdapter() {
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			bar.setValue(e.getX()/5);
//			l_test2.setText(Integer.toString(e.getX()));
//		}
//	});
//		l_test.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				Controller.getInstance().set_count(1);
//			}
//		});
	}	
	
	public JPanel getP_option() {
		l_zurueck.setForeground(Color.orange);
		return p_option;
	}
}