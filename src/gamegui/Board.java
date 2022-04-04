package gamegui;

import game.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;



// Montrer 

public class Board extends JPanel implements  KeyListener,MouseListener {//ActionListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JLabel score = new JLabel();
	public Move moveL;
	public Move moveR;
	public Move moveU;
	public Move moveD;
	public int[][] tableau;
	public int[][] pos_Robot;
	public int[][] pos_jeton;
	protected State state ;
	private BufferedImage green_robot;
	private BufferedImage red_robot;
	private BufferedImage blue_robot;
	private BufferedImage yellow_robot;
	private BufferedImage green_jeton;
	private BufferedImage red_jeton;
	private BufferedImage blue_jeton;
	private BufferedImage yellow_jeton;
	private BufferedImage carre;
	private BufferedImage carre_noir;
	private int pos_x , pos_y;
	private int dim = 40;
	public boolean bool = false ;
	private int p  ;
	public int robot  = 0;
	public int x_green_robot = 0 ;
	public int y_green_robot = 0;
	public int x_red_robot = 0 ;
	public int y_red_robot = 0;
	public int x_blue_robot = 0 ;
	public int y_blue_robot = 0;
	public int x_yellow_robot = 0 ;
	public int y_yellow_robot = 0;

	public Board(State state) throws IOException, InterruptedException
	{	
		this.state = state;
		this.tableau = state.Get_Board();
		this.pos_Robot = state.Get_Robot();
		this.pos_jeton = state.Get_Goal();
		this.robot = state.GetNumber();
		this.x_green_robot = this.pos_Robot[0][0] ;
		this.y_green_robot = this.pos_Robot[0][1] ;
		this.x_red_robot = this.pos_Robot[1][0];
		this.y_red_robot = this.pos_Robot[1][1];
		this.x_yellow_robot = this.pos_Robot[2][0] ;
		this.y_yellow_robot = this.pos_Robot[2][1];
		this.x_blue_robot = this.pos_Robot[3][0];
		this.y_blue_robot = this.pos_Robot[3][1];
		this.addKeyListener(this);
		
		green_robot = ImageIO.read(new File("..\\static\\green_robot.png"));
		red_robot = ImageIO.read(new File("..\\static\\red_robot.png"));
		blue_robot = ImageIO.read(new File("..\\static\\blue_robot.png"));
		yellow_robot = ImageIO.read(new File("..\\static\\yellow_robot.png"));
		green_jeton = ImageIO.read(new File("..\\static\\vertrond.png"));
		red_jeton = ImageIO.read(new File("..\\static\\rougerond.png"));
		blue_jeton = ImageIO.read(new File("..\\static\\bleurond.png"));
		yellow_jeton = ImageIO.read(new File("..\\static\\jaunerond.png"));
		carre = ImageIO.read(new File("..\\static\\carre.jpg"));
		carre_noir = ImageIO.read(new File("..\\static\\carre_noir.png"));
		this.addMouseListener(this);
		setFocusable(true);
		this.setBackground(Color.WHITE);
		}
		 
	
	
		/*
		 * this method is used to draw all of the board and the transformation.
		 */
		@Override
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			
			x_green_robot = this.pos_Robot[0][0] ;
			y_green_robot = this.pos_Robot[0][1] ;
			x_red_robot = this.pos_Robot[1][0];
			y_red_robot = this.pos_Robot[1][1];
			x_yellow_robot = this.pos_Robot[2][0] ;
			y_yellow_robot = this.pos_Robot[2][1];
			x_blue_robot = this.pos_Robot[3][0];
			y_blue_robot = this.pos_Robot[3][1];
			
			int x_green_jeton = this.pos_jeton[0][0];
			int y_green_jeton = this.pos_jeton[0][1];
			int x_red_jeton = this.pos_jeton[1][0];
			int y_red_jeton = this.pos_jeton[1][1];
			int x_yellow_jeton = this.pos_jeton[2][0];
			int y_yellow_jeton = this.pos_jeton[2][1];
			int x_blue_jeton = this.pos_jeton[3][0];
			int y_blue_jeton = this.pos_jeton[3][1];	
			
			// Use g2 for increase the line 
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4.0f));
			
			
			for( int i=0 ;i<16 ; i++) 
		    {
				for( int j=0; j<16 ; j++) 
				{ 
					int valeur = tableau[i][j];
					if( i == 7 && j == 7)
					{
						g.drawImage(carre_noir,dim*i  , dim*j , null);	
					}
					else if( i == 8 && j == 7)
					{
						g.drawImage(carre_noir,dim*i  , dim*j , null);	
					}
					else if( i == 8 && j == 8)
					{
						g.drawImage(carre_noir,dim*i  , dim*j , null);		
					}
					else if( i == 7 && j == 8)
					{
						g.drawImage(carre_noir,dim*i  , dim*j , null);
					}
					else 
					{
						g.drawImage(carre,dim*i + 10 , dim*j + 10, null);				
					}
					
					switch(valeur) 
						{	
						case 10://border left
							g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim);		        				        		
							break;					   					    	
						case 11://border top 
							g.drawLine(i*dim, j*dim, i*dim+dim, j*dim);
							break;
						case 12://border right 
							g.drawLine(i*dim+dim, j*dim, i*dim+dim, j*dim+dim);
							break;
						case 13://border bottom 
							g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim);
							break; 
						case 20://border left top
							g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim); 
							g.drawLine(i*dim, j*dim, i*dim+dim, j*dim); 
							break; 
						case 21://border top right
							g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); 
							g.drawLine(i*dim, j*dim, i*dim+dim, j*dim); 
							break;
						case 22://border right bottom
							g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); 
							g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim); 
							break;
						case 23://border bottom left
							g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim);
							g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim); 
							break;		        	
						default: 
							break;
						}
					
				}		        
		    } 
			
			if(state.getActiveGoal() == 0)
			{	
				//draw the green token
				if(state.isFinalState() == 0)
				{
					g.drawImage(green_jeton,dim*x_green_jeton , dim*y_green_jeton, null);
					repaint();	
				}
				else
				{
					state.chooseActivegoal(1);				
				}		
			}
			if(state.getActiveGoal() == 1)
			{		
				//draw the red token
				if(state.isFinalState() == 0)
				{
					g.drawImage(red_jeton,dim*x_red_jeton , dim*y_red_jeton, null);
					repaint();	
				}
				else
				{
					state.chooseActivegoal(2);				
				}		
			}
			if(state.getActiveGoal() == 2)
			{	
				//draw the yellow token
				if(state.isFinalState() == 0)
				{
					g.drawImage(yellow_jeton,dim*x_yellow_jeton , dim*y_yellow_jeton, null);	
					repaint();	
				}
				else
				{
					state.chooseActivegoal(3);					
				}		
			}
			if(state.getActiveGoal() == 3)
			{		
				//draw the blue token
				if(state.isFinalState() == 0)
				{
					g.drawImage(blue_jeton,dim*x_blue_jeton , dim*y_blue_jeton, null);
					repaint();	
				}
				else
				{
					g.drawImage(blue_jeton,dim*x_blue_jeton , dim*y_blue_jeton, null);
					g.drawImage(green_jeton,dim*x_green_jeton , dim*y_green_jeton, null);
					g.drawImage(red_jeton,dim*x_red_jeton , dim*y_red_jeton, null);
					g.drawImage(yellow_jeton,dim*x_yellow_jeton , dim*y_yellow_jeton, null);	
					bool = true;				
				}		
			}
			//draw the 4 robot
			g.drawImage(green_robot,dim*x_green_robot , dim*y_green_robot, null);
			g.drawImage(red_robot,dim*x_red_robot , dim*y_red_robot, null);
			g.drawImage(blue_robot,dim*x_blue_robot , dim*y_blue_robot, null);
			g.drawImage(yellow_robot,dim*x_yellow_robot , dim*y_yellow_robot, null);	
			
			
			
			//draw the count at the middle of the board
			
			g2.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Font font = new Font("Serif", Font.PLAIN, 40);
			g2.setFont(font);
			g2.setColor (Color.WHITE);
			g2.drawString(String.valueOf(p) , 300, 325);
			String rbot = "vert" ; 
			if(this.robot == 0)
			{
				rbot = "vert" ; 		
			}
			else if(this.robot == 1)
			{
				rbot = "rouge" ; 		
			}
			else if(this.robot == 2)
			{
				rbot = "jaune" ; 		
			}
			else if(this.robot == 3)
			{
				rbot = "bleu" ; 		
			}
			Graphics2D g3 = (Graphics2D) g;
			g3.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Font font1 = new Font("Serif", Font.PLAIN, 24);
			g3.setFont(font1);
			g3.setColor (Color.BLACK);
			g3.drawString("Robot selectionn� : "  + rbot  ,200, 660);
			

		}


		// this method is used to control the robot movement, and increase the count  
		@Override
		public void keyPressed(KeyEvent e) {
		    int key = e.getKeyCode();
		    {
		    	switch(key) 
				{
				case KeyEvent.VK_UP:	
					int YI_U= this.state.getUpMove(this.robot).getPosYI();
					int YF_U = this.state.getUpMove(this.robot).getPosYF();		    	
					state.play(this.state.getUpMove(this.robot) , this.robot);
					if (YI_U != YF_U)
					{
						p++;
					}
					repaint();
			    	break;
			    	
				case KeyEvent.VK_DOWN:		
			    	int YI_D= this.state.getDownMove(this.robot).getPosYI();
			    	int YF_D = this.state.getDownMove(this.robot).getPosYF();
			        state.play(this.state.getDownMove(this.robot), this.robot);
				    if (YI_D != YF_D)
					{
				    	p++;
					}		   
			    	repaint();
			    	break;
			    	
			    case KeyEvent.VK_LEFT:		    
			    	int XI_L = this.state.getLeftMove(this.robot).getPosXI();
			    	int XF_L = this.state.getLeftMove(this.robot).getPosXF();
			        state.play(this.state.getLeftMove(this.robot), this.robot);
				    if (XI_L != XF_L)
				    {
				    	p++;
					}							   
				    repaint();
				    break;
			    
			    case KeyEvent.VK_RIGHT:
			    	int XI_R = this.state.getRightMove(this.robot).getPosXI();
			    	int XF_R = this.state.getRightMove(this.robot).getPosXF();
			    	state.play(this.state.getRightMove(this.robot), this.robot);
			    	if (XI_R != XF_R)
			    	{
			    		p++;
			    	}
			    	repaint();
			    	break;
			    // the R touch is used to restart te game.	
			    case KeyEvent.VK_R:
			    	state.chooseActivegoal(0);
			    	state.resetPosRobot();
			    	p = 0;
			    	repaint();								
			    	break;			    	
			    default:
			    	break;  	
				}	        	
		        	}
		        	
		    
		    	}
      		
	        	
		
		
	/*
	 * 	this method is used to get the pixel position of each robot, 
	 *  with a click of the mouse 
	 *  we use it to choose which robot we want to move
	 * 
	 */
	//
	@Override
	public void mouseClicked(MouseEvent e)
	{
		pos_x = e.getX();		
		pos_y = e.getY();
		if ((int) (pos_x / dim) ==  this.pos_Robot[0][0] && (int)( pos_y / dim) == this.pos_Robot[0][1] )
		{   	 
			this.robot = 0;	
		}		
		else if((int) (pos_x / dim) ==  this.pos_Robot[1][0] && (int)( pos_y / dim) == this.pos_Robot[1][1] )
		{    
			this.robot = 1;				
		}
		else if ((int) (pos_x / dim) ==  this.pos_Robot[2][0] && (int)( pos_y / dim) == this.pos_Robot[2][1] )
		{    
			this.robot = 2;		
		}
		else if((int) (pos_x / dim) ==  this.pos_Robot[3][0] && (int)( pos_y / dim) == this.pos_Robot[3][1] )
		{    
			this.robot = 3;		
		}
		else 
		{
		}		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	 public void keyTyped(KeyEvent evt) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	


}
	 
	 




