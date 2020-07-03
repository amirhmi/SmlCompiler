package ast.Type.PrimitiveType;

import ast.Type.Type;

public class StringType extends Type {
    public StringType() { isPrimitive = true; }

    @Override
    public String toString() {
        return "string";
    }
}
