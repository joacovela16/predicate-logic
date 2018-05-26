package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

public class PLBoolean extends PLAtomic<Boolean> {

    public PLBoolean(Boolean data) {

        super(data);
    }

    public PLBoolean(String data) {

        super(Boolean.valueOf(data));
    }

    @Override
    public String getType() {

        return PLType.BOOLEAN;
    }

    @Override
    public String toString() {

        return String.valueOf(getData());
    }
}
