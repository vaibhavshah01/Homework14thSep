package nopcomm;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.IO;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    private static IO FileUtils;
    //Element To Be Clickable
    public static void waitForClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // Visibility of All Elements Located
    public static void waitForElementVisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    // Alert is Present
    public static void waitForAlertPresent(long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    // Enter Text (SendKeys)
    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // Click The Element (Click)
    public void clickLocaor(By by) {
        driver.findElement(by).click();
    }

    // Clear The Element (Clear)
    public void clearLocator(By by){
        driver.findElement(by).clear();
    }

    //Clear Element and Add Text (Clear,SendKeys)
    public void clearLocatorAndText(By by,String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //drop down method
    //Select By Visible Text
    public static void selectByVisibleText(By by,String text){
        Select select= new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //Select By Value
    public void selectByValue(By by,String value){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(value);
        select.getFirstSelectedOption();
    }
    // Generate Email
    public String generateemail(){
        return "ram" + randomDate()+ "gmail.com";
    }

    // Get Options
    public void dropdownprence(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.getOptions();
    }
    // Get Attribute
    public String getattribute(By by, String text){
        return driver.findElement(by).getAttribute(text);
    }

    // Is Displayed
    public boolean isElementVisible(By by){
        return driver.findElement(by).isDisplayed();
    }

    //Calender get time
    public static Date formatDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth, 0, 0, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    //Is Enabled
    public boolean ifwebelementisenableornot(By by){
        return driver.findElement(by).isEnabled();
    }

    // Get Location
    public boolean getLocation(By by){
        Point location = driver.findElement(by).getLocation();
        return false;
    }
    //Get CSS Value
    public void getCSSValue(By by,String text){
        driver.findElement(by).getCssValue(text);
    }

    //Implicit Wait
    public void implicitWait(long time){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void clickElement(By by){
        driver.findElement(by).click();
    }

    // Randon Date
    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }
    //Assert Equal
    public void findAssertEquals(By by,String text){
        String ActualMessage = text;
        String ExpectedMessage = driver.findElement(by).getText();
        Assert.assertEquals(ExpectedMessage, ActualMessage);
    }





}