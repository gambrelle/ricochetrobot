package game;

import gamegui.*;
//import solvers.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException 
    {
    	  State s = new State();
        new Containers(s);
        /* System.out.println("Le plateau pour cette partie est : ");
        s.printBoard();
        System.out.println("Le position des robot pour cette partie est : " + Arrays.deepToString(s.posRobot));
        System.out.println("Le position des objectifs pour cette partie est : " + Arrays.deepToString(s.goalsToDo));
        s.chooseActivegoal(1);

        Random r1 = new Random();
        Random r2 = new Random();

        while (!(s.isFinalState()))
        {
            //Test avec des mouvement aléatoire.
            int n1 = r1.nextInt(4);
            int n2 = 0;

            while (s.getMove(n1).size() == 0)
            {
                n1 = r1.nextInt(4);
            }

            n2 = r2.nextInt(s.getMove(n1).size());
            
            System.out.println(n1 + " : " + (s.getMove(n1).get(n2)).toString());
            s.play(s.getMove(n1).get(n2), n1);
        } */
    }

}