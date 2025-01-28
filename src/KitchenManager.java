import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KitchenManager {
    private final GameManager manager; //Updates all stations and their state, (has the Client!!)

    private final Grill grill;
    private final Fry fry1;
    private final Fry fry2;
    private final Pizzaoven oven;
    private final Coke coke;
    private final Fanta fanta;
    private final Sprite sprite;
    private final Customers customers;
    private final Tray tray;
    private final Ticket ticket1;
    private final Ticket ticket2;
    private final Ticket ticket3;
    private final Ticket ticket4;
    private final List<Player> playersInRoom = new ArrayList<Player>();

    public KitchenManager(GameManager manager){
        grill = new Grill(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        tray = new Tray(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        ticket1 = new Ticket(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        ticket2 = new Ticket(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        ticket3 = new Ticket(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        ticket4 = new Ticket(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        fry1 = new Fry(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        fry2 = new Fry(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        sprite = new Sprite(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        coke = new Coke(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        fanta = new Fanta(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        oven = new Pizzaoven(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());
        customers = new Customers(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil());

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

    public void addPlayer(int id, String name){

        Player player = new Player(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 2), manager.getUtil(), new Vector2D(Constants.PLAYERSIZE, Constants.PLAYERSIZE), Constants.PLAYERCOLORS[playersInRoom.size()], true, id, name);
        playersInRoom.add(player);


    }

}
