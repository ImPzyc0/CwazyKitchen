import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class PlayerSelf extends Player { //You yourself, movement inputs, sending them to the server etc.
    public PlayerSelf(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, int id, String name) {
        super(position, util, hitboxSize, color, fill, id, name);
    }

    public void updateMovement(boolean w, boolean a, boolean s, boolean d, Client client) {
        //Würde normalerweise ein '? : ;' benutzen aber darf ich ja nicht (glaube ich) also der hässliche Code
        int startx = (int) this.getPosition().getX();
        int starty = (int) this.getPosition().getY();

        double x = 0;
        double y = 0;
        if (w) y = Constants.MOVEMENTSPEED;
        if (s) y = -Constants.MOVEMENTSPEED;
        if (a) x = -Constants.MOVEMENTSPEED;
        if (d) x = +Constants.MOVEMENTSPEED;
        move(new Vector2D(x, y));

        //Check Bounds

        if (position.getX() < Constants.LEFTBORDER) {
            position.setX(Constants.LEFTBORDER);
        }
        if (position.getX() > Constants.RIGHTBORDER) {
            position.setX(Constants.RIGHTBORDER);
        }
        if (position.getY() > Constants.TOPBORDER) {
            position.setY(Constants.TOPBORDER);
        }
        if (position.getY() < Constants.BOTTOMBORDER) {
            position.setY(Constants.BOTTOMBORDER);
        }
        if(startx != (int) this.getPosition().getX() || starty != (int) this.getPosition().getY()){
            KitchenSend.MOVE.send(client, (int) this.getPosition().getX(), (int) this.getPosition().getY());
        }


    }

    public void setID(int id){this.id = id;}


}
