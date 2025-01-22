import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Player extends RectangleColoredHitboxSprite {//A player as shown in the game, name id etc.

    protected int id;
    private final String name;

    public Player(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, int id, String name) {
        super(position, util, hitboxSize, color, fill);

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


}
