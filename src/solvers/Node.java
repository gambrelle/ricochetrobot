package solvers;

import java.util.Arrays;

import game.*;

public class Node
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

    // Accesseurs 
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


    // Redéfinition de la fonction équals pour vérifier si un élément est dans une liste. 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Node))
            return false;
        Node n = (Node) obj;
        if (this.move == null)
            return false;
        return Arrays.deepEquals(this.getState().Get_Robot(), n.getState().Get_Robot());
    }


    @Override
    public String toString()
    {
        return this.getState().Get_Robot()[this.getState().getActiveGoal()][0] + ", " + this.getState().Get_Robot()[this.getState().getActiveGoal()][0] + " : " + this.heuristic + " " + this.cout;
    }
}
