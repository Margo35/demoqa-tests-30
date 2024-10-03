package tests.data;

public enum Gender {
    MALE("[for='gender-radio-1']"),
    FEMALE("[for='gender-radio-2']"),
    OTHER("[for='gender-radio-3']");

    public final String description;

    Gender(String description) {
        this.description = description;
    }

}
