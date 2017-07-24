import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Paul on 7/23/2017.
 */
public class ShootingMisslesCraft extends Sprite {

    private int dx;
    private int dy;
    private ArrayList missiles;

    public ShootingMisslesCraft(int x, int y) {

        super(x, y);
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList();
        loadImage("craft.png");
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SPACE) {
            fire();
        }

        if(key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if(key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if(key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if(key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2 ));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if(key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if(key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if(key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
