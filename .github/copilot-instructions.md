# Traxxia Automation Framework

Maven + Selenium + Cucumber 7 + TestNG automation suite targeting the Traxxia web app. Java 17.

## Build and Test

```bash
mvn clean test                          # run default suite
mvn clean test -Dbrowser=chrome         # chrome | edge | firefox
mvn clean test -Dbrowser=edge
allure serve target/allure-results      # open Allure report
```

Suite XML: `src/test/resources/suites/SuiteTraxxia.xml`  
Runner: `src/test/java/com/anhtester/runners/TraxxiaTestRunner.java`

## Architecture

| Area | Location |
|------|----------|
| Feature files | `src/test/resources/features/traxxia/*.feature` |
| Step definitions | `src/test/java/com/anhtester/projects/traxxia/stepdefinitions/` |
| Page objects | `src/test/java/com/anhtester/projects/traxxia/pages/` |
| Shared steps | `src/test/java/com/anhtester/common/CommonSteps.java` |
| Page manager base | `src/test/java/com/anhtester/common/TraxxiaPageManager.java` |
| Hooks (before/after) | `src/test/java/com/anhtester/hooks/Hooks.java` |
| WebUI keywords | `src/main/java/com/anhtester/keywords/` |
| Framework utilities | `src/main/java/com/anhtester/utils/`, `helpers/` |
| Config properties | `src/test/resources/config/config.properties` |

## Conventions

**Step definitions** must extend `TraxxiaPageManager` (lazy page access via `getLoginPage()`, `getKickstartPage()`, etc.). Do not instantiate pages directly inside step classes.

**Glue packages** must declare all three in the runner `@CucumberOptions`:
```java
glue = { "com.anhtester.common", "com.anhtester.hooks", "com.anhtester.projects.traxxia.stepdefinitions" }
```

**Shared steps** (navigation, sign-out, common assertions) live in `CommonSteps.java`. Do not duplicate them in project-specific step defs.

**Cucumber tags**: `@Regression`, `@Smoke`, `@testing` — filter in the runner `tags` field.

**Parallel execution**: Enabled via `@DataProvider(parallel = true)` on the runner's `scenarios()` method. Keep step defs stateless; driver is stored in `DriverManager` (ThreadLocal).

**Email reports**: Configured via environment variables only — no credentials in code:
- `TRAXXIA_EMAIL_FROM` — sender Gmail address  
- `TRAXXIA_EMAIL_PASSWORD` — Gmail App Password (spaces are auto-stripped)  
- `TRAXXIA_EMAIL_TO` — comma-separated recipient addresses  
Missing any of these throws `IllegalStateException` at the start of the run.

## Skill

Use the `traxxia-cucumber-workflow` skill when adding or updating feature scenarios, step definitions, or page objects. See `.github/skills/traxxia-cucumber-workflow/SKILL.md`.
