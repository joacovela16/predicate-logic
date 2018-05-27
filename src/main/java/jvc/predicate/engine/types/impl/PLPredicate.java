package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

import java.util.function.Function;

public class PLPredicate<IN> extends PLType<Function<IN, Boolean>> {

    public PLPredicate(Function<IN, Boolean> data) {
        super(data);
    }

    @Override
    public String getType() {

        return PLType.PREDICATE;
    }
}
