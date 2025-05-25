package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.ServiceAiDemoApplicationTests;
import io.github.verissimor.service.serviceaidemo.entities.assistant.AssistantData;
import io.github.verissimor.service.serviceaidemo.entities.assistant.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

class AssistantControllerTest extends ServiceAiDemoApplicationTests {

  @Autowired
  private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

  @Test
  void createNewBillUsingAssistant() throws Exception {
    UUID uuid = UUID.randomUUID();

    AssistantData body = new AssistantData(
            uuid.toString(),
            List.of(new ChatMessage(
                    null,
                    null,
                    Instant.now(),
                    "user",
                    "Create a new category named 'honeymoon' and a new payable for today with cost 10000 and new supplier 'booking.com'",
                    null
            ))
    );

    // 1. Start the request – it returns immediately because the controller emits a Flux
    MvcResult mvcResult = mockMvc.perform(post("/assistant/messages/" + uuid)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(body)))
            .andDo(print())
            .andExpect(request().asyncStarted())
            .andReturn();

    // 2. Block until the Flux finishes, then assert on the completed response
    mockMvc.perform(asyncDispatch(mvcResult))
            .andDo(print());

    // 3. Assert a new bill has been created
    assertThat(payableBillRepository.listBills()).hasSize(1);
    assertThat(categoryRepository.listCategories().getLast().name()).containsIgnoringCase("honeymoon");
    assertThat(supplierRepository.listSuppliers().getLast().name()).containsIgnoringCase("booking");
  }
}
