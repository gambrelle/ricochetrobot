public class Robot extends Obstacle
{
    protected String color;

    public Robot(String color)
    {
        super(true, true, true, true);
        this.color = color;
    }
}
