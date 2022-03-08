package board;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;




public class Board extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[][] tableau;
	public int[] position_robot;
    private Green_robot robot = new Green_robot() ;
	private Border border_LT = BorderFactory.createMatteBorder(4, 4, 0, 0, Color.BLACK);
	private Border border_TR = BorderFactory.createMatteBorder(4, 0,0 , 4, Color.BLACK);
	private Border border_RB = BorderFactory.createMatteBorder(0, 0, 4, 4, Color.BLACK);
	private Border border_BL = BorderFactory.createMatteBorder(0, 4, 4, 0, Color.BLACK);
	private Border border_Left = BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK);
	private Border border_Top = BorderFactory.createMatteBorder(0, 4,0 , 0, Color.BLACK);
	private Border border_Right = BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK);
	private Border border_Bottom = BorderFactory.createMatteBorder(0, 0,4 , 0, Color.BLACK);
	//public JPanel board;

	
	public Board(int[][] tableau)
	{
		this.setLayout(new GridLayout(0,tableau.length ));
		this.tableau = tableau;

	    for( int i=0; i<tableau.length; i++) 
	    {
	        for( int j=0; j<tableau.length; j++) 
	        {        
		    JPanel cellule = new JPanel();// on utilise un simple JPanel pour chaque cellule, donc on adaptera la couleur de fond (background)	
		    cellule.setPreferredSize(new Dimension(35,35));
	        int valeur = tableau[i][j];

			switch(valeur) 
			{	        
	        case 10:
		        this.add(cellule);	
			    cellule.setLayout(new FlowLayout());
			    cellule.setBorder(border_LT);
			    break;
	        case 11:
		        this.add(cellule);	
			    cellule.setBorder(border_TR);
			    break;
	        case 12:
		        cellule.setBackground(Color.WHITE);
		        this.add(cellule);	
			    cellule.setBorder(border_RB);
			    break;
	        case 13:
		        cellule.setBackground(Color.WHITE);
		        this.add(cellule);	
			    cellule.setBorder(border_BL);
			    break;
	        case 20:
		        cellule.setBackground(Color.WHITE);
			    //cellule.setBorder(black);
		        this.add(cellule);	
			    cellule.setBorder(border_Left);
			    break;
	        case 21:
		        cellule.setBackground(Color.WHITE);
			    //cellule.setBorder(black);
		        this.add(cellule);	
			    cellule.setBorder(border_Top);
			    break;
	        case 22:
		        cellule.setBackground(Color.WHITE);
			    //cellule.setBorder(black);
		        this.add(cellule);	
			    cellule.setBorder(border_Right);
			    break;
	        case 23:
		        cellule.setBackground(Color.WHITE);
			    //cellule.setBorder(black);
		        this.add(cellule);	
			    cellule.setBorder(border_Bottom);
			    break;
			default:
		        cellule.setBackground(Color.WHITE);
			    //cellule.setBorder(black);
		        this.add(cellule);			
	        }
	        }
	        
	    }
  		
	}
	

}

