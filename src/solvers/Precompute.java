package solvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import game.*;
import gamegui.*;

public class Precompute{
    private static State etat;
    private final int[][] mapPrecomputed;
    private static int jeton_objectif;
    private int compteurCasesPleines;


    public Precompute(State etat, int jeton_objectif) throws IOException, InterruptedException{
        
        this.mapPrecomputed = new int[16][16];
        this.compteurCasesPleines = 0;
        this.etat = etat;
        this.jeton_objectif =jeton_objectif;
        int limite = 16*16 - 7;
        int niveau = 0;
        for (int l = 0;l<16;l++){
            for(int r = 0; r <16;r++){
                this.mapPrecomputed[r][l]=0;
            }
        }
        System.out.println("test 1");
        int posToken[] =this.etat.getGoalsToDo()[this.etat.getActiveGoal()];
        this.mapPrecomputed[posToken[0]][posToken[1]]=-1;
        System.out.println("test 2");
        while (niveau <= 8){
                System.out.println("niveau "+niveau);
                for (int l = 0;l<16;l++){
                    for(int r = 0; r <16;r++){
                        if (this.mapPrecomputed[l][r]==(niveau-1)){
                            ArrayList<Move> cache = this.etat.getMoveToken(jeton_objectif);
                            for (Move c : cache){
                                if(c.getPosXF()!=c.getPosXI()){
                                    //deplacement latéral
                                    if(c.getPosXF()>c.getPosXI()){
                                        //déplacement vers la droite
                                        for(int j= 1;j<(c.getPosXF()-c.getPosXI());j++){
                                            if (this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]==0){
                                                this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]=niveau;
                                                compteurCasesPleines++;
                                            };
                                        }
                                    }else{
                                        //déplacement vers la gauche
                                        for(int j= -1;j>(c.getPosXF()-c.getPosXI());j--){
                                            if (this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]==0){
                                                this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]=niveau;
                                                compteurCasesPleines++;
                                            };
                                        }
                                    }
                                }else{
                                    //deplacement vertical
                                    if(c.getPosYF()>c.getPosYI()){
                                        //déplacement vers le bas
                                        for(int j= 1;j<(c.getPosYF()-c.getPosYI());j++){
                                            if(this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]==0){
                                                this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]=niveau;
                                                compteurCasesPleines++;
                                            }
                                        }
                                    }else{
                                        //déplacement vers le haut
                                        for(int j= -1;j>(c.getPosYF()-c.getPosYI());j--){
                                            if(this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]==0){
                                                this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]=niveau;
                                                compteurCasesPleines++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                niveau++; 
        }

        

    }

    //getter
    public int[][] getMapPrecomputed(){
        return this.mapPrecomputed;
    }
}