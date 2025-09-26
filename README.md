 # Incubyte TDD Assessment - String Calculator

 This is a minimal Maven Java project that implements the **String Calculator** kata using TDD.

 ## How to run
 ```bash
 mvn -q test
 ```

 ## What is included
 - `StringCalculator` — implementation in `src/main/java`
 - `StringCalculatorTest` — JUnit 5 tests in `src/test/java`
 - `pom.xml` — Maven build

 ## Suggested TDD commit progression (what to commit and why)
 1. `test: return 0 for empty string` — Add failing test for empty string.
 2. `feat: support single number` — Make test pass for single number input.
 3. `test: add two numbers` — Add failing test for two numbers separated by comma.
 4. `feat: support multiple numbers and sum` — Implement summing logic.
 5. `test: allow newlines between numbers` — Add test for newline delimiter.
 6. `feat: support newlines and commas` — Make the test pass.
 7. `test: support custom delimiter` — Add failing test for custom delimiter (`//;\n1;2`).
 8. `feat: support custom delimiter` — Implement custom delimiter parsing.
 9. `test: negative numbers throw` — Add failing test expecting exception when negatives present.
10. `feat: throw on negatives (list all negatives in message)` — Implement negative detection & exception.
11. `refactor: cleanup parsing and add comments` — Refactor for readability.

 ## Notes
 - The tests check that negative numbers throw an `IllegalArgumentException` and that the message contains all negative values.
 - Feel free to extend and add features (ignore numbers > 1000, support multi-char delimiters, etc.)

 ## To submit
 1. Create a **public** GitHub repo (e.g. `incubyte-tdd-string-calculator`).
 2. Follow the commit progression above — aim for one small change per commit.
 3. Push and share the repo link with Incubyte.
