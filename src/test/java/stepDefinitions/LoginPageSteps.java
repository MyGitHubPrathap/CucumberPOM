package stepDefinitions;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private static String loginTitle;
    private static String homePageTitle;

    @Given("user is in login page")
    public void user_is_in_login_page() {
        DriverFactory.getDriver().get("https://demo.opencart.com/index.php?route=account/login");

    }

    @When("user get the title of the page")
    public void user_get_the_title_of_the_page() {
        loginTitle = loginPage.getLoginPageTitle();
        System.out.println("loginTitle is "+ loginTitle);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedLoginTitle) {
        System.out.println("expectedLoginTitle is-->> " +expectedLoginTitle);
        Assert.assertTrue(loginTitle.contains(expectedLoginTitle));
    }

    @Then("forgot password page should be displayed")
    public void forgot_password_page_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPassordLinkExists());
    }

    @When("user enter valid username {string}")
    public void user_enter_valid_username(String userName) {
        loginPage.enterUserName(userName);
    }

    @When("user enter valid password {string}")
    public void user_enter_valid_password(String pwd) {
        loginPage.enterPassword(pwd);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        loginPage.clickLogin();
    }

//    @Then("user get the title of the home page")
//    public void user_get_the_title_of_the_home_page() {
//        homePageTitle = homePage.getHomePageTitle();
//
//    }
//    @Then("page title should be {string}")
//    public void page_title_should_be(String expectedHomePageTitle) {
//        Assert.assertTrue(homePageTitle.contains(expectedHomePageTitle));
//    }
}
