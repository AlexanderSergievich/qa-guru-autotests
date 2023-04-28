package guru.qa.homework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class VicePage {
SelenideElement ChooselanguageButton = $("button[aria-label='language picker button']");



    public VicePage openPage(){
        open("https://www.vice.com/");
        return this;
    }
    public VicePage chooseLanguage(String language){
        ChooselanguageButton.click();
        $(byText(language)).click();
        return this;
    }
    public VicePage verifyLanguage(String language){
        ChooselanguageButton.find(byTagName("div")).shouldHave(Condition.text("+ " + language));
        return this;

    }
}
