import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Customers extends Station {

    private final GameManager manager;

    public Customers(Vector2D position, GUtility util, GameManager manager) {
        super(position, util, new Vector2D(Constants.CUSTOMSIZE, Constants.CUSTOMSIZE), Constants.CUSTOMCOLOR, true, Constants.CUSTOMSHORT);
        this.manager = manager;
    }

    //Methods useless as the station itself doesn`t ever change

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
