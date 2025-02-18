import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Customers extends Station {

    //The station to get new tickets

    public Customers(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.CUSTOMSIZE, Constants.CUSTOMSIZE), Constants.CUSTOMCOLOR, true, Constants.CUSTOMSHORT);
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
