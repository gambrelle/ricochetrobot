package game;

import gamegui.*;

import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
    	//RandomBoardGeneration generationAleatoire = new RandomBoardGeneration(); 	
    	//int[][] bo = generationAleatoire.getBoard();  	
        State s = new State();
        new Containers(s);
        for (Move move : s.getMove(1))
            System.out.println(move.toString());
        State s2 = s.play(s.getLeftMove(1), 1);
        for (Move move : s2.getMove(1))
            System.out.println(move.toString());
        State s3 = s2.play(s.getUpMove(1), 1);
        for (Move move : s3.getMove(1))
                System.out.println(move.toString());
    }
}
