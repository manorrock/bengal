grammar Bengal;

eval
    :    (classKeyword | ifKeyword) EOF
    ;

classKeyword
    :   'class'
    ;

ifKeyword
    :   'if'
    ;