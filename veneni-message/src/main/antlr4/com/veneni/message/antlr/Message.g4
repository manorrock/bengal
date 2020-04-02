grammar Message;

parse
 : 'object' ID
 ;

/*
 *
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
