package jvc.predicate.engine.types;

import jvc.predicate.engine.types.impl.*;

import java.util.Objects;

public abstract class PLType<T> {

    public final static String INT = "int";
    public final static String BOOLEAN = "bool";
    public final static String FLOAT = "float";
    public final static String STRING = "string";
    public final static String COLLECTION = "collection";
    public final static String FUNCTION = "function";
    public final static String PREDICATE = "predicate";

    private T data;

    public PLType(T data) {

        this.data = data;
    }

    public abstract String getType();

    public T getData() {

        return data;
    }

    public boolean is(String type) {

        return Objects.equals(getType(), type);
    }

    public PLCollection toCollection() {

        return (PLCollection) this;
    }

    public PLInt toInt() {

        switch (getType()) {
            case INT:
                return (PLInt) this;
            case FLOAT:
                return new PLInt(toFloat().getData().intValue());
            case BOOLEAN:
                return new PLInt(toBool().getData() ? 1 : 0);
            default:
                return null;
        }
    }

    public PLBoolean toBool() {

        if (getType().equals(BOOLEAN)) {
            return (PLBoolean) this;
        }

        return null;
    }

    public PLFloat toFloat() {

        switch (getType()) {
            case FLOAT:
                return (PLFloat) this;
            case INT:
                return new PLFloat(toInt().getData().floatValue());
            case BOOLEAN:
                return new PLFloat(toBool().getData() ? 1f : 0f);
            default:
                return null;
        }
    }

    public PLString toStr() {

        switch (getType()) {
            case BOOLEAN:
                return new PLString(toBool().getData().toString());
            case INT:
                return new PLString(toInt().getData().toString());
            case FLOAT:
                return new PLString(toFloat().getData().toString());
            case STRING:
                return (PLString) this;
            default:
                return null;
        }
    }
}
