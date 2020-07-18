grammar Message;

parse
 : booleanLiteral 
 | nilLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

nilLiteral
 : 'nil';

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip
 ;
