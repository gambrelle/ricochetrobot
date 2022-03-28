package solvers;

import java.util.ArrayList;

import game.*;
import gamegui.*;

public class BFS extends Solver
{
    public BFS (State state) {super(state);}

    public ArrayList<Move> getBestPath(int[][] board, int[] posRobot, int[] posGoals)
    {
        ArrayList<State> visitedState = new ArrayList<>();
        visitedState.add(this.initialState);
        return new ArrayList<Move>();
    }
}
