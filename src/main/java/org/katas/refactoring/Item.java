package org.katas.refactoring;

public class Item {
    private String description;
    private Double price;
    private Integer quantity;

    public Item(String description, Double price, Integer quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return price * quantity;
    }
}