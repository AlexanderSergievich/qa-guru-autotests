package guru.qa.homework.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AllurePracticeTest extends TestBase {
    String repo = "eroshenkoam/allure-example";
    int issueNumber = 81;
    String check = "asdfasdf";
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
        step("Open github page", () -> {
            gitHubPage.openPage();
        });
        step("Search for repository", () -> {
            gitHubPage.searchForRepository(repo);
        });
        step("click on repository link", () -> {
            gitHubPage.clickOnRepositoryLink(repo);
        });
        step("Click on issues tab", () -> {
            gitHubPage.openIssuesTab();
        });
        step("Verify there is an issue with number", () -> {
            gitHubPage.shouldSeeIssueWithNumber(issueNumber);
        });
    }
}
