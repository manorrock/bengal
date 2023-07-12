grammar Bengal;

@header {
    package icu.bengal.parser;
}

source: statement;
statement: assignment || boolean_expression || delete_statement || class_definition;
assignment: ID WS* '=' WS* method_call ';';
boolean_false: 'false';
boolean_true: 'true';
boolean_expression: boolean_false || boolean_true;
delete_statement: 'delete' WS* ID;
if_then_else_statement: 'if' WS* '(' WS* boolean_expression WS* ')' WS* 'then' WS* '{' '}' (WS* 'else' WS* '{' '}')?;
class_definition: 'class' WS* ID '{' WS* '}';
new_instance: 'new' WS+ ID;
method_call: ID '.' ID '()';
method_definition: 'method' WS+ ID '('')' WS* '{' WS* '}';
while_statement: 'while' WS* '(' boolean_expression ')' WS* '{''}';
do_while_statement: 'do' WS* '{' '}' WS* 'while' WS* '(' boolean_expression ')' WS*;
for_statement: 'for' WS* '(' WS* ';' WS* boolean_expression WS* ';' WS* ')' '{' '}';
    
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;
