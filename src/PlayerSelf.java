import com.daniel.GSprite.Sprites.HitboxSprites.CollideEventListener;
import com.daniel.GSprite.Sprites.HitboxSprites.HitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerSelf extends Player { //You yourself, movement inputs, sending them to the server etc.

    private final List<Station> stationsCurrentlyIn = new ArrayList<Station>();

    private Vector2D updatedPos;

    public PlayerSelf(Vector2D position, GUtility util, Vector2D hitboxSize, String path, int id, String name) {
        super(position, util, hitboxSize, path, id, name);

        updatedPos = position;

        this.setListener(new CollideEventListener() {
            @Override
            public void onHitboxEnter(HitboxSprite hitboxSprite) {
                if(hitboxSprite instanceof Station){
                    stationsCurrentlyIn.add((Station) hitboxSprite);
                }
            }

            @Override
            public void onHitboxStay(HitboxSprite hitboxSprite) {

            }

            @Override
            public void onHitboxExit(HitboxSprite hitboxSprite) {
                if(hitboxSprite instanceof Station){
                    stationsCurrentlyIn.remove((Station) hitboxSprite);
                }
            }
        });
    }

    public void updateMovement(boolean w, boolean a, boolean s, boolean d, Client client) {
        int startx = (int) updatedPos.getX();
        int starty = (int) updatedPos.getY();

        double x = 0;
        double y = 0;
        if (w) y = Constants.MOVEMENTSPEED;
        if (s) y = -Constants.MOVEMENTSPEED;
        if (a) x = -Constants.MOVEMENTSPEED;
        if (d) x = Constants.MOVEMENTSPEED;
        updatedPos.setX(updatedPos.getX()+x);
        updatedPos.setY(updatedPos.getY()+y);

        //Check Bounds

        if (updatedPos.getX() < Constants.LEFTBORDER) {
            updatedPos.setX(Constants.LEFTBORDER);
        }
        if (updatedPos.getX() > Constants.RIGHTBORDER) {
            updatedPos.setX(Constants.RIGHTBORDER);
        }
        if (updatedPos.getY() > Constants.TOPBORDER) {
            updatedPos.setY(Constants.TOPBORDER);
        }
        if (updatedPos.getY() < Constants.BOTTOMBORDER) {
            updatedPos.setY(Constants.BOTTOMBORDER);
        }
        if(startx != (int) updatedPos.getX() || starty != (int) updatedPos.getY()){
            sendMove(client);
        }

        updateTrayPosition();

    }

    public void sendMove(Client client){
        KitchenSend.MOVE.send(client, (int) updatedPos.getX(), (int) updatedPos.getY());
    }

    public List<Station> getStationsCurrentlyIn() {
        return stationsCurrentlyIn;
    }
}
