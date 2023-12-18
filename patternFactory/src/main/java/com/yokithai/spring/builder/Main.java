package com.yokithai.spring.builder;

class Product {
    private String name;
    private String category;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

interface ProductBuilder {
    void buildName();
    void buildCategory();
    void buildPrice();
    Product getResult();
}

class DropperProductBuilder implements ProductBuilder {
    private Product product = new Product();

    @Override
    public void buildName() {
        product.setName("Default Product");
    }

    @Override
    public void buildCategory() {
        product.setCategory("Default Category");
    }

    @Override
    public void buildPrice() {
        product.setPrice(0.0);
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class ProductDirector {
    private ProductBuilder builder;

    public ProductDirector(ProductBuilder builder) {
        this.builder = builder;
    }

    public void constructProduct() {
        builder.buildName();
        builder.buildCategory();
        builder.buildPrice();
    }

    public Product getProduct() {
        return builder.getResult();
    }
}

public class Main {
    public static void main(String[] args) {
        ProductBuilder builder = new DropperProductBuilder();

        ProductDirector director = new ProductDirector(builder);

        director.constructProduct();

        Product product = director.getProduct();

        System.out.println(product);
    }
}
