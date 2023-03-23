import java.awt.*;
import javax.swing.*;

public class Missiles2 {
	int x, y;
	Image img;
	boolean visible;
	
	public Missiles2(int startX, int startY)
	{
		ImageIcon newMissile = new ImageIcon("\"C:\\Users\\12065\\Desktop\\Rocketship2.png\"");
		img = newMissile.getImage();
		x = startX;
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

	public boolean getVisible()
	{
		return visible;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return img;
	}
	
	public void move()
	{
		x = x - 8; 
		if (x < 0)
		{
			visible = false;
		}
	}


}
