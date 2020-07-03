package ast.Type.PrimitiveType;

import ast.Type.Type;

public class IntType extends Type {
    public IntType() { isPrimitive = true; }
    @Override
    public String toString() {
        return "int";
    }
}
