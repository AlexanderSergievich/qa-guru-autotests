package guru.qa.homework.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LiarsPage {
    SelenideElement addToCartButton = $(".js-store-prod-popup-buy-btn-txt"),
                    goToCartButton = $("a[href='/cart']");
    public LiarsPage openPageWithJacket(){
        open("https://liars.co/clothes/tproduct/549564739-844922253131-jacket-3-pockets");
        return this;
    }
    public LiarsPage chooseSize(String size){
        $("input[value="+size+"]").parent().click();
        return this;
    }
    public LiarsPage addToCart(){
        addToCartButton.click();
        return this;
    }
    public LiarsPage goToCart() {
        executeJavaScript("arguments[0].click()", goToCartButton);
        return this;
    }
    public LiarsPage verifySizeInOrder(String size) {
        $(byText("Размер: "+size+"")).shouldHave(Condition.text("Размер: "+size+""));
        return this;
    }
}
