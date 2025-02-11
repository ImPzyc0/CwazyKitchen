import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Tray extends Station {
    public Tray(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.TRAYSIZE, Constants.TRAYSIZE), Constants.TRAYCOLOR, true, Constants.TRAYSHORT);
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
}
