package symbolTable;

import ast.Type.Type;
import ast.node.declaration.MethodDeclaration;
import symbolTable.SymbolTableItem;
import ast.node.declaration.*;

import java.util.ArrayList;

public class SymbolTableMethodItem extends SymbolTableItem {

    MethodDeclaration methodDeclaration;
    ArrayList<Type> argTypes = new ArrayList<>();

    public SymbolTableMethodItem(String name, ArrayList<Type> argTypes, MethodDeclaration methodDeclaration) {
        this.name = name;
        this.argTypes = argTypes;
        this.methodDeclaration = methodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) { this.methodDeclaration = methodDeclaration; }

    public MethodDeclaration getMethodDeclaration() { return methodDeclaration; }

    @Override
    public String getKey() {
        return name + "-method";
    }
}
