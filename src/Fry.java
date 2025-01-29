import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Fry extends Station{
    private final int number;

    public Fry(Vector2D position, GUtility util, int number) {
        super(position, util, new Vector2D(Constants.FRYSIZE, Constants.FRYSIZE), Constants.FRYCOLOR, true);
        this.number = number;
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
        return Constants.FRYSHORT +String.valueOf(number);
    }
}
