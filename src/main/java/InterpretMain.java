import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.IOException;
import java.io.InputStream;

public class InterpretMain {
    public static void main(String[] args) throws Exception {
		try {
			System.setErr(System.out);
			Value value = evaluateExprWithParser(System.in);
			System.out.println("Value is : " + value);
		} catch (EvalError error) {
			System.out.println(error.getMessage());
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
    }

    public static Value evaluateExprWithoutParser(Expr expr, Env env) throws EvalError {
    	return expr.eval(env);
	}

	public static Value evaluateExprWithParser(InputStream inputStream)
			throws EvalError, IOException, RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(inputStream);
		ProjLangLexer lexer = new ProjLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ProjLangParser parser = new ProjLangParser(tokens);
		Expr expr = parser.input().e;
		Env env = new EnvImp();
		if(expr == null) {
			throw new EvalError(EvalError.EXPRESSION_INVALID);
		}
		return expr.eval(env);
	}
}
