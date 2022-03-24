/* package solvers;

import java.util.ArrayList;
import java.util.PriorityQueue;

import game.*;

public class AStar extends Solver
{
    public AStar(State state)
    {
        super(state);
    }

    public ArrayList<Node> getBestPath(int[][] board, int[] posRobot, int[]posGoals)
    {
        ArrayList<Node> closedList = new ArrayList<>();
        ArrayList<Node> openList = new ArrayList<>();
        openList.add(new Node(posRobot[0], posRobot[0], heuristic(posRobot, posGoals), null));
        while (!(openList.isEmpty()))
        {
            for (Node n : openList)
            {
                if (n.getX() == posGoals[0] && n.getY() == posGoals[1])
                    return openList;
                //////// A COMPLETER ////////////



                
                closedList.add(n);
            }
        }
        
        return openList;
    }
}
 */