package game;

import gamegui.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
    	/*//RandomBoardGeneration generationAleatoire = new RandomBoardGeneration(); 	
    	//int[][] bo = generationAleatoire.getBoard();  	*/
        State s = new State();
        new Containers(s);
    }
}

