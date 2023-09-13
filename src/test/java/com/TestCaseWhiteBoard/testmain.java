package com.TestCaseWhiteBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.POMWhiteBoard.DrawingToolsPom;
import com.POMWhiteBoard.LandingPagePOM;
import com.POMWhiteBoard.LoginPOM;
import com.POMWhiteBoard.LowerToolBarPOM;
import com.POMWhiteBoard.TopToolBarPOM;
import com.UtilitiesWhiteBoard.LoggerLoad;

public class testmain {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\dominicroya\\\\eclipse-workspace\\\\lib\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.get("https://www.whiteboard.chat/");
		LandingPagePOM lp=new LandingPagePOM(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.popupNObtn));	
		lp.popupNo();		
		lp.collaborateOption();
		WebElement hello=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[3]/button")));
		//WebElement hello=driver.findElement(By.)
		wait.until(ExpectedConditions.elementToBeClickable(hello));
		hello.click();
		wait.until(ExpectedConditions.elementToBeClickable(lp.skip4Good));
		lp.skipforGood();
		
		LoginPOM l1 = new LoginPOM(driver);
		SoftAssert softAssert = new SoftAssert();
		wait.until(ExpectedConditions.elementToBeClickable(l1.settingsBtn));	
		l1.Settings();
		wait.until(ExpectedConditions.elementToBeClickable(l1.emailTxtBx));
		l1.enterInvalidEmail();
		l1.enterInvalidPassword();
		l1.sigIn();	
		LoggerLoad.info("Logged in with Invalid Credentials");
		//if(l1.getToastMessage().equals("Loggedin successfully")) {
			//test.log(Status.PASS, "Successfully Logged In");
		//}else if(l1.getToastMessage().equals("User does not exist.")){
		//	test.log(Status.FAIL, "User does not exist.");	
		//}
		Thread.sleep(2000);
		String ExpText="Logged in Succesfull";
		String ActText=l1.getToastMessage();
		softAssert.assertEquals(ActText,ExpText);
		//softAssert.assertEquals("User does not exist.", ActText);
		Thread.sleep(3000);
		l1.closeBtnClick();
		System.out.println("invalid user");
		
		LoginPOM lop = new LoginPOM(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lop.settingsBtn));	
		lop.Settings();
		wait.until(ExpectedConditions.elementToBeClickable(lop.emailTxtBx));
		lop.enterEmail();
		lop.enterPassword();
		lop.sigIn();
		LoggerLoad.info("Logged in with valid Credentials");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(lop.removePopup));	
		lop.RemovePopUP();
		LoggerLoad.info("Removed PopUp");
		LoggerLoad.info("Removed Remind me again Popup");
		LoggerLoad.info("Login Success");
		System.out.println("Login Success");
		
		DrawingToolsPom dt=new DrawingToolsPom(driver);
		System.out.println("Shape Triangle started");
		dt.drawingBtnClick();
		dt.shapesClick();
		dt.triangleClick();
		dt.sendAngles();
		dt.trianglePositioning();
		Thread.sleep(3000);
		LoggerLoad.info("Triangle placed in 1st page");
		LowerToolBarPOM ltb = new LowerToolBarPOM(driver);
		LoggerLoad.info("Click on next page");
		System.out.println("Click on next page");
		ltb.nextPageClick();
		Thread.sleep(3000);
		System.out.println("Free hand drawing started");
		dt.drawingBtnClick();
		dt.drawingPenClick();
		dt.canvasClick();
		dt.clickAndHold();
		Thread.sleep(3000);
		System.out.println("Free Hand Draw successful");		
		Thread.sleep(3000);
		LoggerLoad.info("Free Hand Draw placed in 2st page");
		ltb.nextPageClick();
		Thread.sleep(3000);
		dt.writeClick();
		Thread.sleep(3000);
		dt.clickType();
		Thread.sleep(3000);
		dt.clickAndType();	
		System.out.println("ClickNType Success");
		LoggerLoad.info("ClickNType placed in 3st page");
		LoggerLoad.info("Click back to previous page");
		System.out.println("Click back to previous page");
		ltb.previousPageClick();
		Thread.sleep(2000);
		System.out.println("Click back to previous Page");
		ltb.previousPageClick();
		Thread.sleep(3000);
		LoggerLoad.info("Click on Thumbnail View");
		System.out.println("Click on Thumbnail View");
		ltb.thumbNailClick();
		Thread.sleep(3000);
		System.out.println("Changing the pages of the Board name Success");
		LoggerLoad.info("Changing the pages of the Board name Success");
		
		
		LoggerLoad.info("Re-nameing the Board name Started");
		System.out.println("Re-nameing the Board name Started");
		TopToolBarPOM t1 = new TopToolBarPOM(driver);
		t1.singleBoardName();
		System.out.println("Click on Save button");
		LoggerLoad.info("Click on Save button");
		Thread.sleep(3000);
		LowerToolBarPOM ltbp = new LowerToolBarPOM(driver);
		System.out.println("Click on manage boards");
		LoggerLoad.info("Click on manage boards");
		ltbp.manageBoardsClick();
		WebElement getview=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Automation']//following::td[4]/a[2]")));
		getview.click();
		Thread.sleep(3000);
		System.out.println("Re-nameing the Board name Success");
		LoggerLoad.info("Re-nameing the Board name Success");
		softAssert.assertAll();
	}

}
