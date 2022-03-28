package game;

import gamegui.*;

import java.io.IOException;
import java.util.Arrays;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
    	/*//RandomBoardGeneration generationAleatoire = new RandomBoardGeneration(); 	
    	//int[][] bo = generationAleatoire.getBoard();  	*/
        State s = new State();
        new Containers(s);
        

        	

                

        


        /*State s3 = s2.play(s.getUpMove(1), 1);
        for (Move move : s3.getMove(1))
            System.out.println(move.toString());
        	new Containers(s3);

        s.printBoard();
        System.out.println(Arrays.deepToString(s.posRobot));
        System.out.println(Arrays.deepToString(s.goalsToDo));

        

        System.out.println(Arrays.deepToString(s.posRobot));*/
    }
}
