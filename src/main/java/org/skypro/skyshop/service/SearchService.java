package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String requestString) {
        Collection<SearchResult> results = storageService.getSearchables()
                .stream()
                .filter(searchable -> searchable.getSearchTerm().contains(requestString))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
        return results;
    }
}
