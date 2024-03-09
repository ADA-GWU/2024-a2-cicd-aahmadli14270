package ada.edu.demo.webtest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebInterfaceTests {

	@Autowired
	private WebDriver webDriver;

	@LocalServerPort
	private int port;


	@Test
	@Order(1)
	@DisplayName("Create a user")
	public void CreateUser() {
		webDriver.get("http://localhost:"+port+"/student/new");

		WebElement studentIdInput = webDriver.findElement(By.id("studentId"));
		WebElement firstNameInput = webDriver.findElement(By.id("firstName"));
		WebElement lastNameInput = webDriver.findElement(By.id("lastName"));
		WebElement emailInput = webDriver.findElement(By.id("email"));

		// Check if such a field exists
		assertNotNull(firstNameInput);

		try {
			studentIdInput.sendKeys("1");
			Thread.sleep(2000);
			firstNameInput.sendKeys("Nigar");
			Thread.sleep(2000);
			lastNameInput.sendKeys("Salayeva");
			Thread.sleep(2000);
			emailInput.sendKeys("ns@ada.edu.az");
			Thread.sleep(2000);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}

		// Find and submit the form (assuming there's a submit button with a specific attribute)
		WebElement submitButton = webDriver.findElement(By.id("submit"));
		submitButton.click();
	}

	@Test
	@Order(2)
	@DisplayName("Check the created user")
	public void CheckUser() {
		// Check if the student is added
		webDriver.get("http://localhost:"+port+"/student/list");
		List<WebElement> bodyElementFName = webDriver.findElements(By.xpath("//*[contains(text(), 'Nigar')]"));
		List<WebElement> bodyElementLName = webDriver.findElements(By.xpath("//*[contains(text(), 'Salayeva')]"));
		System.out.println("Element result"+bodyElementLName);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		// Check if the text "Jamal" is present in the page content
		assert(bodyElementFName.size() == 1);
		assert(bodyElementLName.size() == 1);
	}

//	@Test
//	@Order(3)
//	@DisplayName("Update Student Information")
//	public void updateStudentInformation() {
//		webDriver.get("http://localhost:" + port + "/student/update?id=123");
//
//		WebElement firstNameInput = webDriver.findElement(By.id("firstName"));
//		WebElement lastNameInput = webDriver.findElement(By.id("lastName"));
//		WebElement emailInput = webDriver.findElement(By.id("email"));
//
//		firstNameInput.clear();
//		firstNameInput.sendKeys("UpdatedFirstName");
//
//		lastNameInput.clear();
//		lastNameInput.sendKeys("UpdatedLastName");
//
//		emailInput.clear();
//		emailInput.sendKeys("updated@example.com");
//
//		WebElement submitButton = webDriver.findElement(By.id("submit"));
//		submitButton.click();
//
//		assertTrue(webDriver.getPageSource().contains("Student updated successfully!"));
//	}

	@Test
	@Order(3)
	@DisplayName("Update Student Information")
	public void updateStudentInformation() {
	    webDriver.get("http://localhost:" + port + "/student/update?id=1");
	
	    // Wait until the form elements are present
	    WebDriverWait wait = new WebDriverWait(webDriver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	    System.out.println("Found first name input field");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	    System.out.println("Found second name input field");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            System.out.println("Found third name input field");

		
	    // Fill out the form
	    WebElement firstNameInput = webDriver.findElement(By.id("firstName"));
	    WebElement lastNameInput = webDriver.findElement(By.id("lastName"));
	    WebElement emailInput = webDriver.findElement(By.id("email"));
	    System.out.println("maybe error here1");
	    firstNameInput.clear();
	    firstNameInput.sendKeys("UpdatedFirstName");
	    System.out.println("maybe error here2");
	    lastNameInput.clear();
	    lastNameInput.sendKeys("UpdatedLastName");
            System.out.println("maybe error here3");
	    emailInput.clear();
	    emailInput.sendKeys("updated@example.com");
	    System.out.println("maybe error here4");
	    // Submit the form
	    WebElement submitButton = webDriver.findElement(By.id("submit"));
	    submitButton.click();
	    System.out.println("maybe error here5");
		
	    webDriver.get("http://localhost:" + port + "/student/list");
	    System.out.println("maybe error here6");

	    List<WebElement> updatedStudents = webDriver.findElements(By.xpath("//*[contains(text(), 'UpdatedFirstName')]"));
	    System.out.println("maybe error here7");

    	    assertFalse(updatedStudents.isEmpty());
	    System.out.println("maybe error here8");
	}

}
