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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalLabelUI;
import javax.swing.plaf.metal.MetalSliderUI;
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
	private my_Jlabel l_test = new my_Jlabel("Test", 50, 100, 500, 40);
	private my_Jlabel l_test2 = new my_Jlabel("Test2", 50, 150, 100, 40);
	private my_Jlabel l_zurueck = new my_Jlabel("Zurück", 50, 200, 100, 40);
	private JSlider slider = new JSlider(0,100,50);
	private JProgressBar bar = new JProgressBar(0, 100);
	
	// Fenster
	public W_Option (){
		p_option.setBackground(Color.white);
	
		slider.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int direction) {
				//scollByBlock(direction);
				int value = slider.getValue();
				
				if (slider.getOrientation() == JSlider.HORIZONTAL) {
					value = this.valueForXPosition(slider.getMousePosition().x);	
				} else if (slider.getOrientation() == JSlider.VERTICAL) {
					value = this.valueForYPosition(slider.getMousePosition().y);
				}
				slider.setValue(value);
			}
		});
		
		
		slider.setBounds(50, 300, 500, 40);
		slider.setOpaque(false);
		bar.setBounds(50, 280, 500, 40);
		bar.setEnabled(false);
		//Buttonzuweisung zu Panel
		p_option.add(l_test);
		p_option.add(l_test2);
		p_option.add(l_zurueck);
		p_option.add(bar);
		p_option.add(slider);
		
		
		// Action listener
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				bar.setValue(slider.getValue());
			}
			
		});
		
		l_test.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				bar.setValue(e.getX()/5);
				l_test2.setText(Integer.toString(e.getX()));
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
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				Controller.getInstance().set_count(1);
//			}
//		});
	}	
	
	public JPanel getP_option() {
		l_test.setForeground(Color.orange);
		l_test2.setForeground(Color.orange);
		l_zurueck.setForeground(Color.orange);
		return p_option;
	}
}