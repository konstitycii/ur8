package utils;

import com.github.javafaker.Faker;

public class TestDataRandomUtil {

    private final Faker faker = new Faker();

    public String getFirstName() {
        return faker.name().firstName();
    }
ф
    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getMobileNumber() {
        return faker.number().digits(10); // Генерация 10-значного номера телефона
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

    public String getRandomSubject() {
        return faker.options().option("Maths", "Physics", "Chemistry", "English", "Biology");
    }

    public String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String[] getDateOfBirthParts() {
        int day = faker.number().numberBetween(1, 28); // День от 1 до 28
        String month = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        int year = faker.number().numberBetween(1900, 2023); // Год от 1900 до 2023
        return new String[]{String.valueOf(day), month, String.valueOf(year)};
    }
}
