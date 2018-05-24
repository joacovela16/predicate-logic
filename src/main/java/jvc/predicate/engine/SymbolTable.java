package jvc.predicate.engine;

import jvc.predicate.engine.types.PLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {

    private static final Logger logger = LoggerFactory.getLogger(SymbolTable.class);

    private Map<String, PLType<?>> variables;
    private Stack<SymbolTable> symbolTableStack;
    private SymbolTable parent = null;

    public SymbolTable() {
        variables = new HashMap<>();
        symbolTableStack = new Stack<>();
    }

    public void addVariable(String name, PLType<?> value) {
        if (variables.containsKey(name)) {
            logger.info(String.format("Existe variable %s ", name));
        } else if (value != null) {
            variables.put(name, value);
        } else {
            logger.info("No puede ser nulo el valor");
        }
    }

    public void push(SymbolTable table) {
        symbolTableStack.push(table);
    }

    public SymbolTable peek() {
        return symbolTableStack.peek();
    }

    public boolean isRoot() {
        return parent == null;
    }

    private void setParent(SymbolTable parent) {
        this.parent = parent;
    }

    private SymbolTable getParent() {
        return parent;
    }

    public PLType<?> getVariable(String name) {
        if (variables.containsKey(name)) {
            return variables.get("name");
        } else {
            if (isRoot()) {
                return null;
            } else {
                return getParent().getVariable(name);
            }
        }
    }
}
