package org.selenium.architecture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserCreationPage {
    private WebDriver driver;

    //By Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By street = By.name("street");
    private By city = By.name("city");
    private By stateSelect = By.id("inputState");
    private By zipCode = By.name("zip");
    private By registerButton = By.id("register-btn");


    //Constructor
    public UserCreationPage(WebDriver driver) {
        this.driver = driver;
    }


    //Component Interactions

    public void fillOutFirstName(String firstNameSTR) {
        WebElement firstName = driver.findElement(this.firstName);
        firstName.sendKeys(firstNameSTR);
    }

    public void fillOutLastName(String lastNameSTR) {
        WebElement lastName = driver.findElement(this.lastName);
        lastName.sendKeys(lastNameSTR);
    }

    public void fillOutEmail(String emailSTR) {
        WebElement email = driver.findElement(this.email);
        email.sendKeys(emailSTR);
    }

    public void fillOutPassword(String passwordSTR) {
        WebElement password = driver.findElement(this.password);
        password.sendKeys(passwordSTR);
    }

    public void fillOutStreet(String streetSTR) {
        WebElement street = driver.findElement(this.street);
        street.sendKeys(streetSTR);
    }

    public void fillOutCity(String citySTR) {
        WebElement city = driver.findElement(this.city);
        city.sendKeys(citySTR);
    }

    public void fillOutState(String stateSTR) {
        WebElement state = driver.findElement(this.stateSelect);
        state.sendKeys(stateSTR);
    }

    public void fillOutZipCode(String zipCodeSTR) {
        WebElement zip = driver.findElement(this.zipCode);
        zip.sendKeys(zipCodeSTR);
    }

    public void fillOutRegisterButton() {
        WebElement registerButton = driver.findElement(this.registerButton);
        registerButton.click();
    }

}
