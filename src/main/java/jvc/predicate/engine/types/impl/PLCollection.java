package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

import java.util.Collection;

public class PLCollection<A> extends PLType<Collection<A>> {

    public PLCollection(Collection<A> data) {

        super(data);
    }

    @Override
    public String getType() {

        return PLType.COLLECTION;
    }
}
