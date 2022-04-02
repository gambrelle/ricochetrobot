package solvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.*;

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

    public ArrayList<Move> getBestPath() 
    {
        int cout = 1;
        Node startNode = new Node(this.posActiveRobot[0], this.posActiveRobot[1], heuristic(this.posActiveRobot, this.posActiveGoal), cout, this.initialState, null, null);
        PriorityQueue<Node> openList = new PriorityQueue<Node>();
        openList.add(startNode);
        HashSet<Node> closeList = new HashSet<>();

        while (!(openList.isEmpty()))
        {
            Node n = openList.poll();
            cout ++;

            if (n.getX() == this.posActiveGoal[0] && n.getY() == this.posActiveGoal[1])
            {
                return reconstituerChemin(n);
            }
            /* if (cout <11){
                System.out.println();
                System.out.println();} */
            for (int i = 0; i <= 3; i++)
            {
                /* if (cout <11)
                    System.out.println(); */
                for (Move move : n.getState().getMove(i))
                {
                    State s;

                    /* s = n.getState().getClone(); 
                    s.play(move, i); */

                    try {
                        s = n.getState().getClone();
                        s.play(move, i);
                    }
                    catch (Exception e) {return null;}

                    int[] newPosRobot = s.Get_Robot()[s.getActiveGoal()];

                    Node node = new Node(newPosRobot[0], newPosRobot[1], heuristic(newPosRobot, this.posActiveGoal), cout, s, n, move);
                    int count = 0;


                    if (!(closeList.isEmpty()))
                    {
                        for (Node nodeClose : closeList)
                        {
                            if (nodeClose.equals(node))
                            {
                                count += 1;
                            }
                        }
                       for (Node nodeOpen : openList)
                       {
                            if (node.equals(nodeOpen))
                            {
                                if (nodeOpen.cout > node.cout)
                                {
                                    count += 1;
                                }
                            }
                        } 
                    }
                    if (count == 0)
                    {
                        openList.add(node);
                    }
                    /* if (cout <10)
                        System.out.println(Array (node.state.Get_Robot())); */
                }
            }
            
        }
        
        return null;
    }

}
