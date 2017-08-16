package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.testng.Assert.assertTrue;

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
//        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getItemName()));
    }

    /**
     * Click on Edit inside Product Detail.
     */
    @When("^I click on Edit$")
    public void iClickOnEdit() {
        new ProductDetail().clickEditButton();
    }

    /**
     * The Product data should be displayed on Product Detail Page.
     */
    @Then("^the Product should be displayed$")
    public void theProductShouldBeDisplayed() {
//        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("view"));
//        DriverManager.getInstance().getDriver().navigate().refresh();
        DriverManager.getInstance().getWait().until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(String.format("h1[title='%s']", helper.getItemName()))));
        ProductDetail productDetail = new ProductDetail();
        assertTrue(productDetail.getProductNameText().equals(map.get(ProductFormField.PRODUCT_NAME)));
        assertTrue(productDetail.getProductCodeText().equals(map.get(ProductFormField.PRODUCT_CODE)));
        assertTrue(productDetail.getProductDescriptionText().equals(
                map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        assertTrue(productDetail.getProductFamilyText().equals(
                map.get(ProductFormField.PRODUCT_FAMILY)));
    }

    /**
     * The Product Data should be displayed on Product Home Page.
     */
    @And("^the Product should be displayed on Home Page$")
    public void theProductShouldBeDisplayedOnHomePage() {
        ProductHome productHome = new ProductHome();
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Product2"));
        assertTrue(productHome.isDisplayedItem(map.get(ProductFormField.PRODUCT_NAME)));
        assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_CODE)));
        assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_DESCRIPTION)));
        assertTrue(productHome.isProductFieldDisplayed(
                map.get(ProductFormField.PRODUCT_NAME),
                map.get(ProductFormField.PRODUCT_FAMILY)));
    }
}
