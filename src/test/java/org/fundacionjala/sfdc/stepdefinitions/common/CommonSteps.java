package org.fundacionjala.sfdc.stepdefinitions.common;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.fundacionjala.sfdc.utilities.CommonManager;
import org.fundacionjala.sfdc.utilities.Items;

import java.util.Map;

/**
 * Common Steps for all features.
 */
public class CommonSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CommonSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step to go to Item Home Page.
     *
     * @param pageName Items.
     */
    @Given("^I go to \"([^\"]*)\" Home Page$")
    public void iGoToHomePage(Items pageName) {
        CommonManager.gotoPage(pageName);
    }

    /**
     * Fill the Product Form.
     *
     * @param data        String.
     * @param formMapData Map.
     */
    @When("^I fill the \"([^\"]*)\" form with:$")
    public void iFillTheFormWith(String data, Map<ProductFormField, String> formMapData) {
        helper.setData(data);
        helper.setDataMap(formMapData);
        ProductForm productForm = new ProductHome().clickNewButton();
        productForm.fillAndSaveForm(formMapData);
    }
}
