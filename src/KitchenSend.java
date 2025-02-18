import java.util.Arrays;

public enum KitchenSend{

    //Send info the the server

    JOIN {
        @Override
        public void send(Client client, Object... data) {
            client.send(this+" "+((GameManager)client).getName());
        }
    },
    GETROOMS {
        @Override
        public void send(Client client, Object... data) {
            client.send(this.toString());
        }
    },
    CREATE {
        @Override
        public void send(Client client, Object... data) {
            client.send(this.toString());
        }
    },
    JROOM{
        @Override
        public void send(Client client, Object... data) {
            Object[] d = Arrays.stream(data).toArray();
            int l = (int) d[0];
            client.send(this+" "+l);
        }
    },
    MOVE{
        @Override
        public void send(Client client, Object... data) {
            Object[] d = Arrays.stream(data).toArray();
            int x = (int) d[0];
            int y = (int) d[1];
            client.send(this+" "+x+","+y);
        }
    },
    INT{
        @Override
        public void send(Client client, Object... data) {
            Object[] d = Arrays.stream(data).toArray();
            String station = (String) d[0];
            String interaction = (String) d[1];

            client.send(this+" "+station+" "+interaction);
        }
    },
    TICKET{
        @Override
        public void send(Client client, Object... data) {
            Object[] d = Arrays.stream(data).toArray();
            int number = (int) d[0];
            String food = (String) d[1];

            client.send(this+" "+number+" "+food);
        }
    };


    public abstract void send(Client client, Object... data);


}