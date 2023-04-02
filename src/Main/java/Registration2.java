import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Registration2 {

    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/simple_form_find_task.html");
    }

    @Test
    public void inputAllFields() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.cssSelector("[name='first_name']"));
        WebElement inputLastName = driver.findElement(By.cssSelector("[name='last_name']"));
        WebElement inputCity = driver.findElement(By.cssSelector("[class*='city']"));
        WebElement inputCountry = driver.findElement(By.id("country"));

        inputFirstName.sendKeys("John");
        inputLastName.sendKeys("Show");
        inputCity.sendKeys("Berlin");
        inputCountry.sendKeys("Germany");

        WebElement submitButton = driver.findElement(By.id("submit_button"));
        submitButton.click();
        sleep(10000);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

    @Test
    public void invalidRegistration() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.cssSelector("[name='first_name']"));
        WebElement inputLastName = driver.findElement(By.cssSelector("[name='last_name']"));
        WebElement inputCity = driver.findElement(By.cssSelector("[class*='city']"));
        WebElement inputCountry = driver.findElement(By.id("country"));

        //inputFirstName.sendKeys("");
        inputLastName.sendKeys("Show");
        inputCity.sendKeys("Berlin");
        inputCountry.sendKeys("Germany");
        WebElement submitButton = driver.findElement(By.id("submit_button"));
        assertEquals("disabled", submitButton.getAttribute("disabled"));
        System.out.println(submitButton.getAttribute("disabled"));
        sleep(100000);
    }

        @After
        public void tearDown () {
        driver.quit();
    }
}