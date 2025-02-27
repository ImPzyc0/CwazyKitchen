import java.util.Arrays;

public enum KitchenHandle {

    //Handle any incoming traffic

    CONNECTED {
        @Override
        public void handleMessage(GameManager client, String message) {
            KitchenSend.JOIN.send(client);
        }
    },
    JOINED {
        @Override
        public void handleMessage(GameManager client, String message) {
            client.setID(Integer.parseInt(message.substring(8)));
            client.setRoomScreen();
        }
    },
    GROOM {
        @Override
        public void handleMessage(GameManager client, String message) {
            String str = message.substring(7);
            client.getArea().setText("");
            String[] rooms = str.split(" ");
            for (String s : rooms) {
                client.getArea().append(s + "\n");
            }
        }
    },
    ROOM {
        @Override
        public void handleMessage(GameManager client, String message) {
            String str = message.substring(6);

            client.joinRoom(Integer.parseInt(str));
        }
    },
    JROOM {
        @Override
        public void handleMessage(GameManager client, String message) {

            String[] str = message.split(" ");
            client.joinRoom(Integer.parseInt(str[1]));

            //Alle anderen Spieler sind danach im String mit Name und ID

            for(int i = 2; i<str.length; i++){
                String[] s = str[i].split(",");
                int id = Integer.parseInt(s[1]);
                String name = s[0];
                client.getKitchenManager().addPlayer(id, name);
            }


        }
    },
    NPLAYER {
        @Override
        public void handleMessage(GameManager client, String message) {
            //Name und ID des Spielers
            String[] str = message.split(" ");

            client.getKitchenManager().addPlayer(Integer.parseInt(str[2]), str[1]);
            client.getPlayerself().sendMove(client);
        }
    },
    POS {
        @Override
        public void handleMessage(GameManager client, String message) {
            //id, x, y
            String[] l = message.split(" ");
            int id = Integer.parseInt(l[1]);
            int x = Integer.parseInt(l[2].split(",")[0]);
            int y = Integer.parseInt(l[2].split(",")[1]);

            client.getKitchenManager().updatePlayerPos(id, x, y);
        }
    },

    ROOMSTARTSOON {
        @Override
        public void handleMessage(GameManager client, String message) {
            client.giveRoomCountdown();

        }
    },

    ROOMSTART {
        @Override
        public void handleMessage(GameManager client, String message) {
            client.startRoom();

        }
    },
    ROOMCLOSE{
        @Override
        public void handleMessage(GameManager client, String message) {
            System.out.println("End.");
            client.closeGame(message.split(" ")[1]);

        }
    },
    //Ticket is special as it also requires other information, but doesn`t need to trigger any clicks
    TICKET{
        @Override
        public void handleMessage(GameManager client, String message) {

            String[] str = message.split(" ");


            int number = Integer.parseInt(str[1]);

            if(str[2].equals("n")){

                String[] ticket = new String[str.length-3];
                for (int i = 3; i < str.length; i++){
                    ticket[i-3] = str[i];
                }

                client.getKitchenManager().setTicket(number, ticket);

            }else{ // Money

                client.getKitchenManager().setTicket(number, null);

                client.getKitchenManager().addMoney(Double.parseDouble(str[2]));
            }
        }
    },
    INT{
        @Override
        public void handleMessage(GameManager client, String message) {
            String[] str = message.split(" ");

            client.getKitchenManager().handleInteraction(str[1], str[2], str[3]);
        }
    },
    ERR {
        @Override
        public void handleMessage(GameManager client, String message) {
            System.out.println(message);
        }
    };


    public abstract void handleMessage(GameManager client, String message);


}
