package org.selenium.architecture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationSucessfulPage {

    private WebDriver driver;

    private By registryConfirmTitle = By.xpath("//h2[contains(text(),'Registration Confirmation')]");
    private By registryConfirmDescription = By.xpath("//*[@id='registration-confirmation-section']//following-sibling::p");


    public RegistrationSucessfulPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isRegistryConfirmationTitleVisible() {
        WebElement registrationConfirmationTitle = driver.findElement(registryConfirmTitle);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> registrationConfirmationTitle.isDisplayed());
        return driver.findElement(this.registryConfirmTitle).isDisplayed();
    }

    public  boolean isGetRegistryConfirmDescriptionVisible() {
        WebElement getRegistryConfirmDescription = driver.findElement(registryConfirmDescription);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> getRegistryConfirmDescription.isDisplayed());
        return driver.findElement(this.registryConfirmDescription).isDisplayed();
    }




}
