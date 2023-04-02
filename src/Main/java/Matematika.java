import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Matematika {

    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://suninjuly.github.io/math.html");
    }

    public double funcCalc(double x){
        return log(abs(12*sin(x)));
    }

    @Test
    public void validAnswer() throws InterruptedException {
        WebElement robotCheck = driver.findElement(By.id("robotCheckbox"));
        robotCheck.click();

        WebElement x =driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText());
        System.out.println(xValue);
        System.out.println(funcCalc(xValue));

        WebElement answerInputField = driver.findElement(By.id("answer"));
        double result = funcCalc(xValue);
        answerInputField.sendKeys (String.valueOf(result));

        WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Robots should rule!"));

        sleep (10000);
    }

    @Test
    public void validAnswerRobot() throws InterruptedException {
        WebElement robotCheck = driver.findElement(By.id("robotCheckbox"));
        robotCheck.click();

        WebElement robotsRule = driver.findElement(By.id("robotsRule"));
        robotsRule.click();

        WebElement x =driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText());
        System.out.println(xValue);
        System.out.println(funcCalc(xValue));

        WebElement answerInputField = driver.findElement(By.id("answer"));
        double result = funcCalc(xValue);
        answerInputField.sendKeys (String.valueOf(result));

        WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


        sleep (20000);
    }

            @After
    public void tearDown () {
        driver.quit();
    }
}


