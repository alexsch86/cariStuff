package org.learning.caristuff.domain.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class JpaAggregateRoot<ENTITY extends JpaAggregateRoot<ENTITY, ID>, ID> extends BaseEntity<ENTITY, ID> {

    @Version
    @Column(name = "version")
    private int version = 0;

    public int getVersion() {
        return version;
    }

    private void setVersion(int version) {
        this.version = version;
    }

}