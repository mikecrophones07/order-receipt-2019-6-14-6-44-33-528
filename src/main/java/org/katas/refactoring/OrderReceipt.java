package org.katas.refactoring;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private static final String TOTAL_SALES_TAX_KEY = "Total Sale Tax";
    private static final String GRAND_TOTAL_KEY = "Grand Total";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return renderReceiptText(calculateReceipt());
    }

    private Map<String, Object> calculateReceipt() {
        Map<String, Object> finalReceipt = new HashMap<>();
        Double totalSalesTax = order.getItems().stream().mapToDouble(lineItem -> lineItem.getTotalAmount() * .10).sum();
        Double grandTotal = order.getItems().stream().mapToDouble(Item::getTotalAmount).sum() + totalSalesTax ;
        finalReceipt.put(TOTAL_SALES_TAX_KEY, totalSalesTax);
        finalReceipt.put(GRAND_TOTAL_KEY, grandTotal);
        return finalReceipt;
    }

    private String renderReceiptText(Map<String, Object> finalReceipt) {
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        this.order.getItems().forEach( item -> {
            String tempStringHolder = item.getDescription() + '\t'
                    + item.getPrice() + '\t'
                    + item.getQuantity() + '\t'
                    + item.getTotalAmount() + '\n';
            output.append(tempStringHolder);
        });

        output.append("Sales Tax").append('\t').append(finalReceipt.get(TOTAL_SALES_TAX_KEY));
        output.append("Total Amount").append('\t').append(finalReceipt.get(GRAND_TOTAL_KEY));
        return output.toString();
    }
}