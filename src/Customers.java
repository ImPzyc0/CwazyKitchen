import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Customers extends Station {

    private final GameManager manager;

    public Customers(Vector2D position, GUtility util, GameManager manager) {
        super(position, util, new Vector2D(Constants.CUSTOMSIZE, Constants.CUSTOMSIZE), Constants.CUSTOMCOLOR, true, Constants.CUSTOMSHORT);
        this.manager = manager;
    }

    @Override
    public void leftclick(Player player) {

        KitchenSend.INT.send(manager, Constants.CUSTOMSHORT, "l");

    }

    @Override
    public void rightclick(Player player) {
        KitchenSend.INT.send(manager, Constants.CUSTOMSHORT, "r");

    }

    @Override
    public void throwaway(Player player) {
        KitchenSend.INT.send(manager, Constants.CUSTOMSHORT, "e");

    }

}
