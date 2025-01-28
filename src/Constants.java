import java.awt.*;

public interface Constants {

    int FPS = 60;

    double SCALE = 1; //Größe des Bildschirms: 1 - 1200x800, NICHT PERFEKT!

    int WIDTH = (int) (1200*SCALE);
    int HEIGHT = (int) (800*SCALE);

    int PLAYERSIZE = (int) (51*SCALE);
    int PLAYERPERROOM = 2;
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
    double GRILLX = 235*SCALE;
    double GRILLY = 715*SCALE;
    double GRILLSIZE = 120*SCALE;
    Color GRILLCOLOR = Color.DARK_GRAY;
    String GRILLSHORT = "GRL";
    //Fry
    double FRY1X = 235*SCALE;
    double FRY1Y = 715*SCALE;
    double FRY1SIZE = 120*SCALE;
    Color FRY1COLOR = Color.ORANGE;
    String FRY1SHORT = "FRY1";
    //Fry2pos
    double FRY2X = 235*SCALE;
    double FRY2Y = 715*SCALE;
    String FRY2SHORT = "FRY2";
    //Coke
    double COKEX = 235*SCALE;
    double COKEY = 715*SCALE;
    double COKESIZE = 120*SCALE;
    Color COKECOLOR = Color.BLACK;
    String COKESHORT = "COKE";
    //Sprite
    double SPRITEX = 235*SCALE;
    double SPRITEY = 715*SCALE;
    double SPRITESIZE = 120*SCALE;
    Color SPRITECOLOR = Color.LIGHT_GRAY;
    String SPRITESHORT = "SPR";
    //Pizzaoven
    double PIZZAX = 235*SCALE;
    double PIZZAY = 715*SCALE;
    double PIZZASIZE = 120*SCALE;
    Color PIZZACOLOR = Color.PINK;
    String PIZZASHORT = "PIZ";
    //Fanta
    double FANTAX = 235*SCALE;
    double FANTAY = 715*SCALE;
    double FANTASIZE = 120*SCALE;
    Color FANTACOLOR = new Color(254,231,70);
    String FANTASHORT = "FAN";
    //Tray
    double TRAYLX = 235*SCALE;
    double TRAYY = 715*SCALE;
    double TRAYSIZE = 120*SCALE;
    Color TRAYCOLOR = Color.CYAN;
    String TRAYSHORT = "TRAY";
    //Customers
    double CUSTOMX = 235*SCALE;
    double CUSTOMY = 715*SCALE;
    double CUSTOMSIZE = 120*SCALE;
    Color CUSTOMCOLOR = new Color(155, 38, 38);
    String CUSTOMSHORT = "CUST";
    //Ticket 1
    double TICKET1X = 235*SCALE;
    double TICKET1Y = 715*SCALE;
    double TICKET1SIZE = 120*SCALE;
    Color TICKET1COLOR = new Color(46, 187, 40);
    String TICKET1SHORT = "TICK1";
    //Ticket 2
    double TICKET2X = 235*SCALE;
    double TICKET2Y = 715*SCALE;
    String TICKET2SHORT = "TICK2";
    //Ticket 3
    double TICKET3X = 235*SCALE;
    double TICKET3Y = 715*SCALE;
    String TICKET3SHORT = "TICK3";
    //Ticket 4
    double TICKET4X = 235*SCALE;
    double TICKET4Y = 715*SCALE;
    String TICKET4SHORT = "TICK4";


    //Romm Join UI
    String GETROOMS = "Show open rooms";
    String JOINROOM = "Join room!";
    String ROOMCODE = "Join room with code...";
    String CREATEROOM = "Create new room";
    String WAITINGSCREEN = "Waiting for connection to server...";

    int FONTSIZE = (int) (50*SCALE);

}
