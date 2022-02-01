public class Obstacle extends Cells
{
    protected boolean obstacleRight;
    protected boolean obstacleLeft;
    protected boolean obstacleUp;
    protected boolean obstacleDown;

    public Obstacle(boolean left, boolean right, boolean up, boolean down)
    {
        this.obstacleRight = right;
        this.obstacleDown = down;
        this.obstacleLeft = left;
        this.obstacleUp = up;
    }

    public boolean isRightObstacle()
    {
        return this.obstacleRight;
    }
    public boolean isDownObstacle()
    {
        return this.obstacleDown;
    }
    public boolean isUpObstacle()
    {
        return this.obstacleUp;
    }
    public boolean isLeftObstacle()
    {
        return this.obstacleLeft;
    }
}
