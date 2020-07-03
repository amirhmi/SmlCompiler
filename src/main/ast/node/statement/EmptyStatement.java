package main.ast.node.statement;

import ast.node.statement.Statement;
import ast.Visitor;
import ast.node.expression.Expression;

public class EmptyStatement extends Statement {
    Expression expression;
}
