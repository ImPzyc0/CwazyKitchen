import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Tray extends Station {

    //Getting/removing a tray simply
    public Tray(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.TRAYSIZE, Constants.TRAYSIZE), Constants.TRAYCOLOR, true, Constants.TRAYSHORT);
    }

    //Give player a tray
    @Override
    public void leftclick(Player player) {
        player.removeTray();
    }

    @Override
    public void rightclick(Player player) {
        player.giveTray();
    }

    @Override
    public void throwaway(Player player) {
        player.removeTray();
    }
}
