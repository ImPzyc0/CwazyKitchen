import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Pizzaoven extends Station{
    public Pizzaoven(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.PIZZASIZE, Constants.PIZZASIZE), Constants.PIZZACOLOR  , true);
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
        return Constants.PIZZASHORT;
    }

    @Override
    public void cooked(int pos) {

    }

    @Override
    public void cold(int pos) {

    }

    @Override
    protected int getCooktime() {
        return Constants.PIZZACOOKTIME;
    }

    @Override
    protected int getColdtime() {
        return Constants.PIZZACOLDTIME;
    }
}
