lexer grammar BengalLexer;

@header {
    package com.manorrock.bengal.lexer.antlr4;
}

KEYWORD_CLASS       : 'class';
KEYWORD_IF          : 'if';
KEYWORD_NEW         : 'new';
KEYWORD_DELETE      : 'delete';
KEYWORD_TRUE        : 'true';
KEYWORD_FALSE       : 'false';
KEYWORD_NIL         : 'nil';

LEFT_CURLY          : '{';
RIGHT_CURLY         : '}';
SEMI_COLON          : ';';
DOT                 : '.';
LEFT_PARENTHESIS    : '(';
RIGHT_PARENTHESIS   : ')';
ASSIGNMENT_OPERATOR : '=';

CHARACTER_LITERAL   : '\'' [\\u0000-\\u{10FFF}] '\'';
STRING_LITERAL      : '"' (ESC | ~["\\\\\\r\\n])* '"';
FLOAT_LITERAL       : DIGIT+ ('.' DIGIT+)? ;
INTEGER_LITERAL     : [0-9]+;
IDENTIFIER          : [A-Za-z0-9_]+;

fragment ESC : '\\\\' (['"\\\\bfnrt] | UNICODE | OCTAL);
fragment UNICODE : 'u' HEX HEX HEX HEX;
fragment OCTAL : [0-3]? [0-7]? [0-7];
fragment HEX : [0-9a-fA-F];
fragment DIGIT: [0-9];
