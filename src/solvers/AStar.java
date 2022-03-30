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

    public ArrayList<Move> reconstituerChemin(Node n)
    {
        ArrayList<Move> path = new ArrayList<>();
        path.add(n.getMove());
        while (n.getNoeudPrecedent() != null)
        {
            n = n.getNoeudPrecedent();
            path.add(n.getMove());
        }
        return path;
    }

    public ArrayList<Move> getBestPath(int[][] board, int[] posRobot, int[]posGoals) 
    {
        Queue<Node> closeList = new PriorityQueue<>();
        int cout = 1;
        Node startNode = new Node(posRobot[0], posRobot[1], heuristic(posRobot, posGoals), cout, this.initialState, null, null);
        PriorityQueue<Node> openList = new PriorityQueue<>();
        openList.add(startNode);
        ArrayList<Move> actions = new ArrayList<>();

        while (!(openList.isEmpty()))
        {
            Node n = openList.poll();
            cout ++;

            if (n.getX() == posGoals[0] && n.getY() == posGoals[1])
            {
                return reconstituerChemin(n);
            }
            for (int i = 0; i <= 3; i++)
            {
                for (Move move : this.getState().getMove(i))
                {
                    State s;
                    try {
                        s = this.initialState.getClone();
                        s.play(move, i);
                    }
                    catch (Exception e) {return null;}

                    int[] newPosRobot = s.Get_Robot()[this.initialState.getActiveGoal()];

                    Node node = new Node(newPosRobot[0], newPosRobot[1], heuristic(newPosRobot, posGoals)+cout, cout, s, n, move);
                    int count = 0; 
                    if (!(closeList.isEmpty()))
                    {
                        for (Node nodeClose : closeList)
                        if (nodeClose.equals(node))
                            count += 1;
                    }
                    if (count == 0)
                        openList.add(node);
                    if (closeList.isEmpty())
                        openList.add(node);
                    //if (!(closeList.contains(node)))
                    //{
                        //openList.add(node);
                        //System.out.println(cout);
                    //}
                }
            }
            closeList.add(n);
        }
        System.out.println("ERROR");
        return null;
    }

}
