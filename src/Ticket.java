import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Ticket extends Station{
    public Ticket(Vector2D position, GUtility util, int number) {
        super(position, util, new Vector2D(Constants.TICKET1SIZE, Constants.TICKET1SIZE), Constants.TICKET1COLOR, true);
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
        return Constants.TICKET1SHORT;
    }
}
