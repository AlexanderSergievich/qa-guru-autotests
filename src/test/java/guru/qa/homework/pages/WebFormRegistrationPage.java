package guru.qa.homework.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static  com.codeborne.selenide.Selenide.*;

public class WebFormRegistrationPage {
    //SelenideElements, locators, etc
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            pnoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesRadioButton = $("#hobbiesWrapper"),
            pictureFileInputButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropDownList = $("#react-select-3-input"),
            cityDropDownList = $("#react-select-4-input"),
            submitionButton = $("#submit"),
            closeModalButton = $("#closeLargeModal");


    //Файлы


    //Actions
    //для Для return this указывается название класа перед именем метода
    public WebFormRegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public WebFormRegistrationPage closeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public WebFormRegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }
    public WebFormRegistrationPage setLastName(String lastname){
        lastNameInput.setValue(lastname);
        return this;
    }
    public WebFormRegistrationPage chooseEmail(String mail){
        emailInput.setValue(mail);
        return this;
    }
    public WebFormRegistrationPage chooseGender(String value){
        genderRadioButton.$(byText(value)).click();
        return this;
    }
    public WebFormRegistrationPage setPhoneNumber(String number){
        pnoneNumberInput.setValue(number);
        return this;
    }
    public WebFormRegistrationPage setSubject(String subject){
        subjectInput.setValue(subject).pressEnter();
        return this;
    }
    public WebFormRegistrationPage chooseHobbie(String value){
        hobbiesRadioButton.$(byText(value)).click();
        return this;
    }
    public WebFormRegistrationPage uploadPicture(File file){
        pictureFileInputButton.uploadFile(file);
        return this;
    }
    public WebFormRegistrationPage setAddress(String address){
        addressInput.setValue(address);
        return this;
    }
    public WebFormRegistrationPage chooseState(String state){
        stateDropDownList.scrollIntoView(true).setValue(state).pressEnter();
        return this;
    }
    public WebFormRegistrationPage chooseCity(String city){
        cityDropDownList.setValue(city).pressEnter();
        return this;
    }
    public WebFormRegistrationPage clickSubmit(){
        submitionButton.click();
        return this;
    }
    public WebFormRegistrationPage verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(Condition.text(value));
        return  this;


    }
    public WebFormRegistrationPage clickCloseModal(){
        closeModalButton.click();
        return this;
    }


}
