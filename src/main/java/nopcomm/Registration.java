package nopcomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration extends Utils {
    LoadProps loadProps = new LoadProps();

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDrivers\\chromedriver.exe");
        //Open the Browser
        driver = new ChromeDriver();

        //Manage The Window Fullscreen
        driver.manage().window().fullscreen();

        //Set implicit Wait for driver object
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        implicitWait(10);

        //open the URL With Loadprops class  and testdataConfig file
        // driver.get("http://demo.nopcommerce.com/");
        driver.get(loadProps.getProperty("url"));

        //click on register button
        //driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
        clickElement(By.xpath("//a[@class = 'ico-register']"));

        //enter first name
        //driver.findElement(By.id("FirstName")).sendKeys("Vaibhav");
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));

        //enter last name
        //driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Shah");
        enterText((By.xpath("//input[@name='LastName']")), loadProps.getProperty("LastName"));

        //enter date of birth
        // Select select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //select.selectByVisibleText("5");
        selectByVisibleText(By.name("DateOfBirthDay"),"15");

        //Enter date of month
        // Select select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        // select.selectByVisibleText("March");
        selectByVisibleText(By.name("DateOfBirthMonth"),"May");

        // Enter year of birth
        // Select select = new Select(driver.findElement(By.name("DateOfBirthYear")));
        // select.selectByVisibleText("1999");
        selectByVisibleText(By.name("DateOfBirthYear"),"1999");

        //enter email
        // driver.findElement(By.name("Email")).sendKeys("testtest1" + randomDate() + "@test.com");
        enterText((By.name("Email")), "testtest1" + randomDate() + "@test.com");

        // enterText((By.name("Email")),loadProps.getProperty("Email"));
        //enter password
        // driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abcd1234");
        enterText(By.xpath("//input[@id='Password']"), loadProps.getProperty("Password"));

        //enter confirm password
        //driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("abcd1234");
        enterText(By.xpath("//input[@name='ConfirmPassword']"), loadProps.getProperty("ConfirmPassword"));
    }

    @Test (priority = 1)
    public void userShouldBeAbleToRegisterSuccessfully() {

        //click on register button
        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        clickElement(By.xpath(("//input[@id='register-button']")));

        //click on continue
        // driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
        clickElement(By.xpath("//input[@value=\"Continue\"]"));
    }

    @Test(priority = 2)
    public void userShouldBeAbleToReferAFriend() {

        //click on register button
        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        clickElement(By.xpath(("//input[@id='register-button']")));

        //click on continue
        // driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
        clickElement(By.xpath("//input[@value=\"Continue\"]"));

        //click on macbook page
        //driver.findElement((By.xpath("//h2//a[@href=\"/apple-macbook-pro-13-inch\"]"))).click();
        clickElement(By.xpath("//h2//a[@href=\"/apple-macbook-pro-13-inch\"]"));

        //click on enter friend
        // driver.findElement(By.xpath("//input[@value='Email a friend']")).click();
        clickElement(By.xpath("//input[@value='Email a friend']"));

        //enter friend email
        enterText(By.xpath("//input[@id='FriendEmail']"), loadProps.getProperty("FriendEmail"));

        //don't need to enter as automatic enter email as we enter random
        //enter your email
        //driver.findElement(By.xpath("//input[@id='YourEmailAddress']")).click();
        //entertext(By.xpath("//input[@id='YourEmailAddress']"));
        //clickelements(By.xpath("//input[@id='YourEmailAddress']"));

        //enter personal message
        enterText(By.xpath("//textarea[@placeholder='Enter personal message (optional).']"), loadProps.getProperty("EnterPersonalMessage"));

        //click on send email
        //driver.findElement((By.xpath("//input[@value=\"Send email\"]"))).click();
        clickElement(By.xpath("//input[@value=\"Send email\"]"));
    }

    @Test(priority = 3)
    public void userShouldBeAbleToNavigateCameraAndPhotoPage() {

        //click on register button
        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        clickElement(By.xpath(("//input[@id='register-button']")));

        //click on continue
        // driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
        clickElement(By.xpath("//input[@value=\"Continue\"]"));

        //click on electronics
        clickElement(By.xpath("//h2/a[@title=\"Show products in category Electronics\"] "));

        //click on camera and photo button
        clickElement(By.xpath("//h2/a[@title=\"Show products in category Camera & photo\"]"));

        //Assertion
        findAssertEquals(By.xpath("//h1"),"Camera & photo");
        //  String ActualMessage = "Camera & photo";
        //  String ExpectedMessage = driver.findElement(By.xpath("//h1")).getText();
        //  Assert.assertEquals(ExpectedMessage, ActualMessage);
    }
    @Test(priority = 4)
    public void userShouldBeAbleAddProductFromBookCategory() {

        //click on register button
        clickElement(By.xpath("//input[@id='register-button']"));

        //click on continue
        clickElement(By.xpath("//input[@value=\"Continue\"]"));

        //click on books category
        clickElement(By.linkText("Books"));

        //add to cart
        clickElement(By.xpath("//input[contains(@onclick,'37/1/1')]"));

        //click on books category
        clickElement(By.linkText("Books"));

        //click on another book
        clickElement(By.xpath("//input[contains(@onclick,'38/1/1')]"));

        //click on shopping cart
        clickElement(By.xpath("//span[@class=\"cart-label\"]"));

        //Assertion
        findAssertEquals(By.xpath("//span[@class=\"cart-label\"]"),"Shopping cart");
        //String ActualMassage = "Shopping cart";
        //String ExpectedMassage = driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).getText();
        //Assert.assertEquals(ExpectedMassage, ActualMassage);
    }
   @Test(priority = 5)
    public void userShouldBeAbleToSelectTheJewelleryProduct() {

        //click on register button
        clickElement(By.xpath("//input[@id='register-button']"));

        //click on continue
        clickElement(By.xpath("//input[@name='register-continue']"));

        //Navigate to jewellery
        clickElement(By.linkText("Jewelry"));

        //select price limit
        clickElement(By.xpath("//a[contains(@href,\"700-3000\")]"));

        //Assertion
       findAssertEquals(By.xpath("//span[@class='item']"),"$700.00 - $3,000.00");
        //check the Expected result
        //  String Expectedresult = "$700.00 - $3,000.00";

        //check the Actual result
        //  String Actualresult = driver.findElement(By.xpath("//span[@class='item']")).getText();
        //compare the result
        //  Assert.assertEquals(Actualresult, Expectedresult);
        //String Productprice = driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();
        //String price1 = String.valueOf(Productprice.replace("$", ""));
        //String price2 = String.valueOf(price1.replace(",", ""));
        //double price = Double.valueOf(price2);
        //check the result
        //Assert.assertTrue(price >= 700 && price <= 3000);

    }

        //After Method
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

















