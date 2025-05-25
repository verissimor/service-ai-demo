package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.ServiceAiDemoApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SupplierControllerTest extends ServiceAiDemoApplicationTests {

  @Test
  void listSuppliers() throws Exception {
    mockMvc.perform(get("/suppliers"))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void guessSuppliers() throws Exception {
    mockMvc.perform(get("/suppliers/ai-classification")
                    .param("descriptions", "Foxtons Real State London,TFL TRAVEL CHARGE TFL.GOV.UK/CP"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(4))
            .andExpect(jsonPath("$[0].name").value("Foxtons"))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].name").value("TFL"));
  }

  @Test
  void guessNewSupplier() throws Exception {
    mockMvc.perform(get("/suppliers/ai-classification")
                    .param("descriptions", "Jane Doe"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(4))
            .andExpect(jsonPath("$[0].name").value("Jane Doe"));
  }
}
