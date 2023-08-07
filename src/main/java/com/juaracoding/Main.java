package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\My Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Open Browser, Open URL");

        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.id("username")).sendKeys("alfrenzaburhannudin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("ilovedota");
        driver.findElement(By.name("login")).click();

        String titlePage2 = driver.findElement(By.className("page-title")).getText();//scrapping
        System.out.println(titlePage2);

        //assert if
        if(titlePage2.equalsIgnoreCase("MY ACCOUNT")){
            System.out.println("Result Pass");
        }else{
            System.out.println("Result fail");
        }

        js.executeScript("window.scrollBy(0,500)");

        driver.get("https://shop.demoqa.com/shop/");
        js.executeScript("window.scrollBy(0,600)");

        driver.get("https://shop.demoqa.com/product/black-lux-graphic-t-shirt/");
        js.executeScript("window.scrollBy(0,600)");

        Select objSelect = new Select(driver.findElement(By.name("attribute_pa_color")));
        objSelect.selectByValue("black");
        Select objSelect2 = new Select(driver.findElement(By.name("attribute_pa_size")));
        objSelect2.selectByValue("36");
        driver.findElement(By.className("icon_plus")).click();
        driver.findElement(By.className("icon_plus")).click();
        driver.findElement(By.className("icon_plus")).click();
        driver.findElement(By.className("icon_plus")).click();
        driver.findElement(By.className("single_add_to_cart_button")).click();

        js.executeScript("window.scrollBy(0,300)");

        driver.get("https://shop.demoqa.com/cart/");

        js.executeScript("window.scrollBy(0,500)");

        String titlePage = driver.findElement(By.className("page-title")).getText();//scrapping
        System.out.println(titlePage);

        //assert if
        if(titlePage.equalsIgnoreCase("CART")){
            System.out.println("Result Pass");
        }else{
            System.out.println("Result fail");
        }



    }
}