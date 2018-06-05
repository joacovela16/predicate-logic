package jvc.predicate.engine.type;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class PLOperator<C> {

    private BiFunction<Number, Number, C> nr2number;
    private BiFunction<Number, Boolean, C> nr2Bool;
    private BiFunction<Number, String, C> nr2Str;

    private BiFunction<Boolean, Number, C> bool2number;
    private BiFunction<Boolean, Boolean, C> bool2Bool;
    private BiFunction<Boolean, String, C> bool2Str;

    private BiFunction<String, Number, C> str2number;
    private BiFunction<String, Boolean, C> str2Bool;
    private BiFunction<String, String, C> str2Str;

    private Supplier<C> defaultAction;

    public PLOperator() {

    }

    public C process(Object n, Object m) {

        Number n1, n2;
        String s1, s2;
        Boolean b1, b2;

        if (PLUtil.isNumber(n)) {

            n1 = PLUtil.asNumber(n);

            if (PLUtil.isNumber(m)) {

                n2 = PLUtil.asNumber(m);

                return nr2number == null ? defaultAction.get() : nr2number.apply(n1, n2);

            } else if (PLUtil.isBool(m)) {

                b2 = PLUtil.asBool(m);

                return nr2Bool == null ? defaultAction.get() : nr2Bool.apply(n1, b2);
            } else if (PLUtil.isStr(m)) {

                s2 = PLUtil.asStr(m);

                return nr2Str == null ? defaultAction.get() : nr2Str.apply(n1, s2);
            }

        } else if (PLUtil.isBool(n)) {

            b1 = PLUtil.asBool(n);

            if (PLUtil.isNumber(m)) {

                n2 = PLUtil.asNumber(m);

                return bool2number == null ? defaultAction.get() : bool2number.apply(b1, n2);
            } else if (PLUtil.isBool(m)) {

                b2 = PLUtil.asBool(m);

                return bool2Bool == null ? defaultAction.get() : bool2Bool.apply(b1, b2);
            } else if (PLUtil.isStr(m)) {

                s2 = PLUtil.asStr(m);

                return bool2Str == null ? defaultAction.get() : bool2Str.apply(b1, s2);
            }

        } else if (PLUtil.isStr(n)) {

            s1 = PLUtil.asStr(n);

            if (PLUtil.isNumber(m)) {

                n2 = PLUtil.asNumber(m);

                return str2number == null ? defaultAction.get() : str2number.apply(s1, n2);
            } else if (PLUtil.isBool(m)) {

                b2 = PLUtil.asBool(m);

                return str2Bool == null ? defaultAction.get() : str2Bool.apply(s1, b2);
            } else if (PLUtil.isStr(m)) {

                s2 = PLUtil.asStr(m);

                return str2Str == null ? defaultAction.get() : str2Str.apply(s1, s2);
            }
        }

        return defaultAction.get();
    }

    public void setDefaultAction(Supplier<C> defaultAction) {

        this.defaultAction = defaultAction;
    }

    public void setNr2Nr(BiFunction<Number, Number, C> nr2number) {

        this.nr2number = nr2number;
    }

    public void setNr2Bool(BiFunction<Number, Boolean, C> nr2Bool) {

        this.nr2Bool = nr2Bool;
    }

    public void setNr2Str(BiFunction<Number, String, C> nr2Str) {

        this.nr2Str = nr2Str;
    }

    public void setBool2Nr(BiFunction<Boolean, Number, C> bool2number) {

        this.bool2number = bool2number;
    }

    public void setBool2Bool(BiFunction<Boolean, Boolean, C> bool2Bool) {

        this.bool2Bool = bool2Bool;
    }

    public void setBool2Str(BiFunction<Boolean, String, C> bool2Str) {

        this.bool2Str = bool2Str;
    }

    public void setStr2Nr(BiFunction<String, Number, C> str2number) {

        this.str2number = str2number;
    }

    public void setStr2Bool(BiFunction<String, Boolean, C> str2Bool) {

        this.str2Bool = str2Bool;
    }

    public void setStr2Str(BiFunction<String, String, C> str2Str) {

        this.str2Str = str2Str;
    }
}
