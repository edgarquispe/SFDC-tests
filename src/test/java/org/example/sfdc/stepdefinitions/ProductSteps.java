package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.products.ProductDetail;
import org.example.sfdc.pages.products.ProductForm;
import org.example.sfdc.pages.products.ProductFormField;
import org.example.sfdc.pages.products.ProductHome;

/**
 * Create Steps for Products.
 */
public class ProductSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ProductSteps(final Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Product Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Product form with:$")
    public void iFillTheProductFormWith(final Map<ProductFormField, String> formMapData) {
        helper.setItemName(formMapData.get(ProductFormField.PRODUCT_NAME));
        helper.setProductMap(formMapData);
        new ProductForm().fillAndSaveForm(helper.getProductMap());
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
     * Click on Delete button on Detail Page.
     */
    @When("^I click on Delete from Product$")
    public void iClickOnDeleteFromProduct() {
        new ProductDetail().deleteItem();
    }
}
