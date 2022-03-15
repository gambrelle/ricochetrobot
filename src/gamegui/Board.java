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
	private Border border_LT = BorderFactory.createMatteBorder(4, 4, 0, 0, Color.BLACK);
	private Border border_TR = BorderFactory.createMatteBorder(4, 0,0 , 4, Color.BLACK);
	private Border border_RB = BorderFactory.createMatteBorder(0, 0, 4, 4, Color.BLACK);
	private Border border_BL = BorderFactory.createMatteBorder(0, 4, 4, 0, Color.BLACK);
	private Border border_Top = BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK);
	private Border border_Left = BorderFactory.createMatteBorder(0, 4,0 , 0, Color.BLACK);
	private Border border_Right = BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK);
	private Border border_Bottom = BorderFactory.createMatteBorder(0, 0,4 , 0, Color.BLACK);
	//public JPanel board;

	
	public Board(State state) throws IOException, InterruptedException
	{
		this.tableau = state.Get_Board();
		this.setLayout(new GridLayout(0,tableau.length ));
		this.pos_Robot = state.Get_Robot();
		
		int x_robot1 = 3;
		int y_robot1 = 4;
		int x_robot2 = 10;
		int y_robot2 = 11;
		int x_robot3 = 0;
		int y_robot3 = 0;
		int x_robot4 = 0;
		int y_robot4 = 0;
	/*	this.pos_Robot[0][0] = x_robot1;
		this.pos_Robot[0][1] = y_robot1;
		this.pos_Robot[1][0] = x_robot2;
		this.pos_Robot[1][1] = y_robot2;
		this.pos_Robot[2][0] = x_robot3;
		this.pos_Robot[2][1] = y_robot3;
		this.pos_Robot[3][0] = x_robot4;
		this.pos_Robot[3][1] = y_robot4;*/
		


	
		for( int i=0; i<tableau.length; i++) 
		    {
		        for( int j=0; j<tableau.length; j++) 
		        {        
		        //JPanel cellule = new JPanel();// on utilise un simple JPanel pour chaque cellule, donc on adaptera la couleur de fond (background)
		        JPanel cellule = new JPanel();
		        Cellule test = new Cellule(state);
			    cellule.setPreferredSize(new Dimension(35,35));
		        int valeur = tableau[i][j];
					switch(valeur) 
					{	
			        case 10:
				        test.setBackground(Color.WHITE);
				        this.add(test);
					    test.setBorder(border_Top);
					    break;					   					    
			        case 11:
				        cellule.setBackground(Color.WHITE);
				        this.add(cellule);	
					    cellule.setBorder(border_Left);
					    break;
			        case 12:
				        cellule.setBackground(Color.WHITE);
				        this.add(cellule);	
					    cellule.setBorder(border_Right);
					    break;
			        case 13:
				        cellule.setBackground(Color.WHITE);
				        this.add(cellule);	
					    cellule.setBorder(border_Bottom);
					    break;
			        case 20:
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	
					    cellule.setBorder(border_LT);
					    break;
			        case 21:
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	
					    cellule.setBorder(border_TR);
					    break;
			        case 22:
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	
					    cellule.setBorder(border_RB);
					    break;
			        case 23:
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	
					    cellule.setBorder(border_BL);
					    break;
			        case 24: 
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	
					default:
				        cellule.setBackground(Color.WHITE);
					    //cellule.setBorder(black);
				        this.add(cellule);	

					}


		        	
		        }
	
		        }  
		 

}
	


	
	

	
	
	
	
	

	
	

	



	@Override
	public void modeleMAJ(Object source) {
		// TODO Auto-generated method stub
		
	}
	 
	 

}

