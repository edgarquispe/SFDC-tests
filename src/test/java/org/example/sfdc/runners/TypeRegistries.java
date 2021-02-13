package org.example.sfdc.runners;

import java.util.Arrays;
import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import org.example.sfdc.pages.SObject;
import org.example.sfdc.pages.acccounts.AccountFormField;
import org.example.sfdc.pages.campaigns.CampaignFormField;
import org.example.sfdc.pages.opportunities.OpportunityFormField;
import org.example.sfdc.pages.products.ProductFormField;

public class TypeRegistries implements TypeRegistryConfigurer {

    /**
     * {@inheritDoc}
     */
    public Locale locale() {
        return Locale.ENGLISH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTypeRegistry(final TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(SObject.class,
                (TableCellTransformer<SObject>) cell -> Arrays.stream(SObject.values())
                        .filter(e -> e.toString().equalsIgnoreCase(cell)).findFirst().get()));
        typeRegistry.defineDataTableType(new DataTableType(AccountFormField.class,
                (TableCellTransformer<AccountFormField>) cell -> Arrays.stream(AccountFormField.values())
                        .filter(e -> e.toString().equalsIgnoreCase(cell)).findFirst().get()));
        typeRegistry.defineDataTableType(new DataTableType(CampaignFormField.class,
                (TableCellTransformer<CampaignFormField>) cell -> Arrays.stream(CampaignFormField.values())
                        .filter(e -> e.toString().equalsIgnoreCase(cell)).findFirst().get()));
        typeRegistry.defineDataTableType(new DataTableType(OpportunityFormField.class,
                (TableCellTransformer<OpportunityFormField>) cell -> Arrays.stream(OpportunityFormField.values())
                        .filter(e -> e.toString().equalsIgnoreCase(cell)).findFirst().get()));
        typeRegistry.defineDataTableType(new DataTableType(ProductFormField.class,
                (TableCellTransformer<ProductFormField>) cell -> Arrays.stream(ProductFormField.values())
                        .filter(e -> e.toString().equalsIgnoreCase(cell)).findFirst().get()));
    }
}
