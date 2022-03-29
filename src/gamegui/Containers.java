package gamegui;

import game.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.io.*;
//import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;




public class Containers extends JFrame implements ActionListener {
	
	/**
	 * 
	 */	
 
	private static final long serialVersionUID = 1L;
	//private JButton button = new JButton("Manche suivante");
	private JButton button_Restart = new JButton("Recommencer");
	private JPanel rigth_Side = new JPanel();
	private Board board;
	private State state;
	public static int x = 0;
	public int count = 0;
	//public boolean running = false;
    public JTextArea area;
    public Timer timer = new Timer(1000, this);;
    public JLabel show_round = new JLabel();//affiche les manches
    public JLabel affichage_time = new JLabel();//affiche le timer
	private Border border = BorderFactory.createMatteBorder(0, 0,4 , 0, Color.BLACK);;
	
	
	/*public Containers() throws IOException, InterruptedException 
	{
		this(new State());
		this.board = new Board(state);
	}*/

	public Containers(State state) throws IOException, InterruptedException
	{

		/*
		 * container : fen�tre de la Frame
		 */		
		super("board");
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());	
		this.state = state;
		this.board = new Board(state);  
	    board.setPreferredSize(new Dimension(640,640));
	    
	 
		rigth_Side.setLayout(new BorderLayout());
		rigth_Side.setPreferredSize(new Dimension(200,400));

		JPanel affichage_Manche = new JPanel();
		affichage_Manche.setLayout(new BorderLayout());
		affichage_Manche.setBorder(border);
		
		affichage_time.setFont(new Font("Verdana", Font.PLAIN, 28));
		affichage_time.setText("0");
		affichage_time.setHorizontalAlignment(SwingConstants.CENTER); 
		
		button_Restart.addActionListener(this);
		//button_Restart.setPreferredSize(new Dimension(40,40));
		button_Restart.setBounds(80,80, 320, 320 );



		show_round.setFont(new Font("Verdana", Font.PLAIN, 18));
		show_round.setHorizontalAlignment(SwingConstants.CENTER); 
		show_round.setText("Manche" + " "  + x);
		affichage_Manche.add(show_round, BorderLayout.NORTH);
		affichage_Manche.add(button_Restart,BorderLayout.SOUTH);

		JPanel affichage_Score_Robot = new JPanel();
		//affichage_Score_Robot.setLayout(new BorderLayout());
		
		JLabel affichage_Score_Green = new JLabel();
		affichage_Score_Green.setText("robot minmax");
		affichage_Score_Green.setFont(new Font("Verdana", Font.PLAIN, 18));		
		affichage_Score_Green.setForeground (Color.green);
		affichage_Score_Robot.add(affichage_Score_Green);
		
		JLabel affichage_Score_Blue = new JLabel();
		affichage_Score_Blue.setText("robot minmax");
		affichage_Score_Blue.setFont(new Font("Verdana", Font.PLAIN, 18));		
		affichage_Score_Blue.setForeground (Color.blue);
		affichage_Score_Robot.add(affichage_Score_Blue);

		JLabel affichage_Score_Yellow = new JLabel();
		affichage_Score_Yellow.setText("robot minmax");
		affichage_Score_Yellow.setFont(new Font("Verdana", Font.PLAIN, 18));		
		affichage_Score_Yellow.setForeground (Color.yellow);
		affichage_Score_Robot.add(affichage_Score_Yellow);
		
		JLabel affichage_Score_Red = new JLabel();
		affichage_Score_Red.setText("robot minmax");
		affichage_Score_Red.setFont(new Font("Verdana", Font.PLAIN, 18));		
		affichage_Score_Red.setForeground (Color.red);
		affichage_Score_Robot.add(affichage_Score_Red);

		
		rigth_Side.add(affichage_Manche, BorderLayout.NORTH);
		rigth_Side.add(affichage_Score_Robot, BorderLayout.CENTER);
        //rigth_Side.add(affichage_time,BorderLayout.SOUTH);
		
		/************************************************************/

		

		container.add(this.board, BorderLayout.CENTER);

		container.add(rigth_Side, BorderLayout.EAST);
	    pack();
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);//centre la fenetre
	    this.setVisible(true);// rend visible la fenetre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ferme la fentre et le programme 
	    
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		
	}




	
 /*   @Override
    public void actionPerformed(ActionEvent e) {
        affichage_time.setText(String.valueOf(count));
        if (! running) {
            timer.start();
            running = true;
            button.setEnabled(false);
        }
        // Writing the current time and increasing the cont times
        count++;
        if (count == 10) {
    		x += 1 ;
    		show_round.setText("Manche " + " " +  x);
            timer.stop();
            count = 0;
            running = false;
            button.setEnabled(true);
            

        }

    }*/

}