package symbolTable;

import ast.Type.Type;
import ast.node.declaration.*;

import java.util.ArrayList;

public class SymbolTableClassItem extends SymbolTableItem{
    private ClassDeclaration classDeclaration;

    public SymbolTableClassItem(String name, ClassDeclaration classDeclaration)
    {
        this.name = name;
        this.classDeclaration = classDeclaration;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    @Override
    public String getKey() {
        return name + "-class";
    }
}

