import MarkdownDisplay from "@/components/MarkdownDisplay";
import { UserOutlined } from "@ant-design/icons";

export const ChatUserMsg = ({ message }) => {
  return (
    <div className="flex flex-col space-y-2">
      <div className="flex justify-end">
        <div className="flex items-start max-w-[80%]">
          <div className="p-4 bg-white border border-gray-200 rounded-lg">
            <div className="text-gray-800">
              <MarkdownDisplay value={message?.content} />
            </div>
          </div>
          <div className="flex items-center justify-center text-gray-600 text-xs ml-2 flex-shrink-0">
          <div className="w-6 h-6 rounded-full bg-gray-700 flex items-center justify-center text-white text-xs mr-2 flex-shrink-0">
            <UserOutlined />
          </div>
          </div>
        </div>
      </div>
      <div className="flex justify-end">
        <div className="text-xs text-gray-400 pr-8">
          {message.createdAt.toLocaleString()}
        </div>
      </div>
    </div>
  );
};
