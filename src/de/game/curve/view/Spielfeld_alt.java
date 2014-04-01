package de.game.curve.view;



import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Spielfeld_alt extends JFrame{
	
	private boolean[] downKeys = new boolean[9];
	final static int S1Up = 0, S1Left = 1, S1Right = 2, S2Up = 3, S2Left = 4, S2Right = 5, S3Up = 6, S3Left = 7, S3Right = 8;

	/*
	 private Thread runner = new Thread() {
	        {
	            setPriority(MIN_PRIORITY);
	        }
	 
	        public void run() {
	 
	            while (true) {
	            	 if (downKeys[S1Up]) {
	                     System.out.println("Up");
	                 }
	  
	                 if (downKeys[S1Left]) {
	                	 System.out.println("Left");
	                 }
	  
	                 if (downKeys[S1Right]) {
	                	 System.out.println("Right");
	                 }
	            }
	        }
	    };
	    */
	
	public Spielfeld_alt(){
		JPanel ground = new JPanel();
		ground.setLayout(new GridLayout(3,0));
		
		final JLabel up = new JLabel("UP: false");
		final JLabel left = new JLabel("LEFT: false");
		final JLabel right = new JLabel("RIGHT: false");
		
		final JLabel up2 = new JLabel("UP2: false");
		final JLabel left2 = new JLabel("LEFT2: false");
		final JLabel right2 = new JLabel("RIGHT2: false");
		
		final JLabel up3 = new JLabel("UP3: false");
		final JLabel left3 = new JLabel("LEFT3: false");
		final JLabel right3 = new JLabel("RIGHT3: false");
		
		ground.add(up);
		ground.add(left);
		ground.add(right);
		
		ground.add(up2);
		ground.add(left2);
		ground.add(right2);
		
		ground.add(up3);
		ground.add(left3);
		ground.add(right3);
		
		addKeyListener(new KeyAdapter() {
			 
            public void keyPressed(KeyEvent e) {
                delegateKeyCommand(e.getKeyCode(), true);
                System.out.println(e.getKeyCode());
            }
 
            public void keyReleased(KeyEvent e) {
                delegateKeyCommand(e.getKeyCode(), false);
            }
 
            private void delegateKeyCommand(int code, boolean isDown) {
                switch (code) {
                case KeyEvent.VK_W:
                    downKeys[S1Up] = isDown;
                    if(downKeys[S1Up])
                    	up.setText("UP: true");
                    else
                    	up.setText("UP: false");
                    break;
                    
                case KeyEvent.VK_A:
                    downKeys[S1Left] = isDown;
                    if(downKeys[S1Left])
                    	left.setText("LEFT: true");
                    else
                    	left.setText("LEFT: false");
                    break;
                    
                case KeyEvent.VK_D:
                    downKeys[S1Right] = isDown;
                    if(downKeys[S1Right])
                    	right.setText("RIGHT: true");
                    else
                    	right.setText("RIGHT: false");
                    break;
                    
                    
                case KeyEvent.VK_I:
                    downKeys[S2Up] = isDown;
                    if(downKeys[S2Up])
                    	up2.setText("UP2: true");
                    else
                    	up2.setText("UP2: false");
                    break;
                    
                case KeyEvent.VK_J:
                    downKeys[S2Left] = isDown;
                    if(downKeys[S2Left])
                    	left2.setText("LEFT2: true");
                    else
                    	left2.setText("LEFT2: false");
                    break;
                    
                case KeyEvent.VK_L:
                    downKeys[S2Right] = isDown;
                    if(downKeys[S2Right])
                    	right2.setText("RIGHT2: true");
                    else
                    	right2.setText("RIGHT2: false");
                    break;    
                    
                    
                case KeyEvent.VK_T:
                    downKeys[S3Up] = isDown;
                    if(downKeys[S3Up])
                    	up3.setText("UP3: true");
                    else
                    	up3.setText("UP3: false");
                    break;
                    
                case KeyEvent.VK_F:
                    downKeys[S3Left] = isDown;
                    if(downKeys[S3Left])
                    	left3.setText("LEFT3: true");
                    else
                    	left3.setText("LEFT3: false");
                    break;
                    
                case KeyEvent.VK_H:
                    downKeys[S3Right] = isDown;
                    if(downKeys[S3Right])
                    	right3.setText("RIGHT3: true");
                    else
                    	right3.setText("RIGHT3: false");
                    break; 
                    
                default:
                    ;
                }
            }
 
        });
		
	
		setContentPane(ground);
		setVisible(true);
		
	}
	
	

}
