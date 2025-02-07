import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

public class Ticket extends Station{
    private final int number;

    public Ticket(Vector2D position, GUtility util, int number) {
        super(position, util, new Vector2D(Constants.TICKETSIZE, Constants.TICKETSIZE), Constants.TICKETCOLOR, true);
        this.number = number;
    }

    @Override
    public void leftclick(Player player) {

    }

    @Override
    public void rightclick(Player player) {

    }

    @Override
    public void throwaway(Player player) {

    }

    @Override
    public String getInteractionName() {
        return Constants.TICKETSHORT+number;
    }

    @Override
    public void cooked(int pos) {

    }

    @Override
    public void cold(int pos) {

    }

    @Override
    protected int getCooktime() {
        return 0;
    }

    @Override
    protected int getColdtime() {
        return 0;
    }
}
