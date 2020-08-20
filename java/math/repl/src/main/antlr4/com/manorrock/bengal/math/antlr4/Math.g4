grammar Math;

parse
 : booleanLiteral
 | integerLiteral
 ;

booleanLiteral
 : 'false' 
 | 'true';

integerLiteral
 : INTEGER
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
