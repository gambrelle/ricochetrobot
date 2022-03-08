package game;
public class Main
{
    public static void main(String[] args) {
        State s = new State();
        for (Move move : s.getMove(1))
            System.out.println(move.toString());
        State s2 = s.play(s.getLeftMove(1), 1);
        for (Move move : s2.getMove(1))
            System.out.println(move.toString());
        State s3 = s2.play(s.getUpMove(1), 1);
        for (Move move : s3.getMove(1))
                System.out.println(move.toString());
    }
}
