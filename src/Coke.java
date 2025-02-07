import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Coke extends Drink{
    public Coke(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.COKESIZE, Constants.COKESIZE), Constants.COKECOLOR, true);
    }

    @Override
    public String getInteractionName() {
        return Constants.COKESHORT;
    }

    @Override
    public void draw() {
        super.draw();

        util.getPanel().text(this.position.getX()- hitboxSize.getX() /2, this.position.getY(),getInteractionName(), new Font("", 0, (int) (hitboxSize.getX() /4)), Color.WHITE, null);

    }

    @Override
    public void cooked(int pos) {

    }

    @Override
    public void cold(int pos) {

    }
}
