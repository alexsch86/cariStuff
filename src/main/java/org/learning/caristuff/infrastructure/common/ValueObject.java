package org.learning.caristuff.infrastructure.common;

public class ValueObject {

    private static final int HASH_CODE = 0;

    public ValueObject() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public final int hashCode() {
        return HASH_CODE;
    }

}
