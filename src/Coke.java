import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Coke extends Drink{
    public Coke(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.COKESIZE, Constants.COKESIZE), Constants.COKECOLOR, true);
    }

}
