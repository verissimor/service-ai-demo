package io.github.verissimor.service.serviceaidemo.entities.assistant;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record ChatMessage(
        UUID id,
        UUID chatId,
        Instant createdAt,
        String role, // "user" OR "assistant"
        String content,
        List<VercelMessagePart> parts
        // List<ChatMetadataDto> metadata // Uncomment and implement if needed
) {
  public ChatMessage(
          UUID id,
          UUID chatId,
          Instant createdAt,
          String role,
          String content,
          List<VercelMessagePart> parts
  ) {
    this.id = id;
    this.chatId = chatId;
    this.createdAt = createdAt != null ? createdAt : Instant.now();
    this.role = role != null ? role : "user";
    this.content = content;
    this.parts = parts != null ? parts : List.of();
  }
}
