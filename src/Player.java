import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Sprites.PositionSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends RectangleImageHitboxSprite {//A player as shown in the game, name id etc.

    protected int id;
    private final String name;
    //Hashmap so it can have both Image and Colored sprites
    protected List<RectangleImageHitboxSprite> trayItems = null;


    public Player(Vector2D position, GUtility util, Vector2D hitboxSize, String path, int id, String name) {
        super(position, util, hitboxSize, path);

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void draw() {
        if(image == null){return;}
        super.draw();

        util.getPanel().text(this.position.getX()- (double) Constants.PLAYERSIZE /2, this.position.getY()+((double) Constants.PLAYERSIZE /2+ (double) Constants.PLAYERSIZE /8),name, new Font("", 0, Constants.PLAYERSIZE/2), Color.BLACK, null);

    }

    public boolean hasTray() {
        return trayItems != null;
    }

    public boolean trayHasSpace(){
        return trayItems.size() <= 9;
    }

    public void giveTray(){
        if(hasTray()){return;}

        RectangleImageHitboxSprite spr = new RectangleImageHitboxSprite(new Vector2D(this.position.getX()+hitboxSize.getX(), this.position.getY()-hitboxSize.getY()/2), util, new Vector2D(this.hitboxSize.getX()*2, this.hitboxSize.getY()), Constants.PLAYERTRAY);
        this.trayItems = new ArrayList<>();
        trayItems.add(spr);

    }

    public void addItem(String str){
        if(trayItems == null){
            return;
        }

        trayItems.add(new RectangleImageHitboxSprite(calculatePosOfItem(trayItems.size()), util, new Vector2D(hitboxSize.getX()/3, hitboxSize.getY()/3), str));

    }

    private Vector2D calculatePosOfItem(int pos){

        switch (pos){
            case 1:
                return new Vector2D(this.position.getX()+hitboxSize.getX() -(hitboxSize.getX()/4*3), this.position.getY()-hitboxSize.getY()/2+hitboxSize.getY()/4);
            case 2:
                return new Vector2D(this.position.getX()+hitboxSize.getX() -(hitboxSize.getX()/4), this.position.getY()-hitboxSize.getY()/2+hitboxSize.getY()/4);
            case 3:
                return new Vector2D(this.position.getX()+hitboxSize.getX() +(hitboxSize.getX()/4), this.position.getY()-hitboxSize.getY()/2+hitboxSize.getY()/4);
            case 4:
                return new Vector2D(this.position.getX()+hitboxSize.getX() +(hitboxSize.getX()/4*3), this.position.getY()-hitboxSize.getY()/2+hitboxSize.getY()/4);
            case 5:
                return new Vector2D(this.position.getX()+hitboxSize.getX() -(hitboxSize.getX()/4*3), this.position.getY()-hitboxSize.getY()/2-hitboxSize.getY()/4);
            case 6:
                return new Vector2D(this.position.getX()+hitboxSize.getX() -(hitboxSize.getX()/4), this.position.getY()-hitboxSize.getY()/2-hitboxSize.getY()/4);
            case 7:
                return new Vector2D(this.position.getX()+hitboxSize.getX() +(hitboxSize.getX()/4), this.position.getY()-hitboxSize.getY()/2-hitboxSize.getY()/4);
            case 8:
                return new Vector2D(this.position.getX()+hitboxSize.getX() +(hitboxSize.getX()/4*3), this.position.getY()-hitboxSize.getY()/2-hitboxSize.getY()/4);

            default:
                break;

        }

        return new Vector2D(0, 0);
    }

    public void removeTray(){
        if(!hasTray()){return;}
        for(PositionSprite spr : trayItems){
            spr.remove();
        }

        trayItems = null;

    }

    @Override
    public void setPosition(Vector2D vec) {
        super.setPosition(vec);
        updateTrayPosition();

    }

    protected void updateTrayPosition(){
        if(!hasTray()){return;}

        PositionSprite tray = trayItems.get(0);
        tray.setPosition(new Vector2D(this.position.getX()+hitboxSize.getX(), this.position.getY()-hitboxSize.getY()/2));

        for(int i = 1; i < trayItems.size(); i++){

            trayItems.get(i).setPosition(calculatePosOfItem(i));

        }
    }

    public String getFoodOnTray(){
        if(!hasTray()){
            return null;
        }
        StringBuilder str = new StringBuilder();

        for(int i = 1; i < trayItems.size(); i++){
            str.append(",").append(trayItems.get(i).getPath().replace(".jpg", ""));
        }

        return str.toString();
    }
}
