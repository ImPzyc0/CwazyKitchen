import java.awt.*;

public interface Constants {

    int FPS = 120;

    double SCALE = 1; //Größe des Bildschirms: 1 - 1200x800, NICHT PERFEKT!

    int WIDTH = (int) (1200*SCALE);
    int HEIGHT = (int) (800*SCALE);

    int PLAYERSIZE = (int) (51*SCALE);

    Color PLAYERCOLOR = Color.RED;
    Color BACKGROUNDCOLOR = Color.GRAY;

    double MOVEMENTSPEED = 260/FPS;

    double TOPBORDER = 747*SCALE;
    double BOTTOMBORDER = 53*SCALE;
    double LEFTBORDER = 200*SCALE;
    double RIGHTBORDER = 1000*SCALE;

    String SERVERIP = "192.168.0.160";
    int SERVERPORT = 6000;

}
