"use client";

export const ChatInput = ({ input, handleSubmit, handleInputChange }) => {
  return (
    <div className="border-t border-gray-200 bg-white p-4">
      <div className="max-w-4xl mx-auto">
        <div className="relative rounded-xl shadow-sm">
          <form onSubmit={handleSubmit} className="mb-0">
            <input
              className="block w-full rounded-xl border-0 py-3 pl-4 pr-14 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-primary-500 sm:text-sm"
              value={input}
              placeholder="Ask me anything..."
              onChange={handleInputChange}
            />
          </form>
        </div>
        <div className="flex justify-center mt-2 text-xs text-gray-500">
          <span>
            <code className="px-1.5 py-0.5 bg-gray-100 text-gray-800 text-xs rounded border border-gray-200 font-mono mr-1">
              Shift+Enter for new line
            </code>

            <span>
              Start by typing what you need — like “Create a new payable for
              electricity” or “Find all receivables from last month”.
            </span>
          </span>
        </div>
      </div>
    </div>
  );
};
