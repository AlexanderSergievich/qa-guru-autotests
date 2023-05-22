package guru.qa.homework.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.homework.steps.GitHubSteps;
import org.junit.jupiter.api.Test;

public class AllurePracticeTest extends TestBase {
    String repo = "eroshenkoam/allure-example";
    int issueNumber = 81;
    @Test
    public void GitHubPageTest(){
        //SelenideLogger.addListener("allure", new AllureSelenide());
        gitHubSteps.openGitHubPageStep()
                .searchForRepositoryStep(repo)
                .clickOnRepositoryLinkStep(repo)
                .clickOnIssuesTabStep()
                .verifyTHereIsIssueWithNumberStep(issueNumber);

    }
}
