package game;

import gamegui.*;

import java.io.IOException;
import java.util.ArrayList;

public class State
{
    int[][] board;
    int[][] posRobot;
    protected int active_goal;
    protected int[] goalsToDo;

    

    public State() throws IOException, InterruptedException
    {
    	RandomBoardGeneration generationAleatoire = new RandomBoardGeneration();
		this.board =  generationAleatoire.getBoard();
        this.posRobot = generationAleatoire.getPosRobot();
        this.active_goal = generationAleatoire.getActiveGoal();
        this.goalsToDo = generationAleatoire.getGoalsToDo();
		

    }
    //Produit une nouvelle grille à chaque tour, il faudrai faire un ramdom que une seule fois 
    
    
    public int[][] Get_Board()
    {
		return this.board;
    	
    }
    
    public int[][] Get_Robot()
    {
    	return this.posRobot;
    }

    public State getClone() throws IOException, InterruptedException
    {
        State s = new State();
        for (int i = 0; i < s.board.length; i++)
        {
            for (int j = 0; j < s.board[i].length; j++)
            {
                s.board[i][j] = this.board[i][j];
            }
        }
        for (int i = 0; i < s.posRobot.length; i++)
        {
            for (int j = 0; j < s.posRobot[i].length; j++)
            {
                s.posRobot[i][j] = this.posRobot[i][j];

                
            }
        }
        return s;
    }
    public State play(Move move, int robot) throws IOException, InterruptedException
    {
        State s = this.getClone();
        s.posRobot[robot][0] = move.getPosXF();
        s.posRobot[robot][1] = move.getPosYF();
        return s;
    }
    public Move getRightMove(int robot)
    {
        for (int i = this.posRobot[robot][1]; i<16; i++)
        {
            if(this.board[this.posRobot[robot][0]][i] == 12 || this.board[this.posRobot[robot][0]][i] == 21 || this.board[this.posRobot[robot][0]][i] == 22)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 16);
    }
    public Move getLeftMove(int robot)
    {
        for (int i = this.posRobot[robot][1]; i>0; i--)
        {
            if(this.board[this.posRobot[robot][0]][i] == 10 || this.board[this.posRobot[robot][0]][i] == 23 || this.board[this.posRobot[robot][0]][i] == 20)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 0);
    }
    public Move getDownMove(int robot)
    {
        for (int i = this.posRobot[robot][0]; i<16; i++)
        {
            if(this.board[i][this.posRobot[robot][1]] == 13 || this.board[i][this.posRobot[robot][1]] == 22 || this.board[i][this.posRobot[robot][1]] == 23)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][0]);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 16, this.posRobot[robot][0]);
    }
    public Move getUpMove(int robot)
    {
        for (int i = this.posRobot[robot][0]; i>0; i--)
        {
            if(this.board[i][this.posRobot[robot][1]] == 11 || this.board[i][this.posRobot[robot][1]] == 21 || this.board[i][this.posRobot[robot][1]] == 21)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][0]);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 0, this.posRobot[robot][0]);
    }

    public ArrayList<Move> getMove(int robot)
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        allMoves.add(getUpMove(robot));
        allMoves.add(getRightMove(robot));
        allMoves.add(getDownMove(robot));
        allMoves.add(getLeftMove(robot));
        return allMoves;
    }
}
