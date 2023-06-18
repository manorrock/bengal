grammar bengal;

boolean_expression: 'true' || 'false';
assignment: ID WS* '=' WS* method_call ';';
delete_statement: 'delete' WS+ ID;
object_definition: 'object' WS+ ID '{' WS* '}';
new_instance: 'new' WS+ ID;
method_call: ID '.' ID '()';
method_definition: 'method' WS+ ID '('')' WS* '{' WS* '}';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
