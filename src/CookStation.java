import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

public class CookStation extends Station {

    protected enum State{
        EMPTY,
        COOKING,
        DONE,
        COLD;

    }


    protected State state = State.EMPTY;

    protected RectangleImageHitboxSprite sprite;

    protected String cooking, done, cold;
    protected int cooktime, coldtime;

    public CookStation(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, String cooking, String done, String cold, String name, int cooktime, int coldtime) {
        super(position, util, hitboxSize, color, fill, name);
        this.cooking = cooking;
        this.done = done;
        this.cold = cold;
        this.cooktime = cooktime;
        this.coldtime = coldtime;
    } // A Singular station, their states



    @Override
    public void leftclick(Player player) {
        throwaway(player);
    }

    @Override
    public void rightclick(Player player) {
        if(player.hasTray()){return;}
        if(state == State.EMPTY){
            this.sprite = new RectangleImageHitboxSprite(position, util, new Vector2D(this.hitboxSize.getX()/5*4, this.hitboxSize.getX()/5*4), cooking);

            state = State.COOKING;
            callWhenCooked(0);
        }
    }
    @Override
    public void throwaway(Player player) {
        if(sprite == null){return;}
        state = State.EMPTY;
        sprite.remove();
        sprite = null;
    }


    public void cooked(int pos) {
        if(state == State.EMPTY){return;}
        sprite.setImage(done);
        state = State.DONE;
        callWhenCold(0);
    }


    public void cold(int pos) {
        if(state == State.DONE){
            state = State.COLD;
            sprite.setImage(cold);
        }
    }

    public void callWhenCooked(int pos){
        new Thread(() -> {
            try {
                Thread.sleep(cooktime);
                cooked(pos);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }).start();
    }
    public void callWhenCold(int pos){
        new Thread(() -> {
            try {
                Thread.sleep(coldtime);
                cold(pos);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }).start();
    }



}
