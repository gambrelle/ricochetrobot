package solvers;

import java.io.IOException;
import java.util.ArrayList;

import game.*;
import gamegui.*;

public class BFS extends Solver
{
    public BFS (State state) throws IOException, InterruptedException {super(state);}

    public ArrayList<Move> getBestPath(int[][] board, int[] posRobot, int[] posGoals)
    {
        ArrayList<State> visitedState = new ArrayList<>();
        visitedState.add(this.initialState);
        return new ArrayList<Move>();
    }
}
