package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.TestDataGenerator;

public class PracticeFormTest {

    private final TestDataGenerator testData = new TestDataGenerator();

    private final String firstName = testData.getFirstName(),
            lastName = testData.getLastName(),
            email = testData.getEmail(),
            gender = testData.getGender(),
            mobile = testData.getMobileNumber(),
            dayOfBirth = "15",
            monthOfBirth = "May",
            yearOfBirth = "1990",
            picture = "i.webp",
            hobby=testData.getRandomHobby(),
            subject=testData.getRandomSubject(),
            address = testData.getAddress(),
            state = testData.getState(),
            city = testData.getCity(state);

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void fillAndSubmitFullFormTest() {
        PracticeFormPage formPage = new PracticeFormPage();

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setMobile(mobile)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .selectHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .selectStateAndCity(state, city)
                .submitForm();

        // Проверяем результаты
        formPage.verifyModalTitle("Thanks for submitting the form");
        formPage.verifySubmittedData("Student Name", firstName + " " + lastName);
        formPage.verifySubmittedData("Student Email", email);
        formPage.verifySubmittedData("Gender", gender);
        formPage.verifySubmittedData("Mobile", mobile);
        formPage.verifySubmittedData("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        formPage.verifySubmittedData("Subjects", subject);
        formPage.verifySubmittedData("Hobbies", hobby);
        formPage.verifySubmittedData("Picture", picture);
        formPage.verifySubmittedData("Address", address);
        formPage.verifySubmittedData("State and City", state + " " + city);
    }
}