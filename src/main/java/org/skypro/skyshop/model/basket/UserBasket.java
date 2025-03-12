package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItems;
    private final int total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        total = basketItems.stream()
                .mapToInt(item -> item.getProductFromBasketItem().getPrice() *
                        item.getNumberOfProducts())
                .sum();
    }


}
