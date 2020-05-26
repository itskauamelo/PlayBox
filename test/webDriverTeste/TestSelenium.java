/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webDriverTeste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static webDriverTeste.TesteSelenium.driver;

/**
 *
 * @author Kaua.Morateli
 */
public class TestSelenium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:/PlayBox/chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("http://localhost:8080/PlayBox/login.jsp");
        
        WebElement txtLogin = driver.findElement(By.name("txtLogin"));
        WebElement txtSenha = driver.findElement(By.name("txtPw"));
        
        txtLogin.sendKeys("admin@umc.br");
        txtSenha.sendKeys("admin@umc.br");
        
        WebElement btnEntrar = driver.findElement(By.id("btnEntrar"));
        btnEntrar.click();
        
    }
    
}
