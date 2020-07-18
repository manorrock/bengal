grammar Message;

parse
 : booleanLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;
