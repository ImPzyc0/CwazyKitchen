public class KitchenClient extends Client{ //The Client who takes all the data from the server and sends it to the stations etc.
    //Also sends to the server, is the handler too

    private final GameManager manager;

    public KitchenClient(GameManager manager) {
        super(Constants.SERVERIP, Constants.SERVERPORT);
        this.manager = manager;
    }

    private enum KitchenHandler{

        CONNECTED{
            @Override
            public void handleMessage(KitchenClient client, String message) {
                KitchenSend.JOIN.send(client, "Daniel");
            }
        },
        JOINED {
            @Override
            public void handleMessage(KitchenClient client, String message) {
                client.manager.setID(Integer.parseInt(message.substring(8)));
                System.out.println(Integer.parseInt(message.substring(8)));
            }
        },
        ERR{
            @Override
            public void handleMessage(KitchenClient client, String message) {
                System.out.println(message);
            }
        };



        public abstract void handleMessage(KitchenClient client, String message);


    }

    private enum KitchenSend{

        JOIN {
            @Override
            public void send(KitchenClient client, Object... data) {
                client.send(this+" Daniel");
            }
        };

        public abstract void send(KitchenClient client, Object... data);


    }

    @Override
    public void processMessage(String pMessage) {
        try{
            KitchenHandler.valueOf(pMessage.substring(1).split(" ")[0]).handleMessage(this, pMessage);

        }catch(IllegalArgumentException x){
            if(pMessage.startsWith("-ERR")){
                KitchenHandler.ERR.handleMessage(this, pMessage);
                return;
            }

            System.out.println("Unhandled: "+pMessage);
        }


    }

}
