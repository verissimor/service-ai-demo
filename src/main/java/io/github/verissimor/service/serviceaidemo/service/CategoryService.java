package io.github.verissimor.service.serviceaidemo.service;

import io.github.verissimor.service.serviceaidemo.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  public List<Category> listCategories() {
    return List.of(
            new Category(1L, "Salary"),
            new Category(2L, "Office supplies"),
            new Category(3L, "Travel"),
            new Category(4L, "Rent"),
            new Category(5L, "Health insurance")
    );
  }
}
