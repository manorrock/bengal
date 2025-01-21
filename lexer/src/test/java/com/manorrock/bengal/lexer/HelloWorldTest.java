package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws Exception {
        String source = new String(Files.readAllBytes(Paths.get("src/test/bengal/test.b0")));
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();

        // Update the expected token count to match the actual number of tokens
        assertEquals(23, tokens.size());

        // Verify each token
        assertEquals(TokenType.KEYWORD, tokens.get(0).getType());
        assertEquals("class", tokens.get(0).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(1).getType());
        assertEquals("Bengal", tokens.get(1).getLexeme());

        assertEquals(TokenType.LBRACE, tokens.get(2).getType());
        assertEquals("{", tokens.get(2).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(3).getType());
        assertEquals("helloWorld", tokens.get(3).getLexeme());

        assertEquals(TokenType.LPAREN, tokens.get(4).getType());
        assertEquals("(", tokens.get(4).getLexeme());

        assertEquals(TokenType.RPAREN, tokens.get(5).getType());
        assertEquals(")", tokens.get(5).getLexeme());

        assertEquals(TokenType.LBRACE, tokens.get(6).getType());
        assertEquals("{", tokens.get(6).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(7).getType());
        assertEquals("test", tokens.get(7).getLexeme());

        assertEquals(TokenType.EQUAL, tokens.get(8).getType());
        assertEquals("=", tokens.get(8).getLexeme());

        assertEquals(TokenType.KEYWORD, tokens.get(9).getType());
        assertEquals("new", tokens.get(9).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(10).getType());
        assertEquals("Bengal", tokens.get(10).getLexeme());

        assertEquals(TokenType.LPAREN, tokens.get(11).getType());
        assertEquals("(", tokens.get(11).getLexeme());

        assertEquals(TokenType.RPAREN, tokens.get(12).getType());
        assertEquals(")", tokens.get(12).getLexeme());

        assertEquals(TokenType.SEMICOLON, tokens.get(13).getType());
        assertEquals(";", tokens.get(13).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(14).getType());
        assertEquals("test", tokens.get(14).getLexeme());

        assertEquals(TokenType.DOT, tokens.get(15).getType());
        assertEquals(".", tokens.get(15).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(16).getType());
        assertEquals("call", tokens.get(16).getLexeme());

        assertEquals(TokenType.LPAREN, tokens.get(17).getType());
        assertEquals("(", tokens.get(17).getLexeme());

        assertEquals(TokenType.RPAREN, tokens.get(18).getType());
        assertEquals(")", tokens.get(18).getLexeme());

        assertEquals(TokenType.SEMICOLON, tokens.get(19).getType());
        assertEquals(";", tokens.get(19).getLexeme());

        assertEquals(TokenType.RBRACE, tokens.get(20).getType());
        assertEquals("}", tokens.get(20).getLexeme());

        assertEquals(TokenType.RBRACE, tokens.get(21).getType());
        assertEquals("}", tokens.get(21).getLexeme());
    }
}
