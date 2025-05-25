package io.github.verissimor.service.serviceaidemo.repository;


import io.github.verissimor.service.serviceaidemo.entities.Supplier;
import io.github.verissimor.service.serviceaidemo.entities.SupplierType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SupplierRepository {
  private static final List<Supplier> suppliers = new ArrayList<>(List.of(
          new Supplier(1L, "Amazon", SupplierType.COMPANY),
          new Supplier(2L, "TFL", SupplierType.COMPANY),
          new Supplier(3L, "Jon Doe", SupplierType.INDIVIDUAL)
  ));

  private final List<Supplier> initialSuppliers = new ArrayList<>(suppliers);

  public List<Supplier> listSuppliers() {
    return List.copyOf(suppliers);
  }

  public Supplier createSupplier(Supplier supplier) {
    suppliers.add(supplier);
    return supplier;
  }

  public void resetSuppliers() {
    suppliers.clear();
    suppliers.addAll(initialSuppliers);
  }
}
