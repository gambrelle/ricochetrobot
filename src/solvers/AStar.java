package solvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import game.*;

public class AStar extends Solver
{
    public AStar(State state) throws IOException, InterruptedException
    {
        super(state);
    }

    public ArrayList<Move> getBestPath(int[][] board, int[] posRobot, int[]posGoals) 
    {
        Queue<Node> closeList = new PriorityQueue<>();
        int cout = 1;
        Node startNode = new Node(posRobot[0], posRobot[1], heuristic(posRobot, posGoals), cout, this.initialState);
        PriorityQueue<Node> openList = new PriorityQueue<>();
        openList.add(startNode);
        ArrayList<Move> actions = new ArrayList<>();
        actions.add(null);

        while (!(openList.isEmpty()))
        {
            Node n = openList.poll();

            if (n.getX() == posGoals[0] && n.getY() == posGoals[1])
            {
                return actions;
            }
            for (int i = 0; i <= 3; i++)
            {
                for (Move move : this.getState().getMove(i))
                {
                    State s;
                    try {s = this.play(n.state, move, i);}
                    catch (Exception e) {return null;}

                    cout ++;
                    int[] newPosRobot = s.Get_Robot()[this.initialState.getActiveGoal()];

                    Node node = new Node(newPosRobot[0], newPosRobot[1], heuristic(newPosRobot, posGoals)+cout, cout, s);
                    if (!(closeList.contains(node) || openList.contains(node)))
                    {
                        openList.add(node);
                        System.out.println(move.toString());
                    }
                }
            }
            closeList.add(n);
        }
        return null;
    }

    public State play(State s, Move m, int r) throws IOException, InterruptedException
    {
        State newS = s.getClone();
        newS.play(m, r);
        return newS;
    }


}
