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
        /* State s = new State();
        
        System.out.println();
        System.out.println("[" + s.Get_Robot()[s.getActiveGoal()][0] + "," + s.Get_Robot()[s.getActiveGoal()][1] + "], " + "[" + s.Get_Goal()[s.getActiveGoal()][0] + "," + s.Get_Goal()[s.getActiveGoal()][1] + "]");
        System.out.println();

        s.chooseActivegoal(3);

        System.out.println();
        System.out.println("[" + s.Get_Robot()[s.getActiveGoal()][0] + "," + s.Get_Robot()[s.getActiveGoal()][1] + "], " + "[" + s.Get_Goal()[s.getActiveGoal()][0] + "," + s.Get_Goal()[s.getActiveGoal()][1] + "]");
        System.out.println();

        Solver solv = new AStar(s);
        ArrayList<Move> al;

        try 
        {
            al = solv.getBestPath();

        for (int i = al.size() - 1; i >= 0; i--)
            if (al.get(i) != null)
                System.out.println(al.get(i).toString());
            else
                continue;
        
        new Containers(s);
        }
        catch (Exception e) 
        {
            System.out.println("memory error");
        }
        catch (OutOfMemoryError e) 
        {
            System.out.println("memory error");
            new Containers(s);
        }
         */
        State s = new State();

        PrecomputedMap pm = new PrecomputedMap(s);

        pm.printMap();

        new Containers(s);

        /* int j = 0;
        
        ArrayList<Move> al;
        AStar solv;
        Node n;

        while (j < 4)
        {
            s.chooseActivegoal(j);

            System.out.println();
            System.out.println("[" + s.Get_Robot()[s.getActiveGoal()][0] + "," + s.Get_Robot()[s.getActiveGoal()][1] + "], " + "[" + s.Get_Goal()[s.getActiveGoal()][0] + "," + s.Get_Goal()[s.getActiveGoal()][1] + "]");
            System.out.println();
            
            solv = new AStar(s);

            try
            {
            n = solv.getBestPath();
            al = solv.reconstituerChemin(n);

            s = n.getState();

            for (int i = al.size() - 1; i >= 0; i--)
                if (al.get(i) != null)
                    System.out.println(al.get(i).toString());
                else
                    continue;
            }
            catch (Exception e) 
            {
                System.out.println("memory error");
            }
            catch (OutOfMemoryError e) 
            {
                System.out.println("pas de solutions trouvé !");
            }
            j++;
        }
        new Containers(s);*/
    } 
}

