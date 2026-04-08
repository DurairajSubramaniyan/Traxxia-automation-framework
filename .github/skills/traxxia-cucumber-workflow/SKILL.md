---
name: traxxia-cucumber-workflow
description: 'Add or update Traxxia Cucumber feature scenarios, Java step definitions, and page objects for kickstart, onboarding, priorities, and projects flows in this Maven automation repo. Use when editing `src/test/resources/features/traxxia/*.feature`, matching `*Steps.java` classes, or verifying regression behavior.'
argument-hint: 'Feature file, scenario, or step you want to add or update'
user-invocable: true
---

# Traxxia Cucumber Workflow

Use this skill when you need to change a Traxxia test flow end-to-end: Gherkin scenario, step definition, page object, and verification.

## Main Triggers
- Update `src/test/resources/features/traxxia/*.feature`
- Add or change step definitions under `src/test/java/com/anhtester/projects/traxxia/stepdefinitions/`
- Reuse or extend shared steps in `src/test/java/com/anhtester/common/CommonSteps.java`
- Adjust page-object logic in `src/test/java/com/anhtester/projects/traxxia/pages/`
- Verify kickstart-project, onboarding, collaborator-popup, or priorities behavior

## Repo Workflow

### 1) Find the existing implementation first
- Open the target `.feature` file and read the full scenario.
- Search for the exact Gherkin sentence in the step definition classes before adding a new one.
- Reuse the existing wording when possible to avoid duplicate Cucumber steps.

### 2) Decide where the step belongs
- **Shared navigation/login/welcome checks** → `com.anhtester.common.CommonSteps`
- **Traxxia business, priorities, kickstart, onboarding, projects behavior** → `com.anhtester.projects.traxxia.stepdefinitions.*`

> Rule: if the step is specific to the Traxxia business flow, do not put it in `CommonSteps`.

### 3) Keep step definitions thin
- Step classes should extend `TraxxiaPageManager`.
- Call page methods such as `getLoginPage()` or `getKickstartPage()`.
- Put Selenium locators, waits, retries, and assertions in the page class, not in the step method.

Current verified examples:
- `KickstartSteps.java` handles Gherkin bindings for login, business selection, priorities, and kickstart actions.
- `TraxxiaPageManager.java` exposes `getLoginPage()`, `getRegisterPage()`, and `getKickstartPage()`.

### 4) Update the page object if UI behavior changes
For Traxxia kickstart flows, use `KickstartPage.java` for:
- business creation
- execution/priorities navigation
- first/alternate priority selection
- collaborator warning popup actions
- success popup and Projects-page validation

### 5) Keep Gherkin readable
- Use one clear action/assertion per step.
- Prefer business-readable sentences over technical Selenium details.
- Match step text exactly between `.feature` and Java annotations.

Example pattern:
```gherkin
When User selects the first available priority
And User clicks Kickstart Projects
Then the collaborator warning popup should be displayed
```

### 6) Verify glue and tags still align
The Traxxia runner is `src/test/java/com/anhtester/runners/TraxxiaTestRunner.java` and currently loads:
- `com.anhtester.common`
- `com.anhtester.hooks`
- `com.anhtester.projects.traxxia.stepdefinitions`

Supported tags already configured in the runner:
- `@Regression`
- `@regression`
- `@Smoke`
- `@smoke`

## Decision Points

### If the exact step already exists
- Reuse the existing annotation text.
- Only update the underlying page method if behavior changed.

### If multiple scenarios need the same action
- Prefer a parameterized step over adding near-duplicate steps.

### If the app can follow two valid outcomes
- Encode the assertion to accept both outcomes only when the product truly allows both.
- Example already used in this repo: success popup **or** direct Projects page.

### If a locator is flaky
- Fix the page-object locator or wait strategy.
- Do not hide flaky behavior by adding sleeps to the feature or step wording.

## Completion Checklist
Before finishing, confirm all of the following:
- The `.feature` step text and the Java annotation text match exactly.
- No duplicate step definitions were introduced.
- Shared vs Traxxia-specific step placement is correct.
- Page-object methods contain the UI interaction logic.
- The scenario still uses meaningful tags such as `@Regression`.
- Relevant Maven/Cucumber verification has been run.

## Verification Commands
Use one of these after changes:

```powershell
mvn clean test -Dbrowser=chrome
```

If you only need the Traxxia suite, run the TestNG/Cucumber runner from the IDE:
- `TraxxiaTestRunner.java`

For reports:

```powershell
allure serve target/allure-results
```

## Example Requests
- `/traxxia-cucumber-workflow update kickstart-project.feature for second-priority kickstart behavior`
- `/traxxia-cucumber-workflow add a new shared login validation step`
- `/traxxia-cucumber-workflow trace a failing Traxxia step from feature file to page object`
