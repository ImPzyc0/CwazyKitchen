import com.daniel.GSprite.Util.Vector2D;

public class KitchenManager {
    private final GameManager manager; //Updates all stations and their state, (has the Client!!)

    private final Grill grill;

    public KitchenManager(GameManager manager){
        grill = new Grill(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil(), new Vector2D(Constants.GRILLSIZE, Constants.GRILLSIZE), Constants.GRILLCOLOR, true);
        this.manager = manager;
    }

    public Grill getGrill(){return grill;}

    //An Interaction in the game from Playerself
    //Only called once per frame, so any input will be sent at once
    public void interaction(Station station, boolean leftclick, boolean rightclick, boolean epressed){

        //Sends to the server

    }
    //Change the state of the Station accordingly; Only the station, the player will be handled elsewhere!
    public void handleInteraction(Station station, boolean leftclick, boolean rightclick, boolean epressed){
        //Change the state of the station

    }

}
