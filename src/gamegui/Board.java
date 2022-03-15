package gamegui;

import game.*;
import java.util.ArrayList;
import java.awt.Color;
//import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;





public class Board extends JPanel implements EcouteurModele{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[][] tableau;
	public int[][] pos_Robot;
	private State state ;
 
	//public JPanel board;

	
	public Board(State state) throws IOException, InterruptedException
	{
		this.state = state;
		this.tableau = state.Get_Board();
		this.pos_Robot = state.Get_Robot();
		
	/*	int x_robot1 = 3;
		int y_robot1 = 4;
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
		this.pos_Robot[3][1] = y_robot4;*/
		
		}
	

		 
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int x_robot1 = 6;
			int y_robot1 = 5;
			this.pos_Robot[0][0] = x_robot1;
			this.pos_Robot[0][1] = y_robot1;
			
			int dim = 35;
	
			for( int i=0; i<tableau.length; i++) 
		    {
		        for( int j=0; j<tableau.length; j++) 
		        {        
		        //JPanel cellule = new JPanel();// on utilise un simple JPanel pour chaque cellule, donc on adaptera la couleur de fond (background)
		        //JPanel cellule = new JPanel();
		        //Cellule test = new Cellule(state);
			    //cellule.setPreferredSize(new Dimension(35,35));
		        int valeur = tableau[i][j];
					switch(valeur) 
					{	
			        case 10:
			    		//g.setColor(Color.GREEN);
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
			        case 23:
			  			
			  			g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); //3
			  			g.drawLine(i*dim, j*dim, i*dim+dim, j*dim); // 1
			        	//border top rigth
					    break;
			        case 22:
			        	g.drawLine(i*dim +dim, j*dim, i*dim+dim, j*dim+dim); //3
			        	g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim); //4
			        	//border rigth bottom
					    break;
			        case 21:
			        	g.drawLine(i*dim + dim , j*dim + dim, i*dim, j*dim + dim); // 4
			        	g.drawLine(i*dim, j*dim, i*dim ,j*dim+dim); //2
			        	//border bottom left
					    break;/*
					default: */




					}

		        	
		        }
	
		        }  
			
			
		}


	
	

	
	
	
	
	

	
	

	



	@Override
	public void modeleMAJ(Object source) {
		// TODO Auto-generated method stub
		
	}
	 
	 

}

