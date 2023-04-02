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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HugeForm {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/huge_form.html");
    }
@Test
    public void allInputFields() throws InterruptedException {
    List<WebElement> inputFields = driver.findElements(By.tagName("input"));
    for (WebElement inputField :
            inputFields) {
        inputField.sendKeys("hjhhjhjh");
    }
    WebElement submitButton = driver.findElement(By.tagName("button"));
    submitButton.click();
    sleep(30000);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
}

@Test
public void emptyInoutFields(){
    WebElement submitButton = driver.findElement(By.tagName("button"));
    submitButton.click();
    List<WebElement> inputFields = driver.findElements(By.tagName("input"));
    System.out.println(inputFields.get(0).getAttribute("validationMessage"));

    assertEquals("Заполните это поле.", inputFields.get(0).getAttribute("validationMessage"));
}

    @After
    public void tearDown() {
                driver.quit();
    }
}