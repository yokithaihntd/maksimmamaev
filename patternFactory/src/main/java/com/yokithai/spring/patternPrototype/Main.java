package com.yokithai.spring.patternPrototype;

import java.util.HashMap;
import java.util.Map;

abstract class Product implements Cloneable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract Product clone();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ConcreteProduct extends Product {
    private String supplier;

    public ConcreteProduct(String name, double price, String supplier) {
        super(name, price);
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    @Override
    public ConcreteProduct clone() {
        return new ConcreteProduct(getName(), getPrice(), getSupplier());
    }
}

class PrototypeManager {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(String key, Product product) {
        productMap.put(key, product);
    }

    public Product getProduct(String key) {
        return productMap.get(key).clone();
    }
}
public class Main {
    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();

        prototypeManager.addProduct("Product A", new ConcreteProduct("Laptop", 1000, "Supplier1"));
        prototypeManager.addProduct("Product B", new ConcreteProduct("Smartphone", 500, "Supplier2"));

        Product clonedProduct1 = prototypeManager.getProduct("Product A");
        Product clonedProduct2 = prototypeManager.getProduct("Product B");

        System.out.println("Cloned Product A: " + clonedProduct1.getName() + ", " + clonedProduct1.getPrice() + ", "
                + ((ConcreteProduct) clonedProduct1).getSupplier());
        System.out.println("Cloned Product B: " + clonedProduct2.getName() + ", " + clonedProduct2.getPrice() + ", "
                + ((ConcreteProduct) clonedProduct2).getSupplier());
    }
}
