package ricochetrobot;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class State {
    protected int[][] board;
    protected int[] posRobot;
    protected int[] goal;
    protected int[] goalsToDo;

    public State()
    {
        //this.goalsToDo = {1,1,2,2,3,3,4,4};

        //création du plateau vide.
        this.board = new int[16][16];
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                this.board[i][j] = 0;
            }
        }

        //positions interdites du centre
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

        List<Integer> centre = Arrays.asList(7,7,7,8,8,8,8,7,6,7,6,8,7,9,8,9,9,8,9,7,8,6,7,6);

        List<Integer> obstaclesSimples = Arrays.asList(10, 11, 12, 13);//liste non utilisé dans le programme mais utile
        List<Integer> obstaclesDoubles = Arrays.asList(20, 21, 22, 23);
        Random rand = new Random();
        int compteurObstaclesSimples = 0;
        int compteurObstaclesDoubles = 0;
        while (compteurObstaclesSimples < 8){
            //bordure exterieur haute
            for (int l=0;l<2;l++)
            {
                int int_i = 0;
                int int_j = rand.nextInt(14)+1;
                if (this.board[int_i][int_j] == 0)
                {
                    this.board[int_i][int_j] = 10;
                    this.board[int_i][int_j-1]=12;
                    compteurObstaclesSimples++;   
                }
            }
            //bordure exterieur basse
            for (int l=0;l<2;l++)
            {
                int int_i = 15;
                int int_j = rand.nextInt(14)+1; 
                //on place aléatoirement un obstacle vertical sur la paroi/bordure basse
                if (this.board[int_i][int_j] == 0)
                {
                    this.board[int_i][int_j] = 10;
                    this.board[int_i][int_j-1]=12;
                    compteurObstaclesSimples++;
                }
            }
            //bordure exterieur gauche
            for (int l=0;l<2;l++)
            {
                int int_i = rand.nextInt(14)+1;//entre 1 et 15 inclus
                int int_j = 0;
                if (this.board[int_i][int_j] == 0)
                {
                    this.board[int_i][int_j] = 13;
                    this.board[int_i-1][int_j]=11;
                    compteurObstaclesSimples++;                    
                }
            }
            //bordure exterieur droite
            for (int l=0;l<2;l++)
            {
                int int_i = rand.nextInt(14)+1;//entre 1 et 15 inclus
                int int_j = 15;
                if (this.board[int_i][int_j] == 0)
                {
                    this.board[int_i][int_j] = 13;
                    this.board[int_i-1][int_j]=11;
                    compteurObstaclesSimples++;                    
                }
            }
        } 
        //on trouve forcément 8 emplacements pour les obstacles simples.


        while (compteurObstaclesDoubles < 16){
            int int_i = rand.nextInt(13)+1;//entre 1 et 14
            int int_j = rand.nextInt(13)+1;//entre 1 et 14
            if (this.board[int_i][int_j] == 0)
            {
                this.board[int_i][int_j] = obstaclesDoubles.get(rand.nextInt(obstaclesDoubles.size()));
                compteurObstaclesDoubles++;
                //coin haut gauche
                if (this.board[int_i][int_j]==20)
                {
                    
                    //case sur la gauche 
                    if (this.board[int_i][int_j-1]==0){//cas où la case à gauche est vide
                        this.board[int_i][int_j-1]=12;//création obstacle droit sur case de gauche                        
                    }
                    else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
                    {
                        if (this.board[int_i][int_j-1]==12){}
                        else{
                            if (this.board[int_i][int_j-1]==11){ //présence d'un obstacle simple haut
                                this.board[int_i][int_j-1]=21;   //création coin haut droit
                            }
                            else{
                                if (this.board[int_i][int_j-1]==13){//présence d'un obstacle simple bas
                                    this.board[int_i][int_j-1]=22;  //création coin bas droit
                                }
                                else{
                                    this.board[int_i][int_j-1]=30; //création tunnel vertical/gauche droite
                                }
                            }
                        }
                    }


                    //case au-dessus
                    if (this.board[int_i-1][int_j]==0)//obstacle bas sur case au-dessus
                    {
                        this.board[int_i-1][int_j]=13;//création obstacle bas sur case au-dessus
                    }
                    else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
                    {
                        if (this.board[int_i-1][int_j]==13){}
                        else{
                            if (this.board[int_i-1][int_j]==10){ //présence d'un obstacle simple gauche
                                this.board[int_i-1][int_j]=23;   //création coin bas gauche
                            }
                            else{
                                if (this.board[int_i-1][int_j]==12){//présence d'un obstacle simple droit
                                    this.board[int_i-1][int_j]=22;  //création coin bas droit
                                }
                                else{
                                    this.board[int_i-1][int_j]=31; //création tunnel horizontal, bas haut
                                }
                            }
                        }
                    }
                    
                }



                //coin haut droit
                if (this.board[int_i][int_j]==11)
                {
                    //case de droite
                    this.board[int_i][int_j+1]=22;//obstacle gauche sur case de droite

                    //case du dessus
                    this.board[int_i-1][int_j]=23;//obstacle bas sur case au-dessus
                }

                //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                //coin bas droite
                if (this.board[int_i][int_j]==22)
                {
                    //case sur la droite                    
                    if (this.board[int_i+1][int_j]==0){//cas où la case à droite est vide
                        this.board[int_i+1][int_j]=10;//création obstacle gauche sur case de droite                       
                    }
                    else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
                    {
                        if (this.board[int_i+1][int_j]==10){}
                        else{
                            if (this.board[int_i+1][int_j]==11){ //présence d'un obstacle simple haut
                                this.board[int_i+1][int_j]=20;   //création coin haut gauche
                            }
                            else{
                                if (this.board[int_i+1][int_j]==13){//présence d'un obstacle simple bas
                                    this.board[int_i+1][int_j]=23;  //création coin bas gauche
                                }
                                else{
                                    this.board[int_i+1][int_j]=30; //création tunnel vertical/gauche droite
                                }
                            }
                        }
                    }

                    
                    //case en dessous
                    if (this.board[int_i+1][int_j]==0)//cas où la case en dessous est vide
                    {
                        this.board[int_i+1][int_j]=21;//obstacle haut sur case au-dessous
                    }
                    else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
                    {
                        if (this.board[int_i-1][int_j]==13){}
                        else{
                            if (this.board[int_i-1][int_j]==10){ //présence d'un obstacle simple gauche
                                this.board[int_i-1][int_j]=23;   //création coin bas gauche
                            }
                            else{
                                if (this.board[int_i-1][int_j]==12){//présence d'un obstacle simple droit
                                    this.board[int_i-1][int_j]=22;  //création coin bas droit
                                }
                                else{
                                    this.board[int_i-1][int_j]=31; //création tunnel horizontal, bas haut
                                }
                            }
                        }
                    }
                }
                //coin bas gauche
                if (this.board[int_i][int_j]==11)
                {
                    this.board[int_i][int_j-1]=22;//obstacle droit sur case de gauche
                    this.board[int_i+1][int_j]=21;//obstacle haut sur case au-dessous
                }
                
            }
        }
        
        //positions robots initiales
        int compteurRobotspos = 0;
        while (compteurRobotspos < 8)
        {
            int int_i = rand.nextInt(16);
            int int_j = rand.nextInt(16);
            int statut = 0;
            for (int i=0; i<12;i=i+2)
            {
                statut = 0;
                if(int_i != centre.get(i) | int_j != centre.get(i+1))
                {
                    statut = 1;         
                }
                
            }
            if (statut == 1)
            {
                this.posRobot[compteurRobotspos]=int_i;
                compteurRobotspos++;
                this.posRobot[compteurRobotspos]=int_j;
                compteurRobotspos++;
            }
            
            
            
        }

        //positions jetons initiales




    }
    public State(State etatPrecedent)
    {
        this.board = etatPrecedent.getBoard();
        this.posRobot = etatPrecedent.getPosRobot();
        this.goal = etatPrecedent.getGoal();
        this.goalsToDo = etatPrecedent.getGoalsToDo();
    }

    public void ObstaceDouble(int x, int y, int obstacle)
    {
        //coin haut gauche
        if (this.board[int_i][int_j]==10)
        {
            if (this.board[int_i][int_j-1]==0){//cas où la case à gauche est vide
                this.board[int_i][int_j-1]=22;//création obstacle droit sur case de gauche                        
            }
            else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
            {
                if (this.board[int_i][int_j-1]==22){}
                else{

                }
            }
            if (this.board[int_i-1][int_j]==0)//obstacle bas sur case au-dessus
            {
                this.board[int_i-1][int_j]=23;//création obstacle bas sur case au-dessus
            }
            else // cas où cette case n'est pas vide (ne peut être occupé que par un obstacle simple)
            {

            }
            
        }
    }

    public int[][] getBoard()
    {
        return this.board;
    }

    public int[] getPosRobot()
    {
        return this.posRobot;
    }

    public int[] getGoal()
    {
        return this.goal;
    }

    public int[] getGoalsToDo()
    {
        return this.goalsToDo;
    }

    /*public State Play(Move coup){
        State a = new State(this);


        return a;
    }
    */
}
    