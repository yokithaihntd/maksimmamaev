package patternFactory;

interface Supplier {
    void supply();
}

class DropperA implements Supplier {
    @Override
    public void supply() {
        System.out.println("Постачання від DropperA");
    }
}

class DropperB implements Supplier {
    @Override
    public void supply() {
        System.out.println("Постачання від DropperB");
    }
}

class SupplierFactory {
    public Supplier createSupplier(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new DropperA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new DropperB();
        } else {
            throw new IllegalArgumentException("Непідтримуваний тип постачальника: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SupplierFactory supplierFactory = new SupplierFactory();

        Supplier dropperA = supplierFactory.createSupplier("A");
        dropperA.supply();

        Supplier dropperB = supplierFactory.createSupplier("B");
        dropperB.supply();
    }
}