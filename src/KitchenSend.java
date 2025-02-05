import java.util.Arrays;

public enum KitchenSend{

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
            boolean left = (boolean) d[0];
            boolean right = (boolean) d[1];
            String station = (String) d[2];
            client.send(this+" "+left+" "+right+" "+station);
        }
    },;


    public abstract void send(Client client, Object... data);


}