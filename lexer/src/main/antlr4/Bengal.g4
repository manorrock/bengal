grammar Bengal;

eval
    :    (classKeyword | ifKeyword | leftCurly ) EOF
    ;

classKeyword
    :   'class'
    ;

ifKeyword
    :   'if'
    ;

leftCurly
    : '{'
    ;