package solvers;

import java.io.IOException;
import java.util.ArrayList;

import game.*;
import gamegui.*;

public class Precompute{
    private static State etat;
    private final int[][] mapPrecomputed;
    private static int jeton_objectif;
    private int compteurCasesPleines;


    public Precompute(State etat, int jeton_objectif){
        
        this.mapPrecomputed = new int[16][16];
        this.compteurCasesPleines = 0;
        this.etat = etat;
        this.jeton_objectif =jeton_objectif;
        int limite = 16*16 - 5;
        int niveau = 0;
        for (int l = 0;l<16;l++){
            for(int r = 0; r <16;r++){
                this.mapPrecomputed[r][l]=0;
            }
        }
        int posToken[] =this.etat.getGoalsToDo()[this.etat.getActiveGoal()];
        this.mapPrecomputed[posToken[0]][posToken[1]]=-1;
        while (compteurCasesPleines <= limite){
            if (niveau == 0){
                ArrayList<Move> cache = this.etat.getMoveToken(jeton_objectif);
                for (Move c : cache){
                    if(c.getPosXF()!=c.getPosXI()){
                        //deplacement latéral
                        if(c.getPosXF()>c.getPosXI()){
                            //déplacement vers la droite
                            for(int j= 1;j<(c.getPosXF()-c.getPosXI());j++){
                                this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]=1;
                            }
                        }else{
                            //déplacement vers la gauche
                            for(int j= -1;j>(c.getPosXF()-c.getPosXI());j--){
                                this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]=1;
                            }
                        }
                    }else{
                        //deplacement vertical
                        if(c.getPosYF()>c.getPosYI()){
                            //déplacement vers le bas
                            for(int j= 1;j<(c.getPosYF()-c.getPosYI());j++){
                                this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]=1;
                            }
                        }else{
                            //déplacement vers le haut
                            for(int j= -1;j>(c.getPosYF()-c.getPosYI());j--){
                                this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]=1;
                            }
                        }
                    }
                }
            }else{
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
                                            };
                                        }
                                    }else{
                                        //déplacement vers la gauche
                                        for(int j= -1;j>(c.getPosXF()-c.getPosXI());j--){
                                            if (this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]==0){
                                                this.mapPrecomputed[c.getPosXI()+j][c.getPosYI()]=niveau;
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
                                            }
                                        }
                                    }else{
                                        //déplacement vers le haut
                                        for(int j= -1;j>(c.getPosYF()-c.getPosYI());j--){
                                            if(this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]==0){
                                                this.mapPrecomputed[c.getPosXI()][c.getPosYI()+j]=niveau;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                   }
               } 
            }
        }

        

    }

    //getter
    public int[][] getMapPrecomputed(){
        return this.mapPrecomputed;
    }
}