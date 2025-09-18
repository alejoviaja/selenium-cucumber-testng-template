package org.selenium.architecture.stepsdefs;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class UserCreationStepDef {

    private WebDriver driver;
    private UserCreationPage userCreationPage;
    private RegistrationSucessfulPage registrationSucessfulPage;


    @Before
    public void driverSetup() {
        DriverManager.createDriver("chrome");
    }

    @Given("the user goes to the booking portal")
    public void the_user_goes_to_the_booking_portal() {
        DriverManager.getDriver().get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        userCreationPage = new UserCreationPage(DriverManager.getDriver());
    }
    @When("fills out the personal data {string} and {string}")
    public void fills_out_the_personal_data_and(String firstName, String lastName) {
        userCreationPage.fillOutFirstName(firstName);
        userCreationPage.fillOutLastName(lastName);
    }
    @When("personal address {string} {string} {string} {string} {string} {string}")
    public void personal_address(String email, String password ,String street, String city, String state, String zipcode) {
        userCreationPage.fillOutEmail(email);
        userCreationPage.fillOutPassword(password);
        userCreationPage.fillOutStreet(street);
        userCreationPage.fillOutCity(city);
        userCreationPage.fillOutState(state);
        userCreationPage.fillOutZipCode(zipcode);
        userCreationPage.fillOutRegisterButton();
    }

    @Then("a successful header should appear")
    public void a_successful_header_should_appear(){
        RegistrationSucessfulPage registrationSucessfulPage = new RegistrationSucessfulPage(DriverManager.getDriver());
        Assert.assertTrue(registrationSucessfulPage.isRegistryConfirmationTitleVisible());
        Assert.assertTrue(registrationSucessfulPage.isGetRegistryConfirmDescriptionVisible());
    }

    @After
    public void closeDriver() {
        DriverManager.quitDriver();
    }

}
