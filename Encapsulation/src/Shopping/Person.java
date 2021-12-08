package Shopping;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            this.products.add(product);
            money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        } else {
            String msg = String.format("%s can't afford %s%n", this.name, product.getName());
            throw new IllegalArgumentException(msg);


        }

    }

    public String getName() {
        return name;
    }
}
