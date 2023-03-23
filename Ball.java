import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{
	Random random;
	int xMove;
	int yMove;
	int initialSpeed = 3;
	boolean visible = true;
	
	public Ball(int x, int y, int width, int height) //constructor
	{
		super(x,y,width,height); //height nd width is ball diameter
		random = new Random(); //sets random direction
		int randomXDirection = random.nextInt(4);
		if(randomXDirection == 0)
		{
			randomXDirection--;
		}
		setDirectionX(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(4);
		if(randomYDirection == 0)
		{
			randomYDirection--;
		}
		setDirectionY(randomYDirection*initialSpeed);
		
	}
	
	public void setDirectionX(int randomXDirection) 
	{
		xMove = randomXDirection;
	}
	public void setDirectionY(int randomYDirection) 
	{
		yMove = randomYDirection;
	}
	
	public boolean getVisible()
	{
		return visible;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 20, 20);
	}
	public void move() 
	{
		x += xMove;
		y += yMove;
	}
	public void draw(Graphics g) 
	{
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}

}
