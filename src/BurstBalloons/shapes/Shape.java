package BurstBalloons.shapes;

/**
 * Created by Boran1 on 21.3.2016.
 * Abstract shape class
 * It is super class of circle
 */


public abstract class Shape implements Locatable{
    int x;
    int y;

    public String toString() {
        return "[" + this.getX() + "," + this.getY() + "]";
    }

    public abstract double getArea();

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}