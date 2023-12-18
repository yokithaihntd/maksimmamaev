package com.yokithai.spring.adapter;

interface Dropper {
    void drop();
}

class AnotherClass {
    void differentMethod() {
        System.out.println("Doing something differently...");
    }
}

class Adapter implements Dropper {
    private AnotherClass adaptee;

    Adapter(AnotherClass adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void drop() {
        adaptee.differentMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        Dropper dropper = new Dropper() {
            @Override
            public void drop() {
                System.out.println("Dropping...");
            }
        };

        AnotherClass anotherInstance = new AnotherClass();

        dropper.drop();

        Adapter adapter = new Adapter(anotherInstance);
        adapter.drop();
    }
}