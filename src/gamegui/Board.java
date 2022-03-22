package gamegui;

import game.*;
import java.awt.BasicStroke;
//import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;





public class Board extends JPanel implements EcouteurModele,MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[][] tableau;
	public int[][] pos_Robot;
	public int[][] pos_jeton;
	private State state ;
	private BufferedImage green_robot;
	private BufferedImage red_robot;
	private BufferedImage blue_robot;
	private BufferedImage yellow_robot;
	private BufferedImage green_jeton;
	private BufferedImage red_jeton;
	private BufferedImage blue_jeton;
	private BufferedImage yellow_jeton;
	private BufferedImage carre;
	private int pos_x , pos_y;
	private int dim = 40;
	public boolean bool = false ;
	//public JPanel board;

	
	public Board(State state) throws IOException, InterruptedException
	{
		this.state = state;
		this.tableau = state.get_Board();
		this.pos_Robot = state.get_Robot();
		this.pos_jeton = state.get_goalsToDo();
		green_robot = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\green_robot.png"));
		red_robot = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\red_robot.png"));
		blue_robot = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\blue_robot.png"));
		yellow_robot = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\yellow_robot.png"));
		green_jeton = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\vertrond.png"));
		red_jeton = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\rougerond.png"));
		blue_jeton = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\bleurond.png"));
		yellow_jeton = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\jaunerond.png"));
		carre = ImageIO.read(new File("C:\\Users\\lucgu\\Documents\\GitHub\\ricochetrobot\\static\\carre.jpg"));
		this.addMouseListener(this);


		
		}
	

		 
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int x_green_robot = this.pos_Robot[0][0] ;
			int y_green_robot = this.pos_Robot[0][1] ;
			int x_red_robot = this.pos_Robot[1][0];
			int y_red_robot = this.pos_Robot[1][1];
			int x_yellow_robot = this.pos_Robot[2][0] ;
			int y_yellow_robot = this.pos_Robot[2][1];
			int x_blue_robot = this.pos_Robot[3][0];
			int y_blue_robot = this.pos_Robot[3][1];
			
			int x_green_jeton = this.pos_jeton[1][0];
			int y_green_jeton = this.pos_jeton[1][1];
			int x_red_jeton = this.pos_jeton[2][1];
			int y_red_jeton = this.pos_jeton[2][1];
			int x_yellow_jeton = this.pos_jeton[3][0];
			int y_yellow_jeton = this.pos_jeton[3][1];
			int x_blue_jeton = this.pos_jeton[4][0];
			int y_blue_jeton = this.pos_jeton[4][1];
			
			
			
			// Use g2 for increase the line 
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4.0f));
	
			for( int i=0 ;i<16 ; i++) 
		    {
		        for( int j=0; j<16 ; j++) 
		        {        
		        g.drawImage(carre,dim*i + 10 , dim*j + 10, null);
		        int valeur = tableau[i][j];
					switch(valeur) 
					{	
			        case 10:
			    		//Draw a line
			        	g.drawLine(i*dim, j*dim, i*dim+dim, j*dim);//border top 1 			        	
					    break;					   					    
			        case 11:
			        	g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim);//border left 2
					    break;
			        case 12:
			        	g.drawLine(i*dim+dim, j*dim, i*dim+dim, j*dim+dim);//border rigth 3
					    break;
			        case 13:
			        	g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim);//border bottom 4 
					    break; 
			        case 20:
			        	//border left top
			        	g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim); //2
			        	g.drawLine(i*dim, j*dim, i*dim+dim, j*dim); //1
					    break; 
			        case 21:		  			
			  			g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); //3
			  			g.drawLine(i*dim, j*dim, i*dim+dim, j*dim); // 1

			        	//border top rigth
					    break;
			        case 22:
			        	g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); //3
			        	g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim); //4
			        	//border rigth bottom
					    break;
			        case 23:
			        	g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim); // 4
			        	g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim); //2
			        	//border bottom left
					    break;
					default: 
						g.drawImage(green_robot,dim*x_green_robot , dim*y_green_robot, null);
						g.drawImage(red_robot,dim*x_red_robot , dim*y_red_robot, null);
						g.drawImage(blue_robot,dim*x_blue_robot , dim*y_blue_robot, null);
						g.drawImage(yellow_robot,dim*x_yellow_robot , dim*y_yellow_robot, null);
						
						g.drawImage(green_jeton,dim*x_green_jeton , dim*y_green_jeton, null);
						g.drawImage(red_jeton,dim*x_red_jeton , dim*y_red_jeton, null);
						g.drawImage(blue_jeton,dim*x_blue_jeton , dim*y_blue_jeton, null);
						g.drawImage(yellow_jeton,dim*x_yellow_jeton , dim*y_yellow_jeton, null);
						
					}
		        	
		        }		        
		        } 
			
			
		}


	
	

	
	
	
	
	

	
	

	



	@Override
	public void modeleMAJ(Object source) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		pos_x = e.getX();		
		pos_y = e.getY();

		if ((int) (pos_x / dim) ==  this.pos_Robot[0][0] && (int)( pos_y / dim) == this.pos_Robot[0][1] )
		{            

			System.out.println("green_robot");
			System.out.println(this.pos_Robot[0][0]);
			System.out.println(this.pos_Robot[0][1]);

			
			
			

		}// TODO Auto-generated method stub

	}



	@Override
	public void mousePressed(MouseEvent e) {

		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	 

}

