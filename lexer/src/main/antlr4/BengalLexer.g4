lexer grammar BengalLexer;

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

CHARACTER_LITERAL   : '\'' ( ~'\'' | '\\' . ) '\'';
STRING_LITERAL      : '\"' (STRING_ESCAPE | ~[\"\\\\\\r\\n])* '\"';
IDENTIFIER          : [A-Za-z0-9_]+;

fragment STRING_ESCAPE: '\\\\\"' | '\\\\\\\\';
