package guru.qa.homework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

    public class PyePage {
        SelenideElement opticButton = $(byText("Оптика")),
                        everyGlassesButton = $("[href='https://pyeoptics.com/opravy-ochki-dlya-zreniya/vse-ochki-opravy']");



    public PyePage openSite(){
        open("https://pyeoptics.com/");
        return this;
    }
    public PyePage hoverOptics(){
        opticButton.hover();
        return this;
    }
    public PyePage selectEveryGlasses(){
        everyGlassesButton.click();
        return this;
        }
    public PyePage chooseGlasses(String model, String color) {
        $$(".common-card-product__info")
                .filter(Condition.text(model))
                .find(Condition.text(color))
                .click();
        return this;
    }
    public PyePage verifyGlasses(String expectedModel) {
        $(byText(expectedModel)).shouldHave(Condition.text(expectedModel));
        return this;
    }

    }
