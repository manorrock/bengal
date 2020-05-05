/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.message;

import com.veneni.message.antlr.MessageBaseVisitor;
import com.veneni.message.antlr.MessageLexer;
import com.veneni.message.antlr.MessageParser;
import com.veneni.message.runtime.VeneniMessageObject;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * The parser used to get an object tree.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class VeneniMessageParser extends MessageBaseVisitor {

    /**
     * Visit the 'parse' rule.
     * 
     * @param context the context.
     * @return the object tree.
     */
    @Override
    public Object visitParse(MessageParser.ParseContext context) {
        if (context.BooleanLiteral() != null) {
            MessageBoolean mb = new MessageBoolean();
            mb.setBoolean(Boolean.parseBoolean(context.BooleanLiteral().getText()));
            return mb;
        }
        return new VeneniMessageObject(context.ID().getText());
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
