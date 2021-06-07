package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class successCycle extends TestBase {
    LoginPage loginObject ;
    @Test(priority=3,alwaysRun=true)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Complete the full order process Test Case")
    public void successCycle()
    {
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("standard_user","secret_sauce");
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Tester");
        driver.findElement(By.id("last-name")).sendKeys("Tester");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        WebElement successMessage = driver.findElement(By.id("checkout_complete_container"));
        Assert.assertTrue(successMessage.getText().contains("THANK YOU FOR YOUR ORDER"));

    }
}
