.class public FakeMain
.super java/lang/Object


.method public <init>()V
.limit locals 100
.limit stack 1000
aload_0
invokespecial java/lang/Object/<init>()V

return
.end method

;================================

.method public fakeMain()I
.limit locals 100
.limit stack 1000




ldc 10
newarray int
astore 2
new LoopTest
dup
invokespecial LoopTest/<init>()V
astore 1
aload 1
aload 2
invokevirtual LoopTest/initArr([I)[I
astore 2
aload 1
aload 2
invokevirtual LoopTest/bubbleSort([I)[I
astore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Sorted : "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
ldc 0
ireturn
.end method

;================================

