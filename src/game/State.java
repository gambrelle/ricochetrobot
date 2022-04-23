package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class State
{
    int[][] board, posRobot, goalsToDo, initialPosRobot;
    protected int active_goal;

    public State() throws IOException, InterruptedException
    {
    	RandomBoardGeneration generationAleatoire = new RandomBoardGeneration();
		this.board =  generationAleatoire.getBoard();
        this.posRobot = generationAleatoire.getPosRobot();
        this.active_goal = generationAleatoire.getActiveGoal();
        this.goalsToDo = generationAleatoire.getGoalsToDo();

        this.initialPosRobot = new int[4][2];

        for (int i = 0; i < this.posRobot.length; i++)
            for (int j = 0; j < this.posRobot[i].length; j ++)
                this.initialPosRobot[i][j] = this.posRobot[i][j];
    }
    public State(int[][] board, int[][] posRobot, int active_goal, int[][] goalsToDo) throws IOException, InterruptedException
    {
        this.board =  board;
        this.posRobot = posRobot;
        this.active_goal = active_goal;
        this.goalsToDo = goalsToDo;

        this.initialPosRobot = new int[4][2];

        for (int i = 0; i < this.posRobot.length; i++)
            for (int j = 0; j < this.posRobot[i].length; j ++)
                this.initialPosRobot[i][j] = this.posRobot[i][j];
    }
    //Produit une nouvelle grille a chaque tour, il faudrai faire un ramdom que une seule fois

    // Remet les robots dans leurs positions initials
    public void resetPosRobot()
    {
        for (int i = 0; i < this.posRobot.length; i++)
        {
            for (int j = 0; j < this.posRobot[i].length; j ++)
                this.posRobot[i][j] = this.initialPosRobot[i][j];
        }
    }
    // retourne le plateau de jeu
    public int[][] Get_Board()
    {
		return this.board;
    }
    // retourne la positions des robots
    public int[][] Get_Robot()
    {
    	return this.posRobot;
    }
    // retourne la positions des objectifs
    public int[][] Get_Goal()
    {
    	return this.goalsToDo ;
    }
    // retourne la positions des objectifs
    public int[][] getAllGoals()
    {
        return this.goalsToDo;
    }
    // retourne l'indice de l'objectif actif
    public int getActiveGoal()
    {
        return this.active_goal;
    }
    // change l'objectif actif
    public void chooseActivegoal(int i)
    {
        this.active_goal = i;
    }

    // affiche l'objectifs actifs avec la bonne couleur
    public String printActiveGoal()
    {
        if (this.getActiveGoal() == 0)
            return ColorTerminal.GREEN + "Position de l'objectif actif : (" + this.Get_Goal()[this.getActiveGoal()][0] + ", " + this.Get_Goal()[this.getActiveGoal()][1] + ")" + ColorTerminal.RESET;
        if (this.getActiveGoal() == 1)
            return ColorTerminal.RED + "Position de l'objectif actif : (" + this.Get_Goal()[this.getActiveGoal()][0] + ", " + this.Get_Goal()[this.getActiveGoal()][1] + ")" + ColorTerminal.RESET;
        if (this.getActiveGoal() == 2)
            return ColorTerminal.YELLOW + "Position de l'objectif actif : (" + this.Get_Goal()[this.getActiveGoal()][0] + ", " + this.Get_Goal()[this.getActiveGoal()][1] + ")" + ColorTerminal.RESET;
        return ColorTerminal.BLUE + "Position de l'objectif actif : (" + this.Get_Goal()[this.getActiveGoal()][0] + ", " + this.Get_Goal()[this.getActiveGoal()][1] + ")" + ColorTerminal.RESET;
    }

    // affiche le plateau de jeu
    public void printBoard()
    {
        for (int i = 0; i < this.board.length; i++)
        {
            for (int j = 0; j < this.board[i].length; j++)
                {
                    if (this.board[j][i] < 9)
                        System.out.print(" " + this.board[j][i] + " ");
                    else
                        System.out.print(this.board[j][i] +" ");
                }
                System.out.print("\n");
        }
    }

    // renvoie un clone de l'état
    public State getClone() throws IOException, InterruptedException
    {
        int[][] newBoard = new int[16][16];
        int[][] newPosRobot = new int[4][2];

        for (int i = 0; i < this.board.length; i++)
        {
            for (int j = 0; j < this.board[i].length; j++)
            {
                newBoard[i][j] = this.board[i][j];
            }
        }
        for (int i = 0; i < this.posRobot.length; i++)
        {
            for (int j = 0; j < this.posRobot[i].length; j++)
            {
                newPosRobot[i][j] = this.posRobot[i][j];
            }
        }

        State s = new State(newBoard, newPosRobot, this.active_goal, this.goalsToDo);
        return s;
    }

    // Joue le mouvement pris en entree par le robot pris en entree
    public void play(Move move, int robot)
    {
        this.posRobot[robot][0] = move.getPosXF();
        this.posRobot[robot][1] = move.getPosYF();
    }

    // renvoie le mouvement possible a droite pour le robot donne en entree
    public Move getRightMove(int robot)
    {
        // va jusqu'au bordure
        for (int i = this.posRobot[robot][0]; i<16; i++)
        {
            // verifie si un robot bloque
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == i+1 && this.posRobot[k][1] == this.posRobot[robot][1])
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
            }
            // verifie si un mur bloque
            if(this.board[i][this.posRobot[robot][1]] == 12 || this.board[i][this.posRobot[robot][1]] == 21 || this.board[i][this.posRobot[robot][1]] == 22)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 15, this.posRobot[robot][1]);
    }
    // renvoie le mouvement possible a droite pour le robot donne en entree
    public Move getLeftMove(int robot)
    {
        // va jusqu'au bordure
        for (int i = this.posRobot[robot][0]; i>0; i--)
        {
            // verifie si un robot bloque
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == i-1 && this.posRobot[k][1] == this.posRobot[robot][1])
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
            }
            // verifie si un mur bloque
            if(this.board[i][this.posRobot[robot][1]] == 10 || this.board[i][this.posRobot[robot][1]] == 20 || this.board[i][this.posRobot[robot][1]] == 23)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], i, this.posRobot[robot][1]);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], 0, this.posRobot[robot][1]);
    }
    // renvoie le mouvement possible a droite pour le robot donne en entree
    public Move getDownMove(int robot)
    {
        // va jusqu'au bordure
        for (int i = this.posRobot[robot][1]; i<16; i++)
        {
            // verifie si un robot bloque
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == this.posRobot[robot][0] && this.posRobot[k][1] == i+1)
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
            }
            // verifie si un mur bloque
            if(this.board[this.posRobot[robot][0]][i] == 13 || this.board[this.posRobot[robot][0]][i] == 22 || this.board[this.posRobot[robot][0]][i] == 23)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 15);
    }
    // renvoie le mouvement possible a droite pour le robot donne en entree
    public Move getUpMove(int robot)
    {
        // va jusqu'au bordure
        for (int i = this.posRobot[robot][1]; i>0; i--)
        {
            // verifie si un robot bloque
            for (int k = 0; k <= 3; k++)
            {
                if (k != robot && this.posRobot[k][0] == this.posRobot[robot][0] && this.posRobot[k][1] == i-1)
                    return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
            }
            // verifie si un mur bloque
            if(this.board[this.posRobot[robot][0]][i] == 11 || this.board[this.posRobot[robot][0]][i] == 20 || this.board[this.posRobot[robot][0]][i] == 21)
                return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], i);
        }
        return new Move(robot, this.posRobot[robot][0], this.posRobot[robot][1], this.posRobot[robot][0], 0);
    }
    // renvoie tous les mouvement possible pour le robot en argument
    public ArrayList<Move> getMove(int robot)
    {
        ArrayList<Move> allMoves = new ArrayList<>();
        allMoves.add(getUpMove(robot));
        allMoves.add(getRightMove(robot));
        allMoves.add(getDownMove(robot));
        allMoves.add(getLeftMove(robot));
        for (Iterator<Move> it = allMoves.iterator(); it.hasNext(); ) {
            Move move = it.next();
            if (move.getPosXI() == move.getPosXF() && move.getPosYI() == move.getPosYF())
                it.remove();
        }
        return allMoves;
    }

    // renvoie un boolean de si le robot est sur l'objectif
    public int isFinalState()
    {
        if (this.posRobot[this.active_goal][0] == this.goalsToDo[this.active_goal][0] && this.posRobot[this.active_goal][1] == this.goalsToDo[this.active_goal][1])
            return  1;
        else
        	return 0;
    }
    
}