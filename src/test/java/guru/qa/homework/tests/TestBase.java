package guru.qa.homework.tests;
import com.codeborne.selenide.Configuration;
import guru.qa.homework.pages.WebFormRegistrationPage;
import guru.qa.homework.pages.components.Calendar;
import org.junit.jupiter.api.BeforeAll;
public class TestBase {
    WebFormRegistrationPage registrationPage = new WebFormRegistrationPage();
    Calendar calendar = new Calendar();
    @BeforeAll
    static void setConfiguration(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

    }
}
