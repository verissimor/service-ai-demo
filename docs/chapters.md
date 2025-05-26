000 - About the course

# Introduction
001 - Why traditional computing fail on simple tasks 
002 - Spring AI VS Native Library

# One-shot Prompt
003 - What is One-shot Prompt
004 - The Input and its parameters
005 - Choosing a LLM Provider and a model

# Retrieval, Tools & Prompt engineering
006 - Retrieval (RAG VS CAG)
007 - Adding Tool Calling
008 - Prompt engineering
**Quiz
009 - Avoiding Prompt Injection

# AI Workflow
010 - AI Workflows and How They Differ from Agents
**Quiz
011 - Workflow for Parsing Bills from CSV and PDF
012 - Add categories and suppliers in the workflow
013 - Add Support to PDF parsing
014 - PDF Processing with Image Extraction and Reasoning
**Quiz

# Agents & MCP
015 - Agent and MCP Integration Documentation
016 - Advanced Agents Overview

# Assistants
017 - Assistant Interaction
018 - Create a reactive end-point with tooling for assistant
019 - Front-End Assistant Code
020 - Code generation using V0

# Fine tunning
021 - Fine tunning a model


# Intro
000.1 Slides 0- About the course
000.2  Slides 1-6 Intro
000.3  Slides 7 - Why traditional computing fail on simple tasks -> Need reasoning
000.4a  Slides 8 - Spring AI VS Native Library -> Hibernate -> Flexibility VS Customization -> The curse will be using Spring AI, but, the concepts can be applied for both.

# One-shot Prompt
002 Slides 9 - 11 - What is One-shot Prompt
  Code: feat(categories): initial commit -> Show enviorment -> Show in Postman
  Code: feat(categories): add basic AI classification

003 Slides 13-15 - The Input
  https://platform.openai.com/playground/prompts?preset=pbJiNXXeLSsJ5NgK1GFhb67Z
  feat(categories): add maxTokens and temperature
  feat(categories): change to receive a list v1 -> Saving tokens
  feat(categories): change to receive a list v2

004 Slides 17-26 - Choosing a LLM Provider and a model

# Tools, Retrieval & Prompt engineering

006 Slides 27-33 - Retrieval (RAG VS CAG)

007 Slides 34-35 
  feat(categories): add tool to list categories
  feat(categories): add tool to create new categories -> The tests are failing, we will fix next section 

008 Slide 37 - Prompt engineering
  https://platform.openai.com/docs/guides/text?api-mode=responses#prompt-engineering
  https://learn.microsoft.com/en-us/azure/ai-services/openai/concepts/prompt-engineering?tabs=chat
  feat(categories): add tool to create new categories v2

009 Questioner: Does spaces count as a token? Yes they do. Trim spaces to save.

010 Slide 38 - Avoiding Prompt Injection
  feat(categories): fixed chain of command

# AI Workflow
011 Slide 39-43 - AI Workflow
  Questionaire: https://www.anthropic.com/engineering/building-effective-agents
  
012 Slide 44-45 - Parse bills from a csv
  feat(supplier): add supplier following same as category
  feat(bills): add bills parser
  feat(bills): add next.js front-end app to host the csv file

013 Slide 46 - Add categories and supppliers in the workflow
  feat(bills): include logic to parse categories and suppliers as a workflow

014 Slide 47 - Support PDF parsing
  feat(bills): add support for PDF parsing

015 Slide 48 - Use multi-modal and reasoning models
  feat(bills): add support multi-modal with Vision and leverage a reasoning model

# Agents & MCP

016 Slide 49-51 - Adding MCP and Creating an agent

017 Slide 52-53 - Advanced Agent Capabilities

# Assistant

018 Slide 55-58 Assistant overview

019 feat(assistant): create a reactive end-point with tooling for assistant

020 feat(assistant): creating the assistant front-end

021 V0

# Fine tunning

022 Slides 59-67 - Fine tunning a model -> show slides, then open OAI Dashboard and train -> explain the chart

023 feat(assistant): add fine-tuning model
