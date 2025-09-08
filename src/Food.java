public class Food {
    private String foodId;
    private String name;
    private double price;

    public Food(String foodId, String name, double price) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return foodId + " - " + name + " - $" + price;
    }
}
