package main.ast;

import ast.Type.PrimitiveType.StringType;
import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.Type.Type;
import ast.node.statement.Statement;
import ast.node.statement.Assign;
import ast.node.expression.This;
import ast.node.expression.NewArray;
import ast.node.expression.Length;
import ast.node.expression.MethodCall;
import ast.node.expression.Identifier;
import ast.node.expression.Expression;
import ast.node.expression.ArrayCall;
import ast.node.expression.UnaryOperator;
import ast.node.expression.UnaryExpression;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
import ast.node.expression.Value.StringValue;
import ast.node.expression.BinaryExpression;
import ast.node.expression.BinaryOperator;
import ast.Type.PrimitiveType.BooleanType;
import ast.Type.PrimitiveType.IntType;
import main.ast.node.statement.EmptyStatement;
import symbolTable.SymbolTableClassItem;
import ast.Type.UserDefinedType.UserDefinedType;
import symbolTable.SymbolTableMethodItem;
import symbolTable.SymbolTableVariableItem;
import symbolTable.SymbolTable;
import ast.node.statement.*;
import main.ast.Type.*;
import ast.Type.ArrayType.ArrayType;
import symbolTable.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class VisitorSecondPass implements ast.Visitor {

    private ClassDeclaration currentClassDeclaration;
    private MethodDeclaration currentMethodDeclaration;
    private ArrayList<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
    private Program program;
    private boolean hasVarDecErr = true;
    private int hasRvalErr = 0;
    private boolean isMainClass = false;
    private boolean isEmptyStatement = false;
    public VisitorSecondPass(Program program) { this.program = program; }
    public void setProgram(Program program) { this.program = program; }
    public boolean showErrorMessages() {
        Collections.sort(errorMessages);
        for (int i = 0; i < errorMessages.size(); i++)
            errorMessages.get(i).showError();
        return errorMessages.size() > 0;
    }

    public void resetCycleFlags(Program program)
    {
        program.getMainClass().cycleFlag = false;
        for (int i = 0; i < program.getClasses().size(); i++)
            program.getClasses().get(i).cycleFlag = false;
    }

    @Override
    public void visit(Program program) {
        if (!program.getMainClass().cycleCheck()) {
            new ErrorMessage(program.getMainClass().getName().getLine(), "cyclic parental relationship cannot exist").showError();
            return;
        }
        resetCycleFlags(program);
        for (int i = 0; i < program.getClasses().size(); i++) {
            if (!program.getClasses().get(i).cycleCheck()) {
                new ErrorMessage(program.getClasses().get(i).getName().getLine(), "cyclic parental relationship cannot exist").showError();
                return;
            }
            resetCycleFlags(program);
        }
        isMainClass = true;
        program.getMainClass().accept(this);
        isMainClass = false;
        for(int i = 0; i < program.getClasses().size(); i++)
            program.getClasses().get(i).accept(this);
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        currentClassDeclaration = classDeclaration;
        classDeclaration.getName().accept(this);
        if (classDeclaration.getParentName() != null)
            classDeclaration.getParentName().accept(this);
        for(int i = 0; i < classDeclaration.getVarDeclarations().size(); i++)
            classDeclaration.getVarDeclarations().get(i).accept(this);
        for(int i = 0; i < classDeclaration.getMethodDeclarations().size(); i++)
            classDeclaration.getMethodDeclarations().get(i).accept(this);
        currentClassDeclaration = null;
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        methodDeclaration.getName().accept(this);
        for(int i = 0; i < methodDeclaration.getArgs().size(); i++)
            methodDeclaration.getArgs().get(i).accept(this);
        for(int i = 0; i < methodDeclaration.getLocalVars().size(); i++)
            methodDeclaration.getLocalVars().get(i).accept(this);
        currentMethodDeclaration = methodDeclaration;
        for(int i = 0; i < methodDeclaration.getBody().size(); i++) {
            if (methodDeclaration.getBody().get(i).isEmpty() && !isMainClass) {
                errorMessages.add(new ErrorMessage(methodDeclaration.getBody().get(i).getLine(), "invalid statement"));
                continue;
            }
            if (methodDeclaration.getBody().get(i).isEmpty())
                methodDeclaration.getBody().get(i).getExpression().accept(this);
            else
                methodDeclaration.getBody().get(i).accept(this);
            isEmptyStatement = false;
        }
        methodDeclaration.getReturnValue().accept(this);
        if (!methodDeclaration.getReturnType().getIsPrimitive()) {
            ((UserDefinedType)methodDeclaration.getReturnType()).setClassDeclaration(program.getSymbolTable()
                    .findClassDec(new SymbolTableClassItem
                            (((UserDefinedType)methodDeclaration.getReturnType()).getName().getName(), null)));
            if (((UserDefinedType)methodDeclaration.getReturnType()).getClassDeclaration() == null)
            {
                errorMessages.add(new ErrorMessage(methodDeclaration.getName().getLine(), "class " +
                        ((UserDefinedType)methodDeclaration.getReturnType()).getName().getName() + " is not declared"));
                methodDeclaration.setReturnType(new NoType());
            }

        }
        if (!Type.compare(methodDeclaration.getReturnValue().getType(), methodDeclaration.getReturnType()))
            errorMessages.add(new ErrorMessage(methodDeclaration.getReturnValue().getLine(),
                    methodDeclaration.getName().getName() + " return type must be " +
                    methodDeclaration.getReturnType().toString()));
        currentMethodDeclaration = null;
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        if (!varDeclaration.getType().getIsPrimitive()) {
            ((UserDefinedType)varDeclaration.getType()).setClassDeclaration(program.getSymbolTable()
                    .findClassDec(new SymbolTableClassItem
                            (((UserDefinedType) varDeclaration.getType()).getName().getName(), null)));
            if (((UserDefinedType)varDeclaration.getType()).getClassDeclaration() == null)
            {
                errorMessages.add(new ErrorMessage(varDeclaration.getIdentifier().getLine(), "class " +
                        ((UserDefinedType)varDeclaration.getType()).getName().getName() + " is not declared"));
                varDeclaration.setType(new NoType());
            }
        }
        varDeclaration.getIdentifier().accept(this);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        int tempRval = hasRvalErr;
        hasRvalErr = 0;
        arrayCall.getIndex().accept(this);
        hasRvalErr = tempRval;
        if(!Type.compare(arrayCall.getInstance().getType(), new ArrayType(-1)))
            errorMessages.add(new ErrorMessage(arrayCall.getLine(), "unsupported operand type for " + arrayCall.toString()));
        arrayCall.setType(new IntType());
        if (isMainClass && isEmptyStatement)
            errorMessages.add(new ErrorMessage(arrayCall.getLine(), "method call used without return value usage"));
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "left side of assignment must be a valid lvalue"));
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);

        Expression lexp = binaryExpression.getLeft();
        Expression rexp = binaryExpression.getRight();
        if (binaryExpression.getBinaryOperator() == BinaryOperator.add ||
            binaryExpression.getBinaryOperator() == BinaryOperator.sub ||
            binaryExpression.getBinaryOperator() == BinaryOperator.mult ||
            binaryExpression.getBinaryOperator() == BinaryOperator.div) {
            if (!Type.compare(lexp.getType(), new IntType()) ||
                !Type.compare(rexp.getType(), new IntType()))
                errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "unsupported operand type for " +
                        binaryExpression.getBinaryOperator().toString()));
            binaryExpression.setType(new IntType());
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.and ||
                 binaryExpression.getBinaryOperator() == BinaryOperator.or) {
            if (!Type.compare(lexp.getType(), new BooleanType()) ||
                !Type.compare(rexp.getType(), new BooleanType()))
                errorMessages.add(new ErrorMessage(binaryExpression.getLine(),  "unsupported operand type for " +
                        binaryExpression.getBinaryOperator().toString()));
            binaryExpression.setType(new BooleanType());
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.assign) {
            if (!Type.compare(lexp.getType(), rexp.getType())) {
                binaryExpression.setType(new NoType());
                errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "unsupported operand type for " +
                        binaryExpression.getBinaryOperator().toString()));
            }
            else
                binaryExpression.setType(rexp.getType());
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.lt ||
                 binaryExpression.getBinaryOperator() == BinaryOperator.gt) {
            if(!Type.compare(lexp.getType(), new IntType()) || !Type.compare(rexp.getType(), new IntType()))
                errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "unsupported operand type for " +
                        binaryExpression.getBinaryOperator().toString()));
            binaryExpression.setType(new BooleanType());
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.eq ||
                 binaryExpression.getBinaryOperator() == BinaryOperator.neq) {
            if (!Type.compare(lexp.getType(), rexp.getType()))
                errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "unsupported operand type for " +
                        binaryExpression.getBinaryOperator().toString()));
            else if (lexp.getType().toString() == new ArrayType(-1).toString() &&
                     rexp.getType().toString() == new ArrayType(-1).toString())
                if (((ArrayType)lexp.getType()).getSize() != ((ArrayType)rexp.getType()).getSize())
                    errorMessages.add(new ErrorMessage(binaryExpression.getLine(), "unsupported operand type for " +
                            binaryExpression.getBinaryOperator().toString()));
            binaryExpression.setType(new BooleanType());
        }
    }

    @Override
    public void visit(Identifier identifier)
    {
        VarDeclaration varDeclaration;
        if (currentMethodDeclaration != null)
        {
            varDeclaration = currentMethodDeclaration.getSymbolTable().findVarDec
                    (new SymbolTableVariableItem(identifier.getName(), null, null));
            if (varDeclaration != null) {
                identifier.setType(varDeclaration.getType());
                identifier.setVarDeclaration(varDeclaration);
                return;
            }
        }
        if (currentClassDeclaration == null)
            return;
        ClassDeclaration me = currentClassDeclaration;
        while (me != null) {
            varDeclaration = me.getSymbolTable().findVarDec
                    (new SymbolTableVariableItem(identifier.getName(), null, null));
            if (varDeclaration != null)
            {
                identifier.setType(varDeclaration.getType());
                identifier.setVarDeclaration(varDeclaration);
                return;
            }
            me = me.getParentClassDeclaration();
        }
        if(currentMethodDeclaration != null && hasVarDecErr) {
                identifier.setType(new NoType());
                errorMessages.add(new ErrorMessage(identifier.getLine(), "variable "
                        + identifier.getName() + " is not declared"));
                try {
                    currentMethodDeclaration.getSymbolTable().put(new SymbolTableVariableItem(identifier.getName(),
                            new NoType(), new VarDeclaration(new Identifier(identifier.getName() + "-notypevardec"), new NoType())));
                }
                catch (symbolTable.ItemAlreadyExistsException e)
                {
                    System.out.println(":D");
                }
                return;
        }
        identifier.setType(null);
    }

    @Override
    public void visit(Length length) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(length.getLine(), "left side of assignment must be a valid lvalue"));
        length.getExpression().accept(this);
        if (!Type.compare(length.getExpression().getType(), new ArrayType(0)))
            errorMessages.add(new ErrorMessage(length.getExpression().getLine(), "length can only be called on Array types"));
        length.setType(new IntType());
    }

    @Override
    public void visit(MethodCall methodCall) {
        MethodDeclaration methodDeclaration = null;
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(methodCall.getLine(), "left side of assignment must be a valid lvalue"));
        if (isEmptyStatement)
        {
            errorMessages.add(new ErrorMessage(methodCall.getLine(), "empty statement"));
            return;
        }
        if (methodCall.getMethodName().getName() == "length")
        {
            Length ln = new Length(methodCall.getInstance());
            ln.accept(this);
            methodCall.setType(ln.getType());
            if (isMainClass && isEmptyStatement)
                errorMessages.add(new ErrorMessage(methodCall.getLine(), "method call used without return value usage"));
            return;
        }
        methodCall.getInstance().accept(this);
        hasVarDecErr = false;
        methodCall.getMethodName().accept(this);
        hasVarDecErr = true;
        if (methodCall.getInstance().getType().toString() == new NoType().toString())
            methodCall.setType(new NoType());
        else if (methodCall.getInstance().getType().getIsPrimitive())
        {
            errorMessages.add(new ErrorMessage(methodCall.getLine(),
                    "there is no method named " + methodCall.getMethodName() + " in this primitive type"));
            methodCall.setType(new NoType());
        }
        else if (((UserDefinedType)methodCall.getInstance().getType()).getClassDeclaration() == null)
            methodCall.setType(new NoType());
        else
        {
            methodDeclaration = SymbolTable.findMethodDec(new SymbolTableMethodItem
                    (methodCall.getMethodName().getName(), null, null),
                    ((UserDefinedType)methodCall.getInstance().getType()).getClassDeclaration());
            if (methodDeclaration == null)
            {
                errorMessages.add(new ErrorMessage(methodCall.getLine(), "there is no method named " +
                        methodCall.getMethodName().getName() + " in class " +
                        ((UserDefinedType)methodCall.getInstance().getType()).getClassDeclaration().getName().getName()));
                methodCall.setType(new NoType());
            }
            else
                methodCall.setType(methodDeclaration.getReturnType());
        }
        for(int i = 0; i < methodCall.getArgs().size(); i++)
            methodCall.getArgs().get(i).accept(this);
        if(methodDeclaration != null) {
            if (methodCall.getArgs().size() != methodDeclaration.getArgs().size())
            {
                errorMessages.add(new ErrorMessage(methodCall.getLine(), "Args count should be same as method declaration"));
                return;
            }
            for(int i = 0; i < methodCall.getArgs().size(); i++) {
                if (!Type.compare(methodDeclaration.getArgs().get(i).getType(), methodCall.getArgs().get(i).getType()))
                    errorMessages.add(new ErrorMessage(methodCall.getArgs().get(i).getLine(), "Arg type should be " +
                            methodDeclaration.getArgs().get(i).getType() + " but is " + methodCall.getArgs().get(i).getType().toString()));
            }
            methodCall.setMethodDeclaration(methodDeclaration);
        }
    }

    @Override
    public void visit(NewArray newArray) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(newArray.getLine(), "left side of assignment must be a valid lvalue"));
        newArray.getSize().accept(this);
        ((ArrayType)newArray.getType()).setSize(((IntValue)newArray.getSize()).getConstant());
    }

    @Override
    public void visit(NewClass newClass) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(newClass.getLine(), "left side of assignment must be a valid lvalue"));
//        newClass.getClassName().accept(this);
        ClassDeclaration classDeclaration = program.getSymbolTable().findClassDec(new SymbolTableClassItem(newClass.getClassName().getName(), null));
        if(classDeclaration == null) {
            errorMessages.add(new ErrorMessage(newClass.getLine(), "class "
                    + newClass.getClassName().getName() + " is not declared"));
            newClass.setType(new NoType());
        }
        else {
            newClass.setType(new UserDefinedType(classDeclaration));
        }

    }

    @Override
    public void visit(This instance) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(instance.getLine(), "left side of assignment must be a valid lvalue"));
        instance.setType(new UserDefinedType(currentClassDeclaration));
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(unaryExpression.getLine(), "left side of assignment must be a valid lvalue"));
        unaryExpression.getValue().accept(this);
        if (unaryExpression.getUnaryOperator() == UnaryOperator.not)
        {
            if (!Type.compare(unaryExpression.getValue().getType(), new BooleanType())) {
                errorMessages.add(new ErrorMessage(unaryExpression.getLine(), "unsupported operand type for "
                        + unaryExpression.getUnaryOperator().toString()));
                unaryExpression.setType(new NoType());
            }
            else
                unaryExpression.setType(new BooleanType());
        }
        else {
            if (unaryExpression.getValue().getType().toString() != new IntType().toString() &&
                unaryExpression.getValue().getType().toString() != new NoType().toString()) {
                errorMessages.add(new ErrorMessage(unaryExpression.getLine(), "unsupported operand type for "
                        + unaryExpression.getUnaryOperator().toString()));
                unaryExpression.setType(new NoType());
            }
            else
                unaryExpression.setType(new IntType());
        }
    }

    @Override
    public void visit(BooleanValue value) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(value.getLine(), "left side of assignment must be a valid lvalue"));
    }

    @Override
    public void visit(IntValue value) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(value.getLine(), "left side of assignment must be a valid lvalue"));
    }

    @Override
    public void visit(StringValue value) {
        if (hasRvalErr > 0)
            errorMessages.add(new ErrorMessage(value.getLine(), "left side of assignment must be a valid lvalue"));
    }

    @Override
    public void visit(Assign assign) {
        Expression lval = assign.getlValue();
        Expression rval = assign.getrValue();
        hasRvalErr ++;
        lval.accept(this);
        hasRvalErr --;
        rval.accept(this);
        if(!Type.compare(lval.getType(), rval.getType())) {
            errorMessages.add(new ErrorMessage(lval.getLine(), "unsupported operand type for " + assign.toString()));
            assign.setType(new NoType());
        }
        else {
            if (lval.getType().toString() == new ArrayType(-1).toString() &&
                rval.getType().toString() == new ArrayType(-1).toString()) {
                ((ArrayType)lval.getType()).setSize(((ArrayType)rval.getType()).getSize());
                //((ArrayType)(((Identifier)lval).getVarDeclaration().getType())).setSize(((ArrayType)rval.getType()).getSize());
                //System.out.println(assign.getLine() + " " + ((Identifier)lval).getVarDeclaration().getIdentifier().getName());
                //System.out.println(((ArrayType)(((Identifier)lval).getVarDeclaration().getType())).getSize());
            }
            assign.setType(rval.getType());
        }
    }

    @Override
    public void visit(Block block) {
        for(int i = 0; i < block.getBody().size(); i++)
            block.getBody().get(i).accept(this);
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        if(!Type.compare(conditional.getExpression().getType(), new BooleanType())) {
            errorMessages.add(new ErrorMessage(conditional.getExpression().getLine(), "condition type must be boolean"));
        }
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        loop.getCondition().accept(this);
        if(!Type.compare(loop.getCondition().getType(), new BooleanType())) {
            errorMessages.add(new ErrorMessage(loop.getCondition().getLine(), "condition type must be boolean"));
        }
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        write.getArg().accept(this);
        if(!Type.compare(write.getArg().getType(), new IntType()) && !Type.compare(write.getArg().getType(), new StringType()) &&
           !Type.compare(write.getArg().getType(), new ArrayType(0)))
        {
            errorMessages.add(new ErrorMessage(write.getLine(), "unsupported type for writeln"));
        }
    }
}
