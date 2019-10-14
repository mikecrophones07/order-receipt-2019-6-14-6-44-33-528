package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<Item> items;

    public Order(String customerName, String customerAddress, List<Item> items) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<Item> getItems() {
        return items;
    }
}
