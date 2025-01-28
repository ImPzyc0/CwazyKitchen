import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Sprite extends Drink{
    public Sprite(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.SPRITESIZE, Constants.SPRITESIZE), Constants.SPRITECOLOR, true);
    }


}
