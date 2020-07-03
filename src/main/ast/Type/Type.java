package ast.Type;

import main.ast.Type.NoType;
import ast.Type.ArrayType.ArrayType;
import ast.Type.UserDefinedType.UserDefinedType;
import ast.node.declaration.ClassDeclaration;
import ast.Type.PrimitiveType.IntType;
import ast.Type.PrimitiveType.StringType;
import ast.Type.PrimitiveType.BooleanType;

public abstract class Type {
    protected boolean isPrimitive;
    public static boolean compare (Type t1, Type t2) {
        if (t1.toString() == new NoType().toString() || t2.toString() == new NoType().toString())
            return true;
        //if (t1.toString() == new ArrayType(-1).toString() && t2.toString() == new ArrayType(-1).toString())
        //    return (((ArrayType)t1).getSize() == ((ArrayType)t2).getSize());
        if (t1.isPrimitive || t2.isPrimitive)
            return (t1.toString() == t2.toString());
        ClassDeclaration me = ((UserDefinedType)t1).getClassDeclaration();
        while (me != null)
        {
            if (me.getName().getName() == t2.toString())
                return true;
            me = me.getParentClassDeclaration();
        }
        return false;
    }
    public boolean getIsPrimitive() { return isPrimitive; }

    public abstract String toString();

    public String getJasminType() {
        String retType = "";
        if(this.toString() == new StringType().toString())
            retType = "Ljava/lang/String;";
        else if(this.toString() == new IntType().toString() ||
                this.toString() == new BooleanType().toString())
            retType = "I";
        else if(this.toString() == new ArrayType(-1).toString())
            retType = "[I";
        else
            retType = "L" + ((UserDefinedType)this).getName().getName() + ";";
        return retType;
    }

    public String getJasminFeildInitVal() {
        String retType = "";
        if(this.toString() == new StringType().toString())
            retType = " = \"\"";
        else if(this.toString() == new IntType().toString() ||
                this.toString() == new BooleanType().toString())
            retType = " = 0";
        else
            retType = "";
        return retType;
    }

    public String getJasminPushInitValInst(int varIndex) {
        if(this.toString() == new StringType().toString())
            return "ldc \"\"\n" + "astore " + Integer.toString(varIndex);
        else if(this.toString() == new IntType().toString() ||
                this.toString() == new BooleanType().toString())
            return "iconst_0\n" + "istore " + Integer.toString(varIndex);
        else
            return "";
    }

    public String getJasminLocalVarType() {
        if(this.toString() == new IntType().toString() ||
           this.toString() == new BooleanType().toString())
            return "i";
        return "a";
    }

}
