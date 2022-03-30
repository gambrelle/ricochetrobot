package solvers;

import java.io.IOException;

import game.*;
import gamegui.*;

public class Main 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        State s = new State();
        Solver solv = new AStar(s);

        System.out.println(solv.getBestPath(s.Get_Board(), s.Get_Robot()[s.getActiveGoal()], s.Get_Goal()[s.getActiveGoal()]));
    }
}

