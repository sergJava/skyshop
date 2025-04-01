package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;


    public StorageService(Map<UUID, Product> productStorage, Map<UUID, Article> articleStorage) {
        this.productStorage = productStorage;
        this.articleStorage = articleStorage;
        createTestData();
    }

    private void createTestData() {
        SimpleProduct apple = new SimpleProduct("apple", UUID.randomUUID(), 150);
        SimpleProduct apple2 = new SimpleProduct("apple", UUID.randomUUID(), 200);
        DiscountedProduct banana = new DiscountedProduct("banana", UUID.randomUUID(), 200, 10);
        FixPriceProduct pineapple = new FixPriceProduct("pineapple", UUID.randomUUID());
        FixPriceProduct pineapple2 = new FixPriceProduct("bineapple", UUID.randomUUID());
        FixPriceProduct tomato = new FixPriceProduct("tomato", UUID.randomUUID());
        DiscountedProduct potato = new DiscountedProduct("potato", UUID.randomUUID(), 50, 20);
        DiscountedProduct appleDiscount = new DiscountedProduct("apple", UUID.randomUUID(), 100, 20);
        DiscountedProduct appleDiscount2 = new DiscountedProduct("appleDiscount", UUID.randomUUID(), 150, 10);

        productStorage.put(apple.getId(), apple);
        productStorage.put(apple2.getId(), apple2);
        productStorage.put(banana.getId(), banana);
        productStorage.put(pineapple.getId(), pineapple);
        productStorage.put(pineapple2.getId(), pineapple2);
        productStorage.put(tomato.getId(), tomato);
        productStorage.put(potato.getId(), potato);
        productStorage.put(appleDiscount.getId(), appleDiscount);
        productStorage.put(appleDiscount2.getId(), appleDiscount2);


        Article appleArticle = new Article("apple", UUID.randomUUID(), "green apple");
        Article tomatoJuiceArticle = new Article("tomato juice", UUID.randomUUID(), "tomato with apple juice 50%");
        Article smallBananaArticle = new Article("small ban", UUID.randomUUID(), "by New Zeland");
        Article appleJuiceArticle = new Article("apple juice", UUID.randomUUID(), "apple juice 100%");
        Article appleJuiceArticle2 = new Article("apple juice", UUID.randomUUID(), "app juice 100% app");
        Article appleJuiceArticle3 = new Article("apple juice", UUID.randomUUID(), "app juice 100%");

        articleStorage.put(appleArticle.getId(), appleArticle);
        articleStorage.put(tomatoJuiceArticle.getId(), tomatoJuiceArticle);
        articleStorage.put(smallBananaArticle.getId(), smallBananaArticle);
        articleStorage.put(appleJuiceArticle.getId(), appleJuiceArticle);
        articleStorage.put(appleJuiceArticle2.getId(), appleJuiceArticle2);
        articleStorage.put(appleJuiceArticle3.getId(), appleJuiceArticle3);
    }

    public Collection<Product> getProductStorage() {
        return productStorage.values();
    }

    public Collection<Article> getArticleStorage() {
        return articleStorage.values();
    }

    public Collection<Searchable> getSearchables() {
        Collection<Searchable> searchables = Stream.of(productStorage.values(), articleStorage.values())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return searchables;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }

    public void putProduct(Product product) {
        productStorage.put(product.getId(), product);
    }

}
