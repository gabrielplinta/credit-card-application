public class Purchases {
    private String purchase;
    private double price;

    public Purchases (String purchase, double price) {
        this.purchase = purchase;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.purchase + " - " + this.price;
    }
}
