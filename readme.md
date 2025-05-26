# Spring AI: Creating Workflows, Agents and Parsing Data

> Note: I am the instructor of this course, and this repository provides the source code and resources referenced throughout the lessons.

[link1: Access the course on Udemy](https://www.udemy.com/course/draft/6621689/?referralCode=1516172763BF199C6907)

## About this Project

This repository contains the complete source code for the following core topics covered in the course:

1. Develop AI-driven workflows
2. Build autonomous AI agents
3. Create an AI Assistant
4. Implement advanced data parsing

In addition, you will find a `docs` folder, which includes:

* Slides from the course
* A summary of the course, including all lectures and times
* Images such as the Spring Initializr page and related illustrations

## Running the Project

1. First, obtain your OpenAI API key by visiting [https://platform.openai.com/api-keys](https://platform.openai.com/api-keys).
2. Set the following environment variable in your terminal or configuration:

   ```sh
   export SPRING_AI_OPENAI_API_KEY=your_openai_api_key
   ```

   Replace `your_openai_api_key` with the key you generated in step 1.
3. Start the Spring Boot application with the default command:

   ```sh
   ./mvnw spring-boot:run
   ```

   Or, if you are using Gradle:

   ```sh
   ./gradlew bootRun
   ```

## Running Tests

To execute the tests for this project, run the following command:

```sh
./gradlew test
```

# Front-end

This project carries a `Next.JS` front-end that works as a server for csv/pdf files and the AI assistant web-app.

To start the front-end run:
```shell
npm install
npm run dev
```

Then you can access through: http://localhost:3000

The original command to install the front-end was:

```shell
npx create-next-app@latest
# What is your project named? … frontend
# Would you like to use TypeScript? No
# Would you like to use ESLint? Yes
# Would you like to use Tailwind CSS? Yes
# Would you like your code inside a `src/` directory? Yes
# Would you like to use App Router? Yes
# Would you like to use Turbopack for `next dev`? Yes
# Would you like to customize the import alias (`@/*` by default)? No
```
