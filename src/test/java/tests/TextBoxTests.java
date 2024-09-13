package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Adam");
        $("#lastName").setValue("Brown");
        $("#userEmail").setValue("brown.adam@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("7908455879");
        $("#dateOfBirthInput").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#dateOfBirthInput").click();
        Selenide.executeJavaScript("document.getElementById('dateOfBirthInput').value=''");
        $("#dateOfBirthInput").setValue("01 Jul 1990").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("75 PARK PLACE 8TH FLOOR NEW YORK");
        $("#state").click();
        $("#react-select-3-input").setValue("Har").pressEnter();
        $("#city").scrollTo().click();
        $("#react-select-4-input").setValue("Karn").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-content").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Adam Brown"), text("brown.adam@gmail.com"),
                text("Male"), text("7908455879"), text("01 July,1990"), text("Computer Science"), text("Reading, Music"),
                text("cat.jpg"), text("75 PARK PLACE 8TH FLOOR NEW YORK"), text("Haryana Karnal"));

    }

}
