grammar bengal;

delete_statement: 'delete' WS+ ID;
assignment: ID WS* '=' WS* method_call ';';
object_definition: 'object' WS+ ID;
new_instance: 'new' WS+ ID;
method_call: ID '.' ID '()';
method_definition: 'method' WS+ ID '('')' WS* '{' WS* '}';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
