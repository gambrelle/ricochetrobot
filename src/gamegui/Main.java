package gamegui;

import java.io.IOException;
import java.util.Random;

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

	}

}
