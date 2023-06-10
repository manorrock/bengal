grammar bengal;

delete_statement: 'delete' WS* ID;
assignment: ID WS* '=' WS* method_call ';';
object_definition: 'object' WS+ ID;
new_instance: 'new' WS+ ID;
method_call: ID '.' ID '()';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
