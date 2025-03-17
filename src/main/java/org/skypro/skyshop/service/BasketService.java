package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addToProductBasket(UUID id) {
        if (storageService.getProductById(id).isEmpty()) {
            throw new NoSuchProductException();
        }
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItemsList = productBasket.getBasket().entrySet()
                .stream()
                .map(entry -> new BasketItem(storageService.getProductById(entry.getKey())
                        .orElseThrow(NoSuchProductException::new), entry.getValue()))
                .toList();
        return new UserBasket(basketItemsList);
    }
}
