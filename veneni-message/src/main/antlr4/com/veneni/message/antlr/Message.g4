grammar Message;

parse
 : 'object' ID '{' '}'
 ;

BooleanLiteral
 : 'true'
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
