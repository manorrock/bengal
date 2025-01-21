package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ClassMethodsTest {

    @Disabled
    @Test
    public void testClassMethods() throws Exception {
        String source = new String(Files.readAllBytes(Paths.get("src/test/bengal/classmethods.b0")));
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();

        // Verify some tokens
        assertEquals(TokenType.KEYWORD, tokens.get(0).getType());
        assertEquals("class", tokens.get(0).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(1).getType());
        assertEquals("MyClass", tokens.get(1).getLexeme());

        assertEquals(TokenType.KEYWORD, tokens.get(2).getType());
        assertEquals("var", tokens.get(2).getLexeme());

        // Add more assertions as needed to cover all constructs
    }
}