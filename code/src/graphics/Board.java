package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame {
	
	private JPanel board;
	public static final int NB_COLONNES = 16;
	public static final int NB_LIGNES = 16;

	public Board()
	{
		
		/*
		 * container : fentre de la Frame
		 */
		super("board");
		Container container = this.getContentPane();

		container.setLayout(new BorderLayout());
		
		/*
		 * board 
		 */
		
		this.board = new JPanel();
		board.setPreferredSize(new Dimension(500,500));
		board.setLayout(new GridLayout(0,NB_COLONNES));
		
		/*
		 * creation du bouton 
		 */
		
		/*
		 * creation de la matrice
		 */	     
		int[][] matrice=new int[NB_LIGNES][NB_COLONNES];
		matrice[0][6]= 1;
		matrice[5][6]= 1;
		
		/*
		 * parcours du tableau int et remplissage 
		 * chaque coordonne est crer sous forme de panel cellule.
		 */
	    for( int i=0; i<NB_LIGNES; i++) {
	        for( int j=0; j<NB_COLONNES; j++) {
	            int valeur = matrice[i][j];
		    JPanel cellule = new JPanel();// on utilise un simple JPanel pour chaque cellule, donc on adaptera la couleur de fond (background)	
		    //cellule.setPreferredSize(new Dimension(32,32)); // donne une taille de 32x32 pixels par d�faut
		    if ( valeur==0 ) {
		        cellule.setBackground(Color.BLUE);
		        board.add(cellule);
	            }
	        else {
	            cellule.setBackground(Color.BLACK);
	            board.add(cellule);
	            }	            
	       }
	    }
	    
	    
		container.add(board, BorderLayout.WEST);
	    pack();
	    this.setSize(800, 800); //dfinit la taille de la fenetre principale
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);//centre la fenetre
	    this.setVisible(true);// rend visible la fenetre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ferme la fentre et le programme 
	    
	}
	
	
	
	public static void main(String[] args)
	{
		new Board();
	}

}
