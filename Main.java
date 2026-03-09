import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuctionManager manager = new AuctionManager();
        Admin admin = new Admin();

        manager.addUser(new User(1, "Amit"));
        manager.addUser(new User(2, "Rahul"));
        manager.addUser(new User(3, "Neha"));

        System.out.println("Admin Login");

        System.out.print("Username: ");
        String user = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        if (!admin.login(user, pass)) {
            System.out.println("Login Failed!");
            return;
        }

        System.out.println("Login Successful!");

        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Item Name: ");
        String name = sc.next();

        System.out.print("Starting Price: ");
        double price = sc.nextDouble();

        System.out.print("Auction Duration (seconds): ");
        int duration = sc.nextInt();

        Item item = new Item(id, name, price);
        manager.addItem(item);

        CountdownTimer timer = new CountdownTimer(item, duration);
        timer.start();

        while (true) {

            System.out.println("\n1 Show Items");
            System.out.println("2 Place Bid");
            System.out.println("3 Show Winner");
            System.out.println("4 Leaderboard");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.showItems();
                    break;

                case 2:

                    System.out.print("User ID: ");
                    int uid = sc.nextInt();

                    User bidder = manager.getUser(uid);

                    System.out.print("Bid Amount: ");
                    double bid = sc.nextDouble();

                    item.placeBid(bidder, bid);
                    break;

                case 3:
                    item.showWinner();
                    break;

                case 4:
                    manager.showLeaderboard();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}