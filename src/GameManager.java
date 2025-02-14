import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.RectangleColoredHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager extends Client{ //GameLoop, updates, Room, times

    private final GUtility util;

    private KitchenManager kManager;
    private PlayerSelf self;
    private final String name;
    private int id;
    private final List<Player> players = new ArrayList<>();


    private boolean w, a, s, d, e, left, right = false;
    private boolean eWasUsed = false;

    private Button getrooms;
    private Button createroom;
    private Button joinroom;
    private TextField field;
    private TextArea area;

    private int roomCode = -1;
    private GameManager manager = this;
    private boolean connectedToServer = false;

    private Timer gameloop;

    public GameManager(GUtility util, String ip, int port, String name) {

        super(ip, port);
        this.util = util;
        this.name = name;
        //setKitchen();
        //setRoomScreen();
        setLoadingScreen();


    }

    private void gameLoop() {

        gameloop = new Timer();

        util.getPanel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == 1){left = true;}
                if(e.getButton() == 3){right = true;}

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        util.getPanel().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent event) {

                switch (event.getKeyChar()) {
                    case 'w':
                        w = true;
                        break;
                    case 'a':
                        a = true;
                        break;
                    case 's':
                        s = true;
                        break;
                    case 'd':
                        d = true;
                        break;
                    case 'e':
                        e = true;
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void keyPressed(KeyEvent event) {

            }

            @Override
            public void keyReleased(KeyEvent event) {
                switch (event.getKeyChar()) {
                    case 'w':
                        w = false;
                        break;
                    case 'a':
                        a = false;
                        break;
                    case 's':
                        s = false;
                        break;
                    case 'd':
                        d = false;
                        break;
                    case 'e':
                        e = false;
                        eWasUsed = false;
                        break;
                    default:
                        break;
                }
            }
        });

        gameloop.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //Movement before the listeners to detect new collisions
                //If multiple buttons were pressed they will all be detected during a frame
                self.updateMovement(w, a, s, d, manager);
                if(self.getStationsCurrentlyIn().size() == 1){
                    kManager.interaction(self.getStationsCurrentlyIn().get(0), left, right, e&&(!eWasUsed));
                }

                left = false;
                right = false;
                if(e){eWasUsed = true;}
                e = false;
                util.updateHitboxListeners();

                util.getPanel().clear();
                util.draw();

            }
        }, 200, 1000 / Constants.FPS);
    }

    private void setKitchen() { //Setting the scenery, stations etc.

        kManager = new KitchenManager(this);

        RectangleColoredHitboxSprite leftWall = new RectangleColoredHitboxSprite(new Vector2D(Constants.WIDTH / 7.5, (double) Constants.HEIGHT / 2), util, new Vector2D((double) Constants.WIDTH / 37.5, Constants.HEIGHT * 1.01), Color.BLACK, true);
        RectangleColoredHitboxSprite rightWall = new RectangleColoredHitboxSprite(new Vector2D((Constants.WIDTH / 7.5) * 6.5, (double) Constants.HEIGHT / 2), util, new Vector2D((double) Constants.WIDTH / 37.5, Constants.HEIGHT * 1.01), Color.BLACK, true);
        RectangleColoredHitboxSprite topWall = new RectangleColoredHitboxSprite(new Vector2D((double) Constants.WIDTH / 2, Constants.HEIGHT - (double) Constants.HEIGHT / 25 / 3), util, new Vector2D((double) (Constants.WIDTH / 3) * 2 + (double) Constants.WIDTH / 15, (double) Constants.HEIGHT / 25), Color.BLACK, true);
        RectangleColoredHitboxSprite bottomWall = new RectangleColoredHitboxSprite(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 25 / 3), util, new Vector2D((double) (Constants.WIDTH / 3) * 2 + (double) Constants.WIDTH / 15, (double) Constants.HEIGHT / 25), Color.BLACK, true);
        leftWall.setActive(false);
        rightWall.setActive(false);
        topWall.setActive(false);
        bottomWall.setActive(false);

        self = new PlayerSelf(new Vector2D((double) Constants.WIDTH / 2, (double) Constants.HEIGHT / 2), util, new Vector2D(Constants.PLAYERSIZE, Constants.PLAYERSIZE), Constants.PLAYERCOLOR, true, id, name);

        gameLoop();

        util.getPanel().title("Name: "+name+", ID: "+self.getId()+", room: "+roomCode);
    }

    private void setLoadingScreen(){

        util.getPanel().text((double) Constants.WIDTH /5, (double) Constants.HEIGHT /2, Constants.WAITINGSCREEN, new Font("", 0, Constants.FONTSIZE), Color.BLACK, Color.GRAY);
    }


    public void setRoomScreen() {

        getrooms = new Button();
        getrooms.setLabel(Constants.GETROOMS);
        getrooms.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        getrooms.setBackground(Color.DARK_GRAY);
        getrooms.setLocation(Constants.WIDTH/10, Constants.HEIGHT/5*3);
        getrooms.setFont(new Font("", 0, Constants.FONTSIZE));
        createroom = new Button();
        createroom.setLabel(Constants.CREATEROOM);
        createroom.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        createroom.setBackground(Color.DARK_GRAY);
        createroom.setLocation(Constants.WIDTH/10, Constants.HEIGHT/5*2);
        createroom.setFont(new Font("", 0, Constants.FONTSIZE));
        joinroom = new Button();
        joinroom.setLabel(Constants.JOINROOM);
        joinroom.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        joinroom.setBackground(Color.DARK_GRAY);
        joinroom.setLocation(Constants.WIDTH/10, Constants.HEIGHT/5);
        joinroom.setFont(new Font("", 0, Constants.FONTSIZE));

        getrooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KitchenSend.GETROOMS.send(manager);
            }
        });

        createroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KitchenSend.CREATE.send(manager);
            }
        });

        joinroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = -1;
                //Check value of the Field
                try{
                    i = Integer.parseInt(field.getText());
                }catch (NumberFormatException x){
                    field.setText("Roomcodes are numbers!");
                    return;
                }

                KitchenSend.JROOM.send(manager, i);
            }
        });

        //Input for the roomcode to join
        field = new TextField();
        field.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        field.setBackground(Color.WHITE);
        field.setText(Constants.ROOMCODE);
        field.setLocation(Constants.WIDTH/10, Constants.HEIGHT/22);
        field.setFont(new Font("", 2, Constants.FONTSIZE/10*9));
        //Text area with the codes
        area = new TextArea(null,0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
        area.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        area.setBackground(Color.WHITE);
        area.setText("");
        area.setLocation(Constants.WIDTH/10, Constants.HEIGHT/5*4);
        area.setFont(new Font("", 4, Constants.FONTSIZE/5*3));
        area.setEditable(false);

        util.getPanel().addComponent(joinroom);
        util.getPanel().addComponent(getrooms);
        util.getPanel().addComponent(createroom);
        util.getPanel().addComponent(field);
        util.getPanel().addComponent(area);

    }

    public void setID(int id){
        this.id = id;
    }

    public GUtility getUtil() {
        return util;
    }

    public TextArea getArea() {
        return area;
    }

    public void joinRoom(int code){

        roomCode = code;
        deactivateRoomUI();
        setKitchen();

    }

    private void deactivateRoomUI(){

        getrooms.setVisible(false);
        createroom.setVisible(false);
        joinroom.setVisible(false);
        field.setVisible(false);
        area.setVisible(false);

    }

    @Override
    public void processMessage(String pMessage) {
        try{
            KitchenHandle.valueOf(pMessage.substring(1).split(" ")[0]).handleMessage(this, pMessage);

        }catch(IllegalArgumentException x){

            System.out.println("Unhandled:"+pMessage);
        }


    }

    public KitchenManager getKitchenManager() {
        return kManager;
    }

    public String getName() {
        return name;
    }

    public PlayerSelf getPlayerself() {
        return self;
    }

    public void closeGame(String reason){

        gameloop.cancel();

        Label label = new Label();
        label.setText(reason.equals("LEAVE") ? Constants.GAMECLOSEDUETOPLAYERLEAVE : Constants.GAMECLOSEDUETOGAMEEND);
        label.setSize(Constants.WIDTH/10*8, Constants.HEIGHT/7);
        label.setLocation(Constants.WIDTH/10, Constants.HEIGHT/2);
        label.setFont(new Font("", Font.BOLD, (int) (Constants.FONTSIZE/(1.5))));
        util.getPanel().addComponent(label);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                label.setVisible(false);
                System.exit(0);

            }
        },3000);

    }

    public void giveRoomCountdown(){

        Timer timer = new Timer();

        final int[] times = {0};

        Label label = new Label();
        label.setText(Constants.GAMESTARTSIN+(5-times[0]));
        label.setSize(Constants.WIDTH/5*4, Constants.HEIGHT/7);
        label.setLocation(Constants.WIDTH/5, Constants.HEIGHT/2);
        label.setFont(new Font("", 0, (int) (Constants.FONTSIZE/(1.5))));
        util.getPanel().addComponent(label);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                times[0]++;

                label.setText(Constants.GAMESTARTSIN+(5-times[0]));

                if(times[0] == 5){label.setVisible(false); this.cancel();}
            }
        }, 0,1000);

    }

    public void startRoom(){

        kManager.setActive(true);

        Label label = new Label();
        label.setText(Constants.GAMESTART);
        label.setSize(Constants.WIDTH/5*2, Constants.HEIGHT/7);
        label.setLocation(Constants.WIDTH/5, Constants.HEIGHT/2);
        label.setFont(new Font("", Font.BOLD, (int) (Constants.FONTSIZE/(1.5))));
        util.getPanel().addComponent(label);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                label.setVisible(false);

            }
        },2000);

    }
}
