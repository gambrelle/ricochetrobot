package game;

import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        State s = new State();
        Random r = new Random();
        s.printBoard();
        System.out.println(Arrays.deepToString(s.posRobot));
        for (int i = 0; i < 5; i ++)
        {
            int n = r.nextInt(3);
            int m = r.nextInt(s.getMove(n).size());
            s.printBoard();
            System.out.println(n + " : " + s.getMove(n).get(m).toString());
            s = s.play(s.getMove(n).get(m), n);
        }
        /*for (Move move : s.getMove(1))
            System.out.println(move.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        State s2 = s.play(s.getLeftMove(1), 1);
        for (Move move : s2.getMove(1))
            System.out.println(move.toString());*/
    }
}
