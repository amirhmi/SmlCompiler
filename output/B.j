.class public B
.super A


.method public <init>()V
.limit locals 100
.limit stack 1000
aload_0
invokespecial A/<init>()V

return
.end method

;================================

.method public binaryExprCheck()I
.limit locals 100
.limit stack 1000

iconst_0
istore 6
iconst_0
istore 7
iconst_0
istore 8

aload 0
getfield A/fact I
ldc 12
ldc 123
imul
iload 6
ldc 12
idiv
iadd
iadd
istore 6
iload 7
aload 0
getfield A/fact I
if_icmpne L7
iconst_1
goto L8
L7:
iconst_0
L8:
ifeq L9
iload 8
ifeq L9
iconst_1
goto L10
L9:
iconst_0
L10:
ifeq L5
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "It's ok"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto L6
L5:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "It's not ok"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L6:
ldc 0
ireturn
.end method

;================================

