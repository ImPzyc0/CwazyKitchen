import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Customers extends Station{
    public Customers(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.CUSTOMSIZE, Constants.CUSTOMSIZE), Constants.CUSTOMCOLOR, true);
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
        return Constants.CUSTOMSHORT;
    }

    @Override
    public void cooked(int pos) {

    }

    @Override
    public void cold(int pos) {

    }

    @Override
    protected int getCooktime() {
        return 0;
    }

    @Override
    protected int getColdtime() {
        return 0;
    }
}
