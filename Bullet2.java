import java.awt.*;
import javax.swing.*;

public class Bullet2 {
	int x, y;
	boolean visible;
	Image img;
	
	public Bullet2(int startX, int startY)
	{
		ImageIcon newBullet = new ImageIcon("\"C:\\Users\\12065\\Desktop\\Missile2.png\"");
		img = newBullet.getImage();
		x = startX;
		y = startY+20;
		visible = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 20, 15);
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
		x = x - 7; 
		if (x < 0)
		{
			visible = false;
		}
	}

}
