package patternSingletone;

class Dropper {
    private static Dropper instance;

    private Dropper() {
    }

    public static synchronized Dropper getInstance() {
        if (instance == null) {
            instance = new Dropper();
        }
        return instance;
    }

    public void processDropperOrder(String productId, int quantity, String supplier) {
        System.out.println("Processing dropper order for product ID: " + productId +
                ", Quantity: " + quantity + ", Supplier: " + supplier);
    }
}

public class Main {
    public static void main(String[] args) {
        Dropper dropperManager = Dropper.getInstance();

        dropperManager.processDropperOrder("54612AE", 20, "Supplier A");
    }
}