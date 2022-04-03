package game;

import gamegui.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class State
{
    int[][] board;
    int[][] posRobot;
    protected int active_goal;
    protected int[][] goalsToDo;
    int robot ; 

    

    public State() //throws IOException, InterruptedException
    {   
        System.out.println("State.java");
    	RandomBoardGeneration generationAleatoire = new RandomBoardGeneration();
		this.board =  generationAleatoire.getBoard();
        this.posRobot = generationAleatoire.getPosRobot();
        this.active_goal = generationAleatoire.getActiveGoal();
        this.goalsToDo = generationAleatoire.getGoalsToDo();
        
    }
    //Produit une nouvelle grille a chaque tour, il faudrai faire un ramdom que une seule fois 

    public int GetNumber()
    {
    	return robot;
    }
    
    public int[][] Get_Board()
    {
		return this.board;
    	
    }
    public int[][] Get_Robot()
    {
    	return this.posRobot;
    }
    public int[][] getGoalsToDo()
    {
        return this.goalsToDo;
    } 
    public int getActiveGoal()
    {
        return this.active_goal;
    }
    public void chooseActivegoal(int i)
    {
        this.active_goal = i;
    }  
    
    public int[][] Get_Goal()
    {
    	return this.goalsToDo ;
    }



    public void printBoard()
    {
        for (int i = 0; i < this.board.length; i++)
        {
            for (int j = 0; j < this.board[i].length; j++)
                {
                    if (this.board[j][i] < 9)
                        System.out.print(" " + this.board[j][i] + " ");
                    else
                        System.out.print(this.board[j][i] +" ");
                }
                System.out.print("\n");
        }
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

  
    public void play(Move move, int robot)
    {
        this.posRobot[robot][0] = move.getPosXF();
        this.posRobot[robot][1] = move.getPosYF();
    }

  
    public Move getRightMove(int robot)
    {
        for (int i = this.posRobot[robot][0]; i<16; i++)
        {

            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == i+1 && this.posRobot[k][1] == this.posRobot[robot][1])
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
            }
            if(this.board[i][this.posRobot[robot][1]] == 12 || this.board[i][this.posRobot[robot][1]] == 21 || this.board[i][this.posRobot[robot][1]] == 22)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 15, this.posRobot[robot][1]);
    }
    public Move getLeftMove(int robot)
    {
        for (int i = this.posRobot[robot][0]; i>0; i--)
        {

            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == i-1 && this.posRobot[k][1] == this.posRobot[robot][1])
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
            }
            if(this.board[i][this.posRobot[robot][1]] == 10 || this.board[i][this.posRobot[robot][1]] == 20 || this.board[i][this.posRobot[robot][1]] == 23)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);

        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 0, this.posRobot[robot][1]);
    }
    public Move getDownMove(int robot)
    {
        for (int i = this.posRobot[robot][1]; i<16; i++)
        {
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == this.posRobot[robot][0] && this.posRobot[k][1] == i+1)
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
            }
            if(this.board[this.posRobot[robot][0]][i] == 13 || this.board[this.posRobot[robot][0]][i] == 22 || this.board[this.posRobot[robot][0]][i] == 23)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);

        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 15);
    }
    public Move getUpMove(int robot)
    {
        for (int i = this.posRobot[robot][1]; i>0; i--)
        {
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == this.posRobot[robot][0] && this.posRobot[k][1] == i-1)
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
            }
            if(this.board[this.posRobot[robot][0]][i] == 11 || this.board[this.posRobot[robot][0]][i] == 20 || this.board[this.posRobot[robot][0]][i] == 21)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);

        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 0);
    }

    public Move getRightMoveToken(int jeton)
    {
        for (int i = this.getGoalsToDo()[jeton][0]; i<16; i++)
        {
            if(this.Get_Board()[i][this.getGoalsToDo()[jeton][1]] == 12 || this.getGoalsToDo()[jeton][1] == 21 || this.getGoalsToDo()[jeton][1] == 22)
                return new Move(this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], i, this.getGoalsToDo()[jeton][1]);
        }
        return new Move(this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], 15, this.getGoalsToDo()[jeton][1]);
    }

    public Move getLeftMoveToken(int jeton)
    {
        for (int i = this.getGoalsToDo()[jeton][0]; i>0; i--)
        {
            if(this.Get_Board()[i][this.getGoalsToDo()[jeton][1]] == 10 || this.getGoalsToDo()[jeton][1] == 20 || this.getGoalsToDo()[jeton][1] == 23)
                return new Move(robot, this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], i, this.getGoalsToDo()[jeton][0]);

        }
        return new Move(this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], 0, this.getGoalsToDo()[jeton][1]);
    }

    public Move getDownMoveToken(int jeton)
    {
        for (int i = this.getGoalsToDo()[jeton][1]; i<16; i++)
        {
            if(this.board[this.getGoalsToDo()[jeton][0]][i] == 13 || this.board[this.getGoalsToDo()[jeton][0]][i] == 22 || this.board[this.getGoalsToDo()[jeton][0]][i] == 23)
                return new Move(this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], this.getGoalsToDo()[jeton][0], i);
        }
        return new Move(robot, this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], this.getGoalsToDo()[jeton][0], 15);
    }

    public Move getUpMoveToken(int jeton)
    {
        for (int i = this.getGoalsToDo()[jeton][1]; i>0; i--)
        {
            if(this.board[this.getGoalsToDo()[jeton][0]][i] == 11 || this.board[this.getGoalsToDo()[jeton][0]][i] == 20 || this.board[this.getGoalsToDo()[jeton][0]][i] == 21)
                return new Move(robot, this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], this.getGoalsToDo()[jeton][0], i);

        }
        return new Move(this.getGoalsToDo()[jeton][0], this.getGoalsToDo()[jeton][1], this.getGoalsToDo()[jeton][0], 0);
    }

    public ArrayList<Move> getMove(int robot)
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        allMoves.add(getUpMove(robot));
        allMoves.add(getRightMove(robot));
        allMoves.add(getDownMove(robot));
        allMoves.add(getLeftMove(robot));
        for (Iterator<Move> it = allMoves.iterator(); it.hasNext(); ) {
            Move move = it.next();
            if (move.getPosXI() == move.getPosXF() && move.getPosYI() == move.getPosYF())
                it.remove();
        }
        return allMoves;
    }

    public ArrayList<Move> getMoveToken(int jeton)
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        allMoves.add(getUpMoveToken(jeton));
        allMoves.add(getRightMoveToken(jeton));
        allMoves.add(getDownMoveToken(jeton));
        allMoves.add(getLeftMoveToken(jeton));
        for (Iterator<Move> it = allMoves.iterator(); it.hasNext(); ) {
            Move move = it.next();
            if (move.getPosXI() == move.getPosXF() && move.getPosYI() == move.getPosYF())
                it.remove();
        }
        return allMoves;
    }

    public boolean isFinalState()
    {
        return this.posRobot[this.active_goal][0] == this.goalsToDo[this.active_goal][0] && this.posRobot[this.active_goal][1] == this.goalsToDo[this.active_goal][1];
    }
    
}