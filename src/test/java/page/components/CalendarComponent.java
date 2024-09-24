package page.components;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String date) {
        Selenide.executeJavaScript("document.getElementById('dateOfBirthInput').value=''");
        $("#dateOfBirthInput").setValue(date).pressEnter();
    }
}
