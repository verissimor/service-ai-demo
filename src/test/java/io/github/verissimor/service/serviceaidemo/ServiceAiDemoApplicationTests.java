package io.github.verissimor.service.serviceaidemo;

import io.github.verissimor.service.serviceaidemo.repository.CategoryRepository;
import io.github.verissimor.service.serviceaidemo.repository.PayableBillRepository;
import io.github.verissimor.service.serviceaidemo.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceAiDemoApplicationTests {

  @Autowired
  public MockMvc mockMvc;

  @Autowired
  public CategoryRepository categoryRepository;

  @Autowired
  public SupplierRepository supplierRepository;

  @Autowired
  public PayableBillRepository payableBillRepository;

  @BeforeEach
  void prepareTests() {
    categoryRepository.resetCategories();
    supplierRepository.resetSuppliers();
    payableBillRepository.resetBills();
  }
}
