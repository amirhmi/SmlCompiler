package main.ast;

import ast.Visitor;
import ast.Type.PrimitiveType.StringType;
import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.Type.Type;
import ast.node.statement.Statement;
import ast.node.statement.Write;
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
import ast.node.expression.NewClass;
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

import java.io.IOException;
import java.io.PrintWriter;

public class VisitorByteCode implements Visitor {

    private String jpath = "./output/";
    private boolean acceptClassFeild = false;
    private boolean isMainClass = false;

    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private int rvalNum = 0;
    private int Lcount = 0;

    PrintWriter file;

    String newLable()
    {
        return "L" + Integer.toString(Lcount ++);
    }

    @Override
    public void visit(Program program) {
        isMainClass = true;
        try {
            file = new PrintWriter(jpath + program.getMainClass().getName().getName() + ".j");
        }
        catch (IOException e)
        {
            System.out.println("no such a file found\n");
        }
        program.getMainClass().accept(this);
        file.close();
        isMainClass = false;
        for(int i = 0; i < program.getClasses().size(); i++) {
            try {
                file = new PrintWriter(jpath + program.getClasses().get(i).getName().getName() + ".j");
            }
            catch (IOException e)
            {
                System.out.println("no such a file found\n");
            }
            program.getClasses().get(i).accept(this);
            file.close();
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        currentClass = classDeclaration;

        file.println(".class public " + classDeclaration.getName().getName());
        String par_str;
        if (classDeclaration.getParentName() != null)
            par_str = classDeclaration.getParentName().getName();
        else
            par_str = "java/lang/Object";
        file.println(".super " + par_str + "\n");

        acceptClassFeild = true;
        for(int i = 0; i < classDeclaration.getVarDeclarations().size(); i++)
            classDeclaration.getVarDeclarations().get(i).accept(this);
        file.println("");
        acceptClassFeild = false;

        file.println(".method public <init>()V\n" +
                     ".limit locals 100\n" +
                     ".limit stack 1000\n" +
                     "aload_0\n" +
                     "invokespecial " + par_str + "/<init>()V\n");
        for(int i = 0; i < classDeclaration.getVarDeclarations().size(); i++) {
            Type type = classDeclaration.getVarDeclarations().get(i).getIdentifier().getType();
            if(type.toString() != new IntType().toString() && type.toString() != new BooleanType().toString() && type.toString() != new StringType().toString())
                continue;
            file.println("aload 0");
            if(type.toString() == new IntType().toString() || type.toString() == new BooleanType().toString())
                file.println("ldc 0");
            else if(type.toString() == new StringType().toString())
                file.println("ldc \"\"");
            file.println("putfield " + classDeclaration.getName().getName() + "/" + classDeclaration.getVarDeclarations().get(i).getIdentifier().getName() +
                    " " + type.getJasminType());

        }
        file.println("return\n" +
                     ".end method\n\n" +
                     ";================================\n");

        for(int i = 0; i < classDeclaration.getMethodDeclarations().size(); i++)
            classDeclaration.getMethodDeclarations().get(i).accept(this);
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        currentMethod = methodDeclaration;
        if(isMainClass)
        {
            file.println(".method public static main([Ljava/lang/String;)V\n" +
                        ".limit locals 100\n" +
                        ".limit stack 1000");
            for(int i = 0; i < methodDeclaration.getBody().size(); i++)
                if (methodDeclaration.getBody().get(i).isEmpty()) {
                    methodDeclaration.getBody().get(i).getExpression().accept(this);
                    file.println("pop");
                }
                else
                    methodDeclaration.getBody().get(i).accept(this);
            methodDeclaration.getReturnValue().accept(this);
            file.println("return\n" +
                    ".end method\n\n" +
                    ";================================\n");
        }
        else {
            String args_str = ".method public " + methodDeclaration.getName().getName() + "(";
            for (int i = 0; i < methodDeclaration.getArgs().size(); i++)
                args_str += methodDeclaration.getArgs().get(i).getType().getJasminType();
            file.println(args_str + ")" + methodDeclaration.getReturnType().getJasminType() + "\n" +
                    ".limit locals 100\n" +
                    ".limit stack 1000");

            for (int i = methodDeclaration.getArgs().size() - 1; i >= 0; i--) {
                file.println(methodDeclaration.getArgs().get(i).getType().getJasminLocalVarType() +
                        "load " + Integer.toString(i + 1));

                int varIndex = methodDeclaration.getSymbolTable().findVarId(methodDeclaration.getArgs().get(i).getIdentifier());
                file.println(methodDeclaration.getArgs().get(i).getType().getJasminLocalVarType() +
                        "store " + Integer.toString(varIndex));
            }
            file.println("");

            for (int i = 0; i < methodDeclaration.getLocalVars().size(); i++) {
                int varIndex = methodDeclaration.getSymbolTable().findVarId(
                        methodDeclaration.getLocalVars().get(i).getIdentifier());
                file.println(methodDeclaration.getLocalVars().get(i).getType().getJasminPushInitValInst(varIndex));
            }
            file.println("");

            for (int i = 0; i < methodDeclaration.getBody().size(); i++) {
                methodDeclaration.getBody().get(i).accept(this);
            }

            methodDeclaration.getReturnValue().accept(this);
            file.println(methodDeclaration.getReturnType().getJasminLocalVarType() + "return\n" +
                    ".end method\n\n" +
                    ";================================\n");
        }
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        //varDeclaration.getIdentifier().accept(this);
        if(acceptClassFeild)
            file.println(".field protected " + varDeclaration.getIdentifier().getName() + " " + varDeclaration.getType().getJasminType());
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
        file.println("iaload");
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        if(binaryExpression.getBinaryOperator() == BinaryOperator.assign) {
            if(binaryExpression.getLeft() instanceof Identifier) {

                int id = currentMethod.getSymbolTable().findVarId(((Identifier)binaryExpression.getLeft()));
                if (id == -1)
                {
                    ClassDeclaration par = currentClass;
                    while (par != null)
                    {
                        id = par.getSymbolTable().findVarId(((Identifier)binaryExpression.getLeft()));
                        if (id != -1)
                            break;
                        par = par.getParentClassDeclaration();
                    }
                    if (id == -1) System.out.println("panic!!!");
                    file.println("aload 0");
                    binaryExpression.getRight().accept(this);
                    file.println("putfield " + par.getName().getName() + "/" + ((Identifier)binaryExpression.getLeft()).getName() +
                            " " + binaryExpression.getLeft().getType().getJasminType());
                }
                else {
                    binaryExpression.getRight().accept(this);
                    file.println(binaryExpression.getLeft().getType().getJasminLocalVarType() + "store " + Integer.toString(id));
                }
            }
            else if(binaryExpression.getLeft() instanceof ArrayCall) {
                int id = currentMethod.getSymbolTable().findVarId(((Identifier)(((ArrayCall)binaryExpression.getLeft()).getInstance())));
                if (id == -1)
                {
                    ClassDeclaration par = currentClass;
                    while (par != null)
                    {
                        id = par.getSymbolTable().findVarId(((Identifier)(((ArrayCall)binaryExpression.getLeft()).getInstance())));
                        if (id != -1)
                            break;
                        par = par.getParentClassDeclaration();
                    }
                    if (id == -1) System.out.println("panic!!!");
                    file.println("aload 0");
                    file.println("getfield " + par.getName().getName() + "/" + ((Identifier)((ArrayCall)binaryExpression.getLeft()).getInstance()).getName() +
                            " [I");
                }
                else
                    file.println("aload " + Integer.toString(id));
                ((ArrayCall)binaryExpression.getLeft()).getIndex().accept(this);
                binaryExpression.getRight().accept(this);
                file.println("iastore");
            }
            else {
                System.out.println(":D");
            }
            binaryExpression.getRight().accept(this);
            return;
        }
        binaryExpression.getLeft().accept(this);
        if (binaryExpression.getBinaryOperator() == BinaryOperator.and)
        {
            String l0 = newLable(), lend = newLable();
            file.println("ifeq " + l0);
            binaryExpression.getRight().accept(this);
            file.println("ifeq " + l0);
            file.println("iconst_1");
            file.println("goto " + lend);
            file.println(l0 + ":\niconst_0");
            file.println(lend + ":");
            return;
        }
        if (binaryExpression.getBinaryOperator() == BinaryOperator.or)
        {
            String l1 = newLable(), lend = newLable();
            file.println("ifne " + l1);
            binaryExpression.getRight().accept(this);
            file.println("ifne " + l1);
            file.println("iconst_0");
            file.println("goto " + lend);
            file.println(l1 + ":\niconst_1");
            file.println(lend + ":");
            return;
        }
        binaryExpression.getRight().accept(this);
        if (binaryExpression.getBinaryOperator() == BinaryOperator.add)
            file.println("iadd");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.sub)
            file.println("isub");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.mult)
            file.println("imul");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.div)
            file.println("idiv");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.and)
            file.println("iand");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.or)
            file.println("ior");
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.lt) {
            String l1 = newLable(), l2 = newLable();
            file.println("if_icmpge " + l1);
            file.println("iconst_1");
            file.println("goto " + l2);
            file.println(l1 + ":");
            file.println("iconst_0");
            file.println(l2 + ":");
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.gt) {
            String l1 = newLable(), l2 = newLable();
            file.println("if_icmple " + l1);
            file.println("iconst_1");
            file.println("goto " + l2);
            file.println(l1 + ":");
            file.println("iconst_0");
            file.println(l2 + ":");
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.eq) {
            if(binaryExpression.getLeft().getType().toString() == new IntType().toString() ||
               binaryExpression.getLeft().getType().toString() == new BooleanType().toString()) {
                String l1 = newLable(), l2 = newLable();
                file.println("if_icmpne " + l1);
                file.println("iconst_1");
                file.println("goto " + l2);
                file.println(l1 + ":");
                file.println("iconst_0");
                file.println(l2 + ":");
            }
            else {
                file.println("invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z");
            }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.neq) {
            if(binaryExpression.getLeft().getType().toString() == new IntType().toString() ||
                    binaryExpression.getLeft().getType().toString() == new BooleanType().toString()) {
                String l1 = newLable(), l2 = newLable();
                file.println("if_icmpeq " + l1);
                file.println("iconst_1");
                file.println("goto " + l2);
                file.println(l1 + ":");
                file.println("iconst_0");
                file.println(l2 + ":");
            }
            else {
                file.println("invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z");
                file.println("ineg");
            }
        }
    }

    @Override
    public void visit(Identifier identifier) {
        //only for variable use
        int id = -1;
        if (currentMethod != null)
            id = currentMethod.getSymbolTable().findVarId(identifier);
        if (id == -1)
        {
            ClassDeclaration par = currentClass;
            while (par != null)
            {
                id = par.getSymbolTable().findVarId(identifier);
                if (id != -1)
                    break;
                par = par.getParentClassDeclaration();
            }
            if (id == -1) System.out.println("panic!!!");
            file.println("aload 0");
            file.println("getfield " + par.getName().getName() + "/" + identifier.getName() +
                    " " + identifier.getType().getJasminType());

        }
        else
            file.println(identifier.getType().getJasminLocalVarType() + "load " + Integer.toString(id));
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
        file.println("arraylength");
    }

    @Override
    public void visit(MethodCall methodCall) {
        if (methodCall.getMethodName().getName() == "length")
        {
            Length ln = new Length(methodCall.getInstance());
            ln.accept(this);
            return;
        }
        methodCall.getInstance().accept(this);
        for(int i = 0; i < methodCall.getArgs().size(); i++)
            methodCall.getArgs().get(i).accept(this);
        file.print("invokevirtual " + methodCall.getMethodDeclaration().getClassDeclaration().getName().getName() + "/"
                + methodCall.getMethodName().getName() + "(");
        for(int i = 0; i < methodCall.getArgs().size(); i++)
            file.print(methodCall.getArgs().get(i).getType().getJasminType());
        file.println(")" + methodCall.getType().getJasminType());
    }

    @Override
    public void visit(NewArray newArray) {
        file.println("ldc " + Integer.toString(newArray.getSize().getConstant()));
        file.println("newarray int");
    }

    @Override
    public void visit(NewClass newClass) {
        file.println("new " + newClass.getClassName().getName());
        file.println("dup");
        file.println("invokespecial " + newClass.getClassName().getName() + "/<init>()V");
    }

    @Override
    public void visit(This instance) {
        file.println("aload 0");
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
        if (unaryExpression.getUnaryOperator() == UnaryOperator.minus)
            file.println("ineg");
        else
            file.println("iconst_1\n" +
                         "isub\n" +
                         "ineg");
    }

    @Override
    public void visit(BooleanValue value) {
        file.println("ldc " + (value.isConstant() ? "1" : "0"));
    }

    @Override
    public void visit(IntValue value) {
        file.println("ldc " + value.getConstant());
    }

    @Override
    public void visit(StringValue value) {
        file.println("ldc " + value.getConstant());
    }

    @Override
    public void visit(Assign assign) {
        if(assign.getlValue() instanceof Identifier) {
            int id = currentMethod.getSymbolTable().findVarId(((Identifier)assign.getlValue()));
            if (id == -1)
            {
                ClassDeclaration par = currentClass;
                while (par != null)
                {
                    id = par.getSymbolTable().findVarId(((Identifier)assign.getlValue()));
                    if (id != -1)
                        break;
                    par = par.getParentClassDeclaration();
                }
                if (id == -1) System.out.println("panic!!!");
                file.println("aload 0");
                assign.getrValue().accept(this);
                file.println("putfield " + par.getName().getName() + "/" + ((Identifier)assign.getlValue()).getName() +
                        " " + assign.getlValue().getType().getJasminType());
            }
            else {
                assign.getrValue().accept(this);
                file.println(assign.getlValue().getType().getJasminLocalVarType() + "store " + Integer.toString(id));
            }
        }
        else if(assign.getlValue() instanceof ArrayCall) {
            int id = currentMethod.getSymbolTable().findVarId(((Identifier)(((ArrayCall)assign.getlValue()).getInstance())));
            if (id == -1)
            {
                ClassDeclaration par = currentClass;
                while (par != null)
                {
                    id = par.getSymbolTable().findVarId(((Identifier)(((ArrayCall)assign.getlValue()).getInstance())));
                    if (id != -1)
                        break;
                    par = par.getParentClassDeclaration();
                }
                if (id == -1) System.out.println("panic!!!");
                file.println("aload 0");
                file.println("getfield " + par.getName().getName() + "/" + ((Identifier)((ArrayCall)assign.getlValue()).getInstance()).getName() +
                        " [I");
            }
            else
                file.println("aload " + Integer.toString(id));
            ((ArrayCall)assign.getlValue()).getIndex().accept(this);
            assign.getrValue().accept(this);
            file.println("iastore");
        }
        else {
            System.out.println(":D");
        }
    }

    @Override
    public void visit(Block block) {
        for(int i = 0; i < block.getBody().size(); i++)
            block.getBody().get(i).accept(this);
    }

    @Override
    public void visit(Conditional conditional) {
        String lif = newLable(), lend = newLable(), lelse = lend;
        if(conditional.getAlternativeBody() != null) {
            lend = newLable();
        }

        conditional.getExpression().accept(this);
        file.println("ifeq " + lelse);
        conditional.getConsequenceBody().accept(this);
        file.println("goto " + lend);
        if(conditional.getAlternativeBody() != null) {
            file.println(lelse + ":");
            conditional.getAlternativeBody().accept(this);
        }
        file.println(lend + ":");
    }

    @Override
    public void visit(While loop) {
        String lwhile = newLable(), lend = newLable();
        file.println(lwhile + ":");
        loop.getCondition().accept(this);
        file.println("ifeq " + lend);
        loop.getBody().accept(this);
        file.println("goto " + lwhile);
        file.println(lend + ":");
    }

    @Override
    public void visit(Write write) {
        file.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
        write.getArg().accept(this);
        if(write.getArg().getType().toString() == new StringType().toString())
            file.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        else if(write.getArg().getType().toString() == new IntType().toString())
            file.println("invokevirtual java/io/PrintStream/println(I)V");
        else
            file.println("invokestatic java/util/Arrays.toString([I)Ljava/lang/String;\n" +
                         "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
    }
}
