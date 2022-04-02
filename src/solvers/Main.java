package solvers;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.PriorityQueue;

import game.*;
import gamegui.*;

public class Main 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        State s = new State();
        Solver solv = new AStar(s);

        System.out.println();
        System.out.println("[" + s.Get_Robot()[s.getActiveGoal()][0] + "," + s.Get_Robot()[s.getActiveGoal()][1] + "], " + "[" + s.Get_Goal()[s.getActiveGoal()][0] + "," + s.Get_Goal()[s.getActiveGoal()][1] + "]");
        System.out.println();

        ArrayList<Move> al = solv.getBestPath();

        for (int i = al.size() - 1; i >= 0; i--)
            if (al.get(i) != null)
                System.out.println(al.get(i).toString());
            else
                continue;
        
        new Containers(s);
    }
}

