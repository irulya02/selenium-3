import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class Registration {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @Test
    public void checkRegistration() {
        WebElement textRegistration = driver.findElement(By.tagName("h1"));
        assertEquals("Registration", textRegistration.getText());

    }

    @Test
    public void inputAllFields() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        WebElement inputLastName = driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        WebElement inputEmail = driver.findElement(By.xpath("//input[@placeholder='Input your email']"));
        WebElement inputPhone = driver.findElement(By.xpath("//input[@placeholder='Input your phone:']"));
        WebElement inputAddress = driver.findElement(By.xpath("//input[@placeholder='Input your address:']"));
        WebElement submitButton = driver.findElement(By.tagName("button"));
        inputFirstName.sendKeys("John");
        inputLastName.sendKeys("Show");
        inputEmail.sendKeys("jdkkksjj@mail.com");
        inputPhone.sendKeys("+9845738472866");
        inputAddress.sendKeys("Victory Avenu,23");
        submitButton.click();
        sleep(10000);

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", header.getText());

    }
     @Test
    public void withoutFirstName() throws InterruptedException {
      WebElement inputFirstName = driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
    WebElement inputLastName = driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
    WebElement inputEmail = driver.findElement(By.xpath("//input[@placeholder='Input your email']"));
    WebElement inputPhone = driver.findElement(By.xpath("//input[@placeholder='Input your phone:']"));
    WebElement inputAddress = driver.findElement(By.xpath("//input[@placeholder='Input your address:']"));
    WebElement submitButton = driver.findElement(By.tagName("button"));
    inputFirstName.sendKeys("");
    inputLastName.sendKeys("Show");
    inputEmail.sendKeys("jdkkksjj@mail.com");
    inputPhone.sendKeys("+9845738472866");
    inputAddress.sendKeys("Victory Avenu,23");
    submitButton.click();
    sleep(10000);
         List<WebElement> inputFields = driver.findElements(By.tagName("input"));
         //WebElement> inputFields = driver.findElements(By.tagName("input"));
         System.out.println(inputFields.get(0).getAttribute("validationMessage"));


    };
        @After
        public void tearDown () {
            driver.quit();
        }
        }
