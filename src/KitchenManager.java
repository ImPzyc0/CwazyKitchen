import com.daniel.GSprite.Util.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class KitchenManager {
    private final GameManager manager; //Updates all stations and their state, (has the Client!!)

    private final Grill grill;
    private final Fry fry1;
    private final Fry fry2;
    private final Coke coke;
    private final Fanta fanta;
    private final Sprite sprite;
    private final Pizzaoven oven;
    private final Tray tray;
    private final Customers customers;
    private final Ticket ticket1;
    private final Ticket ticket2;
    private final Ticket ticket3;
    private final Ticket ticket4;

    private final List<Player> playersInRoom = new ArrayList<Player>();

    private boolean active = false;

    public KitchenManager(GameManager manager){
        grill = new Grill(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        fry1 = new Fry(new Vector2D(Constants.FRY1X, Constants.FRY1Y), manager.getUtil(), 1);
        fry2 = new Fry(new Vector2D(Constants.FRY2X, Constants.FRY2Y), manager.getUtil(), 2);
        sprite = new Sprite(new Vector2D(Constants.SPRITEX, Constants.SPRITEY), manager.getUtil());
        coke = new Coke(new Vector2D(Constants.COKEX, Constants.COKEY), manager.getUtil());
        fanta = new Fanta(new Vector2D(Constants.FANTAX, Constants.FANTAY), manager.getUtil());
        oven = new Pizzaoven(new Vector2D(Constants.PIZZAX, Constants.PIZZAY), manager.getUtil());
        tray = new Tray(new Vector2D(Constants.TRAYX, Constants.TRAYY), manager.getUtil());
        customers = new Customers(new Vector2D(Constants.CUSTOMX, Constants.CUSTOMY), manager.getUtil());
        ticket1 = new Ticket(new Vector2D(Constants.TICKET1X, Constants.TICKET1Y), manager.getUtil(), 1);
        ticket2 = new Ticket(new Vector2D(Constants.TICKET2X, Constants.TICKET2Y), manager.getUtil(), 2);
        ticket3 = new Ticket(new Vector2D(Constants.TICKET3X, Constants.TICKET3Y), manager.getUtil(), 3);
        ticket4 = new Ticket(new Vector2D(Constants.TICKET4X, Constants.TICKET4Y), manager.getUtil(), 4);

        this.manager = manager;
    }

    //An Interaction in the game from Playerself
    //Only called once per frame, so any input will be sent at once
    public void interaction(Station station, boolean leftclick, boolean rightclick, boolean epressed){
        //Sends to the server

        //System.out.println("Station: "+station.getInteractionName()+ ", l: "+leftclick+", r: "+rightclick+", e: "+epressed);

        if(leftclick){station.leftclick(manager.getPlayerself());}
        if(rightclick){station.rightclick(manager.getPlayerself());}
        if(epressed){station.throwaway(manager.getPlayerself());}
    }
    //Change the state of the Station accordingly; Only the station, the player will be handled elsewhere!
    public void handleInteraction(Station station, boolean leftclick, boolean rightclick, boolean epressed){
        //Change the state of the station

    }

    public void addPlayer(int id, String name){

        Player player = new Player(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 2), manager.getUtil(), new Vector2D(Constants.PLAYERSIZE, Constants.PLAYERSIZE), Constants.PLAYERCOLORS[playersInRoom.size()], true, id, name);
        playersInRoom.add(player);
    }

    public void updatePlayerPos(int id, int x, int y){

        for(Player player : playersInRoom){
            if(player.getId() == id){
                player.setPosition(new Vector2D(x, y));
                return;
            }
        }

    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
