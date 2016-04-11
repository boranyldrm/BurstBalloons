package BurstBalloons;
/**
 * Created by Boran1 on 20.3.2016.
 * main method part for MyBalloonsPanel
 */
import java.awt.*;
import javax.swing.*;

public class BalloonPlay extends JFrame {

    public BalloonPlay() {
        this.setTitle("Balloons");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(new MyBalloonsPanel());
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BalloonPlay();
    }
}