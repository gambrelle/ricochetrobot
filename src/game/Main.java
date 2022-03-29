package game;

import gamegui.*;
import solvers.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
    	  State s = new State();
        new Containers(s);
        System.out.println("Le plateau pour cette partie est : ");
        s.printBoard();
        System.out.println("Le position des robot pour cette partie est : " + Arrays.deepToString(s.posRobot));
        System.out.println("Le position des objectifs pour cette partie est : " + Arrays.deepToString(s.goalsToDo));
        s.chooseActivegoal(1);

        
        
    }

