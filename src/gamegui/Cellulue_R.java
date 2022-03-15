package gamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.State;


public class Cellulue_R extends JLabel
{
	/**
	 * 
	 */
	private int[][] pos_Robot ;
	private State state;
	private int[][] board;
	private static final long serialVersionUID = 1L;
	
	//private int x;
	//private int y;

	
	public Cellulue_R(State state)
	{	

		this.state = state;
		this.board = state.Get_Board();
		this.pos_Robot = state.Get_Robot();
	}
	

	public void paintComponent(Graphics g)
	{
		int x_robot1 = 0;
		int y_robot1 = 0;
		int x_robot2 = 10;
		int y_robot2 = 11;
		int x_robot3 = 0;
		int y_robot3 = 0;
		int x_robot4 = 0;
		int y_robot4 = 0;
		this.pos_Robot[0][0] = x_robot1;
		this.pos_Robot[0][1] = y_robot1;
		this.pos_Robot[1][0] = x_robot2;
		this.pos_Robot[1][1] = y_robot2;
		this.pos_Robot[2][0] = x_robot3;
		this.pos_Robot[2][1] = y_robot3;
		this.pos_Robot[3][0] = x_robot4;
		this.pos_Robot[3][1] = y_robot4;

		
		if(board[x_robot2][y_robot2] != 0)
		{	        	
		g.setColor(Color.RED);
		g.drawOval( 10, 10, 15, 15 );     	
		}

	}
}
	


