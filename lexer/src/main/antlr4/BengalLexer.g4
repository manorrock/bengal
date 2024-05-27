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
// STRING_LITERAL      : '\"' (STRING_ESCAPE | ~[\"\\\\\\r\\n])* '\"';
FLOAT_LITERAL       : DIGIT+ ('.' DIGIT+)? ;
INTEGER_LITERAL     : [0-9]+;
IDENTIFIER          : [A-Za-z0-9_]+;

//fragment STRING_ESCAPE: '\\\\\"' | '\\\\\\\\';
fragment DIGIT: [0-9];
