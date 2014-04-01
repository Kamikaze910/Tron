package de.game.curve.view;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener{

	 public void keyPressed(KeyEvent e) {
         delegateKeyCommand(e.getKeyCode(), true);
     }

     public void keyReleased(KeyEvent e) {
         delegateKeyCommand(e.getKeyCode(), false);
     }

     private void delegateKeyCommand(int code, boolean isDown) {
         switch (code) {
         case KeyEvent.VK_UP:
         //    downKeys[S1Up] = isDown;
             break;
         case KeyEvent.VK_LEFT:
           //  downKeys[S1Left] = isDown;
             break;
         case KeyEvent.VK_RIGHT:
             //downKeys[S1Right] = isDown;
             break;
         default:
             ;
         }
     }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
