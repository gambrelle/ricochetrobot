package solvers;

import java.util.Arrays;

import game.*;

public class Node //implements Comparable<Node>
{
    protected int heuristic, cout;
    protected Move move;
    protected State state;
    protected Node noeudPrecedent;
    
    public Node(int heuristic, int cout, State state, Node noeudPrecedent, Move move)
    {
        this.heuristic = heuristic;
        this.cout = cout;
        this.state = state;
        this.noeudPrecedent = noeudPrecedent;
        this.move = move;
    }

    public int getHeuristic()
    {
        return this.heuristic;
    }
    public int getCout() {
        return this.cout;
    }
    public Node getNoeudPrecedent()
    {
        return this.noeudPrecedent;
    }
    public Move getMove()
    {
        return this.move;
    }
    public State getState() {
        return this.state;
    }
    
   /*  @Override
    public int compareTo(Node n) 
    {
        return this.heuristic > n.heuristic ? 1 : this.heuristic < n.heuristic ? -1 : 0;
    } */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Node))
            return false;
        Node n = (Node) obj;
        if (this.move == null)
            return false;
        //return this.move.equals(n.move) && Arrays.deepEquals(this.state.Get_Robot(), n.state.Get_Robot());// && this.noeudPrecedent.equals(n.noeudPrecedent);
        return Arrays.deepEquals(this.getState().Get_Robot(), n.getState().Get_Robot());
        
    }

    @Override
    public String toString()
    {
        return this.getState().Get_Robot()[this.getState().getActiveGoal()][0] + ", " + this.getState().Get_Robot()[this.getState().getActiveGoal()][0] + " : " + this.heuristic + " " + this.cout;
    }
}
