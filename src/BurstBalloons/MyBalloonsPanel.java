package BurstBalloons;

/**
 * Created by Boran1 on 20.3.2016.
 * Constructs the panel for BurstBalloon game
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BurstBalloons.shapes.Drawable;
import BurstBalloons.shapes.Shape;
import BurstBalloons.shapes.ShapeContainer;

public class MyBalloonsPanel extends JPanel {

    //properties
    static final int DEFAULT_WIDTH = 800;
    static final int DEFAULT_HEIGHT = 600;
    static final int MAX_ELAPSED_TIME = 250;
    static final int UPDATE_PERIOD = 100;
    static final int INIT_BALLOONS = 25;
    static final int MIN_BALLOONS = 15;
    ShapeContainer balloons;
    Timer timer;
    JLabel pointsLabel = new JLabel();
    int points;
    int elapsedTime;
    MouseListener pin;

	//constructor
    public MyBalloonsPanel() {
        add(this.pointsLabel);
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        pin = new Pin();
        timer = new Timer(UPDATE_PERIOD, new GrowListener());
        initGame();
    }

    //initialize the game
    private void initGame() {
        elapsedTime = 0;
        points = 0;
        pointsLabel.setText("Points: " + this.points);
        balloons = new ShapeContainer();
        addRandomBalloons(INIT_BALLOONS, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addMouseListener(pin);
        timer.start();
    }

    //adding balloons to ShpeContainer
    private void addRandomBalloons(int number, int width, int height) {
        for (int i = 0; i < number; ++i) {
            int x = (int)(Math.random() * (double)width);
            int y = (int)(Math.random() * (double)height);
            Balloon b = new Balloon(x, y);
            balloons.add(b);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape balloon : (Iterable<Shape>) balloons) {
            ((Drawable) (balloon)).draw(g);
        }
    }

    //Listen the action of grow
    private class GrowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Shape balloon : (Iterable<Shape>) balloons) {
                ((Balloon) balloon).grow();
            }

            balloons.removeSelected();

            if (balloons.size() < MIN_BALLOONS)
                addRandomBalloons(1, getWidth(), getHeight());

            repaint();
            ++elapsedTime;

            if (elapsedTime >= MAX_ELAPSED_TIME) {
                timer.stop();
                removeMouseListener(pin);
                int again = JOptionPane.showConfirmDialog(MyBalloonsPanel.this, "Play again? ", "Game over", 0);
                if (again == 0) {
                    initGame();
                }
            }
        }
    }

    //increase points when pressed
    private class Pin extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int burstCount = balloons.selectAllAt(e.getX(), e.getY());
            if (burstCount >= 2) {
                points += burstCount;
                pointsLabel.setText("Points: " + points);
            }
        }
    }

}