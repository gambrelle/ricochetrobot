package game;

import java.util.ArrayList;

public class State
{
    int[][] board;
    public State()
    {

    }

    /* public ArrayList<Move> getMove(int robot, int[] posRobot)
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        int x = posRobot[0];
        int y = posRobot[1];
        while(y > 0)
        {
            y--;
            if (this.board[x][y] == 22 || this.board[x][y] == 11 || this.board[x][y] == 12)
            {
                y = -1;
                break;
            }
            allMoves.add(new Move(robot, posRobot[0], posRobot[1], x, y));
        }//fait !
        y = posRobot[0];
        while(y < this.board[x].length)
        {
            y++;
            if (this.board[x][y] == 20 || this.board[x][y] == 10 || this.board[x][y] == 13)
            {
                y = this.board[x].length + 3;
                break;
            }
            allMoves.add(new Move(robot, posRobot[0], posRobot[1], x, y));
        }//fait !!
        y = posRobot[1];
        while(x > 0)
        {
            x--;
            if (this.board[x][y] == 21 || this.board[x][y] == 11 || this.board[x][y] == 10)
            {
                x = -1;
                break;
            }
            allMoves.add(new Move(robot, posRobot[0], posRobot[1], x, y));
        }
        x = posRobot[0];
        while(y < this.board.length)
        {
            x++;
            if (this.board[x][y] == 23 || this.board[x][y] == 12 || this.board[x][y] == 13)
            {
                x = this.board.length + 3;
                break;
            }
            allMoves.add(new Move(robot, posRobot[0], posRobot[1], x, y));
        }
        return allMoves;
    }
    public ArrayList<Move> getMoves()
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        for(int i = 0; i<4; i++)
        {
            for (Move m : this.getMove(i, this.posRobot[i]))
                allMoves.add(m);
        }
        return allMoves;
    }
 */

}
