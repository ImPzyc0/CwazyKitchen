import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public abstract class Station extends RectangleColoredHitboxSprite {

    protected class StateWrap{
        private State state;
        private final int numberOfPreviousPatties;

        protected StateWrap(State state, int numberOfPreviousPatties){
            this.state = state;
            this.numberOfPreviousPatties = numberOfPreviousPatties;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public int getNumberOfPreviousPatties() {
            return numberOfPreviousPatties;
        }

    }

    protected enum State{
        EMPTY,
        COOKING,
        DONE,
        COLD;

    }

    public Station(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, util, hitboxSize, color, fill);
    } // A Singular station, their states


    //These are only for the interactions sent by the the server.
    //When a Player interacts with the stations, the data is sent to the server, which checks it,
    //Only then will these methods be called.
    public abstract void leftclick(Player player);
    public abstract void rightclick(Player player);
    public abstract void throwaway(Player player);

    //For example: GRL for Grill
    public abstract String getInteractionName();

    public abstract void cooked(int pos);
    public abstract void cold(int pos);

    public void callWhenCooked(int pos){
        new Thread(() -> {
            try {
                Thread.sleep(getCooktime());
                cooked(pos);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }).start();
    }
    public void callWhenCold(int pos){
        new Thread(() -> {
            try {
                Thread.sleep(getColdtime());
                cold(pos);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void draw() {
        super.draw();

        util.getPanel().text(this.position.getX()- hitboxSize.getX() /2, this.position.getY(),getInteractionName(), new Font("", 0, (int) (hitboxSize.getX() /4)), Color.BLACK, null);

    }

    protected abstract int getCooktime();
    protected abstract int getColdtime();
}
