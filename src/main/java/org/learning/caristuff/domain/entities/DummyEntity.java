package org.learning.caristuff.domain.entities;

import org.learning.caristuff.common.Builder;
import org.learning.caristuff.domain.jpa.JpaAggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = DummyEntity.DUMMY_ENTITY_TABLE_NAME)
public class DummyEntity extends JpaAggregateRoot<DummyEntity, Long> {

    public static final String DUMMY_ENTITY_TABLE_NAME = "dummytable";
    private static final String ID_COLUMN = "id";

    private Long id;
    private String description;
    private Integer someInteger;
    private BigDecimal someNumber;
    private Date someDate;

    private DummyEntity() {
    }

    @Id
    @Column(nullable = false, name = ID_COLUMN)
    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "some_integer")
    public Integer getSomeInteger() {
        return someInteger;
    }

    private void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    @Column(name = "some_number")
    public BigDecimal getSomeNumber() {
        return someNumber;
    }

    private void setSomeNumber(BigDecimal someNumber) {
        this.someNumber = someNumber;
    }

    @Column(name = "some_date")
    public Date getSomeDate() {
        return someDate;
    }

    private void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }

    public static class DummyEntityBuilder implements Builder<DummyEntity> {

        private String description;
        private Integer someInteger;
        private BigDecimal someNumber;
        private Date someDate;

        private DummyEntityBuilder() {
        }

        public static DummyEntityBuilder dummyEntity() {
            return new DummyEntityBuilder();
        }

        public DummyEntityBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DummyEntityBuilder withSomeInteger(Integer someInteger) {
            this.someInteger = someInteger;
            return this;
        }

        public DummyEntityBuilder withSomeNumber(BigDecimal someNumber) {
            this.someNumber = someNumber;
            return this;
        }

        public DummyEntityBuilder withSomeDate(Date someDate) {
            this.someDate = someDate;
            return this;
        }

        public DummyEntity build() {
            DummyEntity dummyEntity = new DummyEntity();
            dummyEntity.setDescription(this.description);
            dummyEntity.setSomeInteger(this.someInteger);
            dummyEntity.setSomeNumber(this.someNumber);
            dummyEntity.setSomeDate(someDate);
            return dummyEntity;
        }
    }

}
