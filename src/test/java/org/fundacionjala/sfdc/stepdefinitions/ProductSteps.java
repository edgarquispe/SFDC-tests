package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Create Steps for Products.
 */
public class ProductSteps {

    private Helper helper;

    private Map<ProductFormField, String> map;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ProductSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Product Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Product form with:$")
    public void iFillTheProductFormWith(Map<ProductFormField, String> formMapData) {
        map = formMapData;
        helper.setItemName(formMapData.get(ProductFormField.PRODUCT_NAME));
        new ProductForm().fillAndSaveForm(formMapData);
        new ProductHome().waitUntilSpinnerIsHidden();

    }

    /**
     * Click on Edit inside Product Detail.
     */
    @When("^I click on Edit from Product$")
    public void iClickOnEditFromProduct() {
        new ProductDetail().clickEditButton();
    }

    /**
     * The Product data should be displayed on Product Detail Page.
     */
    @Then("^the Product should be displayed$")
    public void theProductShouldBeDisplayed() {
        ProductDetail productDetail = new ProductDetail();
        productDetail.waitObjectNameIs(helper.getItemName());
        productDetail.waitUntilSuccessMessage();
        helper.getAssertion().assertTrue(productDetail.getProductNameText()
                .equals(map.get(ProductFormField.PRODUCT_NAME)));
        helper.getAssertion().assertTrue(productDetail.getProductCodeText()
                .equals(map.get(ProductFormField.PRODUCT_CODE)));
        helper.getAssertion().assertTrue(productDetail.getProductDescriptionText()
                .equals(map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        helper.getAssertion().assertTrue(productDetail.getProductFamilyText()
                .equals(map.get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * The Product Data should be displayed on Product Home Page.
     */
    @And("^the Product should be displayed on Home Page$")
    public void theProductShouldBeDisplayedOnHomePage() {
        ProductHome productHome = new ProductHome();
        productHome.waitUntilSpinnerIsHidden();
        helper.getAssertion().assertTrue(productHome
                .isDisplayedItem(map.get(ProductFormField.PRODUCT_NAME)));
        helper.getAssertion().assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_CODE)));
        helper.getAssertion().assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        helper.getAssertion().assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Product$")
    public void iClickOnDeleteFromProduct() {
        new ProductDetail().deleteItem();
    }

    /**
     * The Product shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Product should not be displayed on Home Page$")
    public void theProductShouldNotBeDisplayedOnHomePage() {
        ProductHome productHome = new ProductHome();
        helper.getAssertion().assertFalse(productHome.isDisplayedItem(map.get(ProductFormField.PRODUCT_NAME)));
    }
}
