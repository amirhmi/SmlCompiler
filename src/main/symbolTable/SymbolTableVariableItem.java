package symbolTable;

import ast.Type.Type;
import symbolTable.SymbolTableItem;
import ast.node.declaration.VarDeclaration;
import ast.node.declaration.*;

public class SymbolTableVariableItem extends SymbolTableItem {

    static int last_index = 1;
    private int index;
    protected Type type;
    private VarDeclaration variableDeclaration;

    public SymbolTableVariableItem(String name, Type type, VarDeclaration variableDeclaration) {
        this.name = name;
        this.type = type;
        this.index = last_index++;
        this.variableDeclaration = variableDeclaration;
    }
    public SymbolTableVariableItem(String name, Type type, VarDeclaration variableDeclaration, int index) {
        this.name = name;
        this.type = type;
        this.index = index;
        this.variableDeclaration = variableDeclaration;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public VarDeclaration getVariableDeclaration () { return variableDeclaration; }

    public void setVariableDeclaration (VarDeclaration variableDeclaration) { this.variableDeclaration = variableDeclaration; }

    @Override
    public String getKey() {
        return name + "-variable";
    }

    public int getIndex() {
        return index;
    }
}