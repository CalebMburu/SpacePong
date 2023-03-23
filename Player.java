import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Player {
	int x;
	int dy;
	int y;
	int speed = 10;
	Image rocket;
	
	static ArrayList bullets;
	
	public Player()
	{
		//get image for player 1
		ImageIcon p = new ImageIcon("C:\\Users\\jin93\\OneDrive\\Documents\\Rocketship.png");
		rocket = p.getImage();
		x = 0;
		y = 0;
		
		//the missiles for player 1
		bullets = new ArrayList();
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 72, 62);
	}
	
	//get the missiles
	public static ArrayList getBullets()
	{
		return bullets;
	}
	
	//fires the missile
	public void fire()
	{
		Bullet b = new Bullet(x, y);
		bullets.add(b);
	}
	
	//move the player
	public void move() 
	{
		y = y + dy;
	}
	
	//change in the y direction, how the player is move
	public void setYDirection(int yDirection) 
	{
		dy = yDirection;
	}
	
	//get player1 x
	public int getX()
	{
		return x;
	}
	
	//get player2 x
	public int getY()
	{
		return y;
	}
	
	//get player 1 image
	public Image getImage()
	{
		return rocket;
	}
	
	//lock the key with the movement
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_W) 
		{
			setYDirection(-speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_S) 
		{
			setYDirection(speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_D) 
		{
			fire();
		}
	}
	
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_W) 
		{
			setYDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_S) 
		{
			setYDirection(0);
		}
	}


}
