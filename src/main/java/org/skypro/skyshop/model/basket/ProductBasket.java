package org.skypro.skyshop.model.basket;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket(Map<UUID, Integer> basket) {
        this.basket = basket;
    }

    public void addProduct(UUID id) {
        basket.put(id, 1);
    }

    public Map<UUID, Integer> getBasket(){
        return Collections.unmodifiableMap(basket);
    }
}
