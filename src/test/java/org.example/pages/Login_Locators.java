package org.example.pages;
import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_Locators {
    public WebElement Account(){
        return Hooks.driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]"));
    }
    public WebElement Go_to_Login_page(){
        return Hooks.driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
    }
   public WebElement Email_address(){
       return Hooks.driver.findElement(By.id("email"));
   }
   public WebElement Password(){
       return Hooks.driver.findElement(By.id("pass"));
   }
  public WebElement Login(){
       return Hooks.driver.findElement(By.id("send2"));
  }
}
