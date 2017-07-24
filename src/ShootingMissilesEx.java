import oracle.jrockit.jfr.JFR;

import javax.swing.*;

/**
 * Created by Paul on 7/23/2017.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ShootingMissilesEx extends JFrame {

    public ShootingMissilesEx() {
        initUI();
    }

    private void initUI() {
        add(new ShootingMissilesBoard());

        setSize(400, 300);
        setResizable(false);

        setTitle("Shooting missiles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                ShootingMissilesEx ex = new ShootingMissilesEx();
                ex.setVisible(true);
            }
        });
    }
}
