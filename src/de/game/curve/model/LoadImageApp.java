package de.game.curve.model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImageApp extends Component {
    
    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImageApp() {
		 try {
	         img = ImageIO.read(new File("Jump.png"));
	     } catch (IOException e) {
	     }
    }
    
    

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(50,50);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
   }
    
    public void setPic(int pic){
    	switch(pic){
    	case 1:
    		 try {
    	         img = ImageIO.read(new File("Jump.png"));
    	     } catch (IOException e) {
    	     }
    		break;
    	case 2:
    		 try {
    	         img = ImageIO.read(new File("Invisibility.png"));
    	     } catch (IOException e) {
    	     }
    		break;
    	case 3:
    		 try {
    	         img = ImageIO.read(new File("Speed Up.png"));
    	     } catch (IOException e) {
    	     }
    		break;
    	case 4:
	   		 try {
	   	         img = ImageIO.read(new File("Speed Down.png"));
	   	     } catch (IOException e) {
	   	     }
	   		 break;
    	case 0:
	   		 try {
	   	         img = ImageIO.read(new File("Shot.png"));
	   	     } catch (IOException e) {
	   	     }
	   		 break;
    	default:
    		 try {
    	         img = ImageIO.read(new File("Jump.png"));
    	     } catch (IOException e) {
    	     }
    	}
    	
    }

}