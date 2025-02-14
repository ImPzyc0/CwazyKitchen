import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Sprites.DrawableSprites.DrawableSprite;
import com.daniel.GSprite.Sprites.PositionSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player extends RectangleColoredHitboxSprite {//A player as shown in the game, name id etc.

    protected int id;
    private final String name;
    //Hashmap so it can have both Image and Colored sprites
    protected HashMap<DrawableSprite, PositionSprite> trayItems = null;


    public Player(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, int id, String name) {
        super(position, util, hitboxSize, color, fill);

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void draw() {
        super.draw();

        util.getPanel().text(this.position.getX()- (double) Constants.PLAYERSIZE /2, this.position.getY()+((double) Constants.PLAYERSIZE /2+ (double) Constants.PLAYERSIZE /8),name, new Font("", 0, Constants.PLAYERSIZE/2), Color.BLACK, null);

        //Tray
        if(trayItems ==  null){return;}
        for(DrawableSprite dsprite : trayItems.keySet()){

            dsprite.draw();

        }

    }

    public boolean hasTray() {
        return trayItems != null;
    }

    public void giveTray(){
        if(hasTray()){return;}
        this.trayItems = new HashMap<>();
        RectangleColoredHitboxSprite spr = new RectangleColoredHitboxSprite(new Vector2D(this.position.getX()+hitboxSize.getX()/2, this.position.getY()+hitboxSize.getY()/2), util, new Vector2D(this.hitboxSize.getX(), this.hitboxSize.getY()), Constants.PLAYERTRAYCOLOR, true);
        trayItems.put(spr, spr);

    }

    public void addItem(String str){
        if(trayItems == null){
            return;
        }

        switch(str){

            case "Frier1":

                break;
            case "Frier2":
                break;
            case "Grill":
                break;
            case "Pizza":
                break;
            case "Coke":
                break;
            case "Sprite":
                break;
            case "Fanta":
                break;
            default:
                break;
        }

    }

    private Vector2D calculatePosOfNewItem(){

        switch (trayItems.size()){

            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                break;

        }

        return null;
    }

    public void removeTray(){

        for(PositionSprite spr : trayItems.values()){
            spr.remove();

        }

        trayItems = null;

    }

    @Override
    public void setPosition(Vector2D vec) {
       updateTrayPosition(vec, this.getPosition());

        super.setPosition(vec);



    }

    protected void updateTrayPosition(Vector2D vec, Vector2D oldVec){
        if(!hasTray()){return;}

        double x = -oldVec.getX() + vec.getX();
        double y = -oldVec.getY() + vec.getY();

        for(PositionSprite pos : trayItems.values()){

            pos.move(new Vector2D(x, y));

        }
    }
}
