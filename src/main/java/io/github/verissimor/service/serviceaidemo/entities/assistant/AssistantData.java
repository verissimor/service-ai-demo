package io.github.verissimor.service.serviceaidemo.entities.assistant;

import java.util.List;

public record AssistantData(
        String id,
        List<ChatMessage> messages
) {}
