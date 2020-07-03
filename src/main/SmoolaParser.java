// Generated from /Users/amirhmi/Desktop/5/Compiler & PL/project3/compilerFall97/Smoola.g4 by ANTLR 4.7

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmoolaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, CONST_NUM=41, CONST_STR=42, NL=43, ID=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_statements = 5, RULE_statement = 6, RULE_statementBlock = 7, 
		RULE_statementCondition = 8, RULE_statementLoop = 9, RULE_statementWrite = 10, 
		RULE_statementAssignment = 11, RULE_expression = 12, RULE_expressionAssignment = 13, 
		RULE_expressionOr = 14, RULE_expressionOrTemp = 15, RULE_expressionAnd = 16, 
		RULE_expressionAndTemp = 17, RULE_expressionEq = 18, RULE_expressionEqTemp = 19, 
		RULE_expressionCmp = 20, RULE_expressionCmpTemp = 21, RULE_expressionAdd = 22, 
		RULE_expressionAddTemp = 23, RULE_expressionMult = 24, RULE_expressionMultTemp = 25, 
		RULE_expressionUnary = 26, RULE_expressionMem = 27, RULE_expressionMemTemp = 28, 
		RULE_expressionMethods = 29, RULE_expressionMethodsTemp = 30, RULE_expressionOther = 31, 
		RULE_type = 32;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"statements", "statement", "statementBlock", "statementCondition", "statementLoop", 
		"statementWrite", "statementAssignment", "expression", "expressionAssignment", 
		"expressionOr", "expressionOrTemp", "expressionAnd", "expressionAndTemp", 
		"expressionEq", "expressionEqTemp", "expressionCmp", "expressionCmpTemp", 
		"expressionAdd", "expressionAddTemp", "expressionMult", "expressionMultTemp", 
		"expressionUnary", "expressionMem", "expressionMemTemp", "expressionMethods", 
		"expressionMethodsTemp", "expressionOther", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'def'", "'('", "')'", "':'", "'int'", "'return'", 
		"';'", "'}'", "'extends'", "'var'", "','", "'if'", "'then'", "'else'", 
		"'while'", "'writeln('", "'='", "'||'", "'&&'", "'=='", "'<>'", "'<'", 
		"'>'", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'length'", 
		"'new '", "'this'", "'true'", "'false'", "'boolean'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "CONST_NUM", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smoola.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmoolaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program p;
		public MainClassContext main_class;
		public ClassDeclarationContext other_class;
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((ProgramContext)_localctx).main_class = mainClass();
			 Program prg = new Program(); prg.setMainClass(((ProgramContext)_localctx).main_class._main_class_dec); 
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(68);
				((ProgramContext)_localctx).other_class = classDeclaration();
				 prg.addClass(((ProgramContext)_localctx).other_class._class_dec); 
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			((ProgramContext)_localctx).p =  prg;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public ClassDeclaration _main_class_dec;
		public Token class_name;
		public Token main_method_name;
		public Token ret_type;
		public ExpressionContext ret_expr;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMainClass(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__0);
			setState(80);
			((MainClassContext)_localctx).class_name = match(ID);
			 ((MainClassContext)_localctx)._main_class_dec =  new ClassDeclaration(new Identifier((((MainClassContext)_localctx).class_name!=null?((MainClassContext)_localctx).class_name.getText():null)), null); 
			 _localctx._main_class_dec.setLine(((MainClassContext)_localctx).class_name.getLine()); _localctx._main_class_dec.getName().setLine(((MainClassContext)_localctx).class_name.getLine()); 
			 MethodDeclaration main_method; 
			setState(84);
			match(T__1);
			setState(85);
			match(T__2);
			setState(86);
			((MainClassContext)_localctx).main_method_name = match(ID);
			 main_method = new MethodDeclaration(new Identifier((((MainClassContext)_localctx).main_method_name!=null?((MainClassContext)_localctx).main_method_name.getText():null))); 
			 main_method.setLine(((MainClassContext)_localctx).main_method_name.getLine()); main_method.getName().setLine(((MainClassContext)_localctx).main_method_name.getLine()); 
			setState(89);
			match(T__3);
			setState(90);
			match(T__4);
			setState(91);
			match(T__5);
			setState(92);
			((MainClassContext)_localctx).ret_type = match(T__6);
			 main_method.setReturnType(new IntType()); 
			setState(94);
			match(T__1);
			setState(95);
			statements(null, main_method);
			setState(96);
			match(T__7);
			setState(97);
			((MainClassContext)_localctx).ret_expr = expression();
			 main_method.setReturnValue(((MainClassContext)_localctx).ret_expr._expr); 
			setState(99);
			match(T__8);
			setState(100);
			match(T__9);
			setState(101);
			match(T__9);
			 _localctx._main_class_dec.addMethodDeclaration(main_method); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration _class_dec;
		public Token class_name;
		public Token par_name;
		public VarDeclarationContext var_dec;
		public MethodDeclarationContext method_dec;
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__0);
			setState(105);
			((ClassDeclarationContext)_localctx).class_name = match(ID);
			 ((ClassDeclarationContext)_localctx)._class_dec =  new ClassDeclaration(new Identifier((((ClassDeclarationContext)_localctx).class_name!=null?((ClassDeclarationContext)_localctx).class_name.getText():null)), null); 
			 _localctx._class_dec.setLine(((ClassDeclarationContext)_localctx).class_name.getLine()); _localctx._class_dec.getName().setLine(((ClassDeclarationContext)_localctx).class_name.getLine()); 
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(108);
				match(T__10);
				setState(109);
				((ClassDeclarationContext)_localctx).par_name = match(ID);
				 _localctx._class_dec.setParentName(new Identifier((((ClassDeclarationContext)_localctx).par_name!=null?((ClassDeclarationContext)_localctx).par_name.getText():null))); _localctx._class_dec.getParentName().setLine(((ClassDeclarationContext)_localctx).par_name.getLine()); 
				}
			}

			setState(113);
			match(T__1);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(114);
				((ClassDeclarationContext)_localctx).var_dec = varDeclaration();
				 _localctx._class_dec.addVarDeclaration(((ClassDeclarationContext)_localctx).var_dec._var_dec); 
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(122);
				((ClassDeclarationContext)_localctx).method_dec = methodDeclaration();
				 _localctx._class_dec.addMethodDeclaration(((ClassDeclarationContext)_localctx).method_dec._method_dec); 
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration _var_dec;
		public Token var_name;
		public TypeContext var_type;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__11);
			setState(133);
			((VarDeclarationContext)_localctx).var_name = match(ID);
			setState(134);
			match(T__5);
			setState(135);
			((VarDeclarationContext)_localctx).var_type = type();
			setState(136);
			match(T__8);
			 ((VarDeclarationContext)_localctx)._var_dec =  new VarDeclaration(new Identifier((((VarDeclarationContext)_localctx).var_name!=null?((VarDeclarationContext)_localctx).var_name.getText():null)), ((VarDeclarationContext)_localctx).var_type._type);
			        _localctx._var_dec.setLine(((VarDeclarationContext)_localctx).var_name.getLine()); _localctx._var_dec.getIdentifier().setLine(((VarDeclarationContext)_localctx).var_name.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclaration _method_dec;
		public Token method_name;
		public Token arg1;
		public TypeContext arg_type1;
		public Token arg_remain;
		public TypeContext arg_type_remain;
		public TypeContext ret_type;
		public VarDeclarationContext var_dec;
		public ExpressionContext ret_expr;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SmoolaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmoolaParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__2);
			setState(140);
			((MethodDeclarationContext)_localctx).method_name = match(ID);
			 ((MethodDeclarationContext)_localctx)._method_dec =  new MethodDeclaration(new Identifier((((MethodDeclarationContext)_localctx).method_name!=null?((MethodDeclarationContext)_localctx).method_name.getText():null)));
			        _localctx._method_dec.setLine(((MethodDeclarationContext)_localctx).method_name.getLine()); _localctx._method_dec.getName().setLine(((MethodDeclarationContext)_localctx).method_name.getLine()); 
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(142);
				match(T__3);
				setState(143);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(144);
				match(T__3);
				setState(145);
				((MethodDeclarationContext)_localctx).arg1 = match(ID);
				setState(146);
				match(T__5);
				setState(147);
				((MethodDeclarationContext)_localctx).arg_type1 = type();
				 VarDeclaration var_arg = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).arg1!=null?((MethodDeclarationContext)_localctx).arg1.getText():null)), ((MethodDeclarationContext)_localctx).arg_type1._type);
				        var_arg.setLine(((MethodDeclarationContext)_localctx).arg1.getLine()); var_arg.getIdentifier().setLine(((MethodDeclarationContext)_localctx).arg1.getLine()); _localctx._method_dec.addArg(var_arg); 
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(149);
					match(T__12);
					setState(150);
					((MethodDeclarationContext)_localctx).arg_remain = match(ID);
					setState(151);
					match(T__5);
					setState(152);
					((MethodDeclarationContext)_localctx).arg_type_remain = type();
					 var_arg = new VarDeclaration(new Identifier((((MethodDeclarationContext)_localctx).arg_remain!=null?((MethodDeclarationContext)_localctx).arg_remain.getText():null)), ((MethodDeclarationContext)_localctx).arg_type_remain._type);
					          var_arg.setLine(((MethodDeclarationContext)_localctx).arg_remain.getLine()); var_arg.getIdentifier().setLine(((MethodDeclarationContext)_localctx).arg_remain.getLine()); _localctx._method_dec.addArg(var_arg); 
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(T__4);
				}
				}
				break;
			}
			setState(164);
			match(T__5);
			setState(165);
			((MethodDeclarationContext)_localctx).ret_type = type();
			 _localctx._method_dec.setReturnType(((MethodDeclarationContext)_localctx).ret_type._type); 
			setState(167);
			match(T__1);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(168);
				((MethodDeclarationContext)_localctx).var_dec = varDeclaration();
				 _localctx._method_dec.addLocalVar(((MethodDeclarationContext)_localctx).var_dec._var_dec); 
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			statements(null, _localctx._method_dec);
			setState(177);
			match(T__7);
			setState(178);
			((MethodDeclarationContext)_localctx).ret_expr = expression();
			 _localctx._method_dec.setReturnValue(((MethodDeclarationContext)_localctx).ret_expr._expr); 
			setState(180);
			match(T__8);
			setState(181);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public Block _par_block;
		public MethodDeclaration _par_method_dec;
		public StatementContext stm;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementsContext(ParserRuleContext parent, int invokingState, Block _par_block, MethodDeclaration _par_method_dec) {
			super(parent, invokingState);
			this._par_block = _par_block;
			this._par_method_dec = _par_method_dec;
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements(Block _par_block,MethodDeclaration _par_method_dec) throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState(), _par_block, _par_method_dec);
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(183);
				((StatementsContext)_localctx).stm = statement();
				 if (_localctx._par_block != null) _localctx._par_block.addStatement(((StatementsContext)_localctx).stm._statement);
				                            if (_localctx._par_method_dec != null) _localctx._par_method_dec.addStatement(((StatementsContext)_localctx).stm._statement); 
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement _statement;
		public StatementBlockContext block;
		public StatementConditionContext cond;
		public StatementLoopContext loop;
		public StatementWriteContext write;
		public StatementAssignmentContext assign;
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatementConditionContext statementCondition() {
			return getRuleContext(StatementConditionContext.class,0);
		}
		public StatementLoopContext statementLoop() {
			return getRuleContext(StatementLoopContext.class,0);
		}
		public StatementWriteContext statementWrite() {
			return getRuleContext(StatementWriteContext.class,0);
		}
		public StatementAssignmentContext statementAssignment() {
			return getRuleContext(StatementAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				((StatementContext)_localctx).block = statementBlock();
				 ((StatementContext)_localctx)._statement =  ((StatementContext)_localctx).block._block_st; 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				((StatementContext)_localctx).cond = statementCondition();
				 ((StatementContext)_localctx)._statement =  ((StatementContext)_localctx).cond._cond_st; 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				((StatementContext)_localctx).loop = statementLoop();
				 ((StatementContext)_localctx)._statement =  ((StatementContext)_localctx).loop._while_st; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				((StatementContext)_localctx).write = statementWrite();
				 ((StatementContext)_localctx)._statement =  ((StatementContext)_localctx).write._write_st; 
				}
				break;
			case T__3:
			case T__26:
			case T__29:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(203);
				((StatementContext)_localctx).assign = statementAssignment();
				((StatementContext)_localctx)._statement =  ((StatementContext)_localctx).assign._statement; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public Block _block_st;
		public Token first_line;
		public StatementsContext stm;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementBlock(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			((StatementBlockContext)_localctx).first_line = match(T__1);
			 ((StatementBlockContext)_localctx)._block_st =  new Block(); _localctx._block_st.setLine(((StatementBlockContext)_localctx).first_line.getLine()); 
			setState(210);
			((StatementBlockContext)_localctx).stm = statements(_localctx._block_st, null);
			setState(211);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementConditionContext extends ParserRuleContext {
		public Conditional _cond_st;
		public Token first_line;
		public ExpressionContext expr;
		public StatementContext stm;
		public StatementContext a_stm;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementCondition(this);
		}
	}

	public final StatementConditionContext statementCondition() throws RecognitionException {
		StatementConditionContext _localctx = new StatementConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((StatementConditionContext)_localctx).first_line = match(T__13);
			setState(214);
			match(T__3);
			setState(215);
			((StatementConditionContext)_localctx).expr = expression();
			setState(216);
			match(T__4);
			setState(217);
			match(T__14);
			setState(218);
			((StatementConditionContext)_localctx).stm = statement();
			 ((StatementConditionContext)_localctx)._cond_st =  new Conditional(((StatementConditionContext)_localctx).expr._expr, ((StatementConditionContext)_localctx).stm._statement); 
			 _localctx._cond_st.setLine(((StatementConditionContext)_localctx).first_line.getLine()); 
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(221);
				match(T__15);
				setState(222);
				((StatementConditionContext)_localctx).a_stm = statement();
				 _localctx._cond_st.setAlternativeBody(((StatementConditionContext)_localctx).a_stm._statement); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementLoopContext extends ParserRuleContext {
		public While _while_st;
		public Token first_line;
		public ExpressionContext expr;
		public StatementContext stm;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementLoop(this);
		}
	}

	public final StatementLoopContext statementLoop() throws RecognitionException {
		StatementLoopContext _localctx = new StatementLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			((StatementLoopContext)_localctx).first_line = match(T__16);
			setState(228);
			match(T__3);
			setState(229);
			((StatementLoopContext)_localctx).expr = expression();
			setState(230);
			match(T__4);
			setState(231);
			((StatementLoopContext)_localctx).stm = statement();
			 ((StatementLoopContext)_localctx)._while_st =  new While(((StatementLoopContext)_localctx).expr._expr, ((StatementLoopContext)_localctx).stm._statement); 
			 _localctx._while_st.setLine(((StatementLoopContext)_localctx).first_line.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWriteContext extends ParserRuleContext {
		public Write _write_st;
		public Token first_line;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementWrite(this);
		}
	}

	public final StatementWriteContext statementWrite() throws RecognitionException {
		StatementWriteContext _localctx = new StatementWriteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((StatementWriteContext)_localctx).first_line = match(T__17);
			setState(236);
			((StatementWriteContext)_localctx).expr = expression();
			setState(237);
			match(T__4);
			setState(238);
			match(T__8);
			 ((StatementWriteContext)_localctx)._write_st =  new Write(((StatementWriteContext)_localctx).expr._expr); _localctx._write_st.setLine(((StatementWriteContext)_localctx).first_line.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementAssignmentContext extends ParserRuleContext {
		public Statement _statement;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementAssignment(this);
		}
	}

	public final StatementAssignmentContext statementAssignment() throws RecognitionException {
		StatementAssignmentContext _localctx = new StatementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			((StatementAssignmentContext)_localctx).expr = expression();
			setState(242);
			match(T__8);
			 if (((StatementAssignmentContext)_localctx).expr._assign_expr == null) { ((StatementAssignmentContext)_localctx)._statement =  new Statement(); _localctx._statement.setExpression(((StatementAssignmentContext)_localctx).expr._expr); _localctx._statement.setEmpty(true); }
			          else { ((StatementAssignmentContext)_localctx)._statement =  new Assign (((StatementAssignmentContext)_localctx).expr._assign_expr.getLeft(), ((StatementAssignmentContext)_localctx).expr._assign_expr.getRight());
			          _localctx._statement.setLine(((StatementAssignmentContext)_localctx).expr._assign_expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryExpression _assign_expr;
		public ExpressionAssignmentContext assign_expr;
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((ExpressionContext)_localctx).assign_expr = expressionAssignment();
			 ((ExpressionContext)_localctx)._expr =  ((ExpressionContext)_localctx).assign_expr._expr; ((ExpressionContext)_localctx)._assign_expr =  ((ExpressionContext)_localctx).assign_expr._assign_expr; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAssignmentContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryExpression _assign_expr;
		public ExpressionOrContext or_expr;
		public ExpressionAssignmentContext assign_expr;
		public ExpressionOrContext or_expr2;
		public ExpressionOrContext expressionOr() {
			return getRuleContext(ExpressionOrContext.class,0);
		}
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAssignment(this);
		}
	}

	public final ExpressionAssignmentContext expressionAssignment() throws RecognitionException {
		ExpressionAssignmentContext _localctx = new ExpressionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionAssignment);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				((ExpressionAssignmentContext)_localctx).or_expr = expressionOr();
				setState(249);
				match(T__18);
				setState(250);
				((ExpressionAssignmentContext)_localctx).assign_expr = expressionAssignment();
				 ((ExpressionAssignmentContext)_localctx)._assign_expr =  new BinaryExpression(((ExpressionAssignmentContext)_localctx).or_expr._expr, ((ExpressionAssignmentContext)_localctx).assign_expr._expr, BinaryOperator.assign); ((ExpressionAssignmentContext)_localctx)._expr =  _localctx._assign_expr; 
				 _localctx._assign_expr.setLine(((ExpressionAssignmentContext)_localctx).or_expr._expr.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				((ExpressionAssignmentContext)_localctx).or_expr2 = expressionOr();
				 ((ExpressionAssignmentContext)_localctx)._expr =  ((ExpressionAssignmentContext)_localctx).or_expr2._expr; ((ExpressionAssignmentContext)_localctx)._assign_expr =  null; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionAndContext and_expr;
		public ExpressionOrTempContext remain_expr;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOr(this);
		}
	}

	public final ExpressionOrContext expressionOr() throws RecognitionException {
		ExpressionOrContext _localctx = new ExpressionOrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			((ExpressionOrContext)_localctx).and_expr = expressionAnd();
			setState(260);
			((ExpressionOrContext)_localctx).remain_expr = expressionOrTemp();
			if (((ExpressionOrContext)_localctx).remain_expr._expr == null) ((ExpressionOrContext)_localctx)._expr =  ((ExpressionOrContext)_localctx).and_expr._expr;
			         else { ((ExpressionOrContext)_localctx)._expr =  new BinaryExpression(((ExpressionOrContext)_localctx).and_expr._expr, ((ExpressionOrContext)_localctx).remain_expr._expr, BinaryOperator.or);
			                _localctx._expr.setLine(((ExpressionOrContext)_localctx).and_expr._expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrTempContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionAndContext and_expr;
		public ExpressionOrTempContext remain_expr;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOrTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOrTemp(this);
		}
	}

	public final ExpressionOrTempContext expressionOrTemp() throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionOrTemp);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(T__19);
				setState(264);
				((ExpressionOrTempContext)_localctx).and_expr = expressionAnd();
				setState(265);
				((ExpressionOrTempContext)_localctx).remain_expr = expressionOrTemp();
				if (((ExpressionOrTempContext)_localctx).remain_expr._expr == null) ((ExpressionOrTempContext)_localctx)._expr =  ((ExpressionOrTempContext)_localctx).and_expr._expr;
				         else { ((ExpressionOrTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionOrTempContext)_localctx).and_expr._expr, ((ExpressionOrTempContext)_localctx).remain_expr._expr, BinaryOperator.or);
				                _localctx._expr.setLine(((ExpressionOrTempContext)_localctx).and_expr._expr.getLine()); } 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionOrTempContext)_localctx)._expr =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionEqContext eq_expr;
		public ExpressionAndTempContext remain_expr;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAnd(this);
		}
	}

	public final ExpressionAndContext expressionAnd() throws RecognitionException {
		ExpressionAndContext _localctx = new ExpressionAndContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			((ExpressionAndContext)_localctx).eq_expr = expressionEq();
			setState(272);
			((ExpressionAndContext)_localctx).remain_expr = expressionAndTemp();
			if (((ExpressionAndContext)_localctx).remain_expr._expr == null) ((ExpressionAndContext)_localctx)._expr =  ((ExpressionAndContext)_localctx).eq_expr._expr;
			         else { ((ExpressionAndContext)_localctx)._expr =  new BinaryExpression(((ExpressionAndContext)_localctx).eq_expr._expr, ((ExpressionAndContext)_localctx).remain_expr._expr, BinaryOperator.and);
			                _localctx._expr.setLine(((ExpressionAndContext)_localctx).eq_expr._expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndTempContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionEqContext eq_expr;
		public ExpressionAndTempContext remain_expr;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAndTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAndTemp(this);
		}
	}

	public final ExpressionAndTempContext expressionAndTemp() throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionAndTemp);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(T__20);
				setState(276);
				((ExpressionAndTempContext)_localctx).eq_expr = expressionEq();
				setState(277);
				((ExpressionAndTempContext)_localctx).remain_expr = expressionAndTemp();
				if (((ExpressionAndTempContext)_localctx).remain_expr._expr == null) ((ExpressionAndTempContext)_localctx)._expr =  ((ExpressionAndTempContext)_localctx).eq_expr._expr;
				         else { ((ExpressionAndTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionAndTempContext)_localctx).eq_expr._expr, ((ExpressionAndTempContext)_localctx).remain_expr._expr, BinaryOperator.and);
				                _localctx._expr.setLine(((ExpressionAndTempContext)_localctx).eq_expr._expr.getLine()); } 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionAndTempContext)_localctx)._expr =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionCmpContext cmp_expr;
		public ExpressionEqTempContext remain_expr;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEq(this);
		}
	}

	public final ExpressionEqContext expressionEq() throws RecognitionException {
		ExpressionEqContext _localctx = new ExpressionEqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionEq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((ExpressionEqContext)_localctx).cmp_expr = expressionCmp();
			setState(284);
			((ExpressionEqContext)_localctx).remain_expr = expressionEqTemp();
			if (((ExpressionEqContext)_localctx).remain_expr._expr == null) ((ExpressionEqContext)_localctx)._expr =  ((ExpressionEqContext)_localctx).cmp_expr._expr;
			         else { ((ExpressionEqContext)_localctx)._expr =  new BinaryExpression(((ExpressionEqContext)_localctx).cmp_expr._expr, ((ExpressionEqContext)_localctx).remain_expr._expr, ((ExpressionEqContext)_localctx).remain_expr._last_operator);
			                _localctx._expr.setLine(((ExpressionEqContext)_localctx).cmp_expr._expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqTempContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryOperator _last_operator;
		public ExpressionCmpContext cmp_expr;
		public ExpressionEqTempContext remain_expr;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEqTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEqTemp(this);
		}
	}

	public final ExpressionEqTempContext expressionEqTemp() throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionEqTemp);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				BinaryOperator b;
				setState(292);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(288);
					match(T__21);
					b = BinaryOperator.eq;
					}
					break;
				case T__22:
					{
					setState(290);
					match(T__22);
					b = BinaryOperator.neq;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(294);
				((ExpressionEqTempContext)_localctx).cmp_expr = expressionCmp();
				setState(295);
				((ExpressionEqTempContext)_localctx).remain_expr = expressionEqTemp();
				if (((ExpressionEqTempContext)_localctx).remain_expr._expr == null) ((ExpressionEqTempContext)_localctx)._expr =  ((ExpressionEqTempContext)_localctx).cmp_expr._expr;
				         else { ((ExpressionEqTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionEqTempContext)_localctx).cmp_expr._expr, ((ExpressionEqTempContext)_localctx).remain_expr._expr, ((ExpressionEqTempContext)_localctx).remain_expr._last_operator);
				                _localctx._expr.setLine(((ExpressionEqTempContext)_localctx).cmp_expr._expr.getLine()); }
				         ((ExpressionEqTempContext)_localctx)._last_operator =  b; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionEqTempContext)_localctx)._expr =  null;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionAddContext add_expr;
		public ExpressionCmpTempContext remain_expr;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmp(this);
		}
	}

	public final ExpressionCmpContext expressionCmp() throws RecognitionException {
		ExpressionCmpContext _localctx = new ExpressionCmpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressionCmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			((ExpressionCmpContext)_localctx).add_expr = expressionAdd();
			setState(302);
			((ExpressionCmpContext)_localctx).remain_expr = expressionCmpTemp();

					    if (((ExpressionCmpContext)_localctx).remain_expr._expr == null)
					        ((ExpressionCmpContext)_localctx)._expr =  ((ExpressionCmpContext)_localctx).add_expr._expr;
			            else
			            {
			                ((ExpressionCmpContext)_localctx)._expr =  new BinaryExpression(((ExpressionCmpContext)_localctx).add_expr._expr, ((ExpressionCmpContext)_localctx).remain_expr._expr, ((ExpressionCmpContext)_localctx).remain_expr._last_operator);
			                _localctx._expr.setLine(((ExpressionCmpContext)_localctx).add_expr._expr.getLine());
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpTempContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryOperator _last_operator;
		public ExpressionAddContext add_expr;
		public ExpressionCmpTempContext remain_expr;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmpTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmpTemp(this);
		}
	}

	public final ExpressionCmpTempContext expressionCmpTemp() throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressionCmpTemp);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				BinaryOperator b;
				setState(310);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					setState(306);
					match(T__23);
					b = BinaryOperator.lt;
					}
					break;
				case T__24:
					{
					setState(308);
					match(T__24);
					b = BinaryOperator.gt;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(312);
				((ExpressionCmpTempContext)_localctx).add_expr = expressionAdd();
				setState(313);
				((ExpressionCmpTempContext)_localctx).remain_expr = expressionCmpTemp();
				if (((ExpressionCmpTempContext)_localctx).remain_expr._expr == null) ((ExpressionCmpTempContext)_localctx)._expr =  ((ExpressionCmpTempContext)_localctx).add_expr._expr;
				         else { ((ExpressionCmpTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionCmpTempContext)_localctx).add_expr._expr, ((ExpressionCmpTempContext)_localctx).remain_expr._expr, ((ExpressionCmpTempContext)_localctx).remain_expr._last_operator);
				                _localctx._expr.setLine(((ExpressionCmpTempContext)_localctx).add_expr._expr.getLine()); }
				         ((ExpressionCmpTempContext)_localctx)._last_operator =  b; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionCmpTempContext)_localctx)._expr =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionMultContext mult_expr;
		public ExpressionAddTempContext remain_expr;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAdd(this);
		}
	}

	public final ExpressionAddContext expressionAdd() throws RecognitionException {
		ExpressionAddContext _localctx = new ExpressionAddContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((ExpressionAddContext)_localctx).mult_expr = expressionMult();
			setState(320);
			((ExpressionAddContext)_localctx).remain_expr = expressionAddTemp();
			if (((ExpressionAddContext)_localctx).remain_expr._expr == null) ((ExpressionAddContext)_localctx)._expr =  ((ExpressionAddContext)_localctx).mult_expr._expr;
			         else { ((ExpressionAddContext)_localctx)._expr =  new BinaryExpression(((ExpressionAddContext)_localctx).mult_expr._expr, ((ExpressionAddContext)_localctx).remain_expr._expr, ((ExpressionAddContext)_localctx).remain_expr._last_operator);
			                _localctx._expr.setLine(((ExpressionAddContext)_localctx).mult_expr._expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddTempContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryOperator _last_operator;
		public ExpressionMultContext mult_expr;
		public ExpressionAddTempContext remain_expr;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAddTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAddTemp(this);
		}
	}

	public final ExpressionAddTempContext expressionAddTemp() throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionAddTemp);
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				BinaryOperator b;
				setState(328);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
					{
					setState(324);
					match(T__25);
					b = BinaryOperator.add;
					}
					break;
				case T__26:
					{
					setState(326);
					match(T__26);
					b = BinaryOperator.sub;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(330);
				((ExpressionAddTempContext)_localctx).mult_expr = expressionMult();
				setState(331);
				((ExpressionAddTempContext)_localctx).remain_expr = expressionAddTemp();
				if (((ExpressionAddTempContext)_localctx).remain_expr._expr == null) ((ExpressionAddTempContext)_localctx)._expr =  ((ExpressionAddTempContext)_localctx).mult_expr._expr;
				         else { ((ExpressionAddTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionAddTempContext)_localctx).mult_expr._expr, ((ExpressionAddTempContext)_localctx).remain_expr._expr, ((ExpressionAddTempContext)_localctx).remain_expr._last_operator);
				                _localctx._expr.setLine(((ExpressionAddTempContext)_localctx).mult_expr._expr.getLine()); }
				         ((ExpressionAddTempContext)_localctx)._last_operator =  b; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionAddTempContext)_localctx)._expr =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionUnaryContext unary_expr;
		public ExpressionMultTempContext remain_expr;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMult(this);
		}
	}

	public final ExpressionMultContext expressionMult() throws RecognitionException {
		ExpressionMultContext _localctx = new ExpressionMultContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionMult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			((ExpressionMultContext)_localctx).unary_expr = expressionUnary();
			setState(338);
			((ExpressionMultContext)_localctx).remain_expr = expressionMultTemp();
			if (((ExpressionMultContext)_localctx).remain_expr._expr == null) ((ExpressionMultContext)_localctx)._expr =  ((ExpressionMultContext)_localctx).unary_expr._expr;
					 else { ((ExpressionMultContext)_localctx)._expr =  new BinaryExpression(((ExpressionMultContext)_localctx).unary_expr._expr, ((ExpressionMultContext)_localctx).remain_expr._expr, ((ExpressionMultContext)_localctx).remain_expr._last_operator);
					        _localctx._expr.setLine(((ExpressionMultContext)_localctx).unary_expr._expr.getLine()); } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultTempContext extends ParserRuleContext {
		public Expression _expr;
		public BinaryOperator _last_operator;
		public ExpressionUnaryContext unary_expr;
		public ExpressionMultTempContext remain_expr;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMultTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMultTemp(this);
		}
	}

	public final ExpressionMultTempContext expressionMultTemp() throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressionMultTemp);
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				BinaryOperator b;
				setState(346);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(342);
					match(T__27);
					b = BinaryOperator.mult;
					}
					break;
				case T__28:
					{
					setState(344);
					match(T__28);
					b = BinaryOperator.div;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348);
				((ExpressionMultTempContext)_localctx).unary_expr = expressionUnary();
				setState(349);
				((ExpressionMultTempContext)_localctx).remain_expr = expressionMultTemp();
				if (((ExpressionMultTempContext)_localctx).remain_expr._expr == null) ((ExpressionMultTempContext)_localctx)._expr =  ((ExpressionMultTempContext)_localctx).unary_expr._expr;
				         else { ((ExpressionMultTempContext)_localctx)._expr =  new BinaryExpression(((ExpressionMultTempContext)_localctx).unary_expr._expr, ((ExpressionMultTempContext)_localctx).remain_expr._expr, ((ExpressionMultTempContext)_localctx).remain_expr._last_operator);
				                _localctx._expr.setLine(((ExpressionMultTempContext)_localctx).unary_expr._expr.getLine()); }
				         ((ExpressionMultTempContext)_localctx)._last_operator =  b; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionMultTempContext)_localctx)._expr =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionUnaryContext extends ParserRuleContext {
		public Expression _expr;
		public Token first_line_n;
		public Token first_line_m;
		public ExpressionUnaryContext expr_unary;
		public ExpressionMemContext expr;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMemContext expressionMem() {
			return getRuleContext(ExpressionMemContext.class,0);
		}
		public ExpressionUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionUnary(this);
		}
	}

	public final ExpressionUnaryContext expressionUnary() throws RecognitionException {
		ExpressionUnaryContext _localctx = new ExpressionUnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionUnary);
		try {
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				UnaryOperator u; int this_line; 
				setState(360);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(356);
					((ExpressionUnaryContext)_localctx).first_line_n = match(T__29);
					u = UnaryOperator.not; this_line = ((ExpressionUnaryContext)_localctx).first_line_n.getLine(); 
					}
					break;
				case T__26:
					{
					setState(358);
					((ExpressionUnaryContext)_localctx).first_line_m = match(T__26);
					u = UnaryOperator.minus; this_line = ((ExpressionUnaryContext)_localctx).first_line_m.getLine(); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(362);
				((ExpressionUnaryContext)_localctx).expr_unary = expressionUnary();
				 ((ExpressionUnaryContext)_localctx)._expr =  new UnaryExpression(u, ((ExpressionUnaryContext)_localctx).expr_unary._expr); _localctx._expr.setLine(this_line); 
				}
				break;
			case T__3:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				((ExpressionUnaryContext)_localctx).expr = expressionMem();
				 ((ExpressionUnaryContext)_localctx)._expr =  ((ExpressionUnaryContext)_localctx).expr._expr; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionMethodsContext expr_instance;
		public ExpressionMemTempContext expr_index;
		public ExpressionMethodsContext expressionMethods() {
			return getRuleContext(ExpressionMethodsContext.class,0);
		}
		public ExpressionMemTempContext expressionMemTemp() {
			return getRuleContext(ExpressionMemTempContext.class,0);
		}
		public ExpressionMemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMem(this);
		}
	}

	public final ExpressionMemContext expressionMem() throws RecognitionException {
		ExpressionMemContext _localctx = new ExpressionMemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionMem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			((ExpressionMemContext)_localctx).expr_instance = expressionMethods();
			setState(371);
			((ExpressionMemContext)_localctx).expr_index = expressionMemTemp();

					 if (((ExpressionMemContext)_localctx).expr_index._index == null)
					    ((ExpressionMemContext)_localctx)._expr =  ((ExpressionMemContext)_localctx).expr_instance._expr;
					 else
					 {
					    ((ExpressionMemContext)_localctx)._expr =  new ArrayCall(((ExpressionMemContext)_localctx).expr_instance._expr, ((ExpressionMemContext)_localctx).expr_index._index);
					    _localctx._expr.setLine(((ExpressionMemContext)_localctx).expr_instance._expr.getLine());
					 }
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemTempContext extends ParserRuleContext {
		public Expression _index;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMemTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMemTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMemTemp(this);
		}
	}

	public final ExpressionMemTempContext expressionMemTemp() throws RecognitionException {
		ExpressionMemTempContext _localctx = new ExpressionMemTempContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionMemTemp);
		try {
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				match(T__30);
				setState(375);
				((ExpressionMemTempContext)_localctx).expr = expression();
				setState(376);
				match(T__31);
				 ((ExpressionMemTempContext)_localctx)._index =  ((ExpressionMemTempContext)_localctx).expr._expr; 
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				((ExpressionMemTempContext)_localctx)._index =  null;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsContext extends ParserRuleContext {
		public Expression _expr;
		public ExpressionOtherContext expr_instance;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public ExpressionOtherContext expressionOther() {
			return getRuleContext(ExpressionOtherContext.class,0);
		}
		public ExpressionMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethods(this);
		}
	}

	public final ExpressionMethodsContext expressionMethods() throws RecognitionException {
		ExpressionMethodsContext _localctx = new ExpressionMethodsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expressionMethods);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			((ExpressionMethodsContext)_localctx).expr_instance = expressionOther();
			 MethodCall method_call = new MethodCall(((ExpressionMethodsContext)_localctx).expr_instance._expr, null);
				                                      method_call.setLine(((ExpressionMethodsContext)_localctx).expr_instance._expr.getLine()); 
			setState(384);
			expressionMethodsTemp(method_call, null);
			 if (method_call.getMethodName() == null) ((ExpressionMethodsContext)_localctx)._expr =  ((ExpressionMethodsContext)_localctx).expr_instance._expr;
				      else ((ExpressionMethodsContext)_localctx)._expr =  method_call; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsTempContext extends ParserRuleContext {
		public MethodCall _par_method_call;
		public Identifier _last_called;
		public Token ID;
		public ExpressionContext arg_expr;
		public ExpressionContext arg_expr2;
		public Token length_line;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState, MethodCall _par_method_call, Identifier _last_called) {
			super(parent, invokingState);
			this._par_method_call = _par_method_call;
			this._last_called = _last_called;
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethodsTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethodsTemp(this);
		}
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp(MethodCall _par_method_call,Identifier _last_called) throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState(), _par_method_call, _last_called);
		enterRule(_localctx, 60, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(T__32);
				setState(410);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(388);
					((ExpressionMethodsTempContext)_localctx).ID = match(ID);
					setState(389);
					match(T__3);
					setState(390);
					match(T__4);

						        if (_localctx._last_called != null) {
						            Expression expr = _localctx._par_method_call.getInstance();
						            _localctx._par_method_call.setInstance(new MethodCall(expr, _localctx._last_called));
						            _localctx._par_method_call.getInstance().setLine(expr.getLine());
						        }
						        ((ExpressionMethodsTempContext)_localctx)._last_called =  new Identifier((((ExpressionMethodsTempContext)_localctx).ID!=null?((ExpressionMethodsTempContext)_localctx).ID.getText():null));
						        _localctx._last_called.setLine(((ExpressionMethodsTempContext)_localctx).ID.getLine());
						        _localctx._par_method_call.emptyArgs();
						       
					}
					break;
				case 2:
					{
					setState(392);
					((ExpressionMethodsTempContext)_localctx).ID = match(ID);
					setState(393);
					match(T__3);

					           if (_localctx._last_called != null) {
					          	    Expression expr = _localctx._par_method_call.getInstance();
					                _localctx._par_method_call.setInstance(new MethodCall(expr, _localctx._last_called));
					                _localctx._par_method_call.getInstance().setLine(expr.getLine());
					           }
					           ((ExpressionMethodsTempContext)_localctx)._last_called =  new Identifier((((ExpressionMethodsTempContext)_localctx).ID!=null?((ExpressionMethodsTempContext)_localctx).ID.getText():null));
					           _localctx._last_called.setLine(((ExpressionMethodsTempContext)_localctx).ID.getLine());
					           _localctx._par_method_call.emptyArgs();
					          
					{
					setState(395);
					((ExpressionMethodsTempContext)_localctx).arg_expr = expression();
					 _localctx._par_method_call.addArg(((ExpressionMethodsTempContext)_localctx).arg_expr._expr); 
					setState(403);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(397);
						match(T__12);
						setState(398);
						((ExpressionMethodsTempContext)_localctx).arg_expr2 = expression();
						 _localctx._par_method_call.addArg(((ExpressionMethodsTempContext)_localctx).arg_expr2._expr); 
						}
						}
						setState(405);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(406);
					match(T__4);
					}
					break;
				case 3:
					{
					setState(408);
					((ExpressionMethodsTempContext)_localctx).length_line = match(T__33);

						        if (_localctx._last_called != null) {
						            Expression expr = _localctx._par_method_call.getInstance();
						            _localctx._par_method_call.setInstance(new MethodCall(expr, _localctx._last_called));
						            _localctx._par_method_call.getInstance().setLine(expr.getLine());
						        }
						        ((ExpressionMethodsTempContext)_localctx)._last_called =  new Identifier("length");
						        _localctx._last_called.setLine(((ExpressionMethodsTempContext)_localctx).length_line.getLine());
						        _localctx._par_method_call.emptyArgs();
						       
					}
					break;
				}
				setState(412);
				expressionMethodsTemp(_localctx._par_method_call, _localctx._last_called);
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				_localctx._par_method_call.setMethodName(_localctx._last_called); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOtherContext extends ParserRuleContext {
		public Expression _expr;
		public Token CONST_NUM;
		public Token CONST_STR;
		public Token first_line_narr;
		public Token first_line_nclass;
		public Token ID;
		public Token this_line;
		public Token true_line;
		public Token false_line;
		public ExpressionContext expr;
		public ExpressionContext par_expr;
		public TerminalNode CONST_NUM() { return getToken(SmoolaParser.CONST_NUM, 0); }
		public TerminalNode CONST_STR() { return getToken(SmoolaParser.CONST_STR, 0); }
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOther; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOther(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOther(this);
		}
	}

	public final ExpressionOtherContext expressionOther() throws RecognitionException {
		ExpressionOtherContext _localctx = new ExpressionOtherContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expressionOther);
		try {
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				((ExpressionOtherContext)_localctx).CONST_NUM = match(CONST_NUM);
				 ((ExpressionOtherContext)_localctx)._expr =  new IntValue(Integer.parseInt((((ExpressionOtherContext)_localctx).CONST_NUM!=null?((ExpressionOtherContext)_localctx).CONST_NUM.getText():null)), new IntType()); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).CONST_NUM.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				((ExpressionOtherContext)_localctx).CONST_STR = match(CONST_STR);
				 ((ExpressionOtherContext)_localctx)._expr =  new StringValue((((ExpressionOtherContext)_localctx).CONST_STR!=null?((ExpressionOtherContext)_localctx).CONST_STR.getText():null), new StringType()); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).CONST_STR.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				((ExpressionOtherContext)_localctx).first_line_narr = match(T__34);
				setState(421);
				match(T__6);
				setState(422);
				match(T__30);
				setState(423);
				((ExpressionOtherContext)_localctx).CONST_NUM = match(CONST_NUM);
				setState(424);
				match(T__31);
				 NewArray new_array = new NewArray(); new_array.setLine(((ExpressionOtherContext)_localctx).first_line_narr.getLine());
				        new_array.setSize(new IntValue (Integer.parseInt((((ExpressionOtherContext)_localctx).CONST_NUM!=null?((ExpressionOtherContext)_localctx).CONST_NUM.getText():null)), new IntType()));
				        new_array.getSize().setLine(((ExpressionOtherContext)_localctx).CONST_NUM.getLine());
				        new_array.setType(new ArrayType(Integer.parseInt((((ExpressionOtherContext)_localctx).CONST_NUM!=null?((ExpressionOtherContext)_localctx).CONST_NUM.getText():null))));
				        ((ExpressionOtherContext)_localctx)._expr =  new_array;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				((ExpressionOtherContext)_localctx).first_line_nclass = match(T__34);
				setState(427);
				((ExpressionOtherContext)_localctx).ID = match(ID);
				setState(428);
				match(T__3);
				setState(429);
				match(T__4);
				 Identifier class_name = new Identifier((((ExpressionOtherContext)_localctx).ID!=null?((ExpressionOtherContext)_localctx).ID.getText():null)); class_name.setLine(((ExpressionOtherContext)_localctx).ID.getLine());
				            ((ExpressionOtherContext)_localctx)._expr =  new NewClass(class_name); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).first_line_nclass.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(431);
				((ExpressionOtherContext)_localctx).this_line = match(T__35);
				 ((ExpressionOtherContext)_localctx)._expr =  new This(); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).this_line.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(433);
				((ExpressionOtherContext)_localctx).true_line = match(T__36);
				 ((ExpressionOtherContext)_localctx)._expr =  new BooleanValue(true, new BooleanType()); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).true_line.getLine()); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(435);
				((ExpressionOtherContext)_localctx).false_line = match(T__37);
				 ((ExpressionOtherContext)_localctx)._expr =  new BooleanValue(false, new BooleanType()); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).false_line.getLine()); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(437);
				((ExpressionOtherContext)_localctx).ID = match(ID);
				 ((ExpressionOtherContext)_localctx)._expr =  new Identifier((((ExpressionOtherContext)_localctx).ID!=null?((ExpressionOtherContext)_localctx).ID.getText():null)); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).ID.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(439);
				((ExpressionOtherContext)_localctx).ID = match(ID);
				setState(440);
				match(T__30);
				setState(441);
				((ExpressionOtherContext)_localctx).expr = expression();
				setState(442);
				match(T__31);
				 Identifier array_call_name = new Identifier((((ExpressionOtherContext)_localctx).ID!=null?((ExpressionOtherContext)_localctx).ID.getText():null)); array_call_name.setLine(((ExpressionOtherContext)_localctx).ID.getLine());
				                                          ((ExpressionOtherContext)_localctx)._expr =  new ArrayCall(array_call_name, ((ExpressionOtherContext)_localctx).expr._expr); _localctx._expr.setLine(((ExpressionOtherContext)_localctx).ID.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(445);
				match(T__3);
				setState(446);
				((ExpressionOtherContext)_localctx).par_expr = expression();
				setState(447);
				match(T__4);
				 ((ExpressionOtherContext)_localctx)._expr =  ((ExpressionOtherContext)_localctx).par_expr._expr; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type _type;
		public Token ID;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				match(T__6);
				((TypeContext)_localctx)._type =  new IntType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				match(T__38);
				((TypeContext)_localctx)._type =  new BooleanType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				match(T__39);
				((TypeContext)_localctx)._type =  new StringType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(458);
				match(T__6);
				setState(459);
				match(T__30);
				setState(460);
				match(T__31);
				((TypeContext)_localctx)._type =  new ArrayType(-1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(462);
				((TypeContext)_localctx).ID = match(ID);
				UserDefinedType user_defined_type;
				            user_defined_type = new UserDefinedType();
				            user_defined_type.setName(new Identifier((((TypeContext)_localctx).ID!=null?((TypeContext)_localctx).ID.getText():null)));
				            user_defined_type.setClassDeclaration(null);
				            ((TypeContext)_localctx)._type =  user_defined_type; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u01d5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4r\n\4\3\4"+
		"\3\4\3\4\3\4\7\4x\n\4\f\4\16\4{\13\4\3\4\3\4\3\4\7\4\u0080\n\4\f\4\16"+
		"\4\u0083\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u009e\n\6\f\6\16\6\u00a1"+
		"\13\6\3\6\3\6\5\6\u00a5\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ae\n\6"+
		"\f\6\16\6\u00b1\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00bd"+
		"\n\7\f\7\16\7\u00c0\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00d1\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e4\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0104\n\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0110\n\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u011c\n\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0127\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u012e"+
		"\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u0139\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0140\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u014b\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u0152\n\31\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u015d\n\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u0164\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u016b\n"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0173\n\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u017f\n\36\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0194\n \f \16 \u0197\13"+
		" \3 \3 \3 \3 \5 \u019d\n \3 \3 \5 \u01a1\n \3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\5!\u01c5\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u01d3\n\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@B\2\2\2\u01df\2D\3\2\2\2\4Q\3\2\2\2\6j\3\2\2\2\b\u0086"+
		"\3\2\2\2\n\u008d\3\2\2\2\f\u00be\3\2\2\2\16\u00d0\3\2\2\2\20\u00d2\3\2"+
		"\2\2\22\u00d7\3\2\2\2\24\u00e5\3\2\2\2\26\u00ed\3\2\2\2\30\u00f3\3\2\2"+
		"\2\32\u00f7\3\2\2\2\34\u0103\3\2\2\2\36\u0105\3\2\2\2 \u010f\3\2\2\2\""+
		"\u0111\3\2\2\2$\u011b\3\2\2\2&\u011d\3\2\2\2(\u012d\3\2\2\2*\u012f\3\2"+
		"\2\2,\u013f\3\2\2\2.\u0141\3\2\2\2\60\u0151\3\2\2\2\62\u0153\3\2\2\2\64"+
		"\u0163\3\2\2\2\66\u0172\3\2\2\28\u0174\3\2\2\2:\u017e\3\2\2\2<\u0180\3"+
		"\2\2\2>\u01a0\3\2\2\2@\u01c4\3\2\2\2B\u01d2\3\2\2\2DE\5\4\3\2EK\b\2\1"+
		"\2FG\5\6\4\2GH\b\2\1\2HJ\3\2\2\2IF\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2LN\3\2\2\2MK\3\2\2\2NO\7\2\2\3OP\b\2\1\2P\3\3\2\2\2QR\7\3\2\2RS\7.\2"+
		"\2ST\b\3\1\2TU\b\3\1\2UV\b\3\1\2VW\7\4\2\2WX\7\5\2\2XY\7.\2\2YZ\b\3\1"+
		"\2Z[\b\3\1\2[\\\7\6\2\2\\]\7\7\2\2]^\7\b\2\2^_\7\t\2\2_`\b\3\1\2`a\7\4"+
		"\2\2ab\5\f\7\2bc\7\n\2\2cd\5\32\16\2de\b\3\1\2ef\7\13\2\2fg\7\f\2\2gh"+
		"\7\f\2\2hi\b\3\1\2i\5\3\2\2\2jk\7\3\2\2kl\7.\2\2lm\b\4\1\2mq\b\4\1\2n"+
		"o\7\r\2\2op\7.\2\2pr\b\4\1\2qn\3\2\2\2qr\3\2\2\2rs\3\2\2\2sy\7\4\2\2t"+
		"u\5\b\5\2uv\b\4\1\2vx\3\2\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2"+
		"z\u0081\3\2\2\2{y\3\2\2\2|}\5\n\6\2}~\b\4\1\2~\u0080\3\2\2\2\177|\3\2"+
		"\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7\f\2\2\u0085\7\3\2\2\2\u0086"+
		"\u0087\7\16\2\2\u0087\u0088\7.\2\2\u0088\u0089\7\b\2\2\u0089\u008a\5B"+
		"\"\2\u008a\u008b\7\13\2\2\u008b\u008c\b\5\1\2\u008c\t\3\2\2\2\u008d\u008e"+
		"\7\5\2\2\u008e\u008f\7.\2\2\u008f\u00a4\b\6\1\2\u0090\u0091\7\6\2\2\u0091"+
		"\u00a5\7\7\2\2\u0092\u0093\7\6\2\2\u0093\u0094\7.\2\2\u0094\u0095\7\b"+
		"\2\2\u0095\u0096\5B\"\2\u0096\u009f\b\6\1\2\u0097\u0098\7\17\2\2\u0098"+
		"\u0099\7.\2\2\u0099\u009a\7\b\2\2\u009a\u009b\5B\"\2\u009b\u009c\b\6\1"+
		"\2\u009c\u009e\3\2\2\2\u009d\u0097\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a3\7\7\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0090\3\2\2\2\u00a4\u0092\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\5B\"\2\u00a8"+
		"\u00a9\b\6\1\2\u00a9\u00af\7\4\2\2\u00aa\u00ab\5\b\5\2\u00ab\u00ac\b\6"+
		"\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b3\5\f\7\2\u00b3\u00b4\7\n\2\2\u00b4\u00b5\5\32\16\2\u00b5"+
		"\u00b6\b\6\1\2\u00b6\u00b7\7\13\2\2\u00b7\u00b8\7\f\2\2\u00b8\13\3\2\2"+
		"\2\u00b9\u00ba\5\16\b\2\u00ba\u00bb\b\7\1\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\r\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\5\20\t\2\u00c2\u00c3"+
		"\b\b\1\2\u00c3\u00d1\3\2\2\2\u00c4\u00c5\5\22\n\2\u00c5\u00c6\b\b\1\2"+
		"\u00c6\u00d1\3\2\2\2\u00c7\u00c8\5\24\13\2\u00c8\u00c9\b\b\1\2\u00c9\u00d1"+
		"\3\2\2\2\u00ca\u00cb\5\26\f\2\u00cb\u00cc\b\b\1\2\u00cc\u00d1\3\2\2\2"+
		"\u00cd\u00ce\5\30\r\2\u00ce\u00cf\b\b\1\2\u00cf\u00d1\3\2\2\2\u00d0\u00c1"+
		"\3\2\2\2\u00d0\u00c4\3\2\2\2\u00d0\u00c7\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d0"+
		"\u00cd\3\2\2\2\u00d1\17\3\2\2\2\u00d2\u00d3\7\4\2\2\u00d3\u00d4\b\t\1"+
		"\2\u00d4\u00d5\5\f\7\2\u00d5\u00d6\7\f\2\2\u00d6\21\3\2\2\2\u00d7\u00d8"+
		"\7\20\2\2\u00d8\u00d9\7\6\2\2\u00d9\u00da\5\32\16\2\u00da\u00db\7\7\2"+
		"\2\u00db\u00dc\7\21\2\2\u00dc\u00dd\5\16\b\2\u00dd\u00de\b\n\1\2\u00de"+
		"\u00e3\b\n\1\2\u00df\u00e0\7\22\2\2\u00e0\u00e1\5\16\b\2\u00e1\u00e2\b"+
		"\n\1\2\u00e2\u00e4\3\2\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\23\3\2\2\2\u00e5\u00e6\7\23\2\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\5\32"+
		"\16\2\u00e8\u00e9\7\7\2\2\u00e9\u00ea\5\16\b\2\u00ea\u00eb\b\13\1\2\u00eb"+
		"\u00ec\b\13\1\2\u00ec\25\3\2\2\2\u00ed\u00ee\7\24\2\2\u00ee\u00ef\5\32"+
		"\16\2\u00ef\u00f0\7\7\2\2\u00f0\u00f1\7\13\2\2\u00f1\u00f2\b\f\1\2\u00f2"+
		"\27\3\2\2\2\u00f3\u00f4\5\32\16\2\u00f4\u00f5\7\13\2\2\u00f5\u00f6\b\r"+
		"\1\2\u00f6\31\3\2\2\2\u00f7\u00f8\5\34\17\2\u00f8\u00f9\b\16\1\2\u00f9"+
		"\33\3\2\2\2\u00fa\u00fb\5\36\20\2\u00fb\u00fc\7\25\2\2\u00fc\u00fd\5\34"+
		"\17\2\u00fd\u00fe\b\17\1\2\u00fe\u00ff\b\17\1\2\u00ff\u0104\3\2\2\2\u0100"+
		"\u0101\5\36\20\2\u0101\u0102\b\17\1\2\u0102\u0104\3\2\2\2\u0103\u00fa"+
		"\3\2\2\2\u0103\u0100\3\2\2\2\u0104\35\3\2\2\2\u0105\u0106\5\"\22\2\u0106"+
		"\u0107\5 \21\2\u0107\u0108\b\20\1\2\u0108\37\3\2\2\2\u0109\u010a\7\26"+
		"\2\2\u010a\u010b\5\"\22\2\u010b\u010c\5 \21\2\u010c\u010d\b\21\1\2\u010d"+
		"\u0110\3\2\2\2\u010e\u0110\b\21\1\2\u010f\u0109\3\2\2\2\u010f\u010e\3"+
		"\2\2\2\u0110!\3\2\2\2\u0111\u0112\5&\24\2\u0112\u0113\5$\23\2\u0113\u0114"+
		"\b\22\1\2\u0114#\3\2\2\2\u0115\u0116\7\27\2\2\u0116\u0117\5&\24\2\u0117"+
		"\u0118\5$\23\2\u0118\u0119\b\23\1\2\u0119\u011c\3\2\2\2\u011a\u011c\b"+
		"\23\1\2\u011b\u0115\3\2\2\2\u011b\u011a\3\2\2\2\u011c%\3\2\2\2\u011d\u011e"+
		"\5*\26\2\u011e\u011f\5(\25\2\u011f\u0120\b\24\1\2\u0120\'\3\2\2\2\u0121"+
		"\u0126\b\25\1\2\u0122\u0123\7\30\2\2\u0123\u0127\b\25\1\2\u0124\u0125"+
		"\7\31\2\2\u0125\u0127\b\25\1\2\u0126\u0122\3\2\2\2\u0126\u0124\3\2\2\2"+
		"\u0127\u0128\3\2\2\2\u0128\u0129\5*\26\2\u0129\u012a\5(\25\2\u012a\u012b"+
		"\b\25\1\2\u012b\u012e\3\2\2\2\u012c\u012e\b\25\1\2\u012d\u0121\3\2\2\2"+
		"\u012d\u012c\3\2\2\2\u012e)\3\2\2\2\u012f\u0130\5.\30\2\u0130\u0131\5"+
		",\27\2\u0131\u0132\b\26\1\2\u0132+\3\2\2\2\u0133\u0138\b\27\1\2\u0134"+
		"\u0135\7\32\2\2\u0135\u0139\b\27\1\2\u0136\u0137\7\33\2\2\u0137\u0139"+
		"\b\27\1\2\u0138\u0134\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u013b\5.\30\2\u013b\u013c\5,\27\2\u013c\u013d\b\27\1\2\u013d\u0140"+
		"\3\2\2\2\u013e\u0140\b\27\1\2\u013f\u0133\3\2\2\2\u013f\u013e\3\2\2\2"+
		"\u0140-\3\2\2\2\u0141\u0142\5\62\32\2\u0142\u0143\5\60\31\2\u0143\u0144"+
		"\b\30\1\2\u0144/\3\2\2\2\u0145\u014a\b\31\1\2\u0146\u0147\7\34\2\2\u0147"+
		"\u014b\b\31\1\2\u0148\u0149\7\35\2\2\u0149\u014b\b\31\1\2\u014a\u0146"+
		"\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5\62\32\2"+
		"\u014d\u014e\5\60\31\2\u014e\u014f\b\31\1\2\u014f\u0152\3\2\2\2\u0150"+
		"\u0152\b\31\1\2\u0151\u0145\3\2\2\2\u0151\u0150\3\2\2\2\u0152\61\3\2\2"+
		"\2\u0153\u0154\5\66\34\2\u0154\u0155\5\64\33\2\u0155\u0156\b\32\1\2\u0156"+
		"\63\3\2\2\2\u0157\u015c\b\33\1\2\u0158\u0159\7\36\2\2\u0159\u015d\b\33"+
		"\1\2\u015a\u015b\7\37\2\2\u015b\u015d\b\33\1\2\u015c\u0158\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\5\66\34\2\u015f\u0160\5"+
		"\64\33\2\u0160\u0161\b\33\1\2\u0161\u0164\3\2\2\2\u0162\u0164\b\33\1\2"+
		"\u0163\u0157\3\2\2\2\u0163\u0162\3\2\2\2\u0164\65\3\2\2\2\u0165\u016a"+
		"\b\34\1\2\u0166\u0167\7 \2\2\u0167\u016b\b\34\1\2\u0168\u0169\7\35\2\2"+
		"\u0169\u016b\b\34\1\2\u016a\u0166\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c"+
		"\3\2\2\2\u016c\u016d\5\66\34\2\u016d\u016e\b\34\1\2\u016e\u0173\3\2\2"+
		"\2\u016f\u0170\58\35\2\u0170\u0171\b\34\1\2\u0171\u0173\3\2\2\2\u0172"+
		"\u0165\3\2\2\2\u0172\u016f\3\2\2\2\u0173\67\3\2\2\2\u0174\u0175\5<\37"+
		"\2\u0175\u0176\5:\36\2\u0176\u0177\b\35\1\2\u01779\3\2\2\2\u0178\u0179"+
		"\7!\2\2\u0179\u017a\5\32\16\2\u017a\u017b\7\"\2\2\u017b\u017c\b\36\1\2"+
		"\u017c\u017f\3\2\2\2\u017d\u017f\b\36\1\2\u017e\u0178\3\2\2\2\u017e\u017d"+
		"\3\2\2\2\u017f;\3\2\2\2\u0180\u0181\5@!\2\u0181\u0182\b\37\1\2\u0182\u0183"+
		"\5> \2\u0183\u0184\b\37\1\2\u0184=\3\2\2\2\u0185\u019c\7#\2\2\u0186\u0187"+
		"\7.\2\2\u0187\u0188\7\6\2\2\u0188\u0189\7\7\2\2\u0189\u019d\b \1\2\u018a"+
		"\u018b\7.\2\2\u018b\u018c\7\6\2\2\u018c\u018d\b \1\2\u018d\u018e\5\32"+
		"\16\2\u018e\u0195\b \1\2\u018f\u0190\7\17\2\2\u0190\u0191\5\32\16\2\u0191"+
		"\u0192\b \1\2\u0192\u0194\3\2\2\2\u0193\u018f\3\2\2\2\u0194\u0197\3\2"+
		"\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0198\u0199\7\7\2\2\u0199\u019d\3\2\2\2\u019a\u019b\7$"+
		"\2\2\u019b\u019d\b \1\2\u019c\u0186\3\2\2\2\u019c\u018a\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a1\5> \2\u019f\u01a1\b \1"+
		"\2\u01a0\u0185\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1?\3\2\2\2\u01a2\u01a3"+
		"\7+\2\2\u01a3\u01c5\b!\1\2\u01a4\u01a5\7,\2\2\u01a5\u01c5\b!\1\2\u01a6"+
		"\u01a7\7%\2\2\u01a7\u01a8\7\t\2\2\u01a8\u01a9\7!\2\2\u01a9\u01aa\7+\2"+
		"\2\u01aa\u01ab\7\"\2\2\u01ab\u01c5\b!\1\2\u01ac\u01ad\7%\2\2\u01ad\u01ae"+
		"\7.\2\2\u01ae\u01af\7\6\2\2\u01af\u01b0\7\7\2\2\u01b0\u01c5\b!\1\2\u01b1"+
		"\u01b2\7&\2\2\u01b2\u01c5\b!\1\2\u01b3\u01b4\7\'\2\2\u01b4\u01c5\b!\1"+
		"\2\u01b5\u01b6\7(\2\2\u01b6\u01c5\b!\1\2\u01b7\u01b8\7.\2\2\u01b8\u01c5"+
		"\b!\1\2\u01b9\u01ba\7.\2\2\u01ba\u01bb\7!\2\2\u01bb\u01bc\5\32\16\2\u01bc"+
		"\u01bd\7\"\2\2\u01bd\u01be\b!\1\2\u01be\u01c5\3\2\2\2\u01bf\u01c0\7\6"+
		"\2\2\u01c0\u01c1\5\32\16\2\u01c1\u01c2\7\7\2\2\u01c2\u01c3\b!\1\2\u01c3"+
		"\u01c5\3\2\2\2\u01c4\u01a2\3\2\2\2\u01c4\u01a4\3\2\2\2\u01c4\u01a6\3\2"+
		"\2\2\u01c4\u01ac\3\2\2\2\u01c4\u01b1\3\2\2\2\u01c4\u01b3\3\2\2\2\u01c4"+
		"\u01b5\3\2\2\2\u01c4\u01b7\3\2\2\2\u01c4\u01b9\3\2\2\2\u01c4\u01bf\3\2"+
		"\2\2\u01c5A\3\2\2\2\u01c6\u01c7\7\t\2\2\u01c7\u01d3\b\"\1\2\u01c8\u01c9"+
		"\7)\2\2\u01c9\u01d3\b\"\1\2\u01ca\u01cb\7*\2\2\u01cb\u01d3\b\"\1\2\u01cc"+
		"\u01cd\7\t\2\2\u01cd\u01ce\7!\2\2\u01ce\u01cf\7\"\2\2\u01cf\u01d3\b\""+
		"\1\2\u01d0\u01d1\7.\2\2\u01d1\u01d3\b\"\1\2\u01d2\u01c6\3\2\2\2\u01d2"+
		"\u01c8\3\2\2\2\u01d2\u01ca\3\2\2\2\u01d2\u01cc\3\2\2\2\u01d2\u01d0\3\2"+
		"\2\2\u01d3C\3\2\2\2\37Kqy\u0081\u009f\u00a4\u00af\u00be\u00d0\u00e3\u0103"+
		"\u010f\u011b\u0126\u012d\u0138\u013f\u014a\u0151\u015c\u0163\u016a\u0172"+
		"\u017e\u0195\u019c\u01a0\u01c4\u01d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}