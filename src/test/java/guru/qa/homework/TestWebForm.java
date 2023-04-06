package guru.qa.homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestWebForm {
    @Test
    public void testWebForm() {
        //Настройка chrome
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        //Тесты
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Sergievich");
        $("#userEmail").setValue("stackinthecorner@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("879650447812");
        $("#dateOfBirthInput").scrollIntoView(true).click(); //на макбук 13" элементы слишком плотно расоложены друг. Корректно ли решать через scrollIntoView?
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(byText("11")).click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/download.jpeg"));
        $("#currentAddress").setValue("Tsotne dadiani 25");
        $("#react-select-3-input").scrollIntoView(true).setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();
        //Валидация значений и закрытие модального окна
        $(byText("Student Name")).sibling(0).shouldHave(Condition.text("Alexander Sergievich"));
        $(byText("Student Email")).sibling(0).shouldHave(Condition.text("stackinthecorner@gmail.com"));
        $(byText("Gender")).sibling(0).shouldHave(Condition.text("Female"));
        //здесь и далее по какой-то причине не получается найти элемент byText, почему так? Структура html идентична для всех таблицы.
        $(byTagName("tbody")).$$(byTagName("tr")).get(3).shouldHave(Condition.text("8796504478"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(4).shouldHave(Condition.text("11 March,1997"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(5).shouldHave(Condition.text("Physics"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(6).shouldHave(Condition.text("Music"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(7).shouldHave(Condition.text("download.jpeg"));
        $(byText("Address")).sibling(0).shouldHave(Condition.text("Tsotne dadiani 25"));
        $(byTagName("tbody")).$$(byTagName("tr")).get(9).shouldHave(Condition.text("Haryana Panipat"));
        $("#closeLargeModal").click();

    }
}

