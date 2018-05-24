package jvc.predicate.engine.types.impl;

import jvc.predicate.engine.types.PLType;

public abstract class PLAtomic<T> extends PLType<T> {

    public PLAtomic(T data) {
        super(data);
    }
}
