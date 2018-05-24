package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

public class PLInt extends PLAtomic<Integer> {

    public PLInt(Integer data) {
        super(data);
    }

    @Override
    public String getType() {
        return PLType.INT;
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}
