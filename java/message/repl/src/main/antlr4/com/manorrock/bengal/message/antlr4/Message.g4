grammar Message;

parse
 : objectDeclaration
 | booleanLiteral 
 | integerLiteral
 | nilLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

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

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;

