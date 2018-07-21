package jvc.predicate.engine.type;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PLUtil {

    private final static Set<String> primitives = new HashSet<String>() {{
        add(getType(Integer.class));
        add(getType(Boolean.class));
        add(getType(Float.class));
        add(getType(String.class));
    }};

    private final static Set<String> types = new HashSet<String>() {{
        addAll(primitives);
        add(getType(Collection.class));
    }};

    public static boolean isValidType(Object n) {

        return types.contains(getType(n));
    }

    public static <T> String getType(T data) {

        return data.getClass().getSimpleName();
    }

    public static <T> String getType(Class<T> tClass) {

        return tClass.getSimpleName();
    }

    public static Collection<?> asCollection(Object n) {

        if (isCollection(n)) {
            return (Collection<?>) n;
        }

        return null;
    }

    public static boolean isCollection(Object n) {

        return is(n, Collection.class);
    }

    public static boolean isNumber(Object n) {

        return is(n, Number.class);
    }

    public static boolean isBool(Object n) {

        return is(n, Boolean.class);
    }

    public static boolean isStr(Object n) {

        return is(n, String.class);
    }

    public static <T> boolean isPrimitive(Class<T> tClass) {

        return primitives.contains(getType(tClass));
    }

    public static <T> boolean is(Object n, Class<T> tClass) {

        return tClass != null && tClass.isInstance(n);
    }

    public static Number asNumber(Object n) {

        if (n instanceof Number) {
            return (Number) n;
        }

        return null;
    }

    public static Integer asInt(Object obj) {

        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    public static String asStr(Object n) {

        if (is(n, String.class)) {
            return (String) n;
        }

        return null;
    }

    public static Boolean asBool(Object obj) {

        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public static Float asFloat(Object obj) {

        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }
}
