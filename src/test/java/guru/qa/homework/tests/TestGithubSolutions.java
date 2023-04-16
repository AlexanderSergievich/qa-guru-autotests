package guru.qa.homework.tests;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class TestGithubSolutions {
    @Test
    public void hoverSolutions(){
        open("https://github.com/");
        //1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        $(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $(byText("GitHub for enterprises")).sibling(0)
                .shouldHave(Condition.text("Build like the best"));
        sleep(5000);

    }
    @Test
    public void dragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //(опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // - Откройте https://the-internet.herokuapp.com/drag_and_drop
        // - Перенесите прямоугольник А на место В
        //actions().dragAndDropBy($("#column-a"),100,0).perform(); НЕ Работает, элемент переносится в место, где находится курсор
        /*actions().clickAndHold($("#column-a")).moveToElement($("#column-b"))
                .release().build().perform(); НЕ работает, элемент переносится в место, где находится курсор */
        //actions().dragAndDrop($("#column-a"), $("#column-b")).perform(); НЕ работает, элемент переносится в место, где находится курсор

    //Подскажите, почему вышеописанные варианты не работают?

        // - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDropTo($("#column-b")); //Работает
        $("#column-a").shouldHave(Condition.exactText("B"));
        $("#column-b").shouldHave(Condition.exactText("A"));
        sleep(5000);

    }
}
