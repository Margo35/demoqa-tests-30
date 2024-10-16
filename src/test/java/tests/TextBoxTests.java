package tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.RegistrationPage;
import tests.data.Gender;
import utils.RandomUtils;

public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils random = new RandomUtils();

    String
            firstName = random.getRandomFirstName(),
            lastName = random.getRandomLastName(),
            userEmail = random.getRandomUserEmail(),
            phoneNumber = random.getRandomPhoneNumber(),
            gender = random.getRandomGender(),
            dateOfBirth = random.getRandomBirthDate(),
            subjects = random.getRandomSubjects(),
            hobbies = random.getRandomHobbies(),
            picture = "cat.jpg",
            currentAddress = random.getRandomCurrentAddress(),
            state = random.getRandomState(),
            city = random.getRandomCity(state),
            resultGender = registrationPage.getResultGender(gender),
            //resultDateOfBirth = registrationPage.getResultDateOfBirth(dateOfBirth),
            resultHobbies = registrationPage.getResultHobbies(hobbies);

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    void successFillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setuserNumber(phoneNumber)
                .setDateOfBirth(dateOfBirth)
                .setGender(gender)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture()
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", resultGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dateOfBirth) //"01 July,1990"
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", resultHobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);

    }

    @Test
    void unSuccessFillFormTest() {


        registrationPage.openPage()
                .removeBanner()
                .clickSubmit()
                .modalDialogCheck();
    }


    @Test
    void requiredFieldsCheckTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setuserNumber(phoneNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", resultGender)
                .checkResult("Mobile", phoneNumber);

    }

    @ValueSource(strings = {
            "7904587489","7959614557","7916143111"
    })
    @ParameterizedTest(name = "Успешная регистрация под мобильным номером {0}")
    void successfulRegistrationWithDifferentMobileTest(String mobileNumber) {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setuserNumber(mobileNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", resultGender)
                .checkResult("Mobile", mobileNumber);
    }

    @CsvFileSource(resources = "/test_data/students.csv")
    @ParameterizedTest(name = "Успешная регистрация под студентом {0} {1}")
    void successfulRegistrationWithDifferentStudentsTest(String firstName,String lastName, String gender, String mobileNumber) {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setuserNumber(mobileNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", resultGender)
                .checkResult("Mobile", mobileNumber);
    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Успешная регистрация с гендером {0}")
    void successfulRegistrationWithDifferentGenderTest(Gender gender) {
        resultGender = registrationPage.getResultGender(gender.description);
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender.description)
                .setuserNumber(phoneNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", resultGender)
                .checkResult("Mobile", phoneNumber);
    }
}
