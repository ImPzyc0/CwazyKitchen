import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Fanta extends Drink{
    public Fanta(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.FANTASIZE, Constants.FANTASIZE), Constants.FANTACOLOR, true);
    }


}
