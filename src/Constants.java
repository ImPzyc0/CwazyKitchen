import java.awt.*;

public interface Constants {

    int FPS = 60;

    double SCALE = 0.4; //Größe des Bildschirms: 1 - 1200x800, NICHT PERFEKT!

    int WIDTH = (int) (1200*SCALE);
    int HEIGHT = (int) (800*SCALE);

    int PLAYERSIZE = (int) (35*SCALE);
    Color[] PLAYERCOLORS = new Color[]{Color.BLUE, Color.GREEN, Color.YELLOW};

    Color PLAYERCOLOR = Color.RED;
    Color BACKGROUNDCOLOR = Color.GRAY;

    double MOVEMENTSPEED = 260/FPS;

    double TOPBORDER = 747*SCALE;
    double BOTTOMBORDER = 53*SCALE;
    double LEFTBORDER = 200*SCALE;
    double RIGHTBORDER = 1000*SCALE;

    String SERVERIP = "127.0.0.1";
    int SERVERPORT = 6000;

    //Stations
    //Grill
    double GRILLX = 270*SCALE;
    double GRILLY = 680*SCALE;
    double GRILLSIZE = 120*1.5*SCALE;
    Color GRILLCOLOR = Color.DARK_GRAY;
    String GRILLSHORT = "GRL";
    //Fry
    double FRY1X = 410*SCALE;
    double FRY1Y = 725*SCALE;
    double FRYSIZE = 60*1.5*SCALE;
    Color FRYCOLOR = Color.ORANGE;
    String FRYSHORT = "FRY";
    //Fry2pos
    double FRY2X = 505*SCALE;
    double FRY2Y = 725*SCALE;
    //Coke
    double COKEX = 600*SCALE;
    double COKEY = 725*SCALE;
    double COKESIZE = 60*1.5*SCALE;
    Color COKECOLOR = Color.BLACK;
    String COKESHORT = "COKE";
    //Sprite
    double SPRITEX = 695*SCALE;
    double SPRITEY = 725*SCALE;
    double SPRITESIZE = 60*1.5*SCALE;
    Color SPRITECOLOR = Color.LIGHT_GRAY;
    String SPRITESHORT = "SPR";
    //Pizzaoven
    double PIZZAX = 920*SCALE;
    double PIZZAY = 695*SCALE;
    double PIZZASIZE = 100*1.5*SCALE;
    Color PIZZACOLOR = Color.PINK;
    String PIZZASHORT = "PIZ";
    //Fanta
    double FANTAX = 790*SCALE;
    double FANTAY = 725*SCALE;
    double FANTASIZE = 60*1.5*SCALE;
    Color FANTACOLOR = new Color(254,231,70);
    String FANTASHORT = "FAN";
    //Tray
    double TRAYX = 900*SCALE;
    double TRAYY = 130*SCALE;
    double TRAYSIZE = 200*SCALE;
    Color TRAYCOLOR = Color.CYAN;
    String TRAYSHORT = "TRAY";
    //Customers
    double CUSTOMX = 600*SCALE;
    double CUSTOMY = 120*SCALE;
    double CUSTOMSIZE = 180*SCALE;
    Color CUSTOMCOLOR = new Color(155, 38, 38);
    String CUSTOMSHORT = "CUST";
    //Ticket 1
    double TICKET1X = 235*SCALE;
    double TICKET1Y = 80*SCALE;
    double TICKETSIZE = 100*SCALE;
    Color TICKETCOLOR = new Color(46, 187, 40);
    String TICKETSHORT = "TICK";
    //Ticket 2
    double TICKET2X = 340*SCALE;
    double TICKET2Y = 80*SCALE;
    //Ticket 3
    double TICKET3X = 235*SCALE;
    double TICKET3Y = 185*SCALE;
    //Ticket 4
    double TICKET4X = 340*SCALE;
    double TICKET4Y = 185*SCALE;


    //Romm Join UI
    String GETROOMS = "Show open rooms";
    String JOINROOM = "Join room!";
    String ROOMCODE = "Join room with code...";
    String CREATEROOM = "Create new room";
    String WAITINGSCREEN = "Waiting for connection to server...";

    int FONTSIZE = (int) (50*SCALE);

    //Login screen
    String LOGIN = "Connect to server!";
    String LABELLOGINSCREEN = "Put in your name, port and ip of the server to connect";
    String DEFAULTNAME = "Player";

    String GAMESTARTSIN = "Game starts in: ";
    String GAMESTART = "Game has started!";

    String GAMECLOSEDUETOPLAYERLEAVE = "Game has ended due to a player leaving.";
    String GAMECLOSEDUETOGAMEEND = "Game has ended.";

}
