package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addToProductBasket(UUID id){
        if(storageService.getProductById(id).isPresent() == false){
            throw new IllegalArgumentException();
        } else{
            productBasket.addProduct(id);
        }
    }

    public UserBasket getUserBasket(){
        List<BasketItem> basketItems = productBasket.getBasket()
        UserBasket userBasket = new UserBasket()
    }


}
