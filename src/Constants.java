import java.awt.*;

public interface Constants {

    int FPS = 60;


    double SCALE = 1; //Größe des Bildschirms: 1 - 1200x800, NICHT PERFEKT!
    double COOKTIMEMULTIPLIER = 1;

    int WIDTH = (int) (1200*SCALE);
    int HEIGHT = (int) (800*SCALE);

    int PLAYERSIZE = (int) (40*SCALE);
    String[] PLAYERS = new String[]{"spieler1.jpg", "spieler2.jpg", "spieler3.jpg", "spieler4.jpg"};
    String PLAYERTRAY = "tray.jpg";
    Color BACKGROUNDCOLOR = Color.GRAY;

    double MOVEMENTSPEED = 350/FPS*SCALE;

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
    String GRILLSHORT = "Grill";
    int GRILLCOOKTIME = (int) (10000*COOKTIMEMULTIPLIER);
    int GRILLCOLDTIME = (int) (5000*COOKTIMEMULTIPLIER);

    String PATTYCOOKING = "pattycooking.jpg";
    String PATTYDONE = "pattydone.jpg";
    String PATTYCOLD = "pattycold.jpg";

    //Fry
    double FRY1X = 410*SCALE;
    double FRY1Y = 725*SCALE;
    double FRYSIZE = 60*1.5*SCALE;
    Color FRYCOLOR = Color.ORANGE;
    String FRYSHORT = "Frier";
    int FRYCOOKTIME = (int) (8000*COOKTIMEMULTIPLIER);
    int FRYCOLDTIME = (int) (4000*COOKTIMEMULTIPLIER);
    //Fry2pos
    double FRY2X = 505*SCALE;
    double FRY2Y = 725*SCALE;

    String FRIESDONE = "friesdone.jpg";
    String FRIESCOOKING = "friescooking.jpg";
    String FRIESCOLD = "friescold.jpg";
    //Coke
    double COKEX = 600*SCALE;
    double COKEY = 725*SCALE;
    double COKESIZE = 60*1.5*SCALE;
    Color COKECOLOR = Color.BLACK;
    String COKESHORT = "Coke";
    String COKEDONE = "cokedone.jpg";
    String COKECOOKING = "cokeemptycupcooking.jpg";
    String COKECOLD = "cokecold.jpg";
    int COKECOOKTIME = (int) (7000*COOKTIMEMULTIPLIER);
    int COKECOLDTIME = (int) (15000*COOKTIMEMULTIPLIER);
    //Sprite
    double SPRITEX = 695*SCALE;
    double SPRITEY = 725*SCALE;
    double SPRITESIZE = 60*1.5*SCALE;
    Color SPRITECOLOR = Color.LIGHT_GRAY;
    String SPRITESHORT = "Sprite";
    String SPRITEDONE = "spritedone.jpg";
    String SPRITECOOKING = "spriteemptycupcooking.jpg";
    String SPRITECOLD = "spritecold.jpg";
    int SPRITECOOKTIME = COKECOOKTIME;
    int SPRITECOLDTIME = COKECOLDTIME;
    //Pizzaoven
    double PIZZAX = 920*SCALE;
    double PIZZAY = 695*SCALE;
    double PIZZASIZE = 100*1.5*SCALE;
    Color PIZZACOLOR = Color.PINK;
    String PIZZASHORT = "Pizza";
    int PIZZACOOKTIME = (int) (20000*COOKTIMEMULTIPLIER);
    int PIZZACOLDTIME = (int) (8000*COOKTIMEMULTIPLIER);
    String PIZZACOOKING = "pizzacooking.jpg";
    String PIZZACOLD = "pizzacold.jpg";
    String PIZZADONE = "pizzadone.jpg";
    //Fanta
    double FANTAX = 790*SCALE;
    double FANTAY = 725*SCALE;
    double FANTASIZE = 60*1.5*SCALE;
    Color FANTACOLOR = new Color(254,231,70);
    String FANTASHORT = "Fanta";
    String FANTADONE = "fantadone.jpg";
    String FANTACOOKING = "fantaemptycupcooking.jpg";
    String FANTACOLD = "fantacold.jpg";
    int FANTACOOKTIME = COKECOOKTIME;
    int FANTACOLDTIME = COKECOLDTIME;
    //Tray
    double TRAYX = 900*SCALE;
    double TRAYY = 130*SCALE;
    double TRAYSIZE = 200*SCALE;
    Color TRAYCOLOR = Color.CYAN;
    String TRAYSHORT = "Tray";
    //Customers
    double CUSTOMX = 600*SCALE;
    double CUSTOMY = 120*SCALE;
    double CUSTOMSIZE = 180*SCALE;
    Color CUSTOMCOLOR = new Color(155, 38, 38);
    String CUSTOMSHORT = "Customers";
    //Ticket 1
    double TICKET1X = 235*SCALE;
    double TICKET1Y = 80*SCALE;
    double TICKETSIZE = 100*SCALE;
    Color TICKETCOLOR = new Color(46, 187, 40);
    String TICKETSHORT = "Ticket";
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
