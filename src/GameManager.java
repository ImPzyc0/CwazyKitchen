import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager { //GameLoop, updates, Room, times

    private final int FPS;
    private final GUtility util;

    private final KitchenManager kManager;
    private final PlayerSelf self;
    private final List<Player> players = new List<Player>();

    private final KitchenClient client;

    private boolean w, a, s, d = false;

    public GameManager(int fps, int width, int height, Color backgroundColor) {
        FPS = fps;
        util = new GUtility(width, height);
        util.getPanel().getWindow().setBgColor(backgroundColor);

        kManager = new KitchenManager(this);
        self = new PlayerSelf(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 2), util, new Vector2D(Constants.PLAYERSIZE, Constants.PLAYERSIZE), Constants.PLAYERCOLOR, true, 0, "Self");

        this.client = new KitchenClient(this);

        setKitchen();
        //setRoomScreen();


        gameLoop();


    }

    private void gameLoop() {

        Timer timer = new Timer();

        util.getPanel().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        w = true;
                        break;
                    case 'a':
                        a = true;
                        break;
                    case 's':
                        s = true;
                        break;
                    case 'd':
                        d = true;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        w = false;
                        break;
                    case 'a':
                        a = false;
                        break;
                    case 's':
                        s = false;
                        break;
                    case 'd':
                        d = false;
                        break;
                    default:
                        break;
                }
            }
        });

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //Movement before the listeners to detect new collisions
                //If multiple buttons were pressed they will all be detected during a frame
                self.updateMovement(w, a, s, d);

                util.updateHitboxListeners();

                util.getPanel().clear();
                util.draw();

            }
        }, 0, 1000 / FPS);
    }

    private void setKitchen() { //Setting the scenery, stations etc.

        RectangleColoredHitboxSprite leftWall = new RectangleColoredHitboxSprite(new Vector2D(Constants.WIDTH / 7.5, (double) Constants.HEIGHT / 2), util, new Vector2D((double) Constants.WIDTH / 37.5, Constants.HEIGHT * 1.01), Color.BLACK, true);
        RectangleColoredHitboxSprite rightWall = new RectangleColoredHitboxSprite(new Vector2D((Constants.WIDTH / 7.5) * 6.5, (double) Constants.HEIGHT / 2), util, new Vector2D((double) Constants.WIDTH / 37.5, Constants.HEIGHT * 1.01), Color.BLACK, true);
        RectangleColoredHitboxSprite topWall = new RectangleColoredHitboxSprite(new Vector2D((double) Constants.WIDTH / 2, Constants.HEIGHT - (double) Constants.HEIGHT / 25 / 3), util, new Vector2D((double) (Constants.WIDTH / 3) * 2 + (double) Constants.WIDTH / 15, (double) Constants.HEIGHT / 25), Color.BLACK, true);
        RectangleColoredHitboxSprite bottomWall = new RectangleColoredHitboxSprite(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 25 / 3), util, new Vector2D((double) (Constants.WIDTH / 3) * 2 + (double) Constants.WIDTH / 15, (double) Constants.HEIGHT / 25), Color.BLACK, true);
        leftWall.setActive(false);
        rightWall.setActive(false);
        topWall.setActive(false);
        bottomWall.setActive(false);

    }

    private void setRoomScreen() {


    }

    public void setID(int id){
        self.setID(id);
    }

    public GUtility getUtil() {
        return util;
    }

}
