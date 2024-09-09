package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests {

    File file = new File("C:\\Users\\pulda\\Desktop\\qa_guru\\cat.jpg");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //sleep(30000);
        $("#firstName").setValue("Adam");
        $("#lastName").setValue("Brown");
        $("#userEmail").setValue("brown.adam@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("79084558790");
        $("#dateOfBirthInput").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        Selenide.executeJavaScript("document.getElementById('dateOfBirthInput').value='';");
        $("#dateOfBirthInput").setValue("01 Jul 1990").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("75 PARK PLACE 8TH FLOOR NEW YORK");
        $("#state").scrollTo().click();
        $("#react-select-3-input").setValue("Har").pressEnter();
        $("#city").scrollTo().click();
        $("#react-select-4-input").setValue("Karn").pressEnter();
        $("#submit").scrollTo().click();

    }

}
