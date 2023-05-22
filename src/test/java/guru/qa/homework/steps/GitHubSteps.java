package guru.qa.homework.steps;
import guru.qa.homework.pages.components.GitHubPage;


public class GitHubSteps extends GitHubPage {
    @Step("Open github page")
    public GitHubSteps openGitHubPage(){
        GitHubPage.openPage();
        return this;
    }
    @Step("Search for repository")
    public GitHubSteps searchForRepository(String repo){
        GitHubPage.searchForRepository(repo);
        return this;
    }
    @Step("click on repository link")
    public GitHubSteps clickOnRepositoryLink(String repo){
        GitHubPage.clickOnRepositoryLink(repo);
        return this;
    }
    @Step("Click on issues tab")
    public GitHubSteps clickOnIssuesTab(){
        GitHubPage.openIssuesTab();
        return this;
    }
    @Step("Verify there is an issue with number")
    public GitHubSteps verifyTHereIsIssueWithNumber(int issue){
        GitHubPage.shouldSeeIssueWithNumber(issue);
        return this;
    }


}
