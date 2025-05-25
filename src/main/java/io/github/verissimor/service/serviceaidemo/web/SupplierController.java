package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.service.SupplierService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController {

  private final SupplierService supplierService;

  public SupplierController(SupplierService supplierService) {
    this.supplierService = supplierService;
  }

  @GetMapping("/suppliers")
  public Object listSuppliers() {
    return supplierService.listSuppliers();
  }

  @GetMapping("/suppliers/ai-classification")
  public Object guessSuppliers(@RequestParam List<String> descriptions) {
    return supplierService.guessSupplier(descriptions);
  }
}
