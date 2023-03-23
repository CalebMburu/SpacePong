import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	static final int GAME_WIDTH = 1100;
	static final int GAME_HEIGHT = 600;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 30;
	static final int PLAYER_WIDTH = 62;
	static final int PLAYER_HEIGHT = 72;
	boolean lost1 = false;
	boolean lost2 = false;
	Timer time;
	Image image;
	Graphics graphics;
	Random random;
	Player p1;
	Player2 p2;
	Ball ball;
	Score score;
	public Image img;
	public Image img2;
	
	public GamePanel()
	{
		newPlayers();
		newBall();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		setFocusable(true);
		addKeyListener(new AL());
		
		time = new Timer(5, this);
		time.start();
	}
	
	public void newBall() 
	{
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPlayers() 
	{
		p1 = new Player();
		p2 = new Player2();
	}
	public void paint(Graphics g) 
	{
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
		g.drawImage(p1.getImage(), p1.getX(), p1.getY(), null);
		g.drawImage(p2.getImage(), p2.getX(), p2.getY(), null);
		
		ArrayList bullets = Player.getBullets();
		for (int i = 0; i<bullets.size(); i++)
		{
			Bullet b = (Bullet) bullets.get(i);
			g.drawImage(b.getImage(), b.getX(), b.getY(), null);
		}
		
		ArrayList bullets2 = Player2.getBullet2();
		for (int i = 0; i<bullets2.size(); i++)
		{
			Bullet2 b2 = (Bullet2) bullets2.get(i);
			g.drawImage(b2.getImage(), b2.getX(), b2.getY(), null);
		}
		
		//if player 1 is hit what would happen
		if(lost1)
		{
			System.out.println("Player 2 won!");
			System.exit(0);
		}
		if(lost2)
		{
			System.out.println("Player 1 won!");
			System.exit(0);
		}
	}
	public void draw(Graphics g) 
	{
		ball.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	public void move() 
	{
		ball.move();
	}
	public void checkCollision() 
	{
		
		//bounce ball off the window edges
		if(ball.y <=0) 
		{
			ball.setDirectionY(-ball.yMove);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) 
		{
			ball.setDirectionY(-ball.yMove);
		}
		if(ball.x <= 0)
		{
			ball.setDirectionX(-ball.xMove);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER)
		{
			ball.setDirectionX(-ball.xMove);
		}
		//stops player at window edges
		if(p1.y<=0)
		{
			p1.y=0;
		}
		if(p1.y >= (GAME_HEIGHT-PLAYER_HEIGHT))
		{
			p1.y = GAME_HEIGHT-PLAYER_HEIGHT;
		}
		if(p2.y<=0)
		{
			p2.y=0;
		}
		if(p2.y >= (GAME_HEIGHT-PLAYER_HEIGHT))
		{
			p2.y = GAME_HEIGHT-PLAYER_HEIGHT;
		}
		
		//get the dimensions of players
		Rectangle r1 = p1.getBounds();
		Rectangle r2 = p2.getBounds();

		//array list for player 1 missiles
		ArrayList bullets = Player.getBullets();
		for (int i = 0; i<bullets.size(); i++)
		{
			//retrieve the missile
			Bullet b = (Bullet) bullets.get(i);
			
			Rectangle b1 = b.getBounds();
			//check if player 1 missiles hit player 2
			if (r2.intersects(b1))
			{
				b.visible=false;
				score.player1++;
				
				if(score.player1==9)
				{
					lost2=true;
				}
			}
		}
		
		//array list for player 2 missiles
		ArrayList bullets2 = Player2.getBullet2();
		for (int i = 0; i<bullets2.size(); i++)
		{
			//retrieve the missile
			Bullet2 bu2 = (Bullet2) bullets2.get(i);
					
			Rectangle b2 = bu2.getBounds();
			//check if player 1 missiles hit player 2
			if (r1.intersects(b2))
			{
				bu2.visible=false;
				score.player2++;
				
				if(score.player2==9)
				{
					lost1=true;
				}
			}
		}
		
		Rectangle b = ball.getBounds();
		
		//check if the ball hit the players
		if(b.intersects(r1))
		{
			score.player2++;
			ball.setDirectionY(-ball.yMove);
			ball.setDirectionX(-ball.xMove);
			
			if(score.player1==9)
			{
				lost2=true;
			}
			if(score.player2==9)
			{
				lost1=true;
			}
		}
		if(b.intersects(r2))
		{
			score.player1++;
			ball.setDirectionY(-ball.yMove);
			ball.setDirectionX(-ball.xMove);
			
			if(score.player1==9)
			{
				lost2=true;
			}
			if(score.player2==9)
			{
				lost1=true;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//array list to move the missiles and change the visibility of the missile
		ArrayList bullets = Player.getBullets();
		for (int i = 0; i<bullets.size(); i++)
		{
			Bullet b = (Bullet) bullets.get(i);
			if(b.getVisible()==true)
			{
				b.move();
			}
			else
			{
				bullets.remove(i);
			}
		}
		
		ArrayList bullets2 = Player2.getBullet2();
		for (int i = 0; i<bullets2.size(); i++)
		{
			Bullet2 b2 = (Bullet2) bullets2.get(i);
			if(b2.getVisible()==true)
			{
				b2.move();
			}
			else
				bullets2.remove(i);
		}
		
		//move the players
		p1.move();
		p2.move();
		
		//check the collisions
		move();
		checkCollision();
		repaint();
	}

	public class AL extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			p1.keyPressed(e);
			p2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) 
		{
			p1.keyReleased(e);
			p2.keyReleased(e);
		}
	}

}
