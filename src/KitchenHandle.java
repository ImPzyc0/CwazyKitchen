public enum KitchenHandle {


    CONNECTED {
        @Override
        public void handleMessage(GameManager client, String message) {
            KitchenSend.JOIN.send(client, "Daniel");
        }
    },
    JOINED {
        @Override
        public void handleMessage(GameManager client, String message) {
            client.setID(Integer.parseInt(message.substring(8)));

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
        }
    },
    NPLAYER {
        @Override
        public void handleMessage(GameManager client, String message) {
            //Name und ID des Spielers
            String[] str = message.split(" ");
            System.out.println(str[1] +" : " + str[2]);
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
