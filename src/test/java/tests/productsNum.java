package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class productsNum extends TestBase

{
    LoginPage loginObject ;
    @Test(priority=2,alwaysRun=true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check the number of items in the cart Test Case")
    public void productsNum()
    {
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("standard_user","secret_sauce");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
        loginObject.UserLogin("standard_user","secret_sauce");
        WebElement items = driver.findElement(By.className("shopping_cart_badge"));
        String items_num = items.getText();
        System.out.println("Number of products in the cart is = "+ items_num);

    }

}
