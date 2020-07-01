package tests;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestClass extends BaseClass {

    @Test
    public void makePaymentTest() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("usernameTextField")));
        getDriver().findElement(By.id("usernameTextField")).sendKeys("company");
        getDriver().findElement(By.id("passwordTextField")).sendKeys("company");
        getDriver().findElement(By.id("loginButton")).click();
        Boolean isLogoutButtonPresent = getDriver().findElement(By.id("logoutButton")).isDisplayed();
        assertTrue(isLogoutButtonPresent);

        getDriver().findElement(By.id("makePaymentButton")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.id("cancelButton")).click();
        getDriver().findElement(By.id("logoutButton")).click();

        Boolean isLoginButtonPresent = getDriver().findElement(By.id("loginButton")).isDisplayed();
        assertTrue(isLoginButtonPresent);
    }


}
