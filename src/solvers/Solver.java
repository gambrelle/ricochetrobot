package solvers;

import java.io.IOException;

import game.*;

public abstract class Solver
{
    protected State initialState;
    protected int[] posActiveRobot, posActiveGoal;

    public Solver(State state) throws IOException, InterruptedException
    {
        this.initialState = state.getClone();
        this.posActiveGoal = this.initialState.getAllGoals()[this.initialState.getActiveGoal()];
        this.posActiveRobot = this.initialState.Get_Robot()[this.initialState.getActiveGoal()];
    }

    // Renvoie le State
    public State getState()
    {
        return this.initialState;
    }
    // Permet de changer la valeur de state
    public void setState(State newState)
    {
        this.initialState = newState;
    }
    // Renvoie la distance de manhattan entre 2 point.
    public int manhattanDistance(int[] posRobot, int[] posGoals)
    {
        // Comme donnee heuristique on prend la distance de manhattan entre le robot et l'objectif
        return Math.abs(posGoals[0] - posRobot[0]) + Math.abs(posGoals[1] - posRobot[1]);
    }

    // Renvoie le dernier noeud du meilleur chemin trouvé.
    public abstract Node getBestPath();
}
