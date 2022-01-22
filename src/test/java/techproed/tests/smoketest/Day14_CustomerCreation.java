package techproed.tests.smoketest;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.CreateCustomerPage;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;

public class Day14_CustomerCreation {
    EmployeeDefaultPage employeeDefaultPage = new EmployeeDefaultPage();
    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void createCustomerAsEmployee() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage.loginApplication("gino.wintheiser","%B6B*q1!TH");

        employeeDefaultPage.myOperationsDropdown.click();
        employeeDefaultPage.manageCustomers.click();

        createCustomerPage.createANewCustomer.click();
        //createCustomerPage.ssn1.sendKeys("111-25-3548");
        //createCustomerPage.searchButton.click();
        createCustomerPage.firstname.sendKeys(Faker.instance().name().firstName());
        createCustomerPage.lastname.sendKeys(Faker.instance().name().lastName());
        createCustomerPage.middleInitial.sendKeys("R");
        createCustomerPage.email.sendKeys(Faker.instance().internet().emailAddress());
        createCustomerPage.mobilePhoneNumber.sendKeys(Faker.instance().phoneNumber().phoneNumber());
        createCustomerPage.phoneNumber.sendKeys(Faker.instance().phoneNumber().cellPhone());
        createCustomerPage.zipCode.sendKeys(Faker.instance().address().zipCode());
        createCustomerPage.address.sendKeys(Faker.instance().address().streetAddress());
        createCustomerPage.city.sendKeys(Faker.instance().address().city());
        createCustomerPage.ssn2.sendKeys("111-25-3548");

        Select country = new Select(createCustomerPage.countryDropdown);
        country.selectByVisibleText("TURKEY");

        createCustomerPage.state.sendKeys("Zonguldak");

        Select userDr = new Select(createCustomerPage.userDrop);
        userDr.selectByIndex(3);

        Select accountDr = new Select(createCustomerPage.accountDropdown);
        accountDr.selectByIndex(3);

        createCustomerPage.zelleEnrolledCheckbox.click();
        createCustomerPage.saveButton.click();

    }
}
