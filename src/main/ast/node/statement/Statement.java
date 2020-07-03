package ast.node.statement;

import ast.Visitor;
import ast.node.Node;
import ast.node.expression.Expression;

public class Statement extends Node {

    boolean empty = false;
    Expression expression;

    public void setExpression(Expression expression) { this.expression = expression; }

    public Expression getExpression() { return expression; }

    public boolean isEmpty() { return empty; }
    public void setEmpty(boolean empty) { this.empty = empty; }

    @Override
    public String toString() { return "Statement"; }

    @Override
    public void accept(Visitor visitor) {}
}
