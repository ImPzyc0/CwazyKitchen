import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Grill extends Station{
    public Grill(Vector2D position, GPanel panel, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, panel, hitboxSize, color, fill);
    }

    public Grill(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, util, hitboxSize, color, fill);
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
