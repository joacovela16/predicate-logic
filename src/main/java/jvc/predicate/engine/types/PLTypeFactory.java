package jvc.predicate.engine.types;

import jvc.predicate.engine.types.impl.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

public class PLTypeFactory {

    public static PLType<?> test(Object datum) {

        if (datum instanceof Integer) {
            return add((Integer) datum);
        } else if (datum instanceof Float) {
            return add((Float) datum);
        } else if (datum instanceof Boolean) {
            return add((Boolean) datum);
        } else if (datum instanceof String) {
            return add((String) datum);
        }

        return null;
    }

    public static <I, O> PLFunction<I, O> add(Function<I, O> f) {

        return new PLFunction<>(f);
    }

    public static PLInt add(Integer value) {

        return new PLInt(value);
    }

    public static PLBoolean add(Boolean value) {

        return new PLBoolean(value);
    }

    public static PLFloat add(Float value) {

        return new PLFloat(value);
    }

    public static PLString add(String value) {

        return new PLString(value);
    }

    @SafeVarargs
    public static <A> PLCollection<A> add(A... items) {

        return new PLCollection<>(Arrays.asList(items));
    }

    public static <A> PLCollection<A> add(Collection<A> items) {

        return new PLCollection<>(items);
    }
}
