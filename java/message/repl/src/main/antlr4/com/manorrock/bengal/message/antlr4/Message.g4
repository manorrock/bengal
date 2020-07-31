grammar Message;

parse
 : objectDeclaration
 | booleanLiteral 
 | floatLiteral 
 | integerLiteral
 | nilLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

floatLiteral
 : FLOAT
 ;

integerLiteral
 : INTEGER
 ;

nilLiteral
 : 'nil';

objectDeclaration
 : 'object' ID '{'
     methodDeclaration*
   '}'
 ;

methodDeclaration
 : 'method' ID '(' ')' '{' '}'
 ;

/*
 * parse an identifier
 */
ID
 : [a-zA-Z_]+
 ;

INTEGER
 : ('0' .. '9')+
 ;

FLOAT
   : INTEGER+ '.' INTEGER+ SCALE?
   ;

SCALE
   : ('e' | 'E') ('+' | '-')? INTEGER+
   ;

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;

