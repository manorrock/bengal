package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class IfTest {

    @Test
    public void testIfControlFlow() throws Exception {
        String source = new String(Files.readAllBytes(Paths.get("src/test/bengal/if.b0")));
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();

        // Verify some tokens
        assertEquals(TokenType.KEYWORD, tokens.get(0).getType());
        assertEquals("if", tokens.get(0).getLexeme());

        assertEquals(TokenType.LPAREN, tokens.get(1).getType());
        assertEquals("(", tokens.get(1).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(2).getType());
        assertEquals("condition", tokens.get(2).getLexeme());

        assertEquals(TokenType.RPAREN, tokens.get(3).getType());
        assertEquals(")", tokens.get(3).getLexeme());

        assertEquals(TokenType.LBRACE, tokens.get(4).getType());
        assertEquals("{", tokens.get(4).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(5).getType());
        assertEquals("doSomething", tokens.get(5).getLexeme());

        assertEquals(TokenType.LPAREN, tokens.get(6).getType());
        assertEquals("(", tokens.get(6).getLexeme());

        assertEquals(TokenType.RPAREN, tokens.get(7).getType());
        assertEquals(")", tokens.get(7).getLexeme());

        assertEquals(TokenType.SEMICOLON, tokens.get(8).getType());
        assertEquals(";", tokens.get(8).getLexeme());

        assertEquals(TokenType.RBRACE, tokens.get(9).getType());
        assertEquals("}", tokens.get(9).getLexeme());

        // Add more assertions as needed to cover all constructs
    }
}
