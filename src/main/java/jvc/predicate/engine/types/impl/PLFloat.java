package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

public class PLFloat extends PLAtomic<Float> {

    public PLFloat(Float data) {
        super(data);
    }

    @Override
    public String getType() {
        return PLType.FLOAT;
    }
}
