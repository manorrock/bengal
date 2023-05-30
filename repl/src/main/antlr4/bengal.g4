grammar bengal;

object: 'object' ID;
methodcall: ID '.' ID '()';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
