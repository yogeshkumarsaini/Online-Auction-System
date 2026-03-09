public class User {

    private int id;
    private String name;
    private double totalBids;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalBids = 0;
    }

    public void addBid(double amount) {
        totalBids += amount;
    }

    public double getTotalBids() {
        return totalBids;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}