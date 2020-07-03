package ast.node.declaration;

import ast.Visitor;
import ast.node.expression.Identifier;
import symbolTable.*;

import java.util.ArrayList;

public class ClassDeclaration extends Declaration{
    private Identifier name;
    private Identifier parentName;
    private ArrayList<VarDeclaration> varDeclarations = new ArrayList<>();
    private ArrayList<MethodDeclaration> methodDeclarations = new ArrayList<>();
    private ClassDeclaration parentClassDeclaration;
    private ArrayList<ClassDeclaration> childClassDeclarations = new ArrayList<>();
    private SymbolTable symbolTable;
    public boolean cycleFlag = false;

    public ClassDeclaration(Identifier name, Identifier parentName) {
        this.name = name;
        this.parentName = parentName;
    }

    public boolean cycleCheck()
    {
        if (cycleFlag)
            return false;
        cycleFlag = true;
        if (parentClassDeclaration != null)
            return parentClassDeclaration.cycleCheck();
        return true;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public Identifier getParentName() {
        return parentName;
    }

    public void setParentName(Identifier parentName) {
        this.parentName = parentName;
    }

    public ArrayList<VarDeclaration> getVarDeclarations() {
        return varDeclarations;
    }

    public void addVarDeclaration(VarDeclaration varDeclaration) {
        this.varDeclarations.add(varDeclaration);
    }

    public ArrayList<MethodDeclaration> getMethodDeclarations() {
        return methodDeclarations;
    }

    public void addMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclarations.add(methodDeclaration);
    }

    public ClassDeclaration getParentClassDeclaration() { return parentClassDeclaration; }

    public void setParentClassDeclaration(ClassDeclaration parentClassDeclaration) { this.parentClassDeclaration = parentClassDeclaration; }

    public ArrayList<ClassDeclaration> getChildClassDeclarations() { return childClassDeclarations; }

    public void addChildClassDeclaration(ClassDeclaration child) { this.childClassDeclarations.add(child); }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }

    @Override
    public String toString() {
        return "ClassDeclaration";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
