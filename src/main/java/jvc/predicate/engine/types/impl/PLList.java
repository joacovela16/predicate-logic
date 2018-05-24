package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

import java.util.List;

public class PLList<A extends PLAtomic<?>> extends PLType<List<A>> {

    public PLList(List<A> data) {
        super(data);
    }

    @Override
    public String getType() {
        return PLType.LIST;
    }
}
