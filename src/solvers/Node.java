package solvers;

import game.*;

public class Node implements Comparable<Node>
{
    protected int x, y, heuristic;
    protected Move move;
    
    public Node(int x, int y, int heuristic, Move move)
    {
        this.x = x;
        this.y = y;
        this.heuristic = heuristic;
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
    
    @Override
    public int compareTo(Node n) 
    {
        return this.heuristic > n.heuristic ? 1 : this.heuristic < n.heuristic ? -1 : 0;
    }

    @Override
    public String toString() 
    {
        return this.x + ", " + this.y + " : " + this.heuristic;
    }
}
