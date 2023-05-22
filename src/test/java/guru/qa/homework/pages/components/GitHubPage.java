package guru.qa.homework.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubPage {
    SelenideElement issuesTab = $("#issues-tab");
    SelenideElement searchInputElement = $(".header-search-input");

    public GitHubPage openPage(){
        open("https://github.com");
        return this;
    }
    public GitHubPage searchForRepository(String repo){
        searchInputElement.click();
        searchInputElement.sendKeys(repo);
        searchInputElement.submit();
        return this;
    }
    public GitHubPage clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
        return this;
    }
    public GitHubPage openIssuesTab() {
        issuesTab.click();
        return this;
    }
    public GitHubPage shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }

}
