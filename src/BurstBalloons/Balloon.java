package BurstBalloons;
/**
 * Created by Boran1 on 20.3.2016.
 * Balloon class for using in the MyBalloonsPanel
 * It is sub class of circle
 */
import java.awt.*;
import BurstBalloons.shapes.Circle;
import BurstBalloons.shapes.Drawable;

public class Balloon extends Circle implements Drawable {

	//properties
    static final int DEFAULT_SIZE = 25;
    final int SIZE_INCREMENT = 1;
    int maxSize = (int) (Math.random() * (125 - 75)) + 75;

	//constructor
    public Balloon(int x, int y) {

        super(DEFAULT_SIZE);
        this.setLocation(x, y);
    }

    @Override
    public void draw(Graphics g) {
        int radius = this.getRadius();
        g.drawOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
    }

    //grows the balloons
    public boolean grow() {
        this.setRadius(this.getRadius() + SIZE_INCREMENT);
        if (this.getRadius() > maxSize) {
            this.burst();
        }
        return this.getRadius() != 0;
    }

    //bursts the balloons
    public void burst() {
        this.setRadius(0);
        this.setSelected(true);
    }
}
