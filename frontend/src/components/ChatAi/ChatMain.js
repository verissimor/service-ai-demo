"use client";

import { useChat } from "@ai-sdk/react";
import { ChatInput } from "./ChatInput";
import { ChatList } from "./ChatList";

export const ChatMain = () => {
  const { messages, input, handleInputChange, handleSubmit } = useChat({
    api: `http://localhost:8080/assistant/messages/ed666c21-790e-47f8-bf5b-0155196b15a6`,
    streamProtocol: "text",
  });

  return (
    <div className="bg-gray-50 text-gray-800 flex flex-col h-full">
      <div className="flex h-[calc(100vh-4rem)] overflow-hidden">
        <div className="flex-1 flex flex-col overflow-auto">
          <div className="flex-1 overflow-y-auto p-4 md:p-6 bg-gray-50 scrollbar-hide">
            <div className="max-w-4xl mx-auto">
              <div className="flex items-start mb-8">
                <ChatList messages={messages} />
              </div>
            </div>
          </div>

          <ChatInput
            handleSubmit={handleSubmit}
            input={input}
            handleInputChange={handleInputChange}
          />
        </div>
      </div>
    </div>
  );
};
