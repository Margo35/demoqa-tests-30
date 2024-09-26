package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Adam")
                .setLastName("Brown")
                .setUserEmail("brown.adam@gmail.com")
                .setuserNumber("7908455879")
                .setDateOfBirth("01 Jul 1990")
                .setGender()
                .setSubjects("Comp")
                .setHobbies()
                .setPicture()
                .setCurrentAddress("75 PARK PLACE 8TH FLOOR NEW YORK")
                .setStateAndCity("Har", "Karn")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Adam" + " " + "Brown")
                .checkResult("Student Email", "brown.adam@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7908455879")
                .checkResult("Date of Birth", "01 July,1990")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", "75 PARK PLACE 8TH FLOOR NEW YORK")
                .checkResult("State and City", "Haryana Karnal");

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
                .setFirstName("Adam")
                .setLastName("Brown")
                .setGender()
                .setuserNumber("7908455879")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Adam" + " " + "Brown")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7908455879");

    }
}
