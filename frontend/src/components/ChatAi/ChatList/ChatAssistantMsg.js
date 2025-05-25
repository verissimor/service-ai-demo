import { RobotFilled } from '@ant-design/icons';
import MarkdownDisplay from '@/components/MarkdownDisplay';


export const ChatAssistantMsg = ({ message }) => {
  return (
    <div className="flex flex-col space-y-2">
      <div className="flex justify-start">
        <div className="flex items-start max-w-[80%]">
          <div className="w-6 h-6 rounded-full bg-gray-700 flex items-center justify-center text-white text-xs mr-2 flex-shrink-0">
            <RobotFilled />
          </div>
          <div className="p-4 bg-white border border-gray-200 rounded-lg">
            <div className="text-gray-700">
              <MarkdownDisplay value={message?.content} />
            </div>
          </div>
        </div>
      </div>
      <div className="flex justify-start">
        <div className="text-xs text-gray-400 pl-8">
          {message.createdAt.toLocaleString()}
        </div>
      </div>
    </div>
  );
};
