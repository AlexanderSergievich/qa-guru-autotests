package guru.qa.homework.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.homework.steps.GitHubSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AllurePracticeTest extends TestBase {
    String repo = "eroshenkoam/allure-example";
    int issueNumber = 81;
    @Test
    public void GitHubListenerPageTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        gitHubPage.openPage()
                .searchForRepository(repo)
                .clickOnRepositoryLink(repo)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(issueNumber);


    }
    @Test
    public void GitHubStepsPageTest(){
        gitHubSteps.openGitHubPageStep()
                    .searchForRepositoryStep(repo)
                    .clickOnRepositoryLinkStep(repo)
                    .clickOnIssuesTabStep()
                    .verifyTHereIsIssueWithNumberStep(issueNumber);

    }
    @Test
    public void GitHubLambdaPageTest(){

    }
}
