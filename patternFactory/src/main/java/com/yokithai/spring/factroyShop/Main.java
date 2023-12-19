package com.yokithai.spring.factroyShop;

interface Product {
    void displayInfo();
}

class Book implements Product {
    @Override
    public void displayInfo() {
        System.out.println("Це книга.");
    }
}

class Electronics implements Product {
    @Override
    public void displayInfo() {
        System.out.println("Це електронний товар.");
    }
}

interface ProductFactory {
    Product createProduct();
}

class BookFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Book();
    }
}

class ElectronicsFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Electronics();
    }
}

public class Main {
    public static void main(String[] args) {
        ProductFactory bookFactory = new BookFactory();
        Product book = bookFactory.createProduct();
        book.displayInfo();

        ProductFactory electronicsFactory = new ElectronicsFactory();
        Product electronics = electronicsFactory.createProduct();
        electronics.displayInfo();
    }
}
