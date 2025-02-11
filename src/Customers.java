import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Customers extends Station {
    public Customers(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.CUSTOMSIZE, Constants.CUSTOMSIZE), Constants.CUSTOMCOLOR, true, Constants.CUSTOMSHORT);
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
