package gamegui;

import java.io.IOException;


import game.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException, InterruptedException
	{

		//int[] position_depart = {8,6,5,8,2,4,6,9};
		//matrice[position_depart[0]][position_depart[1]] = 12; 
		//RandomBoardGeneration ran = new RandomBoardGeneration();
		//int [][] board = ran.getBoard();
		//new Containers(board);
        State s = new State();
        new Containers(s);
        for (Move move : s.getMove(1))
            System.out.println(move.toString());   	
        State s2 = s.play(s.getLeftMove(1), 1);
        for (Move move : s2.getMove(1))
            System.out.println(move.toString());
    		new Containers(s2);
        State s3 = s2.play(s.getUpMove(1), 1);
        for (Move move : s3.getMove(1))
                System.out.println(move.toString());
        		new Containers(s3);

        
       /* for (Move move : s.getMove(1))
            System.out.println(move.toString());   	
        State s2 = s.play(s.getLeftMove(1), 1);
        for (Move move : s2.getMove(1))
            System.out.println(move.toString());
    		new Containers(s2);
        State s3 = s2.play(s.getUpMove(1), 1);
        for (Move move : s3.getMove(1))
                System.out.println(move.toString());
        		new Containers(s3);*/
		
	}

}
