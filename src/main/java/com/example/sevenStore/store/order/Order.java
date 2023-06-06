package com.example.sevenStore.store.order;

public class Order {

    private Long memnerId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memnerId, String itemName, int itemPrice, int discountPrice) {
        this.memnerId = memnerId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public Long getMemnerId() {
        return memnerId;
    }

    public void setMemnerId(Long memnerId) {
        this.memnerId = memnerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memnerId=" + memnerId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
