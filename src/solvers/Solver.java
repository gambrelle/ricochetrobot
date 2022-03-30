package solvers;

import java.io.IOException;
import java.util.ArrayList;

import game.*;

public abstract class Solver 
{
    protected State initialState;
    protected int[] posActiveRobot, posActiveGoal;

    public Solver(State state) throws IOException, InterruptedException
    {
        this.initialState = state.getClone();
        this.posActiveGoal = this.initialState.getAllGoals()[this.initialState.getActiveGoal()];
        this.posActiveGoal = this.initialState.Get_Robot()[this.initialState.getActiveGoal()];
    }

    public State getState()
    {
        return this.initialState;
    }
    public void setState(State newState)
    {
        this.initialState = newState;
    }

    public int heuristic(int[] posRobot, int[] posGoals)
    {
        // Comme donnée heuristique on prend la distance de manhattan entre le robot et l'objectif
        return Math.abs(posGoals[0] - posRobot[0]) + Math.abs(posGoals[1] - posRobot[1]);
    }

    public abstract ArrayList<Move> getBestPath(int[][] board, int[] posRobot, int[]posGoals);
}
