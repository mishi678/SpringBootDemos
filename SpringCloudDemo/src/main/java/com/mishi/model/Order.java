package com.mishi.model;

import java.io.Serializable;

public class Order implements Serializable {
    String orderId;
    String item;
    int qty;

    public Order() {
    }

    public Order(String orderId, String item, int qty) {
        this.orderId = orderId;
        this.item = item;
        this.qty = qty;
    }

    public Order(String orderId) {
        this.orderId =orderId;
        this.item = "Xyz";
        this.qty =1;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
