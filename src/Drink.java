import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Drink extends Station{
    public Drink(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
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
    public String getInteractionName() {
        return null;
    }

    @Override
    public void cooked(int pos) {

    }

    @Override
    public void cold(int pos) {

    }

    @Override
    protected int getCooktime() {
        return Constants.COKECOOKTIME;
    }

    @Override
    protected int getColdtime() {
        return Constants.COKECOLDTIME;
    }
}
