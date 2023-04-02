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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DropDown {

    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver", "");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://suninjuly.github.io/selects2.html");
    }

    @Test
        public void correctSum() throws InterruptedException {
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int result = 0;
        int a = Integer.parseInt(num1.getText());
        int b = Integer.parseInt(num2.getText());
        result = a+b;
        System.out.println (num1.getText()+""+ num2.getText());
        System.out.println(result);

        WebElement dropDown = driver.findElement((By.id("dropdown")));
        dropDown.click();
        String newValue = String.valueOf(result);
        WebElement answer = driver.findElement(By.cssSelector("[value='"+newValue+"']"));
    answer.click();


    WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

          }



    @After
    public void tearDown () {
        driver.quit();
    }

}
