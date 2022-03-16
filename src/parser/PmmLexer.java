// Generated from C:/Users/ignac/Desktop/Uni/20-21/DLP/PL/DLP-Lenguaje/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

    import ast.*;
    import java.util.*;
    import java.lang.Integer;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, IGNORAR=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, VAR=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "COMENTARIOMULTILINEA", "COMENTARIOUNALINA", 
			"EXPONENTE", "IGNORAR", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"VAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "':'", "';'", "'def'", "'('", "')'", "'{'", "'}'", "'main'", 
			"'int'", "'double'", "'char'", "'struct'", "'['", "']'", "'='", "'if'", 
			"'else'", "'while'", "'print'", "'input'", "'return'", "'.'", "'-'", 
			"'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", 
			"'=='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "IGNORAR", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"VAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0154\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\7\'\u00dc\n\'\f\'\16\'\u00df\13\'\3\'\3\'\3\'\3\'\3(\3(\7(\u00e7"+
		"\n(\f(\16(\u00ea\13(\3(\5(\u00ed\n(\3(\5(\u00f0\n(\3)\3)\5)\u00f4\n)\3"+
		")\6)\u00f7\n)\r)\16)\u00f8\3*\3*\3*\5*\u00fe\n*\3*\3*\3+\3+\3+\7+\u0105"+
		"\n+\f+\16+\u0108\13+\5+\u010a\n+\3,\6,\u010d\n,\r,\16,\u010e\3,\3,\7,"+
		"\u0113\n,\f,\16,\u0116\13,\3,\7,\u0119\n,\f,\16,\u011c\13,\3,\7,\u011f"+
		"\n,\f,\16,\u0122\13,\3,\3,\6,\u0126\n,\r,\16,\u0127\3,\7,\u012b\n,\f,"+
		"\16,\u012e\13,\5,\u0130\n,\3,\5,\u0133\n,\3,\7,\u0136\n,\f,\16,\u0139"+
		"\13,\3,\5,\u013c\n,\3-\3-\3-\6-\u0141\n-\r-\16-\u0142\3-\3-\3-\3-\3-\5"+
		"-\u014a\n-\3-\3-\3.\3.\7.\u0150\n.\f.\16.\u0153\13.\4\u00dd\u00e8\2/\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M\2O\2Q\2S(U)W*Y+[,\3\2\n\3\3\f\f\4\2GGgg\4\2--//\3\2"+
		"\62;\5\2\13\f\17\17\"\"\3\2\63;\5\2C\\aac|\6\2\62;C\\aac|\2\u0168\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13g\3\2\2\2\ri\3\2"+
		"\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25t\3\2\2\2\27x\3\2\2\2\31\177"+
		"\3\2\2\2\33\u0084\3\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2"+
		"\2\2#\u0091\3\2\2\2%\u0094\3\2\2\2\'\u0099\3\2\2\2)\u009f\3\2\2\2+\u00a5"+
		"\3\2\2\2-\u00ab\3\2\2\2/\u00b2\3\2\2\2\61\u00b4\3\2\2\2\63\u00b6\3\2\2"+
		"\2\65\u00b8\3\2\2\2\67\u00ba\3\2\2\29\u00bc\3\2\2\2;\u00be\3\2\2\2=\u00c0"+
		"\3\2\2\2?\u00c2\3\2\2\2A\u00c5\3\2\2\2C\u00c7\3\2\2\2E\u00ca\3\2\2\2G"+
		"\u00cd\3\2\2\2I\u00d0\3\2\2\2K\u00d3\3\2\2\2M\u00d6\3\2\2\2O\u00e4\3\2"+
		"\2\2Q\u00f1\3\2\2\2S\u00fd\3\2\2\2U\u0109\3\2\2\2W\u013b\3\2\2\2Y\u013d"+
		"\3\2\2\2[\u014d\3\2\2\2]^\7.\2\2^\4\3\2\2\2_`\7<\2\2`\6\3\2\2\2ab\7=\2"+
		"\2b\b\3\2\2\2cd\7f\2\2de\7g\2\2ef\7h\2\2f\n\3\2\2\2gh\7*\2\2h\f\3\2\2"+
		"\2ij\7+\2\2j\16\3\2\2\2kl\7}\2\2l\20\3\2\2\2mn\7\177\2\2n\22\3\2\2\2o"+
		"p\7o\2\2pq\7c\2\2qr\7k\2\2rs\7p\2\2s\24\3\2\2\2tu\7k\2\2uv\7p\2\2vw\7"+
		"v\2\2w\26\3\2\2\2xy\7f\2\2yz\7q\2\2z{\7w\2\2{|\7d\2\2|}\7n\2\2}~\7g\2"+
		"\2~\30\3\2\2\2\177\u0080\7e\2\2\u0080\u0081\7j\2\2\u0081\u0082\7c\2\2"+
		"\u0082\u0083\7t\2\2\u0083\32\3\2\2\2\u0084\u0085\7u\2\2\u0085\u0086\7"+
		"v\2\2\u0086\u0087\7t\2\2\u0087\u0088\7w\2\2\u0088\u0089\7e\2\2\u0089\u008a"+
		"\7v\2\2\u008a\34\3\2\2\2\u008b\u008c\7]\2\2\u008c\36\3\2\2\2\u008d\u008e"+
		"\7_\2\2\u008e \3\2\2\2\u008f\u0090\7?\2\2\u0090\"\3\2\2\2\u0091\u0092"+
		"\7k\2\2\u0092\u0093\7h\2\2\u0093$\3\2\2\2\u0094\u0095\7g\2\2\u0095\u0096"+
		"\7n\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098&\3\2\2\2\u0099\u009a"+
		"\7y\2\2\u009a\u009b\7j\2\2\u009b\u009c\7k\2\2\u009c\u009d\7n\2\2\u009d"+
		"\u009e\7g\2\2\u009e(\3\2\2\2\u009f\u00a0\7r\2\2\u00a0\u00a1\7t\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7v\2\2\u00a4*\3\2\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7r\2\2\u00a8\u00a9\7w\2\2"+
		"\u00a9\u00aa\7v\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7g\2"+
		"\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1"+
		"\7p\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7\60\2\2\u00b3\60\3\2\2\2\u00b4\u00b5"+
		"\7/\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\7#\2\2\u00b7\64\3\2\2\2\u00b8\u00b9"+
		"\7,\2\2\u00b9\66\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb8\3\2\2\2\u00bc\u00bd"+
		"\7\'\2\2\u00bd:\3\2\2\2\u00be\u00bf\7-\2\2\u00bf<\3\2\2\2\u00c0\u00c1"+
		"\7@\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3\u00c4\7?\2\2\u00c4@\3"+
		"\2\2\2\u00c5\u00c6\7>\2\2\u00c6B\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9D\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb\u00cc\7?\2\2\u00ccF\3"+
		"\2\2\2\u00cd\u00ce\7?\2\2\u00ce\u00cf\7?\2\2\u00cfH\3\2\2\2\u00d0\u00d1"+
		"\7(\2\2\u00d1\u00d2\7(\2\2\u00d2J\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4\u00d5"+
		"\7~\2\2\u00d5L\3\2\2\2\u00d6\u00d7\7$\2\2\u00d7\u00d8\7$\2\2\u00d8\u00d9"+
		"\7$\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\13\2\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1\u00e2\7$\2\2\u00e2\u00e3"+
		"\7$\2\2\u00e3N\3\2\2\2\u00e4\u00e8\7%\2\2\u00e5\u00e7\13\2\2\2\u00e6\u00e5"+
		"\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\7\17\2\2\u00ec\u00eb\3"+
		"\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\t\2\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0P\3\2\2\2\u00f1\u00f3\t\3\2\2\u00f2\u00f4\t\4\2\2"+
		"\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f7"+
		"\t\5\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9R\3\2\2\2\u00fa\u00fe\t\6\2\2\u00fb\u00fe\5O(\2\u00fc"+
		"\u00fe\5M\'\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\b*\2\2\u0100T\3\2\2\2\u0101\u010a"+
		"\7\62\2\2\u0102\u0106\t\7\2\2\u0103\u0105\t\5\2\2\u0104\u0103\3\2\2\2"+
		"\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102\3\2\2\2\u010a"+
		"V\3\2\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2"+
		"\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0114"+
		"\7\60\2\2\u0111\u0113\t\7\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011a\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0119\t\5\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0130\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011d\u011f\t\5\2\2\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0123\u0125\7\60\2\2\u0124\u0126\t\7\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012c\3\2"+
		"\2\2\u0129\u012b\t\5\2\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012f\u010c\3\2\2\2\u012f\u0120\3\2\2\2\u0130\u0132\3\2\2\2\u0131"+
		"\u0133\5Q)\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u013c\3\2\2"+
		"\2\u0134\u0136\t\5\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013c\5Q)\2\u013b\u012f\3\2\2\2\u013b\u0137\3\2\2\2\u013cX\3\2\2\2\u013d"+
		"\u0149\7)\2\2\u013e\u0140\7^\2\2\u013f\u0141\t\5\2\2\u0140\u013f\3\2\2"+
		"\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u014a"+
		"\3\2\2\2\u0144\u014a\13\2\2\2\u0145\u0146\7^\2\2\u0146\u014a\7p\2\2\u0147"+
		"\u0148\7^\2\2\u0148\u014a\7v\2\2\u0149\u013e\3\2\2\2\u0149\u0144\3\2\2"+
		"\2\u0149\u0145\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c"+
		"\7)\2\2\u014cZ\3\2\2\2\u014d\u0151\t\b\2\2\u014e\u0150\t\t\2\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\\\3\2\2\2\u0153\u0151\3\2\2\2\31\2\u00dd\u00e8\u00ec\u00ef\u00f3\u00f8"+
		"\u00fd\u0106\u0109\u010e\u0114\u011a\u0120\u0127\u012c\u012f\u0132\u0137"+
		"\u013b\u0142\u0149\u0151\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}