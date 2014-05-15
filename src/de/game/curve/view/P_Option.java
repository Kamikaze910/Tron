package de.game.curve.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalSliderUI;

import de.game.curve.controller.Controller;
import de.game.curve.model.my_Jlabel;

public class P_Option{
	
	// Werte
	private Color 	color1 = Color.blue;
	private Color 	color2 = Color.red;
	private Color 	color3 = Color.yellow;
	private Color	color4 = Color.green;
	private int		speed = 45;
	private int     holesize = 40;
	private int		holespace = 50;
	private int		playercount = 4;
	private int		turnangle = 32;
	private String	skill[] = {"Jump","invisibility","Speed Up","Slow Motion"};
	private String	keys[] = {"A","D","S","F","H","G","J","L","K","4","6","5"}; 
	
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
	
	private JTextField t_p1lk = new JTextField(1);
	private JTextField t_p1rk = new JTextField(1);
	private JTextField t_p1sk = new JTextField(1);
	private JTextField t_p2lk = new JTextField(1);
	private JTextField t_p2rk = new JTextField(1);
	private JTextField t_p2sk = new JTextField(1);
	private JTextField t_p3lk = new JTextField(1);
	private JTextField t_p3rk = new JTextField(1);
	private JTextField t_p3sk = new JTextField(1);
	private JTextField t_p4lk = new JTextField(1);
	private JTextField t_p4rk = new JTextField(1);
	private JTextField t_p4sk = new JTextField(1);
	
	private my_Jlabel l_zurueck = new my_Jlabel("Zurück", 50, 900, 100, 40);
	
	private JSlider sl_speed = new JSlider(0,100,50);
	private JSlider sl_holesize = new JSlider(0,100,50);
	private JSlider sl_holespace = new JSlider(0,100,50);
	private JSlider sl_turnangle = new JSlider(0,100,50);
	
	private JProgressBar p_speed = new JProgressBar(0, 100);
	private JProgressBar p_holesize = new JProgressBar(0, 100);
	private JProgressBar p_holespace = new JProgressBar(0, 100);
	private JProgressBar p_turnangle = new JProgressBar(0, 100);
	
	private JSpinner sp_playercount = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
			
	// Fenster
	public P_Option (){
		p_option.setBackground(Color.black);
	
		sl_speed.setBounds(150, 100, 500, 40);
		sl_speed.setOpaque(false);
		sl_speed.setPaintTrack(false);
		sl_speed.setPaintLabels(false);
		sl_speed.setValue(speed);
		
		sl_holesize.setBounds(150, 150, 500, 40);
		sl_holesize.setOpaque(false);
		sl_holesize.setPaintTrack(false);
		sl_holesize.setPaintLabels(false);
		sl_holesize.setValue(holesize);
		
		sl_holespace.setBounds(150, 200, 500, 40);
		sl_holespace.setOpaque(false);
		sl_holespace.setPaintTrack(false);
		sl_holespace.setPaintLabels(false);
		sl_holespace.setValue(holespace);
		
		sl_turnangle.setBounds(150, 250, 500, 40);
		sl_turnangle.setOpaque(false);
		sl_turnangle.setPaintTrack(false);
		sl_turnangle.setPaintLabels(false);
		sl_turnangle.setValue(turnangle);
		
		p_speed.setBounds(150, 100, 500, 40);
		p_speed.setForeground(Color.cyan);
		p_speed.setValue(speed);
		
		p_holesize.setBounds(150, 150, 500, 40);
		p_holesize.setForeground(Color.green);
		p_holesize.setValue(holesize);
		
		p_holespace.setBounds(150, 200, 500, 40);
		p_holespace.setForeground(Color.yellow);
		p_holespace.setValue(holespace);
		
		p_turnangle.setBounds(150, 250, 500, 40);
		p_turnangle.setForeground(Color.orange);
		p_turnangle.setValue(turnangle);
		
		sp_playercount.setBounds(150, 358, 50, 25);
		sp_playercount.setValue(playercount);
		
		l_anzahlspilertext.setBounds(50, 350, 500, 40);
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
		l_speedvalue.setText(Integer.toString(speed));
		l_speedvalue.setForeground(Color.cyan);
		
		l_holesizevalue.setBounds(655, 150, 500, 40);
		l_holesizevalue.setText(Integer.toString(holesize));
		l_holesizevalue.setForeground(Color.green);
		
		l_holespacevalue.setBounds(655, 200, 500, 40);
		l_holespacevalue.setText(Integer.toString(holespace));
		l_holespacevalue.setForeground(Color.yellow);
		
		l_turnanglevalue.setBounds(655, 250, 500, 40);
		l_turnanglevalue.setText(Integer.toString(turnangle));
		l_turnanglevalue.setForeground(Color.orange);
		
		l_button.setBounds(240, 420, 500, 40);
		l_button.setText("<Buttons>");
		l_button.setForeground(Color.white);
		
		l_keyleft.setBounds(150, 450, 50, 40);
		l_keyleft.setText("Left");
		l_keyleft.setForeground(Color.white);
		
		l_keyright.setBounds(250, 450, 50, 40);
		l_keyright.setText("Right");
		l_keyright.setForeground(Color.white);
		
		l_keyspecial.setBounds(350, 450, 500, 40);
		l_keyspecial.setText("Special-Taste");
		l_keyspecial.setForeground(Color.white);
		
		l_specialtext.setBounds(545, 420, 500, 40);
		l_specialtext.setText("<Special>");
		l_specialtext.setForeground(Color.white);
		
		l_specialbild.setBounds(600, 450, 500, 40);
		l_specialbild.setText("Special_Bild");
		l_specialbild.setForeground(Color.white);
		
		l_specials.setBounds(500, 450, 500, 40);
		l_specials.setText("Special_Name");
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
		
		t_p1lk.setBounds(150, 500, 50, 40);
		t_p1lk.setBackground(Color.BLACK);
		t_p1lk.setForeground(color1);
		t_p1lk.setText(keys[0]);
		
		t_p1rk.setBounds(250, 500, 50, 40);
		t_p1rk.setBackground(Color.BLACK);
		t_p1rk.setForeground(color1);
		t_p1rk.setText(keys[1]);
		
		t_p1sk.setBounds(350, 500, 50, 40);
		t_p1sk.setBackground(Color.BLACK);
		t_p1sk.setForeground(color1);
		t_p1sk.setText(keys[2]);
		
		t_p2lk.setBounds(150, 550, 50, 40);
		t_p2lk.setBackground(Color.BLACK);
		t_p2lk.setForeground(color2);
		t_p2lk.setText(keys[3]);
		
		t_p2rk.setBounds(250, 550, 50, 40);
		t_p2rk.setBackground(Color.BLACK);
		t_p2rk.setForeground(color2);
		t_p2rk.setText(keys[4]);
		
		t_p2sk.setBounds(350, 550, 50, 40);
		t_p2sk.setBackground(Color.BLACK);
		t_p2sk.setForeground(color2);
		t_p2sk.setText(keys[5]);
		
		t_p3lk.setBounds(150, 600, 50, 40);
		t_p3lk.setBackground(Color.BLACK);
		t_p3lk.setForeground(color3);
		t_p3lk.setText(keys[6]);
		
		t_p3rk.setBounds(250, 600, 50, 40);
		t_p3rk.setBackground(Color.BLACK);
		t_p3rk.setForeground(color3);
		t_p3rk.setText(keys[7]);
		
		t_p3sk.setBounds(350, 600, 50, 40);
		t_p3sk.setBackground(Color.BLACK);
		t_p3sk.setForeground(color3);
		t_p3sk.setText(keys[8]);
		
		t_p4lk.setBounds(150, 650, 50, 40);
		t_p4lk.setBackground(Color.BLACK);
		t_p4lk.setForeground(color4);
		t_p4lk.setText(keys[9]);
		
		t_p4rk.setBounds(250, 650, 50, 40);
		t_p4rk.setBackground(Color.BLACK);
		t_p4rk.setForeground(color4);
		t_p4rk.setText(keys[10]);
		
		t_p4sk.setBounds(350, 650, 50, 40);
		t_p4sk.setBackground(Color.BLACK);
		t_p4sk.setForeground(color4);
		t_p4sk.setText(keys[11]);
		
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
		p_option.add(t_p1lk);
		p_option.add(t_p1rk);
		p_option.add(t_p1sk);
		p_option.add(t_p2lk);
		p_option.add(t_p2rk);
		p_option.add(t_p2sk);
		p_option.add(t_p3lk);
		p_option.add(t_p3rk);
		p_option.add(t_p3sk);
		p_option.add(t_p4lk);
		p_option.add(t_p4rk);
		p_option.add(t_p4sk);
		
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