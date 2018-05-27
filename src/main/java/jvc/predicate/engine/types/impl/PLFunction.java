package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

import java.util.function.Function;

public class PLFunction<IN, OUT> extends PLType<Function<IN, OUT>> {

    public PLFunction(Function<IN, OUT> data) {
        super(data);
    }

    @Override
    public String getType() {

        return PLType.FUNCTION;
    }
}
