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

        PrecomputedMap pm = new PrecomputedMap(s);

        int j = 0;
        new Containers(s);
        ArrayList<Move> al;
        AStar solv;
        Node n;

        while (j < 4)
        {
            s.chooseActivegoal(j);

            System.out.println(s.printActiveGoal() + "\n");

            solv = new AStar(s);

            try
            {
            n = solv.getBestPath();
            al = solv.reconstituerChemin(n);

            s = n.getState();

            for (int i = 0; i < al.size(); i++)
                if (al.get(i) != null)
            System.out.println(al.get(i).toString());
                else
            continue;

            for (int i = al.size() - 1; i >= 0; i--)
                if (al.get(i) != null)
                    System.out.println(al.get(i).toString());
                else
                    continue;
            }
            catch (Exception e) 
            {
            }
            catch (OutOfMemoryError e) 
            {
                System.out.println("Solutions introuvables !");
            }
            j++;
            System.out.println();
        }
    } 
}

