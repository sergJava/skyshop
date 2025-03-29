package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void addToProductBasket_nonExistentProduct_thenThrowsException() {
        UUID nonExistentUuid = UUID.randomUUID();
        when(storageService.getProductById(nonExistentUuid)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addToProductBasket(nonExistentUuid));
    }

    @Test
    void addToProductBasket_existentProduct_thenCallsAddToProductBasket() {
        UUID existentUuid = UUID.randomUUID();
        Product existentProduct = new SimpleProduct("test product", existentUuid, 100);
        when(storageService.getProductById(existentUuid)).thenReturn(Optional.of(existentProduct));

        basketService.addToProductBasket(existentUuid);

        verify(productBasket).addProduct(existentUuid);
    }

    @Test
    void getUserBasket_productBasketIsEmpty_returnsEmptyBasket() {
        when(productBasket.getBasket()).thenReturn(Collections.emptyMap());

        Assertions.assertEquals(0, basketService.getUserBasket().getBasketItemsList().size());
    }

    @Test
    void getUserBasket_productBasketWithItems_returnsCorrectBasket() {
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        Product product1 = new SimpleProduct("product1", productId1, 10);
        Product product2 = new SimpleProduct("product2", productId2, 20);
        Map<UUID, Integer> testProductBasket = new HashMap<>();
        testProductBasket.put(productId1, 2);
        testProductBasket.put(productId2, 3);

        BasketItem basketItem1 = new BasketItem(product1, 2);
        BasketItem basketItem2 = new BasketItem(product2, 3);
        List<BasketItem> testBasketItemsList = List.of(basketItem1, basketItem2);

        when(productBasket.getBasket()).thenReturn(testProductBasket);
        when(storageService.getProductById(productId1)).thenReturn(Optional.of(product1));
        when(storageService.getProductById(productId2)).thenReturn(Optional.of(product2));


        List<BasketItem> result = basketService.getUserBasket().getBasketItemsList();

        Assertions.assertEquals(testBasketItemsList.size(), result.size());
        Assertions.assertTrue(testBasketItemsList.containsAll(result));
        Assertions.assertTrue(result.containsAll(testBasketItemsList));
    }


}
