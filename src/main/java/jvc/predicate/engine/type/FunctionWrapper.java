package jvc.predicate.engine.type;

import java.util.Objects;
import java.util.function.BiFunction;

public class FunctionWrapper<M, N, C> {

    private Class<M> mClass;
    private Class<N> nClass;
    private BiFunction<M, N, C> function;

    public FunctionWrapper(Class<M> mClass, Class<N> nClass, BiFunction<M, N, C> function) {

        this.mClass = mClass;
        this.nClass = nClass;
        this.function = function;
    }

    public BiFunction<M, N, C> getFunction() {

        return function;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionWrapper<?, ?, ?> that = (FunctionWrapper<?, ?, ?>) o;
        return Objects.equals(mClass, that.mClass) &&
                Objects.equals(nClass, that.nClass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mClass, nClass);
    }

}
