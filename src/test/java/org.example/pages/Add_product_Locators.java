package org.example.pages;
import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Add_product_Locators {
    public WebElement Accessories(){
        return Hooks.driver.findElement(By.xpath("//header/div[1]/div[3]/nav[1]/ol[1]/li[3]"));
    }
    public WebElement Shoes(){
        return Hooks.driver.findElement(By.xpath("//header/div[1]/div[3]/nav[1]/ol[1]/li[3]/ul[1]/li[4]/a[1]"));
    }
    public WebElement Sort_by_Price(){
        return Hooks.driver.findElement(By.xpath("//select[@title='Sort By']"));
    }

    public WebElement View_Choose_Details(){
        return Hooks.driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/ul[1]/li[2]/div[1]/div[2]/a[1]"));
    }
    public WebElement Choose_Color(){
        return Hooks.driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/form[1]/div[3]/div[5]/dl[1]/dd[1]/div[1]/ul[1]/li[1]/a[1]/span[1]/img[1]"));
    }
    public WebElement Choose_Size(){
        return Hooks.driver.findElement(By.xpath("//span[contains(text(),'7')]"));
    }
    public WebElement Add_to_Card(){
        return Hooks.driver.findElement(By.xpath("//button[@class='button btn-cart']"));
    }
}
