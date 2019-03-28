/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    CHOOSE              = 5, //Se agrega el choose
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FOR                 = 10,//Se agrega el for
    FROM                = 11,//Se agrega el from
    FUNC		= 12,
    IF			= 13,
    IN			= 14,
    LET			= 15,
    LOOP                = 16,//Se agrega el loop
    OF			= 17,
    PASS                = 18,//Se agrega el pass
    PAR                 = 19,//Se agrega el par
    PRIVATE             = 20,//Se agrega el private
    PROC		= 21,
    RECORD		= 22,
    RECURSIVE           = 23,//Se agrega el recursive
    THEN		= 24,
    TO                  = 25,//Se agrega el to
    TYPE		= 26,
    UNTIL               = 27,//Se agrega el until
    VAR			= 28,
    WHEN                = 29,//Se agrega el pass
    WHILE		= 30,

    // punctuation...
    DOT			= 31,
    COLON		= 32,
    SEMICOLON           = 33,
    COMMA		= 34,
    BECOMES		= 35,
    IS			= 36,
    VERTICALBAR         = 37,
    ASIGNER             = 38,
    DOLAR               = 39,
    DOTDOT              = 40, 
          

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET            = 43,
    RBRACKET            = 44,
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "choose",
    "const",
    "do",
    "else",
    "end",
    "for",
    "from",
    "func",
    "if",
    "in",
    "let",
    "loop",
    "of",
    "pass",
    "par",
    "private",
    "proc",
    "record",
    "recursive",
    "then",
    "to",
    "type",
    "until",
    "var",
    "when",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",
    "::=",
    "$",
    "..",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
