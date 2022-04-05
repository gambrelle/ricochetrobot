package solvers;

import game.*;

public class PrecomputedMap 
{   
    public State state; 
    public int[][] map;
    

    public PrecomputedMap(State state)
    {
        this.state = state;
        this.map = new int[16][16];
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                this.map[i][j] = -1;
        map[7][7] = -2;
        map[7][8] = -2;
        map[8][7] = -2;
        map[8][8] = -2;
        map[this.state.Get_Goal()[this.state.getActiveGoal()][0]][this.state.Get_Goal()[this.state.getActiveGoal()][1]] = 0;

        int level = 0;
        while (!(this.isComputed()))
        {
            for (int i = 0; i < 16; i ++)
                for (int j = 0; j < 16; j++)
                    if (this.map[i][j] == level)
                    {
                        this.searchRight(i, j, level + 1);
                        this.searchLeft(i, j, level + 1);
                        this.searchUp(i, j, level + 1);
                        this.searchDown(i, j, level + 1);
                    }
            level ++;
        }
    }

    //Affiche la map sans le milieu
    public void printMap()
    {
        for (int i = 0; i < this.map.length; i++)
        {
            for (int j = 0; j < this.map[i].length; j++)
                {
                    if (this.map[j][i] == -2)
                        System.out.print("  ");
                    else
                        System.out.print(this.map[j][i] +" ");
                }
                System.out.print("\n");
    }

    }

    //Accesseurs
    public int[][] getMap()
    {
        return this.map;
    }

    //Vérifie si la Map contient encore des -1 (des cases sans accès)
    public boolean isComputed()
    {
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                if (this.map[i][j] == -1)
                    return false;
        return true;
    }

    //Remplis la Map vers la droite jusqu'a un obstacle.
    public void searchRight(int positionX, int positionY, int level)
    {
        for (int i = positionX; i<16; i++)
        {
            if (this.map[i][positionY] == -1 && i != positionX)
                this.map[i][positionY] = level;
            if(this.state.Get_Board()[i][positionY] ==  12 || this.state.Get_Board()[i][positionY] == 21 || this.state.Get_Board()[i][positionY] == 22)
            {
                i = 16;
                continue;
            }
        }
    }
    //Remplis la Map vers la droite jusqu'a un obstacle.
    public void searchLeft(int positionX, int positionY, int level)
    {
        for (int i = positionX; i>=0; i--)
        {
            if (this.map[i][positionY] == -1 && i != positionX)
                this.map[i][positionY] = level;
            if(this.state.Get_Board()[i][positionY] == 10 || this.state.Get_Board()[i][positionY] == 20 || this.state.Get_Board()[i][positionY] == 23)
            {
                i = 0;
                continue;
            } 
        }
    }
    //Remplis la Map vers la droite jusqu'a un obstacle.
    public void searchDown(int positionX, int positionY, int level)
    {
        for (int i = positionY; i<16; i++)
        {
            if (this.map[positionX][i] == -1 && i != positionY)
                this.map[positionX][i] = level;
            if(this.state.Get_Board()[positionX][i] == 13 || this.state.Get_Board()[positionX][i] == 22 || this.state.Get_Board()[positionX][i] == 23)
            {
                i = 16;
                continue;
            }
        }
    }
    //Remplis la Map vers la droite jusqu'a un obstacle.
    public void searchUp(int positionX, int positionY, int level)
    {
        for (int i = positionY; i>=0; i--)
        {
            if (this.map[positionX][i] == -1 && i != positionY)
                this.map[positionX][i] = level;
            if(this.state.Get_Board()[positionX][i] == 11 || this.state.Get_Board()[positionX][i] == 20 || this.state.Get_Board()[positionX][i] == 21)
            {
                i = 0;
                continue;
            } 
        }
    } 

}
