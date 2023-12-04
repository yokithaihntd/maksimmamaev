package factoryAbstract;

interface Product {
    String getName();
}

class ElectronicProduct implements Product {
    private String name;

    public ElectronicProduct(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Електроніка: " + name;
    }
}

class ClothingProduct implements Product {
    private String name;

    public ClothingProduct(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Одяг: " + name;
    }
}

interface ProductFactory {
    Product createProduct();
}

class ElectronicProductFactory implements ProductFactory {
    private String name;

    public ElectronicProductFactory(String name) {
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new ElectronicProduct(name);
    }
}

class ClothingProductFactory implements ProductFactory {
    private String name;

    public ClothingProductFactory(String name) {
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new ClothingProduct(name);
    }
}

class Dropper {
    private ProductFactory electronicProductFactory;
    private ProductFactory clothingProductFactory;

    public Dropper(ProductFactory electronicProductFactory, ProductFactory clothingProductFactory) {
        this.electronicProductFactory = electronicProductFactory;
        this.clothingProductFactory = clothingProductFactory;
    }

    public Product orderElectronicProduct() {
        return electronicProductFactory.createProduct();
    }

    public Product orderClothingProduct() {
        return clothingProductFactory.createProduct();
    }
}

public class Main {
    public static void main(String[] args) {
        ProductFactory electronicProductFactory = new ElectronicProductFactory("Смартфон");
        ProductFactory clothingProductFactory = new ClothingProductFactory("Футболка");

        Dropper dropper = new Dropper(electronicProductFactory, clothingProductFactory);

        Product electronicProduct = dropper.orderElectronicProduct();
        System.out.println("Замовлено: " + electronicProduct.getName());

        Product clothingProduct = dropper.orderClothingProduct();
        System.out.println("Замовлено: " + clothingProduct.getName());
    }
}

