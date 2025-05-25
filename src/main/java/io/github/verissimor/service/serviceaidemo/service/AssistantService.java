package io.github.verissimor.service.serviceaidemo.service;

import io.github.verissimor.service.serviceaidemo.entities.assistant.ChatMessage;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssistantService {

  private final CategoryService categoryService;
  private final SupplierService supplierService;
  private final PayableBillService payableBillService;
  private final OpenAiChatModel chatModel;

  public AssistantService(
          CategoryService categoryService,
          SupplierService supplierService,
          PayableBillService payableBillService,
          OpenAiChatModel chatModel
  ) {
    this.categoryService = categoryService;
    this.supplierService = supplierService;
    this.payableBillService = payableBillService;
    this.chatModel = chatModel;
  }

  public Flux<String> createNewMessage(List<ChatMessage> messages) {
    OpenAiChatOptions options = OpenAiChatOptions.builder()
            .model(OpenAiApi.ChatModel.GPT_4_1)
            .maxTokens(1000)
            .temperature(0.7)
            .build();

    SystemMessage systemMessage = new SystemMessage("""
            # Accounts‑Payable Ingestion **Assistant** – Unified System Prompt
            
            ```text
            You are an **Accounts‑Payable Ingestion Assistant**.
            
            Your goal is to work **with** the user to turn each bank statement into
            stored payable bills.  
            You have direct access to these tools:
            
              • `listCategories`, `createCategory`  
              • `listSuppliers`,  `createSupplier`  
              • `createBill`
            
            You may call them whenever needed.  
            Unlike a silent background agent, you *explain what you’re doing* at
            each step, invite clarifications, and show the results of tool calls.
            
            ... [REMAINDER OMITTED FOR BREVITY] ...
            ```  
            """);

    List<Message> allMessages = new ArrayList<Message>();
    allMessages.add(systemMessage);
    allMessages.addAll(
            messages.stream()
                    .map(msg -> "user".equals(msg.role())
                            ? new UserMessage(msg.content())
                            : new AssistantMessage(msg.content())
                    ).toList()
    );

    Prompt prompt = new Prompt(allMessages);

    return ChatClient.create(chatModel)
            .prompt(prompt)
            .options(options)
            .tools(categoryService, supplierService, payableBillService)
            .stream()
            .content();
  }
}
