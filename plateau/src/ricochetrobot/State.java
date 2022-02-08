package ricochetrobot;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Random;
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
            for (int j = 0; j < 16; j++)
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

        List<Integer> obstaclesDoubles = Arrays.asList(10, 11, 12, 13);// cf représentation des obstacles
        List<Integer> obstaclesSimples = Arrays.asList(20, 21, 22, 23);
        Random rand = new Random();
        int compteurObstaclesSimples = 0;
        int compteurObstaclesDoubles = 0;
        while (compteurObstaclesSimples < 8){
            int int_i = rand.nextInt(16);
            int int_j = rand.nextInt(16);
            if (this.board[int_i][int_j] == 0)
            {
                this.board[int_i][int_j] = obstaclesSimples.get(rand.nextInt(obstaclesSimples.size()));
                compteurObstaclesSimples++;
            }
        }
        while (compteurObstaclesDoubles < 16){
            int int_i = rand.nextInt(15)+1;
            int int_j = rand.nextInt(15)+1;
            if (this.board[int_i][int_j] == 0)
            {
                this.board[int_i][int_j] = obstaclesDoubles.get(rand.nextInt(obstaclesDoubles.size()));
                compteurObstaclesDoubles++;
                //coin haut gauche
                if (this.board[int_i][int_j]==10)
                {
                    this.board[int_i][int_j-1]=22;//obstacle droit sur case de gauche
                    this.board[int_i-1][int_j]=23;//obstacle bas sur case au-dessus
                }
                //coin haut droit
                if (this.board[int_i][int_j]==11)
                {
                    this.board[int_i][int_j+1]=22;//obstacle gauche sur case de droite
                    this.board[int_i-1][int_j]=23;//obstacle bas sur case au-dessus
                }
                //coin bas droite
                if (this.board[int_i][int_j]==12)
                {
                    this.board[int_i][int_j+1]=20;//obstacle gauche sur case de droite
                    this.board[int_i+1][int_j]=21;//obstacle haut sur case au-dessous
                }
                //coin bas gauche
                if (this.board[int_i][int_j]==11)
                {
                    this.board[int_i][int_j-1]=22;//obstacle droit sur case de gauche
                    this.board[int_i+1][int_j]=21;//obstacle haut sur case au-dessous
                }
                
            }
        }
        
        //tirage des cases à modifier




    }
}
    