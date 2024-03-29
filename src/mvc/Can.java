package mvc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Can extends Canvas 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image myImage;
	private String myValue;
	
	public Can (String value)
	{
		myImage = null;
		myValue = value;
	}
	
	public Can (Image image)
	{
		myImage = image;
		myValue = null;
	}
	
	 public void paint(Graphics g)
	    {
	        if(myValue==null)
	        {
	            g.drawImage(myImage,0,0,this);
	        }
	        else
	        {
	            g.setColor(Color.red);
	            g.drawString(myValue,20,20);
	        }
	    }
	    
	    public void setImage(Image data)
	    {
	      myImage = data;
	      this.repaint();
	    }
}

