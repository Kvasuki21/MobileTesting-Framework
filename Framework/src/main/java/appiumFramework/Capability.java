package appiumFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Capability {
	
	protected static String apppackage,appactivity,devicename,platformname,chromedriver;
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startserver()
	{
		boolean flag=checkifserverisrunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\KatakamVasuki\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723));
		service.start();
		}
		return service;
	}
	public static boolean checkifserverisrunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serversocket;
		try
		{
			serversocket = new ServerSocket(port);
			serversocket.close();
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally{
            serversocket=null;
        }
        return isServerRunning;
	}
	public static void startemulator() throws InterruptedException, IOException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\emulator.bat");
		Thread.sleep(5000);
	}
	public static AndroidDriver<AndroidElement> capabilities(String apppackage,String appactivity,String devicename,String platformname,String chromedriver) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//File fs = new File("src/ApiDemos-debug.apk");

		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		apppackage = pro.getProperty("appPackage");
		appactivity = pro.getProperty("appActivity");
		devicename = pro.getProperty("deviceName");
		platformname= pro.getProperty("platformName");
		chromedriver = pro.getProperty("CHROMEDRIVER_EXECUTABLE");
		if(devicename.contains("Vasuki"))
		{
			startemulator();
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Vasuki Blackberry");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		//Only for IOS cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath() );
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,apppackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appactivity);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,chromedriver);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL ("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
