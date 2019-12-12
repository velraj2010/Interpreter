grammar ProjLang;

options { 
  output=AST; 
}


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
 
NUM  : ('0'..'9')+ ;

ADDOP	: 	('+' | '-' | '|' );
MULOP	:	('*' | '/' | '&');
EQ	:	'=';
LT	:	'<';
COLON 	:	':';
SEMICOLON
	:	';';
ASSIGNMENTOP 
	:	COLON EQ;
relop	:	(LT|EQ);
NEGATION 
	:	'!';
LEFT_PARENTHESIS
	:	'(';
RIGHT_PARENTHESIS
	:	')';
LEFT_CURLY
	:	'{';
RIGHT_CURLY
	:	'}';
THEN	:	'then';
IF	:	'if';
ELSE	:	'else';
LET	:	'let';
VAL	:	'val';
IN	:	'in';
END	:	'end';
FUN	:	'fun';
WHILE	:	'while';
DO	:	'do';

TRUE	:	'true';
FALSE	:	'false';

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
 
fragment DIGIT  : '0'..'9' ;


/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
input returns [Expr e]   	: 	
		ex=expr SEMICOLON {$e = $ex.eout;}; 
expr returns [Expr eout]   	:	
		IF ifexp1=expr THEN ifexp2=expr ELSE ifexp3=expr {$eout= new IfExp($ifexp1.eout, $ifexp2.eout, $ifexp3.eout);}
		| LET VAL letid=ID '=' letex1=expr IN letex2=expr END {$eout= new LetValExp($letid.text, $letex1.eout, $letex2.eout);}
		| LET FUN letfunnameid=ID LEFT_PARENTHESIS letfuninputid=ID RIGHT_PARENTHESIS '=' letfunex1=expr IN letfunex2=expr END 
			{$eout= new LetFunExp($letfunnameid.text, $letfuninputid.text, $letfunex1.eout, $letfunex2.eout);}
		| WHILE whileex1=expr DO whileex2=expr {$eout= new WhileExp($whileex1.eout, $whileex2.eout);}
		| LEFT_CURLY seqex1=expr {$eout= new SeqExp($seqex1.eout);} (SEMICOLON seqex2=expr { ((SeqExp)$eout).addExpr($seqex2.eout); } )* RIGHT_CURLY 
		| NEGATION negexpr=expr {$eout= new NotExp($negexpr.eout);}
		| idvar=ID ASSIGNMENTOP assnexpr=expr { $eout=new AssnExp($idvar.text, $assnexpr.eout); 
					     }
		| relexpr1=relexpr {$eout=$relexpr1.relout;} ;
relexpr returns [Expr relout]
	:	ae1=arithexpr {$relout=$ae1.aeout;} (reloperation=relop ae2=arithexpr {$relout= new BinExp($relout, $ae2.aeout, $reloperation.text);})?;

arithexpr returns [Expr aeout]
	:	t1=term {$aeout=$t1.termout;} (addop=ADDOP t2=term { $aeout= new BinExp($aeout, $t2.termout, $addop.text); })*;
term returns [Expr termout]
	: 
	fc1=factor {$termout=$fc1.fcout;} (op=MULOP fc2=factor { $termout= new BinExp($termout, $fc2.fcout, $op.text);  })*
	;
factor returns [Expr fcout] 
	: 
	NUM {$fcout=new IntConst(Integer.parseInt($NUM.text));} 
	| TRUE {$fcout=new BoolConst(Boolean.valueOf($TRUE.text));}
	| FALSE {$fcout=new BoolConst(Boolean.valueOf($FALSE.text));}
	| ID {$fcout=new VarExp($ID.text);}
	| funid=ID LEFT_PARENTHESIS funexpr=expr RIGHT_PARENTHESIS {$fcout=new AppExp($funid.text, $funexpr.eout);}
	| LEFT_PARENTHESIS ex1=expr { $fcout= $ex1.eout; } RIGHT_PARENTHESIS
	;

 