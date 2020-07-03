package ast;

import ast.Type.UserDefinedType.UserDefinedType;
import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
import ast.node.expression.Value.StringValue;
import ast.node.statement.*;
import ast.Type.*;
import main.ast.node.statement.EmptyStatement;
import symbolTable.*;
import ast.node.expression.This;

import java.util.*;

import java.util.List;

public class VisitorImpl implements Visitor {

    boolean has_error = false;
    String pre_order = "";
    private ClassDeclaration currentClassDeclaration;

    public boolean getHasError() { return has_error; }
    public void resetHasError() { has_error = false; }

    @Override
    public void visit(Program program) {
        SymbolTable st = new SymbolTable();
        SymbolTable.push(st);

        program.setSymbolTable(st);

        pre_order += program.toString() + "\n";
        program.getMainClass().accept(this);
        for(int i = 0; i < program.getClasses().size(); i++)
            program.getClasses().get(i).accept(this);

        SymbolTable.pop();

//        if (!has_error)
//            System.out.println(pre_order);
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        pre_order += classDeclaration.toString() + "\n";

        currentClassDeclaration = classDeclaration;
        int ind = 0;
        boolean flag = true;
        while (flag) {
            try {
                if (ind == 0)
                    SymbolTable.top.put(new SymbolTableClassItem(classDeclaration.getName().getName(), classDeclaration));
                else
                    SymbolTable.top.put(new SymbolTableClassItem("Unique_" + classDeclaration.getName().getName() + "_" + Integer.toString(ind),
                                                                 classDeclaration));
                flag = false;
            } catch (ItemAlreadyExistsException e) {
                has_error = true;
                if (ind == 0)
                    System.out.println("Line:" + classDeclaration.getLine() + ":Redefinition of class " + classDeclaration.getName().getName());
                ind++;
            }
        }
        if (ind != 0)
            classDeclaration.getName().setName("Unique_" + classDeclaration.getName().getName() + "_" + Integer.toString(ind));
        classDeclaration.getName().accept(this);
        if (classDeclaration.getParentName() != null)
            classDeclaration.getParentName().accept(this);

        SymbolTable st = new SymbolTable(SymbolTable.top);
        SymbolTable.push(st);
        classDeclaration.setSymbolTable(st);
        for(int i = 0; i < classDeclaration.getVarDeclarations().size(); i++) {
            classDeclaration.getVarDeclarations().get(i).setClassDeclaration(classDeclaration);
            classDeclaration.getVarDeclarations().get(i).setIsClassProperty(true);
            classDeclaration.getVarDeclarations().get(i).accept(this);
        }
        for(int i = 0; i < classDeclaration.getMethodDeclarations().size(); i++) {
            classDeclaration.getMethodDeclarations().get(i).setClassDeclaration(classDeclaration);
            classDeclaration.getMethodDeclarations().get(i).accept(this);
        }
        SymbolTable.pop();
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        pre_order += methodDeclaration.toString() + "\n";
        ArrayList<Type> arg_types = new ArrayList<Type>();
        for (int i = 0; i < methodDeclaration.getArgs().size(); i++)
            arg_types.add(methodDeclaration.getArgs().get(i).getType());
        int ind = 0;
        boolean flag = true;
        while (flag) {
            try {
                if (ind == 0)
                    SymbolTable.top.put(new SymbolTableMethodItem(methodDeclaration.getName().getName(), arg_types, methodDeclaration));
                else
                    SymbolTable.top.put(new SymbolTableMethodItem("Unique_" + methodDeclaration.getName().getName() + "_" + Integer.toString(ind),
                                                                  arg_types, methodDeclaration));
                flag = false;
            } catch (ItemAlreadyExistsException e) {
                has_error = true;
                if (ind == 0)
                    System.out.println("Line:" + methodDeclaration.getLine() + ":Redefinition of method " + methodDeclaration.getName().getName());
                ind++;
            }
        }
        if (ind != 0)
            methodDeclaration.getName().setName("Unique_" + methodDeclaration.getName().getName() + "_" + Integer.toString(ind));
        methodDeclaration.getName().accept(this);

        SymbolTable st = new SymbolTable(SymbolTable.top);
        SymbolTable.push(st);
        methodDeclaration.setSymbolTable(st);
        for(int i = 0; i < methodDeclaration.getArgs().size(); i++)
            methodDeclaration.getArgs().get(i).accept(this);
        //pre_order += methodDeclaration.getReturnType().toString() + "\n";
        for(int i = 0; i < methodDeclaration.getLocalVars().size(); i++) {
            methodDeclaration.getLocalVars().get(i).setMethodDeclaration(methodDeclaration);
            methodDeclaration.getLocalVars().get(i).accept(this);
        }
//        System.out.println(methodDeclaration.getName().getName());
        for(int i = 0; i < methodDeclaration.getBody().size(); i++) {
            if (methodDeclaration.getBody().get(i) == null)
                continue;
            if (methodDeclaration.getBody().get(i).isEmpty() && methodDeclaration.getBody().get(i).getExpression() != null)
                methodDeclaration.getBody().get(i).getExpression().accept(this);
            else
                methodDeclaration.getBody().get(i).accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
        SymbolTable.pop();
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        pre_order += varDeclaration.toString() + "\n";

        int ind = 0;
        boolean flag = true;
        while (flag) {
            try {
                if (ind == 0)
                    SymbolTable.top.put(new SymbolTableVariableItem(varDeclaration.getIdentifier().getName(), varDeclaration.getType(),
                                                                    varDeclaration));
                else
                    SymbolTable.top.put(new SymbolTableVariableItem("Unique_" + varDeclaration.getIdentifier().getName() + "_" + Integer.toString(ind),
                                                                    varDeclaration.getType(), varDeclaration));
                flag = false;
            } catch (ItemAlreadyExistsException e) {
                has_error = true;
                if (ind == 0)
                    System.out.println("Line:" + varDeclaration.getLine() + ":Redefinition of variable " + varDeclaration.getIdentifier().getName());
                ind++;
            }
        }
        if (ind != 0)
            varDeclaration.getIdentifier().setName("Unique_" + varDeclaration.getIdentifier().getName() + "_" + Integer.toString(ind));
        varDeclaration.getIdentifier().accept(this);
        //pre_order += varDeclaration.getType().toString() + "\n";
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        pre_order += arrayCall.toString() + "\n";
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        pre_order += binaryExpression.toString() + "\n";
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) { pre_order += identifier.toString() + '\n'; }

    @Override
    public void visit(Length length) {
        pre_order += length.toString() + '\n';
    }

    @Override
    public void visit(MethodCall methodCall) {
        pre_order += methodCall.toString() + '\n';
        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
        for(int i = 0; i < methodCall.getArgs().size(); i++)
            methodCall.getArgs().get(i).accept(this);
    }

    @Override
    public void visit(NewArray newArray) {
        pre_order += newArray.toString() + '\n';
        if (newArray.getSize().getConstant() <= 0) {
            System.out.println("Line:" + newArray.getSize().getLine() + ":Array length should not be zero or negative");
            newArray.getSize().setConstant(0);
        }
        newArray.getSize().accept(this);
    }

    @Override
    public void visit(NewClass newClass) {
        pre_order += newClass.toString() + '\n';
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
       pre_order += this.toString() + '\n';
       instance.setType(new UserDefinedType(currentClassDeclaration));
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        pre_order += unaryExpression.toString() + '\n';
        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {
        pre_order += value.toString() + '\n';
    }

    @Override
    public void visit(IntValue value) {
        pre_order += value.toString() + '\n';
    }

    @Override
    public void visit(StringValue value) {
        pre_order += value.toString() + '\n';
    }

    @Override
    public void visit(Assign assign) {
        pre_order += assign.toString() + '\n';
        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {
        pre_order += block.toString() + '\n';

        SymbolTable st = new SymbolTable(SymbolTable.top);
        SymbolTable.push(st);
        for(int i = 0; i < block.getBody().size(); i++)
            block.getBody().get(i).accept(this);
        SymbolTable.pop();
    }

    @Override
    public void visit(Conditional conditional) {
        pre_order += conditional.toString() + '\n';
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        pre_order += loop.toString() + '\n';
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        pre_order += write.toString() + '\n';
        write.getArg().accept(this);
    }
}
