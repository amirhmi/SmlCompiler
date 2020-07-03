package ast.node;

import ast.Visitor;
import java.util.ArrayList;
import symbolTable.SymbolTable;
import ast.node.declaration.ClassDeclaration;
import java.util.List;

public class Program {
    private ArrayList<ClassDeclaration> classes = new ArrayList<>();
    private ClassDeclaration mainClass;
    private SymbolTable symbolTable;

    public ClassDeclaration getMainClass() {
        return mainClass;
    }

    public void setMainClass(ClassDeclaration mainClass) {
        this.mainClass = mainClass;
    }

    public void addClass(ClassDeclaration classDeclaration) {
        classes.add(classDeclaration);
    }

    public List<ClassDeclaration> getClasses() {
        return classes;
    }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }

    @Override
    public String toString() {
        return "Program";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
