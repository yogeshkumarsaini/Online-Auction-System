import java.util.ArrayList;

public class Item {

    private int itemId;
    private String name;
    private double highestBid;
    private User highestBidder;
    private boolean auctionOpen = true;

    private ArrayList<Bid> bidHistory = new ArrayList<>();

    public Item(int itemId, String name, double startPrice) {
        this.itemId = itemId;
        this.name = name;
        this.highestBid = startPrice;
    }

    public synchronized void placeBid(User user, double amount) {

        if (!auctionOpen) {
            System.out.println("Auction closed.");
            return;
        }

        if (amount > highestBid) {

            highestBid = amount;
            highestBidder = user;

            user.addBid(amount);

            bidHistory.add(new Bid(user, amount));

            System.out.println("Bid accepted!");

        } else {
            System.out.println("Bid must be higher than current bid.");
        }
    }

    public void closeAuction() {
        auctionOpen = false;
    }

    public void showWinner() {

        if (highestBidder != null) {
            System.out.println("Winner: " + highestBidder.getName());
            System.out.println("Winning Bid: ₹" + highestBid);
        } else {
            System.out.println("No bids placed.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAuctionOpen() {
        return auctionOpen;
    }

    public int getItemId() {
        return itemId;
    }

    public double getHighestBid() {
        return highestBid;
    }
}