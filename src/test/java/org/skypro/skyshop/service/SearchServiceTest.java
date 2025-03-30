package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void whenStorageServiceIsEmpty_ThenSearchServiceReturnsEmptyList() {
        when(searchService.search("request")).thenReturn(Collections.emptyList());
        Assertions.assertTrue(searchService.search("request").isEmpty());
    }

    @Test
    void whenNoObject_thenSearchServiceReturnsEmptyList() {
        UUID existingUuid = UUID.randomUUID();
        Product product = new SimpleProduct("product", UUID.randomUUID(), 10);
        Article article = new Article("article", UUID.randomUUID(), "test article");

        when(storageService.getSearchables()).thenReturn(List.of(product, article));
        Assertions.assertTrue(searchService.search("request").isEmpty());
    }

    @Test
    void whenObjectIsExist_thenSearchServiceReturnsObject() {
        Product product = new SimpleProduct("apple", UUID.randomUUID(), 10);
        SearchResult searchResult = SearchResult.fromSearchable(product);
        Collection<Searchable> searchables = Collections.singletonList(product);

        when(storageService.getSearchables()).thenReturn(searchables);

        Collection<SearchResult> searchResults = searchService.search("appl");

        Assertions.assertEquals(1, searchResults.size());
        Assertions.assertTrue(searchResults.contains(searchResult));
    }


}
