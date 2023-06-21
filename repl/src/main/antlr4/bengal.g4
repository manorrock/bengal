grammar bengal;

assignment: ID WS* '=' WS* method_call ';';
boolean_false: 'false';
boolean_true: 'true';
boolean_expression: boolean_false || boolean_true;
delete_statement: 'delete' WS+ ID;
if_then_statement: 'if' WS* '(' WS* boolean_expression WS* ')' WS* 'then' WS* '{' '}';
object_definition: 'object' WS+ ID '{' WS* '}';
new_instance: 'new' WS+ ID;
method_call: ID '.' ID '()';
method_definition: 'method' WS+ ID '('')' WS* '{' WS* '}';
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
