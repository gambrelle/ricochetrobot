package ricochetrobot;

public class Test
{
    public static void main(String[] args)
    {

        int[][] board = new int[16][16];
        for (int i = 0; i <= 15; i++)
        {
            for (int j = 0; j <= 15; j++)
            {
                board[i][j] = 0;
            }
        }
        board[7][7] = 24;
        board[7][8] = 21;
        board[8][8] = 22;
        board[8][7] = 23;
        board[6][7] = 13;
        board[6][8] = 13;
        board[7][9] = 14;
        board[8][9] = 14;
        board[9][8] = 11;
        board[9][7] = 11;
        board[8][6] = 12;
        board[7][6] = 12;
        System.out.println(board);
    }
}