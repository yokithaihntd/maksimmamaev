package com.yokithai.spring.factoryMethod;

interface Product {
    void show();
}

class ConcreteProductA implements Product {
    @Override
    public void show() {
        System.out.println("Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void show() {
        System.out.println("Product B");
    }
}

interface Creator {
    Product factoryMethod();
}

class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.show();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.show();


    }
}