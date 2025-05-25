package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.ServiceAiDemoApplicationTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryControllerTest extends ServiceAiDemoApplicationTests {

  @Test
  void listCategories() throws Exception {
    mockMvc.perform(get("/categories"))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void guessCategory() throws Exception {
    mockMvc.perform(get("/categories/ai-classification?description=TFL TRAVEL CHARGE TFL.GOV.UK/CP"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(3))
            .andExpect(jsonPath("$.name").value("Travel"));
  }
}
