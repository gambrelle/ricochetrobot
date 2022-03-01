package game;

import java.util.ArrayList;

public class State
{
    int[][] board;
    int[][] posRobot;
    public State()
    {

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
