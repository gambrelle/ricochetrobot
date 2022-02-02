package ricochetrobot;

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

}