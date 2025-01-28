import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public abstract class Station extends RectangleColoredHitboxSprite {


    protected enum State{

        COOKING,
        DONE,
        COLD;

    }


    public Station(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, util, hitboxSize, color, fill);
    } // A Singular station, their states


    private long timeForPreperation;
    private long timeUntillCold;

    //These are only for the interactions sent by the the server.
    //When a Player interacts with the stations, the data is sent to the server, which checks it,
    //Only then will these methods be called.
    public abstract void leftclick(Player player);
    public abstract void rightclick(Player player);
    public abstract void throwaway(Player player);
    public abstract void cold(Player player);
    //For example: GRL for Grill
    public abstract String getInteractionName();
}
