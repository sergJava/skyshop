package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItemsList;
    private final int totalPrice;

    public UserBasket(List<BasketItem> basketItemsList) {
        this.basketItemsList = basketItemsList;
        totalPrice = basketItemsList.stream()
                .mapToInt(item -> item.getProductFromBasketItem().getPrice() *
                        item.getNumberOfProducts())
                .sum();
    }

    public List<BasketItem> getBasketItemsList() {
        return basketItemsList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
