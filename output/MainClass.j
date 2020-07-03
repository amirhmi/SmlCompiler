.class public MainClass
.super java/lang/Object


.method public <init>()V
.limit locals 100
.limit stack 1000
aload_0
invokespecial java/lang/Object/<init>()V

return
.end method

;================================

.method public static main([Ljava/lang/String;)V
.limit locals 100
.limit stack 1000
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Hello This is a test"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Factorial of 6 is :"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
new A
dup
invokespecial A/<init>()V
ldc 6
invokevirtual A/calculateFactorial(I)I
invokevirtual java/io/PrintStream/println(I)V
new B
dup
invokespecial B/<init>()V
invokevirtual B/binaryExprCheck()I
pop
new FakeMain
dup
invokespecial FakeMain/<init>()V
invokevirtual FakeMain/fakeMain()I
pop
ldc 0
return
.end method

;================================

