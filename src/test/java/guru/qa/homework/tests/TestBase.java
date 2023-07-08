package guru.qa.homework.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.homework.helpers.Attach;
import guru.qa.homework.pages.PyePage;
import guru.qa.homework.pages.VicePage;
import guru.qa.homework.pages.WebFormRegistrationPage;
import guru.qa.homework.pages.components.Calendar;
import guru.qa.homework.pages.LiarsPage;
import guru.qa.homework.pages.GitHubPage;
import guru.qa.homework.steps.GitHubSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

public class TestBase {
    WebFormRegistrationPage registrationPage = new WebFormRegistrationPage();
    VicePage vicePage = new VicePage();
    LiarsPage liarsPage = new LiarsPage();
    PyePage pyePage = new PyePage();
    Calendar calendar = new Calendar();
    GitHubSteps gitHubSteps = new GitHubSteps();
    GitHubPage gitHubPage = new GitHubPage();


    @BeforeAll
    static void setConfiguration(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Configuration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
//    @AfterEach
//    public void closeBrowserAfterEachTest(){
//        Selenide.closeWebDriver();
//    }
}
