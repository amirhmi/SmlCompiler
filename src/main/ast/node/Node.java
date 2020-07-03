package ast.node;

import ast.Visitor;

public abstract class Node {
    private int line;
    public void setLine(int line) { this.line = line; }
    public int getLine() { return line; }
    public void accept(Visitor visitor) {}
}
