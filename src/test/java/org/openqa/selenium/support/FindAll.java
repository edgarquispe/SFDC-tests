package org.openqa.selenium.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;

import org.example.sfdc.pages.SFDCEnvironment;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@PageFactoryFinder(FindAll.FindByBuilder.class)
public @interface FindAll {

    FindBy[] value();

    class FindByBuilder extends AbstractFindByBuilder {
        public By buildIt(final Object annotation, final Field field) {
            FindAll findBys = (FindAll) annotation;
            assertValidFindAll(findBys);

            FindBy[] findByArray = findBys.value();
            By[] byArray = new By[1];

            if (SFDCEnvironment.isLightningExperience()) {
                byArray[0] = buildByFromFindBy(findByArray[1]);
            } else {
                byArray[0] = buildByFromFindBy(findByArray[0]);
            }
            return new ByAll(byArray);
        }

    }
}
