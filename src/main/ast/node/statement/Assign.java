package ast.node.statement;

import ast.Visitor;
import ast.node.statement.Statement;
import ast.node.expression.Expression;
import ast.Type.Type;

public class Assign extends Statement {
    private Expression lValue;
    private Expression rValue;
    private  Type type;

    public Assign(Expression lValue, Expression rValue) {
        this.lValue = lValue;
        this.rValue = rValue;
    }

    public Expression getlValue() {
        return lValue;
    }

    public void setlValue(Expression lValue) {
        this.lValue = lValue;
    }

    public Expression getrValue() {
        return rValue;
    }

    public void setrValue(Expression rValue) {
        this.rValue = rValue;
    }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    @Override
    public String toString() {
        return "Assign";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
