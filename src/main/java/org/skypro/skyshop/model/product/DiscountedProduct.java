package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private int basicPrice;
    private int discountInPercent;

    public DiscountedProduct(String name, UUID id, int basicPrice, int discountInPercent) {
        super(name, id);
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("цена не может быть меньше 1");
        }
        this.basicPrice = basicPrice;
        if (discountInPercent < 0 || discountInPercent > 100) {
            throw new IllegalArgumentException("скидка должна быть в пределах 0 - 100");
        }
        this.discountInPercent = discountInPercent;
    }

    @Override
    public int getPrice() {
        return (int) (basicPrice * (1 - (float) discountInPercent / 100));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "<" + this.getName() + "> : <" + getPrice() + "> (<" +
                this.discountInPercent + ">%)";
    }

}