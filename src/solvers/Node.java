package solvers;

import game.*;

public class Node implements Comparable<Node>
{
    protected int x, y, heuristic, cout;
    protected Move move;
    protected State state;
    
    public Node(int x, int y, int heuristic, int cout, State state)
    {
        this.x = x;
        this.y = y;
        this.heuristic = heuristic;
        this.cout = cout;
        this.state = state; 
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
        return this.getX() == n.getX() && this.getY() == this.getY();

    }

    @Override
    public String toString() 
    {
        return this.x + ", " + this.y + " : " + this.heuristic + " " + this.cout;
    }
}
