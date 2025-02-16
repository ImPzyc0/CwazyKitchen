import com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites.RectangleImageHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.HashMap;

public class Grill extends CookStation {

    protected class StateWrap{
        private State state;
        private final int numberOfPreviousPatties;

        private RectangleImageHitboxSprite sprite = null;

        private final Vector2D pos;

        protected StateWrap(State state, int numberOfPreviousPatties, Vector2D pos){
            this.numberOfPreviousPatties = numberOfPreviousPatties;
            this.pos = pos;
            setState(state);
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;

            switch (state){
                case DONE:
                    sprite.setImage(done);
                    break;
                case COOKING:
                    sprite = new RectangleImageHitboxSprite(pos, util, new Vector2D(Constants.GRILLSIZE/3, Constants.GRILLSIZE/3), cooking);
                    break;
                case COLD:
                    sprite.setImage(cold);
                    break;
                default:
                    if(sprite != null){
                        sprite.remove();
                        sprite = null;
                    }
                    break;
            }
        }

        public int getNumberOfPreviousPatties() {
            return numberOfPreviousPatties;
        }

    }

    public Grill(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill, String cooking, String done, String cold, String name, int cooktime, int coldtime) {
        super(position,  util,  hitboxSize,  color,  fill,  cooking,  done,  cold,  name,  cooktime, coldtime);
        //Jeweils für eine Position auf dem Grill
        for(int i = 0; i< 4; i++){
            patties.put(i, new StateWrap(State.EMPTY, 0, new Vector2D(1, 1)));
        }


    }

    private final HashMap<Integer, StateWrap> patties = new HashMap<>();
    private int amountOfPatties = 0;



    @Override
    public void leftclick(Player player) {
        int oldestPatty = getOldestPatty();
        if(!player.hasTray() || !player.trayHasSpace() || oldestPatty == -1 || patties.get(oldestPatty).getState() == State.EMPTY){return;}
        String str = switch (patties.get(getOldestPatty()).getState()) {
            case DONE -> done;
            case COOKING -> cooking;
            case COLD -> cold;
            default -> "";
        };
        player.addItem(str);

        throwaway(player);
    }

    @Override
    public void rightclick(Player player) {
        if(player.hasTray()){return;}

        for(int i = 0; i< patties.size(); i++){

            if(patties.get(i).getState() == State.EMPTY){

                switch (i){
                    case 0:
                        patties.put(i, new StateWrap(State.COOKING, amountOfPatties, new Vector2D(Constants.GRILLX+Constants.GRILLSIZE/4, Constants.GRILLY+Constants.GRILLSIZE/4)));
                        break;
                    case 1:
                        patties.put(i, new StateWrap(State.COOKING, amountOfPatties, new Vector2D(Constants.GRILLX-Constants.GRILLSIZE/4, Constants.GRILLY+Constants.GRILLSIZE/4)));
                        break;
                    case 2:
                        patties.put(i, new StateWrap(State.COOKING, amountOfPatties, new Vector2D(Constants.GRILLX-Constants.GRILLSIZE/4, Constants.GRILLY-Constants.GRILLSIZE/4)));
                        break;
                    case 3:
                        patties.put(i, new StateWrap(State.COOKING, amountOfPatties, new Vector2D(Constants.GRILLX+Constants.GRILLSIZE/4, Constants.GRILLY-Constants.GRILLSIZE/4)));
                        break;
                    default:
                        break;
                }

                amountOfPatties++;
                callWhenCooked(i);



                return;

            }

        }

    }

    @Override
    public void throwaway(Player player) {
        int numberOnGrill = getOldestPatty();

        if(numberOnGrill == -1){return;}

        patties.get(numberOnGrill).setState(State.EMPTY);

    }

    private int getOldestPatty(){
        int top = Integer.MAX_VALUE;
        int numberOnGrill = -1;
        for (Integer i : patties.keySet()){

            if(patties.get(i).getNumberOfPreviousPatties() < top && patties.get(i).getState() != State.EMPTY){
                top = patties.get(i).getNumberOfPreviousPatties();
                numberOnGrill = i;
            }

        }
        return numberOnGrill;

    }


    @Override
    public void cooked(int pos) {
        if(patties.get(pos).getState() != State.COOKING){return;}
        callWhenCold(pos);

        patties.get(pos).setState(State.DONE);
    }

    @Override
    public void cold(int pos) {
        if(patties.get(pos).getState() != State.DONE){return;}

        patties.get(pos).setState(State.COLD);
    }

}
