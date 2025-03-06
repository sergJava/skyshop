package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private String name;
    private final UUID id;

    @Override
    public String getSearchTerm() {
        return this.name;
    }

    @Override
    public String getTypeObject() {
        return "PRODUCT";
    }

    public Product(String name, UUID id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("неправильное название продукта");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getPrice();

    @Override
    public UUID getId() {
        return id;
    }

    public abstract boolean isSpecial();

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    public int hashCode(){
        return Objects.hashCode(name);
    }
}
