package appiumFramework;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumFramework.Capability;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class Demo extends Capability {

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /f /im node.exe");
		Thread.sleep(3000);
		
	}
	//Positive scenario
	@Test(enabled=false)
	public void testcase()
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vasuki");
		//driver.findElementByAccessibilityId("com.androidsample.generalstore:id/nameField").sendKeys("Vasuki");
		//driver.findElements(By.className("android.widget.RadioButton")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
	}
	//Negative scenario
	@Test(enabled=false)
	public void testcase2()
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vasuki");
		//driver.findElementByAccessibilityId("com.androidsample.generalstore:id/nameField").sendKeys("Vasuki");
		//driver.findElements(By.className("android.widget.RadioButton")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String error = driver.findElement(By.xpath("/hierarchy/android.widget.Toast[1]")).getAttribute("name");
		System.out.println(error);
        Assert.assertEquals(error, "Please enter your name");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vasuki");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
	}
	@Test(enabled=false)
	public void testcase3()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vasuki");
		//driver.findElementByAccessibilityId("com.androidsample.generalstore:id/nameField").sendKeys("Vasuki");
		//driver.findElements(By.className("android.widget.RadioButton")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		System.out.println(driver.findElements(By.className("android.widget.LinearLayout")).size());//4
		System.out.println(driver.findElements(By.className("android.widget.ImageView")).size());//3
		System.out.print(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size());//2
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\"))");
        int prod = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<prod;i++)
        {
        	String prodname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	if(prodname.equals("Air Jordan 9 Retro"))
        	{
        		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        		break;
        	}
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String cartprod = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(cartprod, "Air Jordan 9 Retro");
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        
	}
	@Test
	public void test4() throws InterruptedException, IOException
	{
		service = startserver();
		Thread.sleep(3000);
		driver=capabilities(apppackage,appactivity,devicename,platformname,chromedriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vasuki");
		//driver.findElementByAccessibilityId("com.androidsample.generalstore:id/nameField").sendKeys("Vasuki");
		//driver.findElements(By.className("android.widget.RadioButton")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Austria\")")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
//		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
//		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //this is to click on the second add to cart button 
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		int n=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.print(n);
		
		String str1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText().substring(1);
		String str2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText().substring(1);
		Double Amt1=Double.parseDouble(str1);
		Double Amt2=Double.parseDouble(str2);
		System.out.print(" "+Amt1+" "+Amt2);
		Double expected = Amt1+Amt2;
		System.out.println(expected);
		
		String str3 = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1);
		
		Double actualVal=Double.parseDouble(str3);
		System.out.println(actualVal);
		Assert.assertEquals(actualVal,expected);
		
		WebElement check = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(check))).perform();
		
		WebElement tc= driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(3))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(8000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM",Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		service.stop();
		 
	}
	
}
