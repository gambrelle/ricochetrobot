package gamegui;

import game.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

/*
 * Classe Principal de la partie graphique.
 * C'est dans cette classe que l'on structure l'emplacement des containers.
 */


public class Containers extends JFrame {
	
	/**
	 * 
	 */	
 
	private static final long serialVersionUID = 1L;	
	private JPanel top_Side = new JPanel();
	private Board board;
	public int count = 0;
	public JLabel affichage_Score_Green = new JLabel();
    public JTextArea area;
    public JLabel show_round = new JLabel();//affiche les manches
    public JLabel affichage_time = new JLabel();//affiche le timer
	private Border border = BorderFactory.createMatteBorder(0, 0,4 , 0, Color.BLACK);;
	

	public Containers(State state) throws IOException, InterruptedException
	{

		/*
		 * container : fenetre de la Frame
		 */		
		super("board");
		
		//creer un container pour pouvoir gerer l'emplacement des containers mineurs dans le JFrame 
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		//creer une instance de la classe Board.
		this.board = new Board(state);  	
	    board.setPreferredSize(new Dimension(640,700));	 
	    


		//Créer un titre
		JLabel affichage_Ricochet = new JLabel();
		affichage_Ricochet.setHorizontalAlignment(SwingConstants.CENTER); 
		affichage_Ricochet.setText("Ricochet Robot :");
		affichage_Ricochet.setFont(new Font("Verdana", Font.PLAIN, 20));		
		affichage_Ricochet.setForeground (Color.BLACK);
		affichage_Ricochet.setBorder(border);

		//Creer un texte pout informer comment reinitialiser le jeu
		JLabel affichage_Reset = new JLabel();
		affichage_Reset.setText("Press R to reset the game");
		affichage_Reset.setFont(new Font("Verdana", Font.PLAIN, 20));		
		affichage_Reset.setForeground (Color.BLACK);
		affichage_Reset.setHorizontalAlignment(SwingConstants.CENTER);
		 	
		top_Side.add(affichage_Ricochet);
		top_Side.add(affichage_Score_Green);

		//depose les trois containers dans le container principal et place les containers dans l'espace.
		container.add(this.board, BorderLayout.SOUTH);
		container.add(top_Side, BorderLayout.WEST);
		container.add(affichage_Reset, BorderLayout.EAST);
		
	    pack();
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);//centre la fenetre
	    this.setVisible(true);// rend visible la fenetre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ferme la fentre et le programme 
	    
	}}

