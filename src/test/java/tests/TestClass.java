package tests;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestClass extends BaseClass {

    @Test
    public void loginTest() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("usernameTextField")));
        getDriver().findElement(By.id("usernameTextField")).sendKeys("company");
        getDriver().findElement(By.id("passwordTextField")).sendKeys("company");
        getDriver().findElement(By.id("loginButton")).click();
        Boolean isPresent = getDriver().findElement(By.id("logoutButton")).isDisplayed();
        assertTrue(isPresent);
    }

    @Test(dependsOnMethods = "loginTest")
    public void makePayment() {
        getDriver().findElement(By.id("Make Payment")).click();
//        getDriver().findElement(By.id("phoneTextField")).sendKeys("3479350000");
//        getDriver().findElement(By.id("nameTet"))
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "makePayment")
    public void logOut() {
        getDriver().findElement(By.id("cancelButton")).click();
        getDriver().findElement(By.id("logoutButton")).click();
        Boolean isPresent = getDriver().findElement(By.id("loginButton")).isDisplayed();
        assertTrue(isPresent);
    }

}
