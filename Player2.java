import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Player2 {
	int x;
	int dy;
	int y;
	int speed = 10;
	Image rocket;
	
	static ArrayList bullet2;
	
	public Player2()
	{
		ImageIcon p = new ImageIcon("C:\\Users\\jin93\\OneDrive\\Documents\\Rocketship2.png");
		rocket = p.getImage();
		x = 1020;
		y = 0;
		bullet2 = new ArrayList();
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 72, 62);
	}

	public static ArrayList getBullet2()
	{
		return bullet2;
	}
	
	public void fire2()
	{
		Bullet2 b2 = new Bullet2(x, y);
		bullet2.add(b2);
	}
	
	public void move() 
	{
		y = y + dy;
	}
	
	public void setYDirection(int yDirection) 
	{
		dy = yDirection;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return rocket;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_UP) 
		{
			setYDirection(-speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
			setYDirection(speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			fire2();
		}
	}
	
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_UP) 
		{
			setYDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
			setYDirection(0);
		}
	}

}
