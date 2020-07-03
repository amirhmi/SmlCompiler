.class public A
.super java/lang/Object

.field protected fact I

.method public <init>()V
.limit locals 100
.limit stack 1000
aload_0
invokespecial java/lang/Object/<init>()V

aload 0
ldc 0
putfield A/fact I
return
.end method

;================================

.method public calculateFactorial(I)I
.limit locals 100
.limit stack 1000
iload 1
istore 4

iconst_0
istore 5

iload 4
istore 5
aload 0
ldc 1
putfield A/fact I
L0:
iload 5
ldc 0
if_icmpeq L2
iconst_1
goto L3
L2:
iconst_0
L3:
ifeq L1
aload 0
aload 0
getfield A/fact I
iload 5
imul
putfield A/fact I
iload 5
ldc 1
isub
istore 5
goto L0
L1:
aload 0
getfield A/fact I
ireturn
.end method

;================================

