package game;
import gamegui.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.IOException;

public class RandomBoardGeneration 
{
    protected int[][] board;
    protected int[][] posRobot;//[xrobot1, yrobot1, xrobot2, yrobot2,..] positions des robots (4 robots donc 8 entiers (coordonnées x, y))
    protected int active_goal; //numéro du jeton "objectif" entre 0 et 3 (4 valeurs possibles car 4 jetons)
    protected int[] goalsToDo;//[xjeton1,yjeton1,xjeton2,yjeton2] position des jetons (4 jetons donc 8 entiers (coordonnées x, y))
    public RandomBoardGeneration() throws IOException, InterruptedException
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
        this.board[7][7] = 20;
        this.board[7][8] = 23;
        this.board[8][8] = 22;
        this.board[8][7] = 21;
        this.board[6][7] = 12;
        this.board[6][8] = 12;
        this.board[7][9] = 11;
        this.board[8][9] = 11;
        this.board[9][8] = 10;
        this.board[9][7] = 10;
        this.board[8][6] = 13;
        this.board[7][6] = 13;

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
        int compteurSimpleHaut = 0;
        int compteurSimpleBas = 0;
        int compteurSimpleDroit = 0;
        int compteurSimpleGauche = 0;
        //System.out.println("le monde");
        while (compteurObstaclesSimples < 8){
            //bordure exterieur haute
            while (compteurSimpleHaut <2)
            {
                int int_i = rand.nextInt(11)+2;//entre 2 et 13 inclus
                int int_j = 0;
                if (this.board[int_i][int_j] == 0)
                {   
                    if (compteurSimpleHaut==1 && this.board[int_i-2][int_j]==0 && this.board[int_i-1][int_j]==0 && this.board[int_i+2][int_j]==0 && this.board[int_i+1][int_j]==0){
                        this.board[int_i][int_j] = 10;
                        this.board[int_i-1][int_j]=12;
                        compteurSimpleHaut++;
                        compteurObstaclesSimples++;   
                    }else{
                        this.board[int_i][int_j] = 10;
                        this.board[int_i-1][int_j]=12;
                        compteurSimpleHaut++;
                        compteurObstaclesSimples++;
                    }
                }
            }
            //bordure exterieur basse
            while (compteurSimpleBas<2)
            {
                int int_i = rand.nextInt(11)+2;//entre 2 et 13 inclus
                int int_j = 15; 
                //on place aléatoirement un obstacle vertical sur la paroi/bordure basse
                if (this.board[int_i][int_j] == 0)
                {
                    if (compteurSimpleBas==1 && this.board[int_i-2][int_j]==0 && this.board[int_i-1][int_j]==0 && this.board[int_i+2][int_j]==0 && this.board[int_i+1][int_j]==0){
                        this.board[int_i][int_j] = 10;
                        this.board[int_i-1][int_j]=12;
                        compteurObstaclesSimples++;
                        compteurSimpleBas++;
                    }else{
                        this.board[int_i][int_j] = 10;
                        this.board[int_i-1][int_j]=12;
                        compteurObstaclesSimples++;
                        compteurSimpleBas++;
                    }
                }
            }
            //bordure exterieur gauche
            while (compteurSimpleGauche<2)
            {
                int int_i = 0;
                int int_j = rand.nextInt(11)+2;//entre 2 et 13 inclus
                if (this.board[int_i][int_j] == 0)
                {   
                    if (compteurSimpleGauche==1 && this.board[int_i][int_j-2]==0 && this.board[int_i][int_j-1]==0 && this.board[int_i][int_j+2]==0 && this.board[int_i][int_j+1]==0){
                        this.board[int_i][int_j] = 11;
                        this.board[int_i][int_j-1]=13;
                        compteurObstaclesSimples++;  
                        compteurSimpleGauche++;
                    }else{
                        this.board[int_i][int_j] = 11;
                        this.board[int_i][int_j-1]=13;
                        compteurObstaclesSimples++;  
                        compteurSimpleGauche++;
                    }                
                }
            }
            //bordure exterieur droite
            while (compteurSimpleDroit<2)
            {
                int int_i = 15;
                int int_j = rand.nextInt(11)+2;//entre 2 et 13 inclus
                if (this.board[int_i][int_j] == 0)
                {   
                    if (compteurSimpleDroit==1 && this.board[int_i][int_j-2]==0 && this.board[int_i][int_j-1]==0 && this.board[int_i][int_j+2]==0 && this.board[int_i][int_j+1]==0){
                        this.board[int_i][int_j] = 11;
                        this.board[int_i][int_j-1]=13;
                        compteurObstaclesSimples++;  
                        compteurSimpleDroit++;
                    }else{
                        this.board[int_i][int_j] = 11;
                        this.board[int_i][int_j-1]=13;
                        compteurObstaclesSimples++;  
                        compteurSimpleDroit++;
                    }                  
                }
            }
            
        } 
        //on trouve forcément 8 emplacements pour les obstacles simples.

        int[] line = new int[16];
        int[] row = new int[16];
        for (int i = 0; i<16;i++){line[i] = 0;row[i]=0;}
        //System.out.println("le monde oui");
        while (compteurObstaclesDoubles < 16){
            int int_i = rand.nextInt(14)+1;//entre 1 et 14
            int int_j = rand.nextInt(14)+1;//entre 1 et 14
            //System.out.println("oui");
            System.out.println("("+int_i + " : " + int_j+")");
            boolean feu_vert = true;
            int obstacle_potentiel = 0;
            if (this.board[int_i][int_j] == 0)
            {   
                
                obstacle_potentiel = obstaclesDoubles.get(rand.nextInt(obstaclesDoubles.size()));                
                if (line[int_i]>2){feu_vert=false;}
                if (row[int_j]>2){feu_vert=false;}                
                //System.out.println("hiver");
                if (feu_vert){
                    for (int k = -1; k < 2; k++)
                    {
                        for (int l = -1; l < 2; l++)
                        {   
                            //System.out.println("double boucle 1");
                            int position_test = this.board[int_i + k][int_j + l];
                            if (!obstaclesDoubles.contains(position_test) )
                            {
                                
                            }
                            else
                            {   
                                System.out.println("obstacle double");
                                feu_vert = false;
                            }
                        }
                    }
                    switch(obstacle_potentiel){
                        case 20: // cas du coin haut gauche
                            System.out.println("cas 20");
                            //System.out.println("("+int_i + " : " + int_j+")");
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j])){ //gauche
                                feu_vert=false;
                                System.out.println("obstacle simple gauche");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j-1])){ //haut
                                feu_vert=false;
                                System.out.println("obstacle simple haut");
                                break;
                            }

                            //axe bord haut cases de droite
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j-1])){ //haut diagonale haut droite
                                feu_vert=false;
                                System.out.println("haut diagonale haut droite");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j])){ //haut diagonale bas droite
                                feu_vert=false;
                                System.out.println("haut diagonale bas droite");
                                break;
                            }

                            //axe bord gauche cases du bas
                            if(obstaclesSimples.contains(this.board[int_i][int_j+1])){ //gauche diagonale bas droite
                                feu_vert=false;
                                System.out.println("gauche diagonale bas droite");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j+1])){ //gauche diagonale bas gauche
                                feu_vert=false;
                                System.out.println("gauche diagonale bas gauche");
                                break;
                            }
                            break;


                        case 21: // cas du coin haut droite
                            System.out.println("cas 21");
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j])){ //droite
                                feu_vert=false;
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j-1])){ //haut
                                feu_vert=false;
                                break;
                            }

                            //axe bords haut cases de gauche
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j-1])){ //haut gauche diagonale haut droite
                                feu_vert=false;
                                System.out.println("huhuhu");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j])){ //haut gauche diagonale haut gauche
                                feu_vert=false;
                                System.out.println("huhuhu");
                                break;
                            }

                            //axe bords droit cases du bas
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j+1])){ //droit bas diagonale droite bas
                                feu_vert=false;
                                System.out.println("huhuhu");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j+1])){ //droit bas diagonale gauche bas
                                feu_vert=false;
                                System.out.println("huhuhu");
                                break;
                            }
                            break;


                        case 22: // cas du coin bas droite
                            System.out.println("cas 22");
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j])){ //droite
                                feu_vert=false;
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j+1])){ //bas
                                feu_vert=false;
                                break;
                            }


                            //axe bords bas cases de gauche
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j])){ // bas gauche diagonale haute
                                feu_vert=false;
                                System.out.println("hihihi");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j+1])){ // bas gauche diagonale basse
                                feu_vert=false;
                                System.out.println("hihihi");
                                break;
                            }


                            //axe bords droite case du haut
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j-1])){ // droite haut diagonale droite
                                feu_vert=false;
                                System.out.println("hihihi");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j-1])){ // droite haut diagonale gauche
                                feu_vert=false;
                                System.out.println("hihihi");
                                break;
                            }
                            break;


                        case 23: // cas du coin bas gauche
                            System.out.println("cas 23");
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j])){ //gauche
                                feu_vert=false;
                                //System.out.println("hahaha");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i][int_j+1])){ //bas
                                feu_vert=false;
                                //System.out.println("hahaha");
                                break;
                            }

                            //axe du bord bas cases de droites
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j])){ //bas droite diagonale haute
                                feu_vert=false;
                                System.out.println("hahaha");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i+1][int_j+1])){ //bas droite diagonale basse
                                feu_vert=false;
                                System.out.println("hahaha");
                                break;
                            }

                            //axe de gauche cases du haut
                            if(obstaclesSimples.contains(this.board[int_i][int_j-1])){ //gauche haut diagonale droite
                                feu_vert=false;
                                System.out.println("hahaha");
                                break;
                            }
                            if(obstaclesSimples.contains(this.board[int_i-1][int_j-1])){ //gauche haut diagonale gauche
                                feu_vert=false;
                                System.out.println("hahaha");
                                break;
                            }
                            break;
                        default:
                            System.out.print("erreur, sortie de switch avec le cas ");
                            System.out.println(obstacle_potentiel);
                            break;
                            
                        }
                    
            
                    
                    
                    
                                    
                }
                if (feu_vert){
                    this.board[int_i][int_j] = obstacle_potentiel;
                        switch(obstacle_potentiel){
                            case 20: // cas du coin haut gauche
                                this.board[int_i-1][int_j]=12; //gauche                            
                                this.board[int_i][int_j-1]=13; //haut
                                break;
                            case 21: // cas du coin haut droit
                                this.board[int_i+1][int_j]=10; //droit                            
                                this.board[int_i][int_j-1]=13; //haut
                                break;
                            case 22: // cas du coin bas droit
                                this.board[int_i+1][int_j] = 10; //droit                           
                                this.board[int_i][int_j+1]= 11; //bas
                                break;
                            case 23: // cas du coin bas gauche
                                this.board[int_i-1][int_j]= 12; //gauche                            
                                this.board[int_i][int_j+1]= 11; //bas
                                break;
                        }
                    compteurObstaclesDoubles++;
                    line[int_i]++;
                    row[int_j]++;
                    System.out.print("allow  ");
                    System.out.println(compteurObstaclesDoubles);
                }else{
                    System.out.println("abort");
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
        this.goalsToDo = new int[8];
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
                this.goalsToDo[compteurjetonspos]=int_i;
                compteurjetonspos++;
                this.goalsToDo[compteurjetonspos]=int_j;
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

    public int[] getGoalsToDo()
    {
        return this.goalsToDo;
    }
}