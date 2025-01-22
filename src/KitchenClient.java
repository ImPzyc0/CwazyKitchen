public class KitchenClient extends Client{ //The Client who takes all the data from the server and sends it to the stations etc.
    //Also sends to the server, is the handler too

    private final GameManager manager;

    public KitchenClient(GameManager manager) {
        super(Constants.SERVERIP, Constants.SERVERPORT);
        this.manager = manager;
    }

    @Override
    public void processMessage(String pMessage) {
        //Switch/Case not possible as it has to be one clear value, but the Strings have different arguments AND lengths
        if(pMessage.startsWith("+CONNECTED")){
            sendJoinMessage();
        }
        else if(pMessage.startsWith("+JOINED ")){
            manager.setID(Integer.parseInt(pMessage.substring(8)));
            System.out.println(Integer.parseInt(pMessage.substring(8)));
        }

    }

    public void sendJoinMessage(){
        send("JOIN Daniel");
    }

}
