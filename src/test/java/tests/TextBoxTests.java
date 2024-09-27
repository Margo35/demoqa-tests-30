package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
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
}
