package guru.qa.homework;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static  com.codeborne.selenide.Selenide.*;

public class TestSelenideGithub {
    @Test
    void checkIfThereIsCodeForJunit(){
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $(byText("SoftAssertions")).shouldBe(Condition.visible).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").scrollIntoView(true)
                .parent().closest("div").should(Condition.visible);
        sleep(5000);
    }
}
