package ast.Type.PrimitiveType;

import ast.Type.Type;

public class BooleanType extends Type {
    public BooleanType() { isPrimitive = true; }

    @Override
    public String toString() {
        return "bool";
    }
}
