import java.util.ArrayList;
import java.util.Comparator;

public class AuctionManager {

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int id) {

        for (Item i : items) {
            if (i.getItemId() == id)
                return i;
        }

        return null;
    }

    public User getUser(int id) {

        for (User u : users) {
            if (u.getId() == id)
                return u;
        }

        return null;
    }

    public void showItems() {

        for (Item i : items) {

            System.out.println(
                    i.getItemId() + " | "
                            + i.getName()
                            + " | Highest Bid: ₹"
                            + i.getHighestBid());
        }
    }

    public void showLeaderboard() {

        users.sort(Comparator.comparing(User::getTotalBids).reversed());

        System.out.println("\n--- Bidder Leaderboard ---");

        for (User u : users) {
            System.out.println(
                    u.getName() +
                    " | Total Bids Value: ₹" +
                    u.getTotalBids());
        }
    }
}