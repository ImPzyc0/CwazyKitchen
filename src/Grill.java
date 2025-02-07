import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Grill extends Station{

    public Grill(Vector2D position, GUtility util) {
        super(position, util, new Vector2D(Constants.GRILLSIZE, Constants.GRILLSIZE), Constants.GRILLCOLOR, true);
        //Jeweils für eine Position auf dem Grill
        patties.put(0, new StateWrap(State.EMPTY, 0));
        patties.put(1, new StateWrap(State.EMPTY, 0));
        patties.put(2, new StateWrap(State.EMPTY, 0));
        patties.put(3, new StateWrap(State.EMPTY, 0));
    }

    private final HashMap<Integer, StateWrap> patties = new HashMap<>();
    private int amountOfPatties = 0;



    @Override
    public void leftclick(Player player) {
        throwaway(player);

    }

    @Override
    public void rightclick(Player player) {

        for(int i = 0; i< patties.size(); i++){

            if(patties.get(i).getState() == State.EMPTY){

                patties.put(i, new StateWrap(State.COOKING, amountOfPatties));
                amountOfPatties++;
                callWhenCooked(i);
                System.out.println(i);
                return;

            }

        }

    }

    @Override
    public void throwaway(Player player) {
        int top = Integer.MAX_VALUE;
        int numberOnGrill = -1;
        for (Integer i : patties.keySet()){

            if(patties.get(i).getNumberOfPreviousPatties() < top && patties.get(i).getState() != State.EMPTY){
                top = patties.get(i).getNumberOfPreviousPatties();
                numberOnGrill = i;
            }

        }

        if(numberOnGrill == -1){return;}

        patties.put(numberOnGrill, new StateWrap(State.EMPTY, 0));

    }

    @Override
    public String getInteractionName() {
        return Constants.GRILLSHORT;
    }

    @Override
    public void cooked(int pos) {
        if(patties.get(pos).getState() == State.EMPTY){return;}
        callWhenCold(pos);

        patties.get(pos).setState(State.DONE);
    }

    @Override
    public void cold(int pos) {
        if(patties.get(pos).getState() == State.EMPTY){return;}

        patties.get(pos).setState(State.COLD);
    }

    @Override
    protected int getCooktime() {
        return Constants.GRILLCOOKTIME;
    }

    @Override
    protected int getColdtime() {
        return Constants.GRILLCOLDTIME;
    }

    @Override
    public void draw() {
        super.draw();

        for(Integer i : patties.keySet()){

            if(!setColor(i)){continue;}
            switch (i){
                case 0:
                    util.getPanel().fillRectangle(Constants.GRILLX+Constants.GRILLSIZE/8, Constants.GRILLY+Constants.GRILLSIZE/8, Constants.GRILLX+Constants.GRILLSIZE/2/8*7, Constants.GRILLY+Constants.GRILLSIZE/2/8*7);
                    break;
                case 1:
                    util.getPanel().fillRectangle(Constants.GRILLX-Constants.GRILLSIZE/2/8*7, Constants.GRILLY+Constants.GRILLSIZE/2/8*7, Constants.GRILLX-Constants.GRILLSIZE/8, Constants.GRILLY+Constants.GRILLSIZE/8);
                    break;
                case 2:
                    util.getPanel().fillRectangle(Constants.GRILLX-Constants.GRILLSIZE/8, Constants.GRILLY-Constants.GRILLSIZE/8, Constants.GRILLX-Constants.GRILLSIZE/2/8*7, Constants.GRILLY-Constants.GRILLSIZE/2/8*7);
                    break;
                case 3:
                    util.getPanel().fillRectangle(Constants.GRILLX+Constants.GRILLSIZE/2/8*7, Constants.GRILLY-Constants.GRILLSIZE/2/8*7, Constants.GRILLX+Constants.GRILLSIZE/8, Constants.GRILLY-Constants.GRILLSIZE/8);
                    break;
                default:
                    break;
            }

        }

    }

    private boolean setColor(int pos){
        switch (patties.get(pos).getState()){
            case COLD:
                util.getPanel().color(Constants.PATTYCOLD);
                break;
            case DONE:
                util.getPanel().color(Constants.PATTYDONE);
                break;
            case COOKING:
                util.getPanel().color(Constants.PATTYCOOKING);
                break;
            case EMPTY:
                return false;
        }

        return true;
    }
}
