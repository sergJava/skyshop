package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket(Map<UUID, Integer> basket) {
        this.basket = basket;
    }

    public void addProduct(UUID id) {
        if (basket.containsKey(id)) {
            basket.put(id, (basket.get(id) + 1));
        } else basket.put(id, 1);
    }

    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }
}
