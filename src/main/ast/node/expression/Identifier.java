package ast.node.expression;

import ast.Visitor;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.Expression;

public class Identifier extends Expression {
    private String name;
    private VarDeclaration varDeclaration;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VarDeclaration getVarDeclaration () { return varDeclaration; }

    public void setVarDeclaration (VarDeclaration varDeclaration) { this.varDeclaration = varDeclaration; }

    @Override
    public String toString() {
        return "Identifier " + name;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
