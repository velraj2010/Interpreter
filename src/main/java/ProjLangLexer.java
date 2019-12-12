// $ANTLR 3.5.1 /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g 2019-12-11 14:57:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ProjLangLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADDOP=4;
	public static final int ASSIGNMENTOP=5;
	public static final int COLON=6;
	public static final int DIGIT=7;
	public static final int DO=8;
	public static final int ELSE=9;
	public static final int END=10;
	public static final int EQ=11;
	public static final int FALSE=12;
	public static final int FUN=13;
	public static final int ID=14;
	public static final int IF=15;
	public static final int IN=16;
	public static final int LEFT_CURLY=17;
	public static final int LEFT_PARENTHESIS=18;
	public static final int LET=19;
	public static final int LT=20;
	public static final int MULOP=21;
	public static final int NEGATION=22;
	public static final int NUM=23;
	public static final int RIGHT_CURLY=24;
	public static final int RIGHT_PARENTHESIS=25;
	public static final int SEMICOLON=26;
	public static final int THEN=27;
	public static final int TRUE=28;
	public static final int VAL=29;
	public static final int WHILE=30;
	public static final int WHITESPACE=31;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ProjLangLexer() {} 
	public ProjLangLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ProjLangLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g"; }

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:12:6: ( ( '0' .. '9' )+ )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:12:8: ( '0' .. '9' )+
			{
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:12:8: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "ADDOP"
	public final void mADDOP() throws RecognitionException {
		try {
			int _type = ADDOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:14:7: ( ( '+' | '-' | '|' ) )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
			{
			if ( input.LA(1)=='+'||input.LA(1)=='-'||input.LA(1)=='|' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADDOP"

	// $ANTLR start "MULOP"
	public final void mMULOP() throws RecognitionException {
		try {
			int _type = MULOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:15:7: ( ( '*' | '/' | '&' ) )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
			{
			if ( input.LA(1)=='&'||input.LA(1)=='*'||input.LA(1)=='/' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULOP"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:16:4: ( '=' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:16:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:17:4: ( '<' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:17:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:18:8: ( ':' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:18:10: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:20:2: ( ';' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:20:4: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "ASSIGNMENTOP"
	public final void mASSIGNMENTOP() throws RecognitionException {
		try {
			int _type = ASSIGNMENTOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:22:2: ( COLON EQ )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:22:4: COLON EQ
			{
			mCOLON(); 

			mEQ(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGNMENTOP"

	// $ANTLR start "NEGATION"
	public final void mNEGATION() throws RecognitionException {
		try {
			int _type = NEGATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:25:2: ( '!' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:25:4: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEGATION"

	// $ANTLR start "LEFT_PARENTHESIS"
	public final void mLEFT_PARENTHESIS() throws RecognitionException {
		try {
			int _type = LEFT_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:27:2: ( '(' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:27:4: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_PARENTHESIS"

	// $ANTLR start "RIGHT_PARENTHESIS"
	public final void mRIGHT_PARENTHESIS() throws RecognitionException {
		try {
			int _type = RIGHT_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:29:2: ( ')' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:29:4: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_PARENTHESIS"

	// $ANTLR start "LEFT_CURLY"
	public final void mLEFT_CURLY() throws RecognitionException {
		try {
			int _type = LEFT_CURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:31:2: ( '{' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:31:4: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_CURLY"

	// $ANTLR start "RIGHT_CURLY"
	public final void mRIGHT_CURLY() throws RecognitionException {
		try {
			int _type = RIGHT_CURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:33:2: ( '}' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:33:4: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_CURLY"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:34:6: ( 'then' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:34:8: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:35:4: ( 'if' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:35:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:36:6: ( 'else' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:36:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:37:5: ( 'let' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:37:7: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "VAL"
	public final void mVAL() throws RecognitionException {
		try {
			int _type = VAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:38:5: ( 'val' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:38:7: 'val'
			{
			match("val"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAL"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:39:4: ( 'in' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:39:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:40:5: ( 'end' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:40:7: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:41:5: ( 'fun' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:41:7: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:42:7: ( 'while' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:42:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:43:4: ( 'do' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:43:6: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:45:6: ( 'true' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:45:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:46:7: ( 'false' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:46:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:48:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:48:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:48:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:51:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:51:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:51:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||(LA3_0 >= '\f' && LA3_0 <= '\r')||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:53:17: ( '0' .. '9' )
			// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:8: ( NUM | ADDOP | MULOP | EQ | LT | COLON | SEMICOLON | ASSIGNMENTOP | NEGATION | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | LEFT_CURLY | RIGHT_CURLY | THEN | IF | ELSE | LET | VAL | IN | END | FUN | WHILE | DO | TRUE | FALSE | ID | WHITESPACE )
		int alt4=27;
		alt4 = dfa4.predict(input);
		switch (alt4) {
			case 1 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:10: NUM
				{
				mNUM(); 

				}
				break;
			case 2 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:14: ADDOP
				{
				mADDOP(); 

				}
				break;
			case 3 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:20: MULOP
				{
				mMULOP(); 

				}
				break;
			case 4 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:26: EQ
				{
				mEQ(); 

				}
				break;
			case 5 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:29: LT
				{
				mLT(); 

				}
				break;
			case 6 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:32: COLON
				{
				mCOLON(); 

				}
				break;
			case 7 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:38: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 8 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:48: ASSIGNMENTOP
				{
				mASSIGNMENTOP(); 

				}
				break;
			case 9 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:61: NEGATION
				{
				mNEGATION(); 

				}
				break;
			case 10 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:70: LEFT_PARENTHESIS
				{
				mLEFT_PARENTHESIS(); 

				}
				break;
			case 11 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:87: RIGHT_PARENTHESIS
				{
				mRIGHT_PARENTHESIS(); 

				}
				break;
			case 12 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:105: LEFT_CURLY
				{
				mLEFT_CURLY(); 

				}
				break;
			case 13 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:116: RIGHT_CURLY
				{
				mRIGHT_CURLY(); 

				}
				break;
			case 14 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:128: THEN
				{
				mTHEN(); 

				}
				break;
			case 15 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:133: IF
				{
				mIF(); 

				}
				break;
			case 16 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:136: ELSE
				{
				mELSE(); 

				}
				break;
			case 17 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:141: LET
				{
				mLET(); 

				}
				break;
			case 18 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:145: VAL
				{
				mVAL(); 

				}
				break;
			case 19 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:149: IN
				{
				mIN(); 

				}
				break;
			case 20 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:152: END
				{
				mEND(); 

				}
				break;
			case 21 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:156: FUN
				{
				mFUN(); 

				}
				break;
			case 22 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:160: WHILE
				{
				mWHILE(); 

				}
				break;
			case 23 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:166: DO
				{
				mDO(); 

				}
				break;
			case 24 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:169: TRUE
				{
				mTRUE(); 

				}
				break;
			case 25 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:174: FALSE
				{
				mFALSE(); 

				}
				break;
			case 26 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:180: ID
				{
				mID(); 

				}
				break;
			case 27 :
				// /home/velraj/0others/Villanova/4_8310_Programming_Languages/Project2/ProjLang.g:1:183: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\6\uffff\1\27\6\uffff\10\25\4\uffff\2\25\1\47\1\50\7\25\1\60\2\25\2\uffff"+
		"\1\25\1\64\1\65\1\66\1\67\2\25\1\uffff\1\72\1\73\1\74\4\uffff\2\25\3\uffff"+
		"\1\77\1\100\2\uffff";
	static final String DFA4_eofS =
		"\101\uffff";
	static final String DFA4_minS =
		"\1\11\5\uffff\1\75\6\uffff\1\150\1\146\1\154\1\145\2\141\1\150\1\157\4"+
		"\uffff\1\145\1\165\2\60\1\163\1\144\1\164\1\154\1\156\1\154\1\151\1\60"+
		"\1\156\1\145\2\uffff\1\145\4\60\1\163\1\154\1\uffff\3\60\4\uffff\2\145"+
		"\3\uffff\2\60\2\uffff";
	static final String DFA4_maxS =
		"\1\175\5\uffff\1\75\6\uffff\1\162\2\156\1\145\1\141\1\165\1\150\1\157"+
		"\4\uffff\1\145\1\165\2\172\1\163\1\144\1\164\1\154\1\156\1\154\1\151\1"+
		"\172\1\156\1\145\2\uffff\1\145\4\172\1\163\1\154\1\uffff\3\172\4\uffff"+
		"\2\145\3\uffff\2\172\2\uffff";
	static final String DFA4_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\11\1\12\1\13\1\14\1\15\10\uffff"+
		"\1\32\1\33\1\6\1\10\16\uffff\1\17\1\23\7\uffff\1\27\3\uffff\1\24\1\21"+
		"\1\22\1\25\2\uffff\1\16\1\30\1\20\2\uffff\1\31\1\26";
	static final String DFA4_specialS =
		"\101\uffff}>";
	static final String[] DFA4_transitionS = {
			"\2\26\1\uffff\2\26\22\uffff\1\26\1\10\4\uffff\1\3\1\uffff\1\11\1\12\1"+
			"\3\1\2\1\uffff\1\2\1\uffff\1\3\12\1\1\6\1\7\1\5\1\4\3\uffff\32\25\4\uffff"+
			"\1\25\1\uffff\3\25\1\24\1\17\1\22\2\25\1\16\2\25\1\20\7\25\1\15\1\25"+
			"\1\21\1\23\3\25\1\13\1\2\1\14",
			"",
			"",
			"",
			"",
			"",
			"\1\30",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\31\11\uffff\1\32",
			"\1\33\7\uffff\1\34",
			"\1\35\1\uffff\1\36",
			"\1\37",
			"\1\40",
			"\1\42\23\uffff\1\41",
			"\1\43",
			"\1\44",
			"",
			"",
			"",
			"",
			"\1\45",
			"\1\46",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\61",
			"\1\62",
			"",
			"",
			"\1\63",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\70",
			"\1\71",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"",
			"",
			"",
			"\1\75",
			"\1\76",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( NUM | ADDOP | MULOP | EQ | LT | COLON | SEMICOLON | ASSIGNMENTOP | NEGATION | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | LEFT_CURLY | RIGHT_CURLY | THEN | IF | ELSE | LET | VAL | IN | END | FUN | WHILE | DO | TRUE | FALSE | ID | WHITESPACE );";
		}
	}

}
