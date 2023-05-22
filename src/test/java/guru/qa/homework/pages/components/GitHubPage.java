package guru.qa.homework.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubPage {
    public static SelenideElement issuesTab = $("#issues-tab");
    public static SelenideElement searchInputElement = $(".header-search-input");

    public static void openPage(){
        open("https://github.com");
    }
    public static void searchForRepository(String repo){
        searchInputElement.click();
        searchInputElement.sendKeys(repo);
        searchInputElement.submit();
    }
    public static void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }
    public static void openIssuesTab() {
        issuesTab.click();
    }
    public static void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}
