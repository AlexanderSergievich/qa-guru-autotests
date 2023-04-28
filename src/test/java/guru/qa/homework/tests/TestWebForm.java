package guru.qa.homework.tests;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;
import com.github.javafaker.*;
import guru.qa.homework.utils.RandomUtils;


public class TestWebForm extends TestBase {
    Faker data = new Faker();
    File fileJpeg = new File("src/test/resources/download.jpeg");
    String
            firstName = data.name().firstName(),
            lastName = data.name().lastName(),
            email = data.internet().emailAddress(),
            gender = RandomUtils.getRandomGender(),
            phoneNumber = data.numerify("##########"),
            birthDayMonth = RandomUtils.getRandomMonth(),
            birthDayYear = Integer.toString(data.number().numberBetween(2000,2022)),
            birthDayDate = Integer.toString(data.number().numberBetween(1,28)),
            subject = RandomUtils.getRandomSubject(),
            hobbies = RandomUtils.getRandomHobbie(),
            fileName = "download.jpeg",
            address = data.address().fullAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity(state);

    @Test
    public void testWebForm() {
        open();
        registrationPage.openPage()
                        .closeBanners()
                        .setLastName(lastName)
                        .setFirstName(firstName)
                        .chooseEmail(email)
                        .chooseGender(gender)
                        .setPhoneNumber(phoneNumber);
        calendar.setCalendarDate(birthDayDate, birthDayMonth, birthDayYear);
        registrationPage.setSubject(subject)
                        .chooseHobbie(hobbies)
                        .uploadPicture(fileJpeg)
                        .setAddress(address)
                        .chooseState(state)
                        .chooseCity(city)
                        .clickSubmit()
                //result assert
                        .verifyResult("Student Name", firstName+" "+lastName)
                        .verifyResult("Student Email",email)
                        .verifyResult("Gender",gender)
                        .verifyResult("Mobile", phoneNumber)
                        .verifyResult("Date of Birth", birthDayDate +" "+ birthDayMonth +","+ birthDayYear)
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("Picture",fileName)
                        .verifyResult("Address", address)
                        .verifyResult("State and City", state +" "+ city);
        registrationPage.clickCloseModal();
    }
}

