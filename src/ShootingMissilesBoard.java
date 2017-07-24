import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Paul on 7/23/2017.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShootingMissilesBoard extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    private ShootingMisslesCraft craft;

    public ShootingMissilesBoard() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        craft = new ShootingMisslesCraft(ICRAFT_X, ICRAFT_Y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(),
                craft.getY(), this);

        ArrayList ms = craft.getMissiles();

        for(Object ml : ms) {
            Missile m = (Missile) ml;
            g2d.drawImage(m.getImage(), m.getX(),
                    m.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updateCraft();

        repaint();
    }

    private void updateMissiles() {

        ArrayList ms = craft.getMissiles();

        for(int i = 0; i < ms.size(); i++) {

            Missile m = (Missile) ms.get(i);

            if(m.isVisible()) {
                m.move();
            }
            else {
                ms.remove(i);
            }
        }
    }

    private void updateCraft() {
        craft.move();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }






























}
