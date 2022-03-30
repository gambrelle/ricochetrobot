package solvers;

import java.util.Arrays;

import game.*;

public class Node implements Comparable<Node>
{
    protected int x, y, heuristic, cout;
    protected Move move;
    protected State state;
    protected Node noeudPrecedent;
    
    public Node(int x, int y, int heuristic, int cout, State state, Node noeudPrecedent, Move move)
    {
        this.x = x;
        this.y = y;
        this.heuristic = heuristic;
        this.cout = cout;
        this.state = state;
        this.noeudPrecedent = noeudPrecedent;
        this.move = move;
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
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
    
    @Override
    public int compareTo(Node n) 
    {
        return this.heuristic > n.heuristic ? 1 : this.heuristic < n.heuristic ? -1 : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Node))
            return false;
        Node n = (Node) obj;
        if (n == null)
            return false;
        if (this.move == null)
            return false;
        return this.getX() == n.getX() && this.getY() == this.getY() && this.move.equals(n.move) && Arrays.deepEquals(this.state.Get_Robot(), n.state.Get_Robot());// && this.noeudPrecedent.equals(n.noeudPrecedent);
    }

    @Override
    public String toString()
    {
        return this.x + ", " + this.y + " : " + this.heuristic + " " + this.cout;
    }
}
