package io.github.verissimor.service.serviceaidemo.entities;


public record Supplier(
        long id,
        String name,
        SupplierType type
) {
}
