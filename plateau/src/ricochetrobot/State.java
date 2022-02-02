package ricochetrobot;
public class State {
    protected int[][] board;
    protected int[][] posRobot;
    protected int[] goal;
    protected int[] goalsToDo;

    public State()
    {
        //this.goalsToDo = {5,1,1,2,2,3,3,4,4};

        //création du plateau vide.
        this.board = new int[16][16];
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; i++)
            {
                this.board[i][j] = 0;
            }
        }
        this.board[7][7] = 24;
        this.board[7][8] = 21;
        this.board[8][8] = 22;
        this.board[8][7] = 23;
        this.board[6][7] = 13;
        this.board[6][8] = 13;
        this.board[7][9] = 14;
        this.board[8][9] = 14;
        this.board[9][8] = 11;
        this.board[9][7] = 11;
        this.board[8][6] = 12;
        this.board[7][6] = 12;
        System.out.println(this.board.toString());
    }
}
