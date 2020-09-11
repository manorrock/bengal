grammar Math;

parse
 : booleanLiteral
 | integerLiteral
 | plusExpression
 ;

plusExpression
 : integerLiteral '+' plusExpression
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
