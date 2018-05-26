package jvc.predicate.engine.evaluator;

public class EvaluatorResult<T> {

    private T data;
    private boolean success;
    private String message;

    public EvaluatorResult(T data) {

        this(true, data, null);
    }

    public EvaluatorResult(String message) {

        this(false, null, message);
    }

    public EvaluatorResult(boolean success, T data, String message) {

        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {

        return success;
    }

    public T getData() {

        return data;
    }

    public String getMessage() {

        return message;
    }

    @Override
    public String toString() {
        return String.format("Status: %s\nResult:\n%s", success ? "OK" : message, data);
    }
}
