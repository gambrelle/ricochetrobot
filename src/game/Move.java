package game;
import gamegui.*;

public class Move
{   
    private int robotcolor;
    private int posx_i;
    private int posy_i;
    private int posx_f;
    private int posy_f;

    public Move(int rc, int xi, int yi, int xf, int yf)
    {
        this.robotcolor = rc;//0=bleu, 1=rouge,2=vert,3=jaune
        this.posx_i = xi;
        this.posy_i = yi;
        this.posx_f = xf;
        this.posy_f = yf;
    }
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
    @Override
    public String toString() {
        return "Mouvement du robot " + this.robotcolor + " de (" + this.posx_i + ", " + this.posy_i + ") -> (" + this.posx_f + ", " + this.posy_f + ")";
    }
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