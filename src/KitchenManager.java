import com.daniel.GSprite.Util.Vector2D;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.*;
import java.util.List;

public class KitchenManager {
    private final GameManager manager; //Updates all stations and their state, (has the Client!!)

    private final CookStation fry1, fry2, coke, fanta, sprite, oven;

    private final Grill grill;

    private final Tray tray;
    private final Customers customers;
    private final Ticket ticket1, ticket2, ticket3, ticket4;

    private final List<Player> playersInRoom = new ArrayList<Player>();

    private boolean active = false;

    private final List<Station> stations = new ArrayList<>();

    private double money = 0;
    private final Label moneyLabel = new Label();
    private final Label missingPlayerLabel = new Label();

    private final Label timeLeftLabel = new Label();

    public KitchenManager(GameManager manager){
        grill = new Grill(new Vector2D(Constants.GRILLX, Constants.GRILLY), manager.getUtil(), new Vector2D(Constants.GRILLSIZE, Constants.GRILLSIZE), Constants.GRILLCOLOR, true, Constants.PATTYCOOKING, Constants.PATTYDONE, Constants.PATTYCOLD, Constants.GRILLSHORT, Constants.GRILLCOOKTIME, Constants.GRILLCOLDTIME);

        fry1 = new CookStation(new Vector2D(Constants.FRY1X, Constants.FRY1Y), manager.getUtil(), new Vector2D(Constants.FRYSIZE, Constants.FRYSIZE), Constants.FRYCOLOR, true, Constants.FRIESCOOKING, Constants.FRIESDONE, Constants.FRIESCOLD, Constants.FRYSHORT+"1", Constants.FRYCOOKTIME, Constants.FRYCOLDTIME);
        fry2 = new CookStation(new Vector2D(Constants.FRY2X, Constants.FRY2Y), manager.getUtil(), new Vector2D(Constants.FRYSIZE, Constants.FRYSIZE), Constants.FRYCOLOR, true, Constants.FRIESCOOKING, Constants.FRIESDONE, Constants.FRIESCOLD, Constants.FRYSHORT+"2", Constants.FRYCOOKTIME, Constants.FRYCOLDTIME);
        sprite = new CookStation(new Vector2D(Constants.SPRITEX, Constants.SPRITEY), manager.getUtil(), new Vector2D(Constants.SPRITESIZE, Constants.SPRITESIZE), Constants.SPRITECOLOR, true, Constants.SPRITECOOKING, Constants.SPRITEDONE, Constants.SPRITECOLD, Constants.SPRITESHORT, Constants.SPRITECOOKTIME, Constants.SPRITECOLDTIME);
        coke = new CookStation(new Vector2D(Constants.COKEX, Constants.COKEY), manager.getUtil(), new Vector2D(Constants.COKESIZE, Constants.COKESIZE), Constants.COKECOLOR, true, Constants.COKECOOKING, Constants.COKEDONE, Constants.COKECOLD, Constants.COKESHORT, Constants.COKECOOKTIME, Constants.COKECOLDTIME);
        fanta = new CookStation(new Vector2D(Constants.FANTAX, Constants.FANTAY), manager.getUtil(), new Vector2D(Constants.FANTASIZE, Constants.FANTASIZE), Constants.FANTACOLOR, true, Constants.FANTACOOKING, Constants.FANTADONE, Constants.FANTACOLD, Constants.FANTASHORT, Constants.FANTACOOKTIME, Constants.FANTACOLDTIME);
        oven = new CookStation(new Vector2D(Constants.PIZZAX, Constants.PIZZAY), manager.getUtil(), new Vector2D(Constants.PIZZASIZE, Constants.PIZZASIZE), Constants.PIZZACOLOR, true, Constants.PIZZACOOKING, Constants.PIZZADONE, Constants.PIZZACOLD, Constants.PIZZASHORT, Constants.PIZZACOOKTIME, Constants.PIZZACOLDTIME);


        tray = new Tray(new Vector2D(Constants.TRAYX, Constants.TRAYY), manager.getUtil());
        customers = new Customers(new Vector2D(Constants.CUSTOMX, Constants.CUSTOMY), manager.getUtil(), manager);
        ticket1 = new Ticket(new Vector2D(Constants.TICKET1X, Constants.TICKET1Y), manager.getUtil(), 1);
        ticket2 = new Ticket(new Vector2D(Constants.TICKET2X, Constants.TICKET2Y), manager.getUtil(), 2);
        ticket3 = new Ticket(new Vector2D(Constants.TICKET3X, Constants.TICKET3Y), manager.getUtil(), 3);
        ticket4 = new Ticket(new Vector2D(Constants.TICKET4X, Constants.TICKET4Y), manager.getUtil(), 4);


        moneyLabel.setText("Money: "+Math.round(money*10)/10);
        moneyLabel.setSize(Constants.WIDTH/10, Constants.HEIGHT/10);
        moneyLabel.setLocation(0, Constants.HEIGHT/7);
        moneyLabel.setFont(new Font("", 0, (Constants.FONTSIZE/(3))));

        missingPlayerLabel.setText("Missing Players: "+(3-playersInRoom.size()));
        missingPlayerLabel.setSize(Constants.WIDTH/9, Constants.HEIGHT/10);
        missingPlayerLabel.setLocation(0, Constants.HEIGHT/7*2);
        missingPlayerLabel.setFont(new Font("", 0, (Constants.FONTSIZE/(3))));

        timeLeftLabel.setText("Game hasn't started!");
        timeLeftLabel.setSize(Constants.WIDTH/9, Constants.HEIGHT/10);
        timeLeftLabel.setLocation(0, Constants.HEIGHT/7*3);
        timeLeftLabel.setFont(new Font("", 0, (int) (Constants.FONTSIZE/(3.5))));

        manager.getUtil().getPanel().addComponent(moneyLabel);
        manager.getUtil().getPanel().addComponent(missingPlayerLabel);
        manager.getUtil().getPanel().addComponent(timeLeftLabel);
        stations.addAll(Arrays.asList(grill, fry1, fry2, sprite, coke, fanta, oven, tray, customers, ticket1, ticket2, ticket3, ticket4));

        this.manager = manager;
    }

    public Station getStationByName(String name){

        for (Station station : stations){
            if(station.getName().equals(name)){
                return station;
            }
        }

        return  null;
    }

    //An Interaction in the game from Playerself
    public void interaction(Station station, boolean leftclick, boolean rightclick, boolean epressed){
        //Sends to the server

        if(!active){return;}

        //Tickets get handled elsewhere as they require more information that would be an overload and unecessary on the server
        if(station instanceof Ticket && (leftclick || rightclick || epressed)){

            ticketInteraction(((Ticket) station).getNumber());
            return;
        }

        if(leftclick){KitchenSend.INT.send(manager, station.getName(), "l");}
        if(rightclick){KitchenSend.INT.send(manager, station.getName(), "r");}
        if(epressed){KitchenSend.INT.send(manager, station.getName(), "e");}

    }

    public void handleInteraction(String station, String interaction, String id){
        if(!active){return;}
        int idHere = Integer.parseInt(id);

        if(interaction.equals("l")){getStationByName(station).leftclick(manager.getKitchenManager().getPlayer(idHere));}
        if(interaction.equals("r")){getStationByName(station).rightclick(manager.getKitchenManager().getPlayer(idHere));}
        if(interaction.equals("e")){getStationByName(station).throwaway(manager.getKitchenManager().getPlayer(idHere));}


    }

    private void ticketInteraction(int ticketNumber){

        String items = manager.getPlayerself().getFoodOnTray();

        if(items == null){
            return;
        }

        KitchenSend.TICKET.send(manager, ticketNumber, items);

    }

    public void addPlayer(int id, String name){
        Player player = new Player(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 2), manager.getUtil(), new Vector2D(Constants.PLAYERSIZE, Constants.PLAYERSIZE), Constants.PLAYERS[playersInRoom.size()+1], id, name);
        playersInRoom.add(player);

        missingPlayerLabel.setText("Missing Players: "+(3-playersInRoom.size()));
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
        missingPlayerLabel.setVisible(false);
        timeLeftLabelStart();

        this.active = active;
    }


    public void setTicket(int ticket, @Nullable String[] value){

        switch(ticket){
            case 1:
                ticket1.setTicketValue(value);
                break;
            case 2:
                ticket2.setTicketValue(value);
                break;
            case 3:
                ticket3.setTicketValue(value);
                break;
            case 4:
                ticket4.setTicketValue(value);
                break;
            default:
                break;
        }

    }

    public Player getPlayer(int id){
        for(Player player : playersInRoom){
            if(player.getId() == id){
                return player;
            }
        }

        if(manager.getPlayerself().getId() == id){
            return manager.getPlayerself();
        }

        return null;
    }

    public void addMoney(double value){
        money += value;

        moneyLabel.setText("Money: "+Math.round(money*10)/10);
    }

    private void timeLeftLabelStart(){

        final int[] minutes = {5};
        final int[] seconds = {0};

        timeLeftLabel.setText("Time left: "+ minutes[0] +"."+ seconds[0]);


        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds[0] == 0 && minutes[0] == 0){this.cancel(); return;}

                if(seconds[0] == 0){
                    minutes[0]--;
                    seconds[0] = 59;
                }else {
                    seconds[0]--;
                }

                timeLeftLabel.setText("Time left: "+ minutes[0] +":"+ (seconds[0] > 9 ? seconds[0] : "0"+seconds[0]));

            }
        }, 50, 1000);

    }
}
