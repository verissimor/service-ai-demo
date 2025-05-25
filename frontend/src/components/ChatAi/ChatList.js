import { ChatAssistantMsg } from './ChatList/ChatAssistantMsg';
import { ChatUserMsg } from './ChatList/ChatUserMsg';

export const ChatList = ({ messages }) => {
  return (
    <>
      <div className="flex-1 overflow-y-auto p-6 space-y-8 chat-container">
        {messages?.map((message, idx) => {
          if (message.role === 'user') {
            return <ChatUserMsg key={`ch${idx}`} message={message} />;
          }
          if (message.role === 'assistant') {
            return <ChatAssistantMsg key={`ch${idx}`} message={message} />;
          }

          return JSON.stringify(message)
        })}
      </div>
    </>
  );
};
