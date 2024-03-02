package org.learning.caristuff.domain.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class JpaAggregateRoot<ENTITY extends JpaAggregateRoot<ENTITY, ID>, ID> extends BaseEntity<ENTITY, ID> {

    @Version
    @Column(name = "version")
    private int version = 1;

    public int getVersion() {
        return version;
    }

    private void setVersion(int version) {
        this.version = version;
    }

}