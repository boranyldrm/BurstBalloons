package BurstBalloons.shapes;

/**
 * Created by Boran1 on 21.3.2016.
 * It provides basic circle properties
 * It is subclass of Shape
 */

public class Circle extends Shape implements Selectable {

    //properties
    private int radius;
    boolean selected;

    //constructor
    public Circle(int pRadius) {
        this.radius = pRadius;
    }

    @Override
    public double getArea() {
        return Math.pow(this.radius, 2.0) * Math.PI;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public Shape contains(int x, int y) {
        int deltaY2;
        int deltaX2 = (x - this.getX()) * (x - this.getX());
        if (deltaX2 + (deltaY2 = (y - this.getY()) * (y - this.getY())) <= this.radius * this.radius) {
            return this;
        }
        return null;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
