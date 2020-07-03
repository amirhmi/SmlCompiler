package ast.node.declaration;

import ast.Type.Type;
import ast.Visitor;
import ast.node.expression.Identifier;
import ast.node.declaration.*;
import ast.node.declaration.MethodDeclaration;

import java.lang.reflect.Method;

public class VarDeclaration extends Declaration {
    private Identifier identifier;
    private Type type;
    private ClassDeclaration classDeclaration;
    private MethodDeclaration methodDeclaration;
    private boolean isClassProperty;

    public VarDeclaration(Identifier identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
        this.isClassProperty = false;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ClassDeclaration getClassDeclaration () { return classDeclaration; }

    public void setClassDeclaration(ClassDeclaration classDeclaration) { this.classDeclaration = classDeclaration; }

    public MethodDeclaration getMethodDeclaration () { return methodDeclaration; }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) { this.methodDeclaration = methodDeclaration; }

    public boolean getIsClassProperty () { return isClassProperty; }

    public void setIsClassProperty (boolean isClassProperty) { this.isClassProperty = isClassProperty; }

    @Override
    public String toString() {
        return "VarDeclaration";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
