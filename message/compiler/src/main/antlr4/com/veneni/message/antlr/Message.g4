grammar Message;

parse
 : BooleanLiteral
 | 'object' ID '{' '}'
 ;

BooleanLiteral
 : 'true'
 | 'false'
 ;

StringLiteral
 : '"' (.)* '"'
 ;

methodDeclaration
 : 'method' ID '{' '}'
 ;

/*
 * parse an identifier
 */
ID
 : [a-zA-Z_]+
 ;

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;
