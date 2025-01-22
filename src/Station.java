import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public abstract class Station extends RectangleColoredHitboxSprite { // A Singular station, their states
    public Station(Vector2D position, GPanel panel, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, panel, hitboxSize, color, fill);
    }

    public Station(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, util, hitboxSize, color, fill);
    }

    //Abstract methods for the interactions
}
