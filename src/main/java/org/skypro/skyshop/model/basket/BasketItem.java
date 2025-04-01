package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.Objects;

public class BasketItem {
    private final Product product;
    private final int numberOfProducts;

    public BasketItem(Product product, int numberOfProducts) {
        this.product = product;
        this.numberOfProducts = numberOfProducts;
    }

    public Product getProductFromBasketItem() {
        return product;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItem that = (BasketItem) o;
        return numberOfProducts == that.numberOfProducts && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, numberOfProducts);
    }
}
