package guru.qa.homework.pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class Calendar {

    SelenideElement
            calendarClick = $(".react-datepicker__input-container"),
            month = $(".react-datepicker__month-select"),
            year = $(".react-datepicker__year-select");
    public String setTheDay(String varDay){
        String day = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", varDay);
        return day;
    }

    public void setCalendarDate(String Day, String Month, String Year){
        calendarClick.click();
        month.selectOption(Month);
        year.selectOption(Year);
        $(setTheDay(Day)).click();



    }
}
