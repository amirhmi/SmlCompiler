package ast.node.expression;

import ast.Visitor;
import ast.node.expression.Expression;

public class This extends Expression {
    @Override
    public String toString() {
        return "This";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
