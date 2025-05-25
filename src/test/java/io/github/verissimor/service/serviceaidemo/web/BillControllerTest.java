package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.ServiceAiDemoApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BillControllerTest extends ServiceAiDemoApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void parseBillWorkflow() throws Exception {
    mockMvc.perform(get("/bills/parse")
                    .param("url", "http://localhost:3000/Mock_Bank_Statement__Jan_Feb_2025_.csv"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].description").value("Foxtons Real State London – Flat 12B"))
            .andExpect(jsonPath("$[0].date").value("2025-01-01"))
            .andExpect(jsonPath("$[0].value").value(1400))
            .andExpect(jsonPath("$[0].categoryId").value(4)) // Rent
            .andExpect(jsonPath("$[0].supplierId").value(4)) // Foxtons

            .andExpect(jsonPath("$[1].description").value("TFL TRAVEL CHARGE TFL.GOV.UK/CP"))
            .andExpect(jsonPath("$[1].date").value("2025-01-03"))
            .andExpect(jsonPath("$[1].value").value(50))
            .andExpect(jsonPath("$[1].categoryId").value(3)) // Travel
            .andExpect(jsonPath("$[1].supplierId").value(2)) // TFL

            .andExpect(jsonPath("$[2].description").value("Ergonomic Office Chair (Amazon Basics)"))
            .andExpect(jsonPath("$[2].date").value("2025-01-15"))
            .andExpect(jsonPath("$[2].value").value(120))
            .andExpect(jsonPath("$[2].categoryId").value(2)) // Office supplies
            .andExpect(jsonPath("$[2].supplierId").value(1)) // Amazon

            .andExpect(jsonPath("$[3].description").value("Printer paper and pens (Amazon)"))
            .andExpect(jsonPath("$[3].date").value("2025-01-22"))
            .andExpect(jsonPath("$[3].value").value(35))
            .andExpect(jsonPath("$[3].categoryId").value(2)) // Office supplies
            .andExpect(jsonPath("$[3].supplierId").value(1)) // Amazon

            .andExpect(jsonPath("$[4].description").value("Foxtons Real State London – Flat 12B"))
            .andExpect(jsonPath("$[4].date").value("2025-02-01"))
            .andExpect(jsonPath("$[4].value").value(1400))
            .andExpect(jsonPath("$[4].categoryId").value(4)) // Rent
            .andExpect(jsonPath("$[4].supplierId").value(4)) // Foxtons

            .andExpect(jsonPath("$[5].description").value("HP 305XL Ink Cartridge – Twin Pack"))
            .andExpect(jsonPath("$[5].date").value("2025-02-10"))
            .andExpect(jsonPath("$[5].value").value(95))
            .andExpect(jsonPath("$[5].categoryId").value(2)) // Office supplies
            .andExpect(jsonPath("$[5].supplierId").value(5)) // HP

            .andExpect(jsonPath("$[6].description").value("TFL TRAVEL CHARGE TFL.GOV.UK/CP"))
            .andExpect(jsonPath("$[6].date").value("2025-02-17"))
            .andExpect(jsonPath("$[6].value").value(50))
            .andExpect(jsonPath("$[6].categoryId").value(3)) // Travel
            .andExpect(jsonPath("$[6].supplierId").value(2)) // TFL

            .andExpect(jsonPath("$[7].description").value("Private physiotherapy session #Jon Doe 50-00-00 12389"))
            .andExpect(jsonPath("$[7].date").value("2025-02-25"))
            .andExpect(jsonPath("$[7].value").value(75));
  }
}
