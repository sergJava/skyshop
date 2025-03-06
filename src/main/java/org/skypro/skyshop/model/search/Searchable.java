package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm ();
    String getTypeObject();

    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + " - " + getTypeObject();
    }

    String getName();

    UUID getId();
}
