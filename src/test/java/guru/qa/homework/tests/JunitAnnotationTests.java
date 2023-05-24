package guru.qa.homework.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class JunitAnnotationTests extends TestBase {
    @CsvSource({
        "English, English",
        "Deutsch, Deutsch",
        "Español, Español"})
    @ParameterizedTest(name = "после выбора языка: {0} язык меняется на: {1}")
    public void viceSiteTest(String language, String expectedLanguage){
        vicePage.openPage()
                .chooseLanguage(language)
                .verifyLanguage(expectedLanguage);
    }
    @CsvFileSource(resources ="/LiarsCollectionTestData.csv")
    @ParameterizedTest(name = "после добавления в корзину куртки с размером: {0} в заказе отображается куртка с размером {1}")
    public void liarsSiteTest(String size, String expectedSize){
        liarsPage.openPageWithJacket()
                .chooseSize(size)
                .addToCart()
                .goToCart()
                .verifySizeInOrder(expectedSize);
    }
    static Stream<Arguments> pyeSiteTest(){
        return Stream.of(
                Arguments.of("Dita 2.0", "Milky Nude"), //ищет
                Arguments.of("Mason", "Salted caramel"), //ищет
                Arguments.of("Pye x Avgvst Orbital", "Wine"), //не ищет
                Arguments.of("Pye x Avgvst Orbital", "State"), //не ищет
                Arguments.of("Dita 2.0", "Milky Green"), // не ищет
                Arguments.of("Ethel", "Chillaxin"), //ищет
                Arguments.of("Ethel", "Wine"), //не ищет
                Arguments.of("Naiton", "WG"), //ищет
                Arguments.of("Naiton", "GM")//не ищет
        );
    }
    @MethodSource
    @ParameterizedTest
    public void pyeSiteTest(String model, String color){
        pyePage.openSite()
                .hoverOptics()
                .selectEveryGlasses()
                .chooseGlasses(model,color)
                .verifyGlasses(model+" "+color);
    }
}
