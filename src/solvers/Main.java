package solvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import game.*;
import gamegui.*;

public class Main 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        State s = new State();
        Solver solv = new AStar(s);

        ArrayList<Move> al = solv.getBestPath(s.Get_Board(), s.Get_Robot()[s.getActiveGoal()], s.Get_Goal()[s.getActiveGoal()]);
        for (Move move : al)
            System.out.println(move.toString());
    }
}

