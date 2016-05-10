package org.learning.caristuff.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = DummyEntity.DUMMY_ENTITY_TABLE_NAME)
public class DummyEntity {

    public static final String DUMMY_ENTITY_TABLE_NAME = "dummytable";
    private static final String ID_COLUMN = "id";

    private Long id;
    private String description;
    private Integer someInteger;
    private BigDecimal someNumber;
    private Date someDate;


    public DummyEntity() {
    }

    @Id
    @Column(nullable = false, name = ID_COLUMN)
    public Long getId() {
        return id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "some_integer")
    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    @Column(name = "some_number")
    public BigDecimal getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(BigDecimal someNumber) {
        this.someNumber = someNumber;
    }

    @Column(name = "some_date")
    public Date getSomeDate() {
        return someDate;
    }

    public void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }


}
