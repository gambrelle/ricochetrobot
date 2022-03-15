package game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBoardGeneration
{
    protected int[][] board;
    protected int[][] posRobot;//[xrobot1, yrobot1, xrobot2, yrobot2,..] positions des robots (4 robots donc 8 entiers (coordonnées x, y))
    protected int active_goal; //numéro du jeton "objectif" entre 0 et 3 (4 valeurs possibles car 4 jetons)
    protected int[][] goalsToDo;//[xjeton1,yjeton1,xjeton2,yjeton2] position des jetons (4 jetons donc 8 entiers (coordonnées x, y))
    public RandomBoardGeneration()
    {

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

        List<Integer> obstaclesSimples = Arrays.asList(10, 11, 12, 13);//liste non utilisé dans le programme
        //10 = obstacle simple gauche
        //11 = obstacle simple haut
        //12 = obstacle simple droit
        //13 = obstacle simple bas

        List<Integer> obstaclesDoubles = Arrays.asList(20, 21, 22, 23);
        //20 = obstacle double haut gauche
        //21 = obstacle double haut droit
        //22 = obstacle double bas droit
        //23 = obstacle double bas gauche

        //Obstacles "tunnel"
        //30 = tunnel vertical/gauche droite
        //31 = tunnel horizontal/haut bas



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

            }
        }

        //positions robots initiales
        int compteurRobotspos = 0;
        this.posRobot= new int[4][2];
        while (compteurRobotspos < 4)
        {
            int int_i = rand.nextInt(16);
            int int_j = rand.nextInt(16);
            int statut = 0;
            for (int i=0; i<12;i=i+2)
            {
                statut = 0;
                if(int_i != centre.get(i) || int_j != centre.get(i+1))
                {
                    statut = 1;
                }

            }
            if (statut == 1)
            {
                this.posRobot[compteurRobotspos][0] = int_i;
                this.posRobot[compteurRobotspos][1] = int_j;
                compteurRobotspos++;
            }
        }

        //positions jetons initiales

        int compteurjetonspos = 0;
        this.goalsToDo = new int[8][2];
        while (compteurjetonspos < 8)
        {
            int int_i = rand.nextInt(16);
            int int_j = rand.nextInt(16);
            int statut = 0;
            for (int i=0; i<12;i=i+2)//vérification de la légalité des coordonnées aléatoirement choisies (=pas au centre)
            {
                statut = 0;
                if(int_i != centre.get(i) || int_j != centre.get(i+1))
                {
                    statut = 1;
                }
            }
            if (statut == 1)
            {
                this.goalsToDo[compteurjetonspos][0]=int_i;
                this.goalsToDo[compteurjetonspos][1]=int_j;
                compteurjetonspos++;
            }
        }

        //position jeton objectif
        this.active_goal = 0;
        // valeur à changer par l'utilisateur avec un setter.
    }

    public int[][] getBoard()
    {
        return this.board;
    }

    public int[][] getPosRobot()
    {
        return this.posRobot;
    }

    public int getActiveGoal()
    {
        return this.active_goal;
    }

    public int[][] getGoalsToDo()
    {
        return this.goalsToDo;
    }
}
