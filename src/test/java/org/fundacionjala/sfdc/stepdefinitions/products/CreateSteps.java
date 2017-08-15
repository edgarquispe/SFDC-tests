package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.testng.Assert.assertTrue;

/**
 * Create Steps for Products.
 */
public class CreateSteps {

    private ProductDetail productDetail;
    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CreateSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * The Product data should be displayed on Product Detail Page.
     *
     * @param data String.
     */
    @Then("^the \"([^\"]*)\" should be displayed$")
    public void theShouldBeDisplayed(String data) {
        productDetail = new ProductDetail();
        assertTrue(productDetail.getProductNameText().equals(helper.getDataMap().get(ProductFormField.PRODUCT_NAME)));
        assertTrue(productDetail.getProductCodeText().equals(helper.getDataMap().get(ProductFormField.PRODUCT_CODE)));
        assertTrue(productDetail.getProductDescriptionText().equals(
                helper.getDataMap().get(ProductFormField.PRODUCT_DESCRIPTION)));
        assertTrue(productDetail.getProductFamilyText().equals(
                helper.getDataMap().get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * The Product Data should be displayed on Product Home Page.
     *
     * @param data String.
     */
    @And("^the \"([^\"]*)\" should be displayed on Home Page$")
    public void theShouldBeDisplayedOnHomePage(String data) {
        ProductHome productHome = new ProductHome();
        assertTrue(productHome.isDisplayedItem(helper.getDataMap().get(ProductFormField.PRODUCT_NAME).toString()));
        assertTrue(productHome.isProductFieldDisplayed(
                helper.getDataMap().get(ProductFormField.PRODUCT_NAME).toString(),
                helper.getDataMap().get(ProductFormField.PRODUCT_CODE).toString()));
        assertTrue(productHome.isProductFieldDisplayed(
                helper.getDataMap().get(ProductFormField.PRODUCT_NAME).toString(),
                helper.getDataMap().get(ProductFormField.PRODUCT_DESCRIPTION).toString()));
        assertTrue(productHome.isProductFieldDisplayed(
                helper.getDataMap().get(ProductFormField.PRODUCT_NAME).toString(),
                helper.getDataMap().get(ProductFormField.PRODUCT_FAMILY).toString()));
    }
}
