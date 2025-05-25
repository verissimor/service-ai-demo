package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.entities.Category;
import io.github.verissimor.service.serviceaidemo.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public List<Category> listCategories() {
    return categoryService.listCategories();
  }
}
