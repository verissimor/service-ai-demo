'use client';

import ReactMarkdown from 'react-markdown';
import remarkGfm from 'remark-gfm';
import remarkBreaks from 'remark-breaks';

export const MarkdownDisplay = ({ value }) => {
  if (!value) return null;
  
  return (
    <div className="markdown-display">
      <ReactMarkdown remarkPlugins={[remarkGfm, remarkBreaks]}>{value}</ReactMarkdown>
    </div>
  );
};

export default MarkdownDisplay;
