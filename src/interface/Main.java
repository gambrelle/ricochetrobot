package board;

import java.io.IOException;

public class Main {
	
	

	public static void main(String[] args) throws IOException, InterruptedException
	{

		
		int[][] matrice = new int[15][15];
		matrice[8][6]= 10;
		matrice[5][6]= 10;
		matrice[14][14]= 13;
		int[] position_depart = {8,6,5,8,2,4,6,9};
		//matrice[position_depart[0]][position_depart[1]] = 12; 
		Board board = new Board(matrice);
		new Containers(board);
		
	}

}
