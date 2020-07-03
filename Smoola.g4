grammar Smoola;

@parser::header
{
    import ast.*;
    import ast.node.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.node.expression.Value.*;
    import ast.node.statement.*;
    import ast.Type.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;
}

    program returns [Program p]:
        main_class = mainClass { Program prg = new Program(); prg.setMainClass($main_class._main_class_dec); }
        ( other_class = classDeclaration { prg.addClass($other_class._class_dec); } )* EOF
        {$p = prg;}
    ;
    mainClass returns [ClassDeclaration _main_class_dec]:
        // name should be checked later
        'class' class_name = ID { $_main_class_dec = new ClassDeclaration(new Identifier($class_name.text), null); }
        { $_main_class_dec.setLine($class_name.getLine()); $_main_class_dec.getName().setLine($class_name.getLine()); }
        { MethodDeclaration main_method; }
        '{' 'def' main_method_name = ID { main_method = new MethodDeclaration(new Identifier($main_method_name.text)); }
        { main_method.setLine($main_method_name.getLine()); main_method.getName().setLine($main_method_name.getLine()); }
        '(' ')' ':' ret_type = 'int' { main_method.setReturnType(new IntType()); } '{'
        statements[null, main_method] 'return' ret_expr = expression { main_method.setReturnValue($ret_expr._expr); } ';' '}' '}'
        { $_main_class_dec.addMethodDeclaration(main_method); }
    ;
    classDeclaration returns [ClassDeclaration _class_dec]:
        'class' class_name = ID { $_class_dec = new ClassDeclaration(new Identifier($class_name.text), null); }
        { $_class_dec.setLine($class_name.getLine()); $_class_dec.getName().setLine($class_name.getLine()); }
        ('extends' par_name = ID
        { $_class_dec.setParentName(new Identifier($par_name.text)); $_class_dec.getParentName().setLine($par_name.getLine()); } )?
        '{' (var_dec = varDeclaration { $_class_dec.addVarDeclaration($var_dec._var_dec); } )*
        (method_dec = methodDeclaration { $_class_dec.addMethodDeclaration($method_dec._method_dec); } )* '}'
    ;
    varDeclaration returns [VarDeclaration _var_dec]:
        'var' var_name = ID ':' var_type = type ';' { $_var_dec = new VarDeclaration(new Identifier($var_name.text), $var_type._type);
        $_var_dec.setLine($var_name.getLine()); $_var_dec.getIdentifier().setLine($var_name.getLine()); }
    ;
    methodDeclaration returns [MethodDeclaration _method_dec]:
        'def' method_name = ID { $_method_dec = new MethodDeclaration(new Identifier($method_name.text));
        $_method_dec.setLine($method_name.getLine()); $_method_dec.getName().setLine($method_name.getLine()); }
        ('(' ')' | ('(' arg1 = ID ':' arg_type1 = type { VarDeclaration var_arg = new VarDeclaration(new Identifier($arg1.text), $arg_type1._type);
        var_arg.setLine($arg1.getLine()); var_arg.getIdentifier().setLine($arg1.getLine()); $_method_dec.addArg(var_arg); }
        (',' arg_remain = ID ':' arg_type_remain = type
        { var_arg = new VarDeclaration(new Identifier($arg_remain.text), $arg_type_remain._type);
          var_arg.setLine($arg_remain.getLine()); var_arg.getIdentifier().setLine($arg_remain.getLine()); $_method_dec.addArg(var_arg); } )* ')'))
        ':' ret_type = type { $_method_dec.setReturnType($ret_type._type); }
        '{'  (var_dec = varDeclaration { $_method_dec.addLocalVar($var_dec._var_dec); })*
        statements[null, $_method_dec] 'return' ret_expr = expression { $_method_dec.setReturnValue($ret_expr._expr); } ';' '}'
    ;
    statements[Block _par_block, MethodDeclaration _par_method_dec]:
        ( stm = statement { if ($_par_block != null) $_par_block.addStatement($stm._statement);
                            if ($_par_method_dec != null) $_par_method_dec.addStatement($stm._statement); } )*
    ;
    statement returns [Statement _statement]:
        block = statementBlock { $_statement = $block._block_st; } |
        cond = statementCondition { $_statement = $cond._cond_st; } |
        loop = statementLoop { $_statement = $loop._while_st; } |
        write = statementWrite { $_statement = $write._write_st; } |
        assign = statementAssignment {$_statement = $assign._statement; }
    ;
    statementBlock returns [Block _block_st]:
        first_line = '{' { $_block_st = new Block(); $_block_st.setLine($first_line.getLine()); } stm = statements[$_block_st, null] '}'
    ;
    statementCondition returns [Conditional _cond_st]:
        first_line = 'if' '('expr = expression')' 'then' stm = statement { $_cond_st = new Conditional($expr._expr, $stm._statement); }
        { $_cond_st.setLine($first_line.getLine()); }
        ('else' a_stm = statement { $_cond_st.setAlternativeBody($a_stm._statement); } )?
    ;
    statementLoop returns [While _while_st]:
        first_line = 'while' '(' expr = expression ')' stm = statement { $_while_st = new While($expr._expr, $stm._statement); }
        { $_while_st.setLine($first_line.getLine()); }
    ;
    statementWrite returns [Write _write_st]:
        first_line = 'writeln(' expr = expression ')' ';' { $_write_st = new Write($expr._expr); $_write_st.setLine($first_line.getLine()); }
    ;
    statementAssignment returns [Statement _statement]:
        expr = expression ';'
        { if ($expr._assign_expr == null) { $_statement = new Statement(); $_statement.setExpression($expr._expr); $_statement.setEmpty(true); }
          else { $_statement = new Assign ($expr._assign_expr.getLeft(), $expr._assign_expr.getRight());
          $_statement.setLine($expr._assign_expr.getLine()); } }
    ;

    expression returns [Expression _expr, BinaryExpression _assign_expr]:
		assign_expr = expressionAssignment { $_expr = $assign_expr._expr; $_assign_expr = $assign_expr._assign_expr; }
	;

    expressionAssignment returns [Expression _expr, BinaryExpression _assign_expr]:
		or_expr = expressionOr '=' assign_expr = expressionAssignment
		{ $_assign_expr = new BinaryExpression($or_expr._expr, $assign_expr._expr, BinaryOperator.assign); $_expr = $_assign_expr; }
		{ $_assign_expr.setLine($or_expr._expr.getLine()); }
	    |	or_expr2 = expressionOr { $_expr = $or_expr2._expr; $_assign_expr = null; }
	;

    expressionOr returns [Expression _expr]:
		and_expr = expressionAnd remain_expr = expressionOrTemp
		{if ($remain_expr._expr == null) $_expr = $and_expr._expr;
         else { $_expr = new BinaryExpression($and_expr._expr, $remain_expr._expr, BinaryOperator.or);
                $_expr.setLine($and_expr._expr.getLine()); } }
	;

    expressionOrTemp returns [Expression _expr]:
		'||' and_expr = expressionAnd remain_expr = expressionOrTemp
		{if ($remain_expr._expr == null) $_expr = $and_expr._expr;
         else { $_expr = new BinaryExpression($and_expr._expr, $remain_expr._expr, BinaryOperator.or);
                $_expr.setLine($and_expr._expr.getLine()); } }
	    | { $_expr = null; }
	;

    expressionAnd returns [Expression _expr]:
		eq_expr = expressionEq remain_expr = expressionAndTemp
	    {if ($remain_expr._expr == null) $_expr = $eq_expr._expr;
         else { $_expr = new BinaryExpression($eq_expr._expr, $remain_expr._expr, BinaryOperator.and);
                $_expr.setLine($eq_expr._expr.getLine()); } }
	;

    expressionAndTemp returns [Expression _expr]:
		'&&' eq_expr = expressionEq remain_expr = expressionAndTemp
		{if ($remain_expr._expr == null) $_expr = $eq_expr._expr;
         else { $_expr = new BinaryExpression($eq_expr._expr, $remain_expr._expr, BinaryOperator.and);
                $_expr.setLine($eq_expr._expr.getLine()); } }
	    | { $_expr = null; }
	;

    expressionEq returns [Expression _expr]:
		cmp_expr = expressionCmp remain_expr = expressionEqTemp
		{if ($remain_expr._expr == null) $_expr = $cmp_expr._expr;
         else { $_expr = new BinaryExpression($cmp_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($cmp_expr._expr.getLine()); } }
	;

    expressionEqTemp returns [Expression _expr, BinaryOperator _last_operator]:
        {BinaryOperator b;} ('==' {b = BinaryOperator.eq;}| '<>' {b = BinaryOperator.neq;})
		cmp_expr = expressionCmp remain_expr = expressionEqTemp
		{if ($remain_expr._expr == null) $_expr = $cmp_expr._expr;
         else { $_expr = new BinaryExpression($cmp_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($cmp_expr._expr.getLine()); }
         $_last_operator = b; }
	    | { $_expr = null;}
	;

    expressionCmp returns [Expression _expr]:
		add_expr = expressionAdd remain_expr = expressionCmpTemp
		{
		    if ($remain_expr._expr == null)
		        $_expr = $add_expr._expr;
            else
            {
                $_expr = new BinaryExpression($add_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($add_expr._expr.getLine());
            }
        }
	;

    expressionCmpTemp returns [Expression _expr, BinaryOperator _last_operator]:
        {BinaryOperator b;} ('<' {b = BinaryOperator.lt;}| '>' {b = BinaryOperator.gt;})
		add_expr = expressionAdd remain_expr = expressionCmpTemp
	    {if ($remain_expr._expr == null) $_expr = $add_expr._expr;
         else { $_expr = new BinaryExpression($add_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($add_expr._expr.getLine()); }
         $_last_operator = b; }
	    | { $_expr = null; }
	;

    expressionAdd returns [Expression _expr]:
		mult_expr = expressionMult remain_expr = expressionAddTemp
		{if ($remain_expr._expr == null) $_expr = $mult_expr._expr;
         else { $_expr = new BinaryExpression($mult_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($mult_expr._expr.getLine()); } }
	;

    expressionAddTemp returns [Expression _expr, BinaryOperator _last_operator]:
        {BinaryOperator b;} ('+' {b = BinaryOperator.add;}| '-' {b = BinaryOperator.sub;})
		mult_expr = expressionMult remain_expr = expressionAddTemp
		{if ($remain_expr._expr == null) $_expr = $mult_expr._expr;
         else { $_expr = new BinaryExpression($mult_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($mult_expr._expr.getLine()); }
         $_last_operator = b; }
	    | { $_expr = null; }
	;

    expressionMult returns [Expression _expr]:
		unary_expr = expressionUnary remain_expr = expressionMultTemp
		{if ($remain_expr._expr == null) $_expr = $unary_expr._expr;
		 else { $_expr = new BinaryExpression($unary_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
		        $_expr.setLine($unary_expr._expr.getLine()); } }
	;

    expressionMultTemp returns [Expression _expr, BinaryOperator _last_operator]:
		{BinaryOperator b;} ('*' {b = BinaryOperator.mult;}| '/' {b = BinaryOperator.div;})
		unary_expr = expressionUnary remain_expr = expressionMultTemp
		{if ($remain_expr._expr == null) $_expr = $unary_expr._expr;
         else { $_expr = new BinaryExpression($unary_expr._expr, $remain_expr._expr, $remain_expr._last_operator);
                $_expr.setLine($unary_expr._expr.getLine()); }
         $_last_operator = b; }
	    | { $_expr = null; }
	;

    expressionUnary returns [Expression _expr]:
		{UnaryOperator u; int this_line; } (first_line_n = '!' {u = UnaryOperator.not; this_line = $first_line_n.getLine(); }
		| first_line_m = '-' {u = UnaryOperator.minus; this_line = $first_line_m.getLine(); }) expr_unary = expressionUnary
		{ $_expr = new UnaryExpression(u, $expr_unary._expr); $_expr.setLine(this_line); }
	    |   expr = expressionMem { $_expr = $expr._expr; }
	;

    expressionMem returns [Expression _expr]:
		expr_instance = expressionMethods
		expr_index = expressionMemTemp
		{
		 if ($expr_index._index == null)
		    $_expr = $expr_instance._expr;
		 else
		 {
		    $_expr = new ArrayCall($expr_instance._expr, $expr_index._index);
		    $_expr.setLine($expr_instance._expr.getLine());
		 }
		}
	;

    expressionMemTemp returns [Expression _index]:
		'[' expr = expression ']' { $_index = $expr._expr; }
	    | {$_index = null;}
	;
	expressionMethods returns [Expression _expr]:
	    expr_instance = expressionOther { MethodCall method_call = new MethodCall($expr_instance._expr, null);
	                                      method_call.setLine($expr_instance._expr.getLine()); }
	    expressionMethodsTemp[method_call, null]
	    { if (method_call.getMethodName() == null) $_expr = $expr_instance._expr;
	      else $_expr = method_call; }
	;
	expressionMethodsTemp[MethodCall _par_method_call, Identifier _last_called]:
	    '.'
	      (ID '(' ')'
	       {
	        if ($_last_called != null) {
	            Expression expr = $_par_method_call.getInstance();
	            $_par_method_call.setInstance(new MethodCall(expr, $_last_called));
	            $_par_method_call.getInstance().setLine(expr.getLine());
	        }
	        $_last_called = new Identifier($ID.text);
	        $_last_called.setLine($ID.getLine());
	        $_par_method_call.emptyArgs();
	       }
	      | ID '('
	      {
           if ($_last_called != null) {
          	    Expression expr = $_par_method_call.getInstance();
                $_par_method_call.setInstance(new MethodCall(expr, $_last_called));
                $_par_method_call.getInstance().setLine(expr.getLine());
           }
           $_last_called = new Identifier($ID.text);
           $_last_called.setLine($ID.getLine());
           $_par_method_call.emptyArgs();
          }
	      (arg_expr = expression { $_par_method_call.addArg($arg_expr._expr); }
	      (',' arg_expr2 = expression { $_par_method_call.addArg($arg_expr2._expr); } )*) ')'
	      | length_line = 'length'
           {
	        if ($_last_called != null) {
	            Expression expr = $_par_method_call.getInstance();
	            $_par_method_call.setInstance(new MethodCall(expr, $_last_called));
	            $_par_method_call.getInstance().setLine(expr.getLine());
	        }
	        $_last_called = new Identifier("length");
	        $_last_called.setLine($length_line.getLine());
	        $_par_method_call.emptyArgs();
	       }
	      )
	    expressionMethodsTemp[$_par_method_call, $_last_called]
	    | {$_par_method_call.setMethodName($_last_called); }
	;
   expressionOther returns [Expression _expr]:
    CONST_NUM { $_expr = new IntValue(Integer.parseInt($CONST_NUM.text), new IntType()); $_expr.setLine($CONST_NUM.getLine()); }
       |    CONST_STR { $_expr = new StringValue($CONST_STR.text, new StringType()); $_expr.setLine($CONST_STR.getLine()); }
       |    first_line_narr = 'new ' 'int' '[' CONST_NUM ']'
        { NewArray new_array = new NewArray(); new_array.setLine($first_line_narr.getLine());
        new_array.setSize(new IntValue (Integer.parseInt($CONST_NUM.text), new IntType()));
        new_array.getSize().setLine($CONST_NUM.getLine());
        new_array.setType(new ArrayType(Integer.parseInt($CONST_NUM.text)));
        $_expr = new_array;}
       |    first_line_nclass = 'new ' ID '(' ')' { Identifier class_name = new Identifier($ID.text); class_name.setLine($ID.getLine());
            $_expr = new NewClass(class_name); $_expr.setLine($first_line_nclass.getLine()); }
       |   this_line = 'this' { $_expr = new This(); $_expr.setLine($this_line.getLine()); }
       |   true_line = 'true' { $_expr = new BooleanValue(true, new BooleanType()); $_expr.setLine($true_line.getLine()); }
       |   false_line = 'false' { $_expr = new BooleanValue(false, new BooleanType()); $_expr.setLine($false_line.getLine()); }
       |	ID { $_expr = new Identifier($ID.text); $_expr.setLine($ID.getLine()); }
       |   ID '[' expr = expression ']' { Identifier array_call_name = new Identifier($ID.text); array_call_name.setLine($ID.getLine());
                                          $_expr = new ArrayCall(array_call_name, $expr._expr); $_expr.setLine($ID.getLine()); }
       |	'(' par_expr = expression ')' { $_expr = $par_expr._expr; }
    ;
    type returns [Type _type]:
        'int' {$_type = new IntType();} |
        'boolean' {$_type = new BooleanType();} |
        'string' {$_type = new StringType();} |
        'int' '[' ']' {$_type = new ArrayType(-1);} |
        ID {UserDefinedType user_defined_type;
            user_defined_type = new UserDefinedType();
            user_defined_type.setName(new Identifier($ID.text));
            user_defined_type.setClassDeclaration(null);
            $_type = user_defined_type; }
    ;
    CONST_NUM:
		[0-9]+
	;

    CONST_STR:
		'"' ~('\r' | '\n' | '"')* '"'
	;
    NL:
		'\r'? '\n' -> skip
	;

    ID:
		[a-zA-Z_][a-zA-Z0-9_]*
	;

    COMMENT:
		'#'(~[\r\n])* -> skip
	;

    WS:
    	[ \t] -> skip
    ;