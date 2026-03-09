public class CountdownTimer extends Thread {

    private Item item;
    private int seconds;

    public CountdownTimer(Item item, int seconds) {
        this.item = item;
        this.seconds = seconds;
    }

    public void run() {

        while (seconds > 0 && item.isAuctionOpen()) {

            System.out.println("Auction ends in: " + seconds + " seconds");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            seconds--;
        }

        item.closeAuction();
        System.out.println("\nAuction finished for item: " + item.getName());
    }
}