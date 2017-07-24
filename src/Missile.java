/**
 * Created by Paul on 7/23/2017.
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 300;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {

        loadImage("missile.png");
        getImageDimensions();
    }

    public void move() {

        x += MISSILE_SPEED;

        if(x > BOARD_WIDTH) {
            vis = false;
        }
    }
}
