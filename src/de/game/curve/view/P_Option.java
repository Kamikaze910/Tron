package de.game.curve.view;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.swing.text.DefaultEditorKit.BeepAction;

import de.game.curve.controller.Controller;
import de.game.curve.model.LoadImageApp;
import de.game.curve.model.my_Jlabel;
public class P_Option{
	// Werte
	private Color 	color1 		= Color.blue;
	private Color 	color2		= Color.red;
	private Color 	color3		= Color.yellow;
	private Color	color4 		= Color.green;
	private Color 	color5 		= Color.cyan;
	private Color 	color6		= Color.gray;
	private Color 	color7		= Color.magenta;
	private Color	color8 		= Color.white;
	private int		speed 		= 45;
	private int     holesize 	= 40;
	private int		holespace 	= 50;
	private int		playercount = 4;
	private int		turnangle 	= 32;
	private String	skill[] 	= {"Jump","Invisibility","Speed Up","Slow Motion","Shot"};
	private String	keys[] 		= {"1.1","1.2","1.3","2.1","2.2","2.3","3.1","3.2","3.3","4.1","4.2","4.3","5.1","5.2","5.3","6.1","6.2","6.3","7.1","7.2","7.3","8.1","8.2","8.3"}; 
	//Fenster Elemente
	private JPanel p_option = new JPanel(null);
	// Erstellung der Labels 
	private JLabel l_keysP1 			= new JLabel();
	private JLabel l_keysP2 			= new JLabel();
	private JLabel l_keysP3 			= new JLabel();
	private JLabel l_keysP4 			= new JLabel();
	private JLabel l_keysP5 			= new JLabel();
	private JLabel l_keysP6 			= new JLabel();
	private JLabel l_keysP7 			= new JLabel();
	private JLabel l_keysP8 			= new JLabel();
	private JLabel l_spedtext 			= new JLabel();
	private JLabel l_holesizetext		= new JLabel();
	private JLabel l_holespacetext 		= new JLabel();
	private JLabel l_turnangletext 		= new JLabel();
	private JLabel l_anzahlspilertext	= new JLabel();
	private JLabel l_speedvalue			= new JLabel();
	private JLabel l_holesizevalue		= new JLabel();
	private JLabel l_holespacevalue		= new JLabel();
	private JLabel l_turnanglevalue 	= new JLabel();
	private JLabel l_option 			= new JLabel();
	private JLabel l_keyleft 			= new JLabel();
	private JLabel l_keyright 			= new JLabel();
	private JLabel l_keyspecial 		= new JLabel();
	private JLabel l_specialtext 		= new JLabel();
	private JLabel l_specialbild 		= new JLabel();
	private JLabel l_button 			= new JLabel();
	private JLabel l_specials 			= new JLabel();
	private JLabel l_sp1				= new JLabel();
	private JLabel l_sp2				= new JLabel();
	private JLabel l_sp3				= new JLabel();
	private JLabel l_sp4				= new JLabel();
	private JLabel l_sp5				= new JLabel();
	private JLabel l_sp6				= new JLabel();
	private JLabel l_sp7				= new JLabel();
	private JLabel l_sp8				= new JLabel();
	// Erstellung der TextField
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
	private JTextField t_p5lk = new JTextField(1);
	private JTextField t_p5rk = new JTextField(1);
	private JTextField t_p5sk = new JTextField(1);
	private JTextField t_p6lk = new JTextField(1);
	private JTextField t_p6rk = new JTextField(1);
	private JTextField t_p6sk = new JTextField(1);
	private JTextField t_p7lk = new JTextField(1);
	private JTextField t_p7rk = new JTextField(1);
	private JTextField t_p7sk = new JTextField(1);
	private JTextField t_p8lk = new JTextField(1);
	private JTextField t_p8rk = new JTextField(1);
	private JTextField t_p8sk = new JTextField(1);
	// Erstellung der my_Jlabels
	private my_Jlabel l_zurueck = new my_Jlabel("Zurück", 50, 900, 100, 40);
	// Erstellung der JSlider
	private JSlider sl_speed 		= new JSlider(0,100,50);
	private JSlider sl_holesize	 	= new JSlider(0,100,50);
	private JSlider sl_holespace 	= new JSlider(0,100,50);
	private JSlider sl_turnangle 	= new JSlider(0,100,50);
	// Erstellung der JProgressBar
	private JProgressBar p_speed 		= new JProgressBar(0, 100);
	private JProgressBar p_holesize	 	= new JProgressBar(0, 100);
	private JProgressBar p_holespace 	= new JProgressBar(0, 100);
	private JProgressBar p_turnangle 	= new JProgressBar(0, 100);
	// Erstellung der JSpinner
	private JSpinner sp_playercount = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
	// Erstellung der LoadImageApp
	private LoadImageApp img_1 = new LoadImageApp();
	private LoadImageApp img_2 = new LoadImageApp();
	private LoadImageApp img_3 = new LoadImageApp();
	private LoadImageApp img_4 = new LoadImageApp();
	private LoadImageApp img_5 = new LoadImageApp();
	private LoadImageApp img_6 = new LoadImageApp();
	private LoadImageApp img_7 = new LoadImageApp();
	private LoadImageApp img_8 = new LoadImageApp();
	
	// Fenster
	public P_Option (){
		// ...
		setPannel();
		//Zuweisung zu Panel
		addPannel();
		// Slider + PpgressBar
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
		sp_playercount.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			int p;
			p=(int) sp_playercount.getValue();
			setVisible(p);
			}
			
		});
		sl_speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
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
		l_sp1.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp1.getText();
				i=skillclcik(s);
				l_sp1.setText(skill[i]);
				if (i==4){
					img_1.setPic(0);
				}
				else{
					img_1.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp2.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp2.getText();
				i=skillclcik(s);
				l_sp2.setText(skill[i]);
				if (i==4){
					img_2.setPic(0);
				}
				else{
					img_2.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp3.getText();
				i=skillclcik(s);
				l_sp3.setText(skill[i]);
				if (i==4){
					img_3.setPic(0);
				}
				else{
					img_3.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp4.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp4.getText();
				i=skillclcik(s);
				l_sp4.setText(skill[i]);
				if (i==3){
					img_4.setPic(0);
				}
				else{
					img_4.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp5.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp5.getText();
				i=skillclcik(s);
				l_sp5.setText(skill[i]);
				if (i==4){
					img_5.setPic(0);
				}
				else{
					img_5.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp6.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp6.getText();
				i=skillclcik(s);
				l_sp6.setText(skill[i]);
				if (i==4){
					img_6.setPic(0);
				}
				else{
					img_6.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp7.getText();
				i=skillclcik(s);
				l_sp7.setText(skill[i]);
				if (i==4){
					img_7.setPic(0);
				}
				else{
					img_7.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_sp8.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				String s;
				s = l_sp8.getText();
				i=skillclcik(s);
				l_sp8.setText(skill[i]);
				if (i==4){
					img_8.setPic(0);
				}
				else{
					img_8.setPic(i+1);
				}
				p_option.repaint();
			}
		});
		l_zurueck.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {

				Controller.getInstance().changePanel(Controller.getInstance().getP_main());
			}
		});
	}	
	public int skillclcik(String skill){
		int arr;
		switch(skill){
		case "Jump":
			arr = 1;
			break;
		case "Invisibility":
			arr = 2;
			break;
		case "Speed Up":
			arr = 3;
			break;
		case "Slow Motion":
			arr = 4;
			break;
		case "Shot":
			arr = 0;
			break;
		default:
			arr = 0;
		}
		return arr;
	}
	public JPanel getP_option() {
		l_zurueck.setForeground(Color.orange);
		return p_option;
	}
	
	public void setVisible(int pa){
		switch(pa){
		case 1:
			setVisiblePlayer1(true);
			setVisiblePlayer2(false);
			setVisiblePlayer3(false);
			setVisiblePlayer4(false);
			setVisiblePlayer5(false);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 2:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(false);
			setVisiblePlayer4(false);
			setVisiblePlayer5(false);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 3:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(false);
			setVisiblePlayer5(false);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 4:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(true);
			setVisiblePlayer5(false);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 5:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(true);
			setVisiblePlayer5(true);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 6:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(true);
			setVisiblePlayer5(true);
			setVisiblePlayer6(true);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
			break;
		case 7:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(true);
			setVisiblePlayer5(true);
			setVisiblePlayer6(true);
			setVisiblePlayer7(true);
			setVisiblePlayer8(false);
			break;
		case 8:
			setVisiblePlayer1(true);
			setVisiblePlayer2(true);
			setVisiblePlayer3(true);
			setVisiblePlayer4(true);
			setVisiblePlayer5(true);
			setVisiblePlayer6(true);
			setVisiblePlayer7(true);
			setVisiblePlayer8(true);
			break;
		default:	
			setVisiblePlayer1(false);
			setVisiblePlayer2(false);
			setVisiblePlayer3(false);
			setVisiblePlayer4(false);
			setVisiblePlayer5(false);
			setVisiblePlayer6(false);
			setVisiblePlayer7(false);
			setVisiblePlayer8(false);
		}
	}
	public void setVisiblePlayer1(boolean a){
		l_keysP1.setVisible(a);
		l_sp1.setVisible(a);
		img_1.setVisible(a);
		t_p1lk.setVisible(a);
		t_p1rk.setVisible(a);
		t_p1sk.setVisible(a);
		
	}
	public void setVisiblePlayer2(boolean a){
		l_keysP2.setVisible(a);
		l_sp2.setVisible(a);
		img_2.setVisible(a);
		t_p2lk.setVisible(a);
		t_p2rk.setVisible(a);
		t_p2sk.setVisible(a);
		
	}
	public void setVisiblePlayer3(boolean a){
		l_keysP3.setVisible(a);
		l_sp3.setVisible(a);
		img_3.setVisible(a);
		t_p3lk.setVisible(a);
		t_p3rk.setVisible(a);
		t_p3sk.setVisible(a);
	}
	public void setVisiblePlayer4(boolean a){
		l_keysP4.setVisible(a);
		l_sp4.setVisible(a);
		img_4.setVisible(a);
		t_p4lk.setVisible(a);
		t_p4rk.setVisible(a);
		t_p4sk.setVisible(a);
	}
	public void setVisiblePlayer5(boolean a){
		l_keysP5.setVisible(a);
		l_sp5.setVisible(a);
		img_5.setVisible(a);
		t_p5lk.setVisible(a);
		t_p5rk.setVisible(a);
		t_p5sk.setVisible(a);
	}
	public void setVisiblePlayer6(boolean a){
		l_keysP6.setVisible(a);
		l_sp6.setVisible(a);
		img_6.setVisible(a);
		t_p6lk.setVisible(a);
		t_p6rk.setVisible(a);
		t_p6sk.setVisible(a);
	}
	public void setVisiblePlayer7(boolean a){
		l_keysP7.setVisible(a);
		l_sp7.setVisible(a);
		img_7.setVisible(a);
		t_p7lk.setVisible(a);
		t_p7rk.setVisible(a);
		t_p7sk.setVisible(a);
	}
	public void setVisiblePlayer8(boolean a){
		l_keysP8.setVisible(a);
		l_sp8.setVisible(a);
		img_8.setVisible(a);
		t_p8lk.setVisible(a);
		t_p8rk.setVisible(a);
		t_p8sk.setVisible(a);
	}
	
	private void addPannel() {
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
		p_option.add(l_keysP5);
		p_option.add(l_keysP6);
		p_option.add(l_keysP7);
		p_option.add(l_keysP8);
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
		p_option.add(t_p5lk);
		p_option.add(t_p5rk);
		p_option.add(t_p5sk);
		p_option.add(t_p6lk);
		p_option.add(t_p6rk);
		p_option.add(t_p6sk);
		p_option.add(t_p7lk);
		p_option.add(t_p7rk);
		p_option.add(t_p7sk);
		p_option.add(t_p8lk);
		p_option.add(t_p8rk);
		p_option.add(t_p8sk);
		p_option.add(l_sp1);
		p_option.add(l_sp2);
		p_option.add(l_sp3);
		p_option.add(l_sp4);
		p_option.add(l_sp5);
		p_option.add(l_sp6);
		p_option.add(l_sp7);
		p_option.add(l_sp8);
		p_option.add(img_1);
		p_option.add(img_2);
		p_option.add(img_3);
		p_option.add(img_4);
		p_option.add(img_5);
		p_option.add(img_6);
		p_option.add(img_7);
		p_option.add(img_8);
	}
	public void setPannel(){

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
		l_keysP1.setForeground(color1);
		
		l_keysP2.setBounds(50, 550, 50, 40);
		l_keysP2.setText("Spieler 2");
		l_keysP2.setForeground(color2);
		
		l_keysP3.setBounds(50, 600, 50, 40);
		l_keysP3.setText("Spieler 3");
		l_keysP3.setForeground(color3);
		
		l_keysP4.setBounds(50, 650, 50, 40);
		l_keysP4.setText("Spieler 4");
		l_keysP4.setForeground(color4);
		
		l_keysP5.setBounds(50, 700, 50, 40);
		l_keysP5.setText("Spieler 5");
		l_keysP5.setForeground(color5);
		
		l_keysP6.setBounds(50, 750, 50, 40);
		l_keysP6.setText("Spieler 6");
		l_keysP6.setForeground(color6);
		
		l_keysP7.setBounds(50, 800, 50, 40);
		l_keysP7.setText("Spieler 7");
		l_keysP7.setForeground(color7);
		
		l_keysP8.setBounds(50, 850, 50, 40);
		l_keysP8.setText("Spieler 8");
		l_keysP8.setForeground(color8);
		
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
	
		t_p5lk.setBounds(150, 700, 50, 40);
		t_p5lk.setBackground(Color.BLACK);
		t_p5lk.setForeground(color5);
		t_p5lk.setText(keys[12]);
		
		t_p5rk.setBounds(250, 700, 50, 40);
		t_p5rk.setBackground(Color.BLACK);
		t_p5rk.setForeground(color5);
		t_p5rk.setText(keys[13]);
		
		t_p5sk.setBounds(350, 700, 50, 40);
		t_p5sk.setBackground(Color.BLACK);
		t_p5sk.setForeground(color5);
		t_p5sk.setText(keys[14]);
		
		t_p6lk.setBounds(150, 750, 50, 40);
		t_p6lk.setBackground(Color.BLACK);
		t_p6lk.setForeground(color6);
		t_p6lk.setText(keys[15]);
		
		t_p6rk.setBounds(250, 750, 50, 40);
		t_p6rk.setBackground(Color.BLACK);
		t_p6rk.setForeground(color6);
		t_p6rk.setText(keys[16]);
		
		t_p6sk.setBounds(350, 750, 50, 40);
		t_p6sk.setBackground(Color.BLACK);
		t_p6sk.setForeground(color6);
		t_p6sk.setText(keys[17]);
		
		t_p7lk.setBounds(150, 800, 50, 40);
		t_p7lk.setBackground(Color.BLACK);
		t_p7lk.setForeground(color7);
		t_p7lk.setText(keys[18]);
		
		t_p7rk.setBounds(250, 800, 50, 40);
		t_p7rk.setBackground(Color.BLACK);
		t_p7rk.setForeground(color7);
		t_p7rk.setText(keys[19]);
		
		t_p7sk.setBounds(350, 800, 50, 40);
		t_p7sk.setBackground(Color.BLACK);
		t_p7sk.setForeground(color7);
		t_p7sk.setText(keys[20]);
		
		t_p8lk.setBounds(150, 850, 50, 40);
		t_p8lk.setBackground(Color.BLACK);
		t_p8lk.setForeground(color8);
		t_p8lk.setText(keys[21]);
		
		t_p8rk.setBounds(250, 850, 50, 40);
		t_p8rk.setBackground(Color.BLACK);
		t_p8rk.setForeground(color8);
		t_p8rk.setText(keys[22]);
		
		t_p8sk.setBounds(350, 850, 50, 40);
		t_p8sk.setBackground(Color.BLACK);
		t_p8sk.setForeground(color8);
		t_p8sk.setText(keys[23]);
		
		l_option.setBounds(50, 50, 50, 40);
		l_option.setText("Option");
		l_option.setForeground(Color.orange);
		
		l_sp1.setBounds(500, 500, 500, 40);
		l_sp1.setText(skill[0]);
		l_sp1.setForeground(color1);
		
		l_sp2.setBounds(500, 550, 500, 40);
		l_sp2.setText(skill[1]);
		l_sp2.setForeground(color2);
		
		l_sp3.setBounds(500, 600, 500, 40);
		l_sp3.setText(skill[2]);
		l_sp3.setForeground(color3);
		
		l_sp4.setBounds(500, 650, 500, 40);
		l_sp4.setText(skill[3]);
		l_sp4.setForeground(color4);
		
		l_sp5.setBounds(500, 700, 500, 40);
		l_sp5.setText(skill[0]);
		l_sp5.setForeground(color5);
		
		l_sp6.setBounds(500, 750, 500, 40);
		l_sp6.setText(skill[1]);
		l_sp6.setForeground(color6);
		
		l_sp7.setBounds(500, 800, 500, 40);
		l_sp7.setText(skill[2]);
		l_sp7.setForeground(color7);
		
		l_sp8.setBounds(500, 850, 500, 40);
		l_sp8.setText(skill[3]);
		l_sp8.setForeground(color8);
		
		img_1.setVisible(true);
		img_1.setBounds(600, 500, 50, 50);
		img_1.setPreferredSize(null);
		img_2.setPic(1);
		
		img_2.setVisible(true);
		img_2.setBounds(600, 550, 50, 50);
		img_2.setPic(2);
		img_2.setPreferredSize(null);
		
		img_3.setVisible(true);
		img_3.setBounds(600, 600, 50, 50);
		img_3.setPic(3);
		img_3.setPreferredSize(null);
		
		img_4.setVisible(true);
		img_4.setBounds(600, 650, 50, 50);
		img_4.setPic(0);
		img_4.setPreferredSize(null);
		
		img_5.setVisible(true);
		img_5.setBounds(600, 700, 50, 50);
		img_5.setPreferredSize(null);
		img_5.setPic(1);
		
		img_6.setVisible(true);
		img_6.setBounds(600, 750, 50, 50);
		img_6.setPic(2);
		img_6.setPreferredSize(null);
	
		img_7.setVisible(true);
		img_7.setBounds(600, 800, 50, 50);
		img_7.setPic(3);
		img_7.setPreferredSize(null);
		
		img_8.setVisible(true);
		img_8.setBounds(600, 850, 50, 50);
		img_8.setPic(0);
		img_8.setPreferredSize(null);
		
	}
	
}