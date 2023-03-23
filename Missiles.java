import java.awt.*;
import javax.swing.*;

public class Missiles {
	int x, y;
	Image img;
	boolean visible;
	
	public Missiles(int startX, int startY)
	{
		ImageIcon newMissile = new ImageIcon("\"C:\\Users\\12065\\Desktop\\Rocketship.png\"");
		img = newMissile.getImage();
		x = startX+70;
		y = startY+20;
		visible = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 24, 18);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getVisible()
	{
		return visible;
	}
	
	public Image getImage()
	{
		return img;
	}
	
	//the movement of the missiles and making sure that it is in frame
	public void move()
	{
		x = x + 8; 
		if (x > 1100)
		{
			visible = false;
		}
	}


}
