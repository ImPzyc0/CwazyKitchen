import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Fry extends Station{
    public Fry(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.FRY1SIZE, Constants.FRY1SIZE), Constants.FRY1COLOR, true);
    }

    @Override
    public void leftclick(Player player) {

    }

    @Override
    public void rightclick(Player player) {

    }

    @Override
    public void throwaway(Player player) {

    }

    @Override
    public void cold(Player player) {

    }

    @Override
    public String getInteractionName() {
        return Constants.GRILLSHORT;
    }
}
