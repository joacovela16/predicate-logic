package jvc.predicate.engine;

import jvc.predicate.engine.types.PLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private static final Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    private Map<String, PLType<?>> variables;

    public SymbolTable() {

        variables = new HashMap<>();
    }

    public void addVariable(String name, PLType<?> value) {

        if (variables.containsKey(name)) {
            logger.warn(String.format("Existe variable %s ", name));
        } else if (value != null) {
            variables.put(name, value);
        } else {
            logger.info("No puede ser nulo el valor");
        }
    }

    public void forceAddVariable(String name, PLType<?> value){
        variables.put(name, value);
    }

    public PLType<?> getVariable(String name) {

        return variables.getOrDefault(name, null);
    }
}
