package guru.qa.homework.pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class Calendar {

    SelenideElement
            calendarClick = $(".react-datepicker__input-container"),
            monthDropDownList = $(".react-datepicker__month-select"),
            yearDropDownList = $(".react-datepicker__year-select");
    public String setTheDay(String varDay){
        String day = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", varDay);
        return day;
    }

    public void setCalendarDate(String day, String month, String year){
        calendarClick.click();
        monthDropDownList.selectOption(month);
        yearDropDownList.selectOption(year);
        $(setTheDay(day)).click();



    }
}
