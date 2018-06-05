package jvc.predicate.engine.type;

import java.util.Arrays;
import java.util.List;

public class PLTypeFactory {

    @SafeVarargs
    public static <T> List<T> add(T... items) {

        return Arrays.asList(items);
    }

}
