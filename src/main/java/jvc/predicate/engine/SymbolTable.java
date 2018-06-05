package jvc.predicate.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private static final Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    private Map<String, Object> variables;

    public SymbolTable() {

        variables = new HashMap<>();
    }

    public void addVariable(String name, Object value) {

        if (variables.containsKey(name)) {
            logger.warn(String.format("Existe variable %s ", name));
        } else if (value != null) {
            variables.put(name, value);
        } else {
            logger.info("No puede ser nulo el valor");
        }
    }

    public void removeVariable(String name) {

        variables.remove(name);
    }

    public void forceAddVariable(String name, Object value) {

        variables.put(name, value);
    }

    public Object getVariable(String name) {

        return variables.getOrDefault(name, null);
    }

    @SuppressWarnings("unchecked")
    public <T> T getVariable(String name, Class<T> tClass) {

        if (tClass != null && variables.containsKey(name)) {
            Object o = variables.get(name);
            if (o.getClass().isInstance(tClass)) {
                return (T) o;
            }
        }

        return null;
    }
}
