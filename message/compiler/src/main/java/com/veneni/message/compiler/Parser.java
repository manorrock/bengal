/*
 * Copyright (c) 2002-2020 Veneni.com. All Rights Reserved.
 */
package com.veneni.message.compiler;

import com.veneni.message.antlr.MessageBaseVisitor;
import com.veneni.message.antlr.MessageLexer;
import com.veneni.message.antlr.MessageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * The parser used to get an object tree.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
class Parser extends MessageBaseVisitor {

    /**
     * Visit the 'parse' rule.
     * 
     * @param context the context.
     * @return the object tree.
     */
    @Override
    public Object visitParse(MessageParser.ParseContext context) {
        if (context.booleanLiteral() != null) {
            ParsedBoolean mb = new ParsedBoolean();
            mb.setBoolean(Boolean.parseBoolean(context.booleanLiteral().getText()));
            return mb;
        }
        if (context.nilLiteral() != null) {
            ParsedNil pn = new ParsedNil();
            return pn;
        }
        if (context.methodDeclaration() != null) {
            ParsedMethod parsedMethod = new ParsedMethod(context.methodDeclaration().ID(0).getText());
            return parsedMethod;
        }
        return new ParsedObject(context.objectDeclaration().ID().getText());
    }

    /**
     * Parse the string.
     *
     * @param string the string.
     * @return the object tree.
     */
    public Object parse(String string) {
        MessageLexer lexer = new MessageLexer(CharStreams.fromString(string));
        MessageParser parser = new MessageParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        Object object = visit(tree);
        return object;
    }
}
