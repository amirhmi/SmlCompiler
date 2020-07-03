.class public LoopTest
.super java/lang/Object

.field protected sortedArray [I
.field protected a I
.field protected b I
.field protected k I
.field protected s Ljava/lang/String;

.method public <init>()V
.limit locals 100
.limit stack 1000
aload_0
invokespecial java/lang/Object/<init>()V

aload 0
ldc 0
putfield LoopTest/a I
aload 0
ldc 0
putfield LoopTest/b I
aload 0
ldc 0
putfield LoopTest/k I
aload 0
ldc ""
putfield LoopTest/s Ljava/lang/String;
return
.end method

;================================

.method public initArr([I)[I
.limit locals 100
.limit stack 1000
aload 1
astore 14

iconst_0
istore 15

L11:
iload 15
ldc 10
if_icmpge L13
iconst_1
goto L14
L13:
iconst_0
L14:
ifeq L12
aload 14
iload 15
iload 15
iastore
iload 15
ldc 1
iadd
istore 15
goto L11
L12:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Unsorted array :"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 14
invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload 14
areturn
.end method

;================================

.method public bubbleSort([I)[I
.limit locals 100
.limit stack 1000
aload 1
astore 16

iconst_0
istore 17
iconst_0
istore 18
iconst_0
istore 19
iconst_0
istore 20
iconst_0
istore 21

ldc 0
istore 20
ldc 0
istore 17
ldc 0
istore 18
ldc 2
istore 19
ldc 2
istore 18
ldc 2
istore 19
ldc 2
istore 17
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 17
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 18
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 19
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 17
invokevirtual java/io/PrintStream/println(I)V
ldc 0
istore 17
ldc 0
istore 18
aload 16
arraylength
istore 19
L15:
iload 17
iload 19
ldc 1
isub
if_icmpge L17
iconst_1
goto L18
L17:
iconst_0
L18:
ifeq L16
ldc 0
istore 20
ldc 0
istore 18
L19:
iload 18
iload 19
iload 17
isub
ldc 1
isub
if_icmpge L21
iconst_1
goto L22
L21:
iconst_0
L22:
ifeq L20
aload 16
iload 18
iaload
aload 16
iload 18
ldc 1
iadd
iaload
if_icmpge L25
iconst_1
goto L26
L25:
iconst_0
L26:
ifeq L24
aload 0
aload 16
iload 18
iaload
putfield LoopTest/a I
aload 0
aload 16
iload 18
ldc 1
iadd
iaload
putfield LoopTest/b I
aload 0
invokevirtual LoopTest/swapAB()I
istore 21
aload 16
iload 18
aload 0
getfield LoopTest/a I
iastore
aload 16
iload 18
ldc 1
iadd
aload 0
getfield LoopTest/b I
iastore
ldc 1
istore 20
goto L24
L24:
iload 18
ldc 1
iadd
istore 18
goto L19
L20:
iload 20
iconst_1
isub
ineg
ifeq L28
iload 19
ldc 1
iadd
istore 17
goto L28
L28:
iload 17
ldc 1
iadd
istore 17
goto L15
L16:
aload 0
aload 16
putfield LoopTest/sortedArray [I
aload 16
areturn
.end method

;================================

.method public swapAB()I
.limit locals 100
.limit stack 1000

iconst_0
istore 22

aload 0
getfield LoopTest/a I
istore 22
aload 0
aload 0
getfield LoopTest/b I
putfield LoopTest/a I
aload 0
iload 22
putfield LoopTest/b I
ldc 0
ireturn
.end method

;================================

