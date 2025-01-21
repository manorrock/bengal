package com.manorrock.bengal.lexer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ControlFlowTest {

    @Disabled
    @Test
    public void testControlFlowExample() throws Exception {
        String source = new String(Files.readAllBytes(Paths.get("src/test/bengal/controlflow.b0")));
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();

        // Debugging: Print all tokens
        for (Token token : tokens) {
            System.out.println(token);
        }

        // Verify some tokens
        assertEquals(TokenType.KEYWORD, tokens.get(0).getType());
        assertEquals("class", tokens.get(0).getLexeme());

        assertEquals(TokenType.IDENTIFIER, tokens.get(1).getType());
        assertEquals("ControlFlowExample", tokens.get(1).getLexeme());

        assertEquals(TokenType.KEYWORD, tokens.get(2).getType());
        assertEquals("main", tokens.get(2).getLexeme());
    }
}