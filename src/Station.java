import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public abstract class Station extends RectangleColoredHitboxSprite {

    protected String name;

    public Station(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, String name) {
        super(position, util, hitboxSize, color, fill);
        this.name = name;
    }

    public abstract void leftclick(Player player);
    public abstract void rightclick(Player player);
    public abstract void throwaway(Player player);


    @Override
    public void draw() {
        super.draw();

        util.getPanel().text(this.position.getX()- hitboxSize.getX() /2, this.position.getY()+hitboxSize.getY()/4,name, new Font("", 0, (int) (hitboxSize.getX() /4)), Color.WHITE  , null);

    }

    public String getName() {
        return name;
    }
}
