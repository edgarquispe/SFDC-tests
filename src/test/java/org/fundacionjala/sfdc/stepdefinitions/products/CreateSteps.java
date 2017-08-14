package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import java.util.Map;

import static org.testng.Assert.assertTrue;

/**
 * Created by abelb on 8/14/2017.
 */
public class CreateSteps {

    private ProductHome productHome;
    private ProductDetail productDetail;
    private Helper helper;

    public CreateSteps(Helper helper) {
        this.helper = helper;
    }

    @Given("^I go to Products Home Page$")
    public void iGoToProductsHomePage() {
        productHome = Navigator.goToProductsHome();
    }

    @When("^I create a new Product with:$")
    public void iCreateANewProductWith(Map<ProductFormField, String> formMapData) {
        ProductForm productForm = (ProductForm) productHome.clickNewButton();
        helper.setItemName(formMapData.get(ProductFormField.PRODUCT_NAME));
        productDetail = (ProductDetail) productForm.setObject(formMapData);
    }

    @Then("^On Products Details Page the new Product should be displayed$")
    public void onProductsDetailsPageTheNewProductShouldBeDisplayed() {
        assertTrue(productDetail.getItemName(helper.getItemName()).equals("AutomatedDemoAT04"));
    }

    @And("^On Products Home Page the new Product should be displayed$")
    public void onProductsHomePageTheNewProductShouldBeDisplayed() {
        assertTrue(productHome.isDisplayedItem(helper.getItemName()));
    }
}
