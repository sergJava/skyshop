package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, UUID id, int price) {
        super(name, id);
        if (price <= 0) {
            throw new IllegalArgumentException("цена не может быть меньше 1");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "<" + this.getName() + "> : <" + this.price + ">";
    }

}
