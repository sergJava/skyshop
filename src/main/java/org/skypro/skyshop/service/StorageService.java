package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;

import java.util.Map;
import java.util.UUID;

public class StorageService {
    private final Map<UUID, Product> productMap;
    private final Map<UUID, Article> articleMap;


    public StorageService(Map<UUID, Product> productMap, Map<UUID, Article> articleMap) {
        this.productMap = productMap;
        this.articleMap = articleMap;
    }
}
