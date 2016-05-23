package org.learning.caristuff.domain.entities;

import org.thymeleaf.util.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

import static org.learning.caristuff.domain.entities.DummyEntity.DummyEntityBuilder.dummyEntity;

public class DummyEntityTestBuilder {

    private String description = "a description";
    private Integer someInteger = 745;
    private BigDecimal someNumber = BigDecimal.TEN;
    private Date someDate = DateUtils.create(2016, 5, 23).getTime();

    private DummyEntityTestBuilder() {
    }

    public static DummyEntityTestBuilder someDummyEntityTestBuilder() {
        return new DummyEntityTestBuilder();
    }

    public DummyEntityTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DummyEntityTestBuilder withSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
        return this;
    }

    public DummyEntityTestBuilder withSomeNumber(BigDecimal someNumber) {
        this.someNumber = someNumber;
        return this;
    }

    public DummyEntityTestBuilder withSomeDate(Date someDate) {
        this.someDate = someDate;
        return this;
    }

    public DummyEntity build() {
        DummyEntity dummyEntity = dummyEntity()
                .withDescription(description)
                .withSomeDate(someDate)
                .withSomeInteger(someInteger)
                .withSomeNumber(someNumber)
                .build();

        return dummyEntity;
    }


}
