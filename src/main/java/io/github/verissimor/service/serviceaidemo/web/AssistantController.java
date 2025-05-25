package io.github.verissimor.service.serviceaidemo.web;

import io.github.verissimor.service.serviceaidemo.entities.assistant.AssistantData;
import io.github.verissimor.service.serviceaidemo.service.AssistantService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class AssistantController {

  private final AssistantService assistantService;

  public AssistantController(AssistantService assistantService) {
    this.assistantService = assistantService;
  }

  @PostMapping("/assistant/messages/{id}")
  public Flux<String> createMessagePost(
          @PathVariable UUID id,
          @RequestBody AssistantData body
  ) {
    return assistantService.createNewMessage(body.messages());
  }
}
