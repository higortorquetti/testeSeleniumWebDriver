import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test
    public void testFazerLoginNoTaskit(){
        System.setProperty("webdriver.chrome.driver", "C:\\Estudos QA\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegator = new ChromeDriver();
        navegator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegator.get("http://www.juliodelima.com.br/taskit");

        navegator.manage().window().maximize();
        navegator.findElement(By.linkText("Sign in")).click();
        navegator.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("");
        navegator.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("");
        navegator.findElement(By.linkText("SIGN IN")).click();
        String saudacao = navegator.findElement(By.className("me")).getText();
        assertEquals("Hi, higor", saudacao);

       // navegator.quit();
    }
}
