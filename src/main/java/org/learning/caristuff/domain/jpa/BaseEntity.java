package org.learning.caristuff.domain.jpa;

import java.lang.reflect.ParameterizedType;

import static java.util.Objects.hash;

@SuppressWarnings("unchecked")
public abstract class BaseEntity<ENTITY extends BaseEntity<ENTITY, ID>, ID> {

    public abstract ID getId();

    @Override
    public final boolean equals(Object obj) {
        if (obj == null)
            return false;
        return hasSameClass(obj) && isSameAs((ENTITY) obj);
    }

    private boolean isSameAs(ENTITY entity) {
        if (this == entity) {
            return true;
        }
        if (getId() == null || entity.getId() == null) {
            return false;
        }
        return equal(getId(), entity.getId());
    }

    private boolean equal(Object a, Object b) {
        return a == b || a != null && a.equals(b);
    }

    private boolean hasSameClass(Object obj) {
        return getEntityClass().isInstance(obj)
                && ((ENTITY) obj).getEntityClass().equals(this.getEntityClass());
    }

    protected final Class<ENTITY> getEntityClass() {
        Class<?> currentClass = this.getClass();
        while (!(currentClass.getGenericSuperclass() instanceof ParameterizedType)) {
            currentClass = currentClass.getSuperclass();
        }

        return ((Class<ENTITY>) ((ParameterizedType) currentClass.getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public final int hashCode() {
        return hash(getId());
    }

    @Override
    public String toString() {
        return getEntityClass().getSimpleName() + ": " + getId();
    }


}
