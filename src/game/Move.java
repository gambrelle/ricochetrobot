package game;

public class Move
{   
    private int robotcolor;
    private int posx_i;
    private int posy_i;
    private int posx_f;
    private int posy_f;

    public Move(int rc, int xi, int yi, int xf, int yf)
    {
        this.robotcolor = rc;
        this.posx_i = xi;
        this.posy_i = yi;
        this.posx_f = xf;
        this.posy_f = yf;
    }
    // Accesseurs
    public int getRobotColor()
    {
        return this.robotcolor;
    }
    public int getPosXI()
    {
        return this.posx_i;
    }
    public int getPosXF()
    {
        return this.posx_f;
    }
    public int getPosYI()
    {
        return this.posy_i;
    }
    public int getPosYF()
    {
        return this.posy_f;
    }

    // affiche le mouvement dans la bonne couleur
    @Override
    public String toString()
    {
        if (this.robotcolor == 0)
            return ColorTerminal.GREEN + "(" + this.posx_i + ", " + this.posy_i + ") -> (" + this.posx_f + ", " + this.posy_f + ")" + ColorTerminal.RESET;
        if (this.robotcolor == 1)
            return ColorTerminal.RED + "(" + this.posx_i + ", " + this.posy_i + ") -> (" + this.posx_f + ", " + this.posy_f + ")" + ColorTerminal.RESET;
        if (this.robotcolor == 2)
            return ColorTerminal.YELLOW + "(" + this.posx_i + ", " + this.posy_i + ") -> (" + this.posx_f + ", " + this.posy_f + ")" + ColorTerminal.RESET;
        return ColorTerminal.BLUE + "(" + this.posx_i + ", " + this.posy_i + ") -> (" + this.posx_f + ", " + this.posy_f + ")" + ColorTerminal.RESET;
    }
    
    //retourne si deux mouvement sont égaux
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Move))
            return false;
        Move m = (Move) obj;
        if (m == null)
            return false;
        return this.getPosXI() == m.getPosXI() && this.getPosXF() == m.getPosXF() && this.getPosYI() == m.getPosYI() && this.getPosYF() == m.getPosYF();
    }
}