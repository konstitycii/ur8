package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.TestDataRandomUtil;

public class PracticeFormTest {

    private final TestDataRandomUtil testData = new TestDataRandomUtil();

    String firstName = testData.getFirstName();
    String lastName = testData.getLastName();
    String email = testData.getEmail();
    String gender = testData.getGender();
    String mobile = testData.getMobileNumber();
    String[] dateOfBirthParts = testData.getDateOfBirthParts();
    String subject = testData.getRandomSubject();
    String picture="i.webp";
    String hobby = testData.getRandomHobby();
    String address = testData.getAddress();
    String state = testData.getState();
    String city = testData.getCity(state);

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
                .setDateOfBirth(dateOfBirthParts[0], dateOfBirthParts[1], dateOfBirthParts[2])
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
        formPage.verifySubmittedData("Date of Birth", dateOfBirthParts[0] + " " + dateOfBirthParts[1] + "," + dateOfBirthParts[2]);
        formPage.verifySubmittedData("Subjects", subject);
        formPage.verifySubmittedData("Hobbies", hobby);
        formPage.verifySubmittedData("Picture", picture);
        formPage.verifySubmittedData("Address", address);
        formPage.verifySubmittedData("State and City", state + " " + city);
    }
}
