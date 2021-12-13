package stepDefinitions;

import com.pages.LoginPage;
import com.pages.YourStorePage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class YourStorePageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private YourStorePage yourStorePage;

    @Given("user has already loged in")
    public void user_has_already_loged_in(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get("https://demo.opencart.com/index.php?route=account/login");
        yourStorePage = loginPage.doLogin(userName, password);

    }

    @Given("user is on account page")
    public void user_is_on_account_page() {
        String yourStorePageTitle = yourStorePage.getYourStorePageTitle();
    }

    @Then("user gets Your Store section")
    public void user_gets_your_store_section(DataTable sectionTable) {
        List<String> expectedAccountSectionsLinksList = sectionTable.asList();
        List<String> actualAccountSectionsLinksList = yourStorePage.getAccountSectionsLinks();
        System.out.println("expectedCustomerServiceList -->>>"+ expectedAccountSectionsLinksList);
        System.out.println("actualCustomerServiceList-->>>"+actualAccountSectionsLinksList);
        Assert.assertTrue(expectedAccountSectionsLinksList.containsAll(actualAccountSectionsLinksList));
    }

    @Then("Store section count should be {int}")
    public void store_section_count_should_be(Integer expectedCount) {
        Assert.assertTrue(yourStorePage.getCusotmerServiceSectionCount() == expectedCount);


    }
}
