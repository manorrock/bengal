grammar Message;

parse
 : booleanLiteral
 | objectDeclaration
 | methodDeclaration
 | ifDeclaration
 | nilLiteral
 ;

booleanLiteral
 : 'true'
 | 'false'
 ;

nilLiteral
 : 'nil'
 ;

stringLiteral
 : '"' (.)*? '"'
 ;

objectDeclaration
 : 'object' ID '{' '}'
 ;

ifDeclaration
 : 'if' '{' '}'
 ;

methodDeclaration
 : 'method' ID '(' ID? ')' '{' '}'
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
