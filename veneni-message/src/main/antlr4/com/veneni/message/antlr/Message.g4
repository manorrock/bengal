grammar Message;

parse
 : 'object'
 ;

/*
 * skip spaces, tabs, newlines
 */
WS 
 : [ \t\r\n]+ -> skip 
 ;       
