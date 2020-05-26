/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webDriverTeste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Kaua.Morateli
 */
public class TesteSelenium {
    
    public static WebDriver driver;
    
    @BeforeClass
    public static void iniciarWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/PlayBox/chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public static void finalizarWebDriver() {
        driver.quit();
    }
    
    public void tentarLogoff() {
        driver.get("http://localhost:8080/PlayBox/ControleAcesso?acao=Sair");
    }

    public void tentarLogin(String login, String senha) {

        driver.get("http://localhost:8080/PlayBox/login.jsp");
        
        WebElement txtLogin = driver.findElement(By.name("txtLogin"));
        WebElement txtSenha = driver.findElement(By.name("txtPw"));
        
        txtLogin.sendKeys("admin@umc.br");
        txtSenha.sendKeys("admin@umc.br");
        
        WebElement btnEntrar = driver.findElement(By.id("btnEntrar"));
        btnEntrar.click();
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
    }
    
}
