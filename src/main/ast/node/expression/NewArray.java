package ast.node.expression;

import ast.Visitor;
import ast.node.expression.Expression;
import ast.node.expression.Value.IntValue;

public class NewArray extends Expression {
    private IntValue size;

    public IntValue getSize() {
        return size;
    }

    public void setSize(IntValue size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "NewArray";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
