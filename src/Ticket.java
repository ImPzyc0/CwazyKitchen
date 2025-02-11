import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.HitboxType;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class Ticket extends Station {
    private final int number;

    private String ticketValue = null;

    public Ticket(Vector2D position, GUtility util, int number) {
        super(position, util, new Vector2D(Constants.TICKETSIZE, Constants.TICKETSIZE), Constants.TICKETCOLOR, true, Constants.TICKETSHORT+" "+number);
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
    public void draw() {
        super.draw();

        if(ticketValue != null){
            String[] things = ticketValue.split(" ");
            for (int i = 0; i < things.length && i < 4; i++){
                util.getPanel().text(this.position.getX()- hitboxSize.getX() /2, this.position.getY()- (hitboxSize.getY()/6*i),things[i], new Font("", 0, (int) (hitboxSize.getX() /6)), Color.BLACK, null);

            }

            for (int i = 4; i < things.length && i < 8; i++){
                util.getPanel().text(this.position.getX(), this.position.getY()- (hitboxSize.getY()/6*(i-4)),things[i], new Font("", 0, (int) (hitboxSize.getX() /6)), Color.BLACK, null);
            }

        }

    }
}
