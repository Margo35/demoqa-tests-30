package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillFormTest() {

        registrationPage.openPage().openPage()
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

    }

    @Test
    void unSuccessFillFormTest() {


        registrationPage.openPage()
                .setFirstName("Adam")
                .setLastName("Brown")
                .setUserEmail("brown.adam@gmail")
                .setuserNumber("7908455879")
                .setDateOfBirth("01 Jul 1990")
                .setGender()
                .setSubjects("Comp")
                .setHobbies()
                .setPicture()
                .setCurrentAddress("75 PARK PLACE 8TH FLOOR NEW YORK")
                .setStateAndCity("Har", "Karn")
                .clickSubmit().
                visibleCheck();
    }


    @Test
    void resultTableResponseCheck() {
        registrationPage.openPage()
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
                .clickSubmit()
                .resultCheck();
    }
}
