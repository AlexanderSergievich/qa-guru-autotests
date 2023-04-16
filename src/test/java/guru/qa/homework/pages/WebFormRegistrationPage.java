package guru.qa.homework.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static  com.codeborne.selenide.Selenide.*;

public class WebFormRegistrationPage {
    //SelenideElements, locators, etc
    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            pnoneNumber = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobbie = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submition = $("#submit"),
            closeModalButton = $("#closeLargeModal");


    //Файлы


    //Actions
    //для Для return this указывается название класа перед именем метода
    public WebFormRegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public WebFormRegistrationPage setFirstName(String name){
        firstName.setValue(name);
        return this;
    }
    public WebFormRegistrationPage setLastName(String lastname){
        lastName.setValue(lastname);
        return this;
    }
    public WebFormRegistrationPage setEmail(String mail){
        email.setValue(mail);
        return this;
    }
    public WebFormRegistrationPage setGender(String value){
        gender.$(byText(value)).click();
        return this;
    }
    public WebFormRegistrationPage setPhoneNumber(String number){
        pnoneNumber.setValue(number);
        return this;
    }
    public WebFormRegistrationPage setSubject(String Subject){
        subject.setValue(Subject).pressEnter();
        return this;
    }
    public WebFormRegistrationPage setHobbie(String value){
        hobbie.$(byText(value)).click();
        return this;
    }
    public WebFormRegistrationPage setPicture(File file){
        picture.uploadFile(file);
        return this;
    }
    public WebFormRegistrationPage setAddress(String Address){
        address.setValue(Address);
        return this;
    }
    public WebFormRegistrationPage setState(String State){
        state.scrollIntoView(true).setValue(State).pressEnter();
        return this;
    }
    public WebFormRegistrationPage setCity(String City){
        city.setValue(City).pressEnter();
        return this;
    }
    public WebFormRegistrationPage setSubmit(){
        submition.click();
        return this;
    }
    public WebFormRegistrationPage verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(Condition.text(value));
        return  this;


    }
    public WebFormRegistrationPage setCloseModal(){
        closeModalButton.click();
        return this;
    }


}
