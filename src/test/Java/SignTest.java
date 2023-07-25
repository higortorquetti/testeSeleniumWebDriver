import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test
    public void testFazerLoginNoTaskit(){
        //Primeiro configuramos o caminho onde esta o webdriver e depois instanciasmos ele na variável navegator
        System.setProperty("webdriver.chrome.driver", "caminhoOndeEstaOexeDoWebdriver");
        WebDriver navegator = new ChromeDriver();
        navegator.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Agora acessamos o end point do teste
        navegator.get("http://www.juliodelima.com.br/taskit");

        //antes de começar maximizo a tela pra ficar em tela cheia
        navegator.manage().window().maximize();

        //Agora clico no botão sign para efetuar o login
        navegator.findElement(By.linkText("Sign in")).click();
        // aqui passo os dados do login para test
        navegator.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("seusdados");
        navegator.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("suasenha");
        // por fim clico no botão para efetuar o login
        navegator.findElement(By.linkText("SIGN IN")).click();
        // após o login feito crio um variável para verificar se deu tudo certo com o login
        String saudacao = navegator.findElement(By.className("me")).getText();
        // através dessa váriavel faço o test se o valor esperado corresponde com o valor apresentado
        assertEquals("Hi, higor", saudacao);

        // após confirmar o login clico no botão para ir para a tela de criação de novas tarefas
        navegator.findElement(By.className("red")).click();

        // aqui faço mais um uma verificação pra ter certeza que consegui acessar o end point correto semelhante a anterior
        String telaTask = navegator.findElement(By.linkText("My tasks")).getText();
        assertEquals("My tasks", telaTask);

        navegator.quit();
    }
}
