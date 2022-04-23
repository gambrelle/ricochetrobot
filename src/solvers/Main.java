package solvers;

import java.io.IOException;
import java.util.ArrayList;

import game.*;
import gamegui.*;

public class Main 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        State s = new State();
        State copyS = s.getClone();

        s.printBoard();

        int j = 0;
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
            
            if (n != null)
            {
                s = n.getState();

                for (int i = al.size() - 1; i >= 0; i--)
                    if (al.get(i) != null)
                        System.out.println(al.get(i).toString());
                    else
                        continue;
            }
            }
            catch (Exception e) 
            {
                System.out.println("Memory Error");
            }
            catch (OutOfMemoryError e) 
            {
                System.out.println("Solutions introuvables !");
            }
            j++;
            System.out.println();
        }
        new Containers(copyS);
    } 
}

