package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RandomUtils {

    Faker faker = new Faker();

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option("[for='gender-radio-1']", "[for='gender-radio-2']", "[for='gender-radio-3']");
    }

    public String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomBirthDate() {
        Faker faker = new Faker();
        // Генерируем случайную дату
        LocalDate localDate = faker.date().birthday(10, 70).toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        // Форматируем дату по формату "01 Jul 1990"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        return localDate.format(formatter);
    }

    public String getRandomSubjects() {
        return faker.options().option("Arts", "Computer Science", "Physics",  "Social Studies");
    }

    public String getRandomHobbies() {
        return faker.options().option("[for='hobbies-checkbox-1']", "[for='hobbies-checkbox-2']", "[for='hobbies-checkbox-3']");
    }

    public String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut" );
            case "Haryana" -> faker.options().option("Karnal", "Panipap");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }


}
