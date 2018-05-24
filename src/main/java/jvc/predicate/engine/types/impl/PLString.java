package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

public class PLString extends PLAtomic<String> {

    public PLString(String data) {
        super(data);
    }

    @Override
    public String getType() {
        return PLType.STRING;
    }
}
