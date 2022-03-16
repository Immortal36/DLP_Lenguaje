package parser;

import ast.Char;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		if(!str.startsWith("'\\"))
			return str.charAt(1);
		else {
			if(str.equals("'\\t'"))
				return '\t';

			if(str.equals("'\\n'"))
				return '\n';

			int ascii = Integer.parseInt(str.replaceAll("\\D+", ""));
			return (char)ascii;
		}

	}
}
