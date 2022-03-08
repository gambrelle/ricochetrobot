package board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class Green_robot extends JLabel
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	
	public Green_robot()
	{	
		this.x = x;
		this.y = y;
	}
	

	public void paintComponent(Graphics g)
	{
		//g.setColor(Color.GREEN);
		//g.drawOval( 10, 10, 15, 15 );
		try
		{
			Image image = ImageIO.read(new File("C:\\Users\\lucgu\\eclipse-workspace\\RicochetRobot\\static\\green_robot.png"));
			g.drawImage(image,0,0,getWidth(),getHeight(),this);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	

	}
}
