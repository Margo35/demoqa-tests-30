package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.ResultTable;

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
            modalContent = $(".modal-content"),
            modalDialog = $(".modal-dialog");

    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
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

    public void modalDialogCheck() {
        modalDialog.shouldNot(appear);
    }

    public RegistrationPage checkResult(String key, String value) {
        modalContent.should(appear);
        modalContent.shouldHave(text("Thanks for submitting the form"));

        new ResultTable().checkResult(key, value);
        return this;
    }


}
