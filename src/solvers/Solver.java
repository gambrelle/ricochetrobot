package solvers;

import java.util.ArrayList;

import game.*;

public abstract class Solver 
{
    protected int[][] board, posRobot;
    protected int [] activeGoals;

    public Solver(State state)
    {
        this.board = state.Get_Board();
        this.posRobot = state.Get_Robot();
        this.activeGoals = state.Get_Robot()[state.getActiveGoal()];
    }

    public int heuristic(int[] posRobot, int[] posGoals)
    {
        // Comme donnée heuristique on prend la distance de manhattan entre le robot et l'objectif
        return Math.abs(posGoals[0] - posRobot[0]) + Math.abs(posGoals[1] - posRobot[1]);
    }
    
    public abstract ArrayList<Node> getBestPath(int[][] board, int[] posRobot, int[]posGoals);
}
