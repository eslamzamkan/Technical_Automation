package org.example.pages;
import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Register_Locators {
    //  Register locators

    public WebElement Account(){
        return Hooks.driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]"));
    }
    public WebElement Go_to_Register_page(){
        return Hooks.driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
    }
    public WebElement First_Name(){
      return Hooks.driver.findElement(By.id("firstname"));
    }
   public WebElement Middle_Name(){
        return Hooks.driver.findElement(By.id("middlename"));
   }
    public WebElement Last_Name(){
        return Hooks.driver.findElement(By.id("lastname"));
   }
   public WebElement Email_Address() {
       return Hooks.driver.findElement(By.id("email_address"));
   }
    public WebElement Password() {
        return Hooks.driver.findElement(By.id("password"));
    }
    public WebElement ConfirmPassword() {
     return Hooks.driver.findElement(By.id("confirmation"));
    }
    public WebElement Register_button(){
        return Hooks.driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[1]"));
    }
}
