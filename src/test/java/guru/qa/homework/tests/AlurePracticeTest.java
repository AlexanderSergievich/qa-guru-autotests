package guru.qa.homework.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;

public class AlurePracticeTest {
    String repo = "eroshenkoam/allure-example";
    int issueNumber = 81;
    @Test
    public void GitHubPageTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }



}
