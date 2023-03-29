import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WebForm {
    @Test
    public void WebFormTest() {
        Configuration.holdBrowserOpen=true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Sergievich");
        $("#userEmail").setValue("stackinthecorner@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("+79650447812");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(byText("11")).click();
        //тут тест на subject
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/download.jpeg"));






    }
}
