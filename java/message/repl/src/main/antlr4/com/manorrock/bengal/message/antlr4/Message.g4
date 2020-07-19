grammar Message;

parse
 : objectDeclaration
 | booleanLiteral 
 | nilLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

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

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;
