package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailImput = $("#userEmail"),
            gender = $("[for='gender-radio-1']"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            currentAddressInput = $("#currentAddress"),
            subjectsInput = $("#subjectsInput"),
            readingHobbiesCheckbox = $("[for='hobbies-checkbox-2']"),
            picture = $("#uploadPicture"),
            state = $("#state"),
            stateInput = $("#react-select-3-input"),
            city = $("#city"),
            cityInput = $("#react-select-4-input"),
            userForm = $("#userForm"),
            modalContent = $(".modal-content"),
            tableResponse = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailImput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        gender.click();
        return this;
    }

    public RegistrationPage setuserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String date) {
        dateOfBirthInput.click();
        calendarComponent.setDate(date);
        return this;
    }


    public RegistrationPage setSubjects(String value) {
        subjectsInput.click();
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        readingHobbiesCheckbox.click();
        return this;
    }

    public RegistrationPage setPicture() {
        picture.uploadFromClasspath("cat.jpg");
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String stateValue, String cityValue) {
        state.click();
        stateInput.setValue(stateValue).pressEnter();
        city.scrollTo().click();
        cityInput.setValue(cityValue).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmit() {
        $("#submit").scrollTo().click();
        return this;
    }

    public void visibleCheck() {
        userForm.shouldBe(visible);
    }

    public void resultCheck() {
        modalContent.should(appear);
        modalContent.shouldHave(text("Thanks for submitting the form"));
        tableResponse.shouldHave(text("Adam Brown"));
        tableResponse.shouldHave(text("brown.adam@gmail.com"));
        tableResponse.shouldHave(text("Male"));
        tableResponse.shouldHave(text("7908455879"));
        tableResponse.shouldHave(text("01 July,1990"));
        tableResponse.shouldHave(text("Computer Science"));
        tableResponse.shouldHave(text("Reading"));
        tableResponse.shouldHave(text("cat.jpg"));
        tableResponse.shouldHave(text("75 PARK PLACE 8TH FLOOR NEW YORK"));
        tableResponse.shouldHave(text("Haryana Karnal"));
    }


}
