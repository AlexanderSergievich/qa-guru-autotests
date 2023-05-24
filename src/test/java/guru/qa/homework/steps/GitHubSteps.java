package guru.qa.homework.steps;
import guru.qa.homework.pages.components.GitHubPage;
import io.qameta.allure.Step;


public class GitHubSteps {
    GitHubPage gitHubPage = new GitHubPage();
    @Step("Open github page")
    public GitHubSteps openGitHubPageStep(){
        gitHubPage.openPage();
        return this;
    }
    @Step("Search for repository")
    public GitHubSteps searchForRepositoryStep(String repo){
        gitHubPage.searchForRepository(repo);
        return this;
    }
    @Step("click on repository link")
    public GitHubSteps clickOnRepositoryLinkStep(String repo){
        gitHubPage.clickOnRepositoryLink(repo);
        return this;
    }
    @Step("Click on issues tab")
    public GitHubSteps clickOnIssuesTabStep(){
        gitHubPage.openIssuesTab();
        return this;
    }
    @Step("Verify there is an issue with number")
    public GitHubSteps verifyTHereIsIssueWithNumberStep(int issue){
        gitHubPage.shouldSeeIssueWithNumber(issue);
        return this;
    }
}
