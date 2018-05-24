package jvc.predicate.engine.types;

import jvc.predicate.engine.types.impl.*;

public class PLTypeFactory {

    public static PLInt getInt(int n) {
        return new PLInt(n);
    }

    public static PLFloat getFloat(float n) {
        return new PLFloat(n);
    }

    public static PLString getStr(Object n) {
        if (n == null) {
            return null;
        } else {
            return new PLString(n.toString());
        }
    }

    public static <A extends PLAtomic<?>> PLList<A> getList(int ...values){
        return null;
    }
}
