grammar bengal;

object_definition: 'object' ID;
method_call: ID '.' ID '()';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
