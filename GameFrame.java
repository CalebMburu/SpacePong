import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import testShoot.Frame;
import testShoot.Panel;

public class GameFrame {
	public GameFrame()
	{
		JFrame frame = new JFrame();
		frame.add(new GamePanel());
		frame.setTitle("Space Pong");
		frame.setSize(1110, 630);
		frame.setBackground(Color.black);
		frame.setResizable(false); //doesn't let resizing
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when the user click x
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); //center the window
	}
	public static void main(String[] args)
	{
		new GameFrame();
	}
}
