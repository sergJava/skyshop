package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    public Collection<Product> gerAllProducts(){
        return storageService.getProductStorage();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticle(){
        return storageService.getArticleStorage();
    }

    @GetMapping("/search")
    public Collection<SearchResult> searchController(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }
}
