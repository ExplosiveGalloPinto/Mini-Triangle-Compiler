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
  
  /*Añadir las palabras reservadas choose, for, from, loop, par, pass, private, recursive, to, until, when

    Añadir los símbolos |, ::=, $, ..
     Eliminar la palabra reservada begin. */
  
  

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // SE AGREGARON LOS NUEVOS TOKENS
    ARRAY		= 4,//BORRE EL BEGIN
    //BEGIN		= 5,
    CHOOSE              = 5,//NUEVA
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FOR                 = 10,//NUEVA
    FROM                = 11,//NUEVA
    FUNC		= 12,
    IF			= 13,
    IN			= 14,
    LET			= 15,
    LOOP                = 16,//NUEVA
    OF			= 17,
    PACKAGE             = 18,//NUEVA
    PAR                 = 19,//NUEVA
    PASS                = 20,//NUEVA
    PRIVATE             = 21,//NUEVA
    PROC		= 22,
    RECORD		= 23,
    RECURSIVE           = 24,//NUEVA
    THEN		= 25,
    TO                  = 26,//NUEVA
    TYPE		= 27,
    UNTIL               = 28,//NUEVA
    VAR			= 29,
    WHEN                = 30,//NUEVA
    WHILE		= 31,

    // punctuation...
    VERTICAL            = 32,  //NUEVA
    DOUBLEBECOMES       = 33,  //NUEVA
    DOLAR               = 34,   //NUEVA
    DOUBLEDOT           = 35,   //NUEVA
          
    DOT			= 36,
    COLON		= 37,
    SEMICOLON           = 38,
    COMMA		= 39,
    BECOMES		= 40,
    IS			= 41,

    // brackets...
    LPAREN		= 42,
    RPAREN		= 43,
    LBRACKET	= 44,
    RBRACKET	= 45,
    LCURLY		= 46,
    RCURLY		= 47,

    // special tokens...
    EOT			= 48,
    ERROR		= 49;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",  //4
    //"begin",
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
    "package",
    "par",
    "pass",
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
    "while",  //31
    "|",    //Nueva
    "::=",  //Nueva
    "$",    //Nueva
    "..",   //Nueva
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
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
