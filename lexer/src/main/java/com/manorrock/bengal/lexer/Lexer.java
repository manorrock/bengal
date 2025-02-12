package com.manorrock.bengal.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class Lexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("class", TokenType.KEYWORD);
        keywords.put("method", TokenType.KEYWORD);
        keywords.put("var", TokenType.KEYWORD);
        keywords.put("if", TokenType.KEYWORD);
        keywords.put("else", TokenType.KEYWORD);
        keywords.put("while", TokenType.KEYWORD);
        keywords.put("for", TokenType.KEYWORD);
        keywords.put("true", TokenType.BOOLEAN);
        keywords.put("false", TokenType.BOOLEAN);
        keywords.put("nil", TokenType.NIL);
        keywords.put("new", TokenType.KEYWORD); 
    }

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(': addToken(TokenType.LPAREN); break;
            case ')': addToken(TokenType.RPAREN); break;
            case '{': addToken(TokenType.LBRACE); break;
            case '}': addToken(TokenType.RBRACE); break;
            case ',': addToken(TokenType.COMMA); break;
            case '.': addToken(TokenType.DOT); break;
            case '-': addToken(TokenType.MINUS); break;
            case '+': addToken(TokenType.PLUS); break;
            case ';': addToken(TokenType.SEMICOLON); break;
            case '*': addToken(TokenType.STAR); break;
            case '!': addToken(match('=') ? TokenType.NOT_EQUAL : TokenType.NOT); break;
            case '=': addToken(match('=') ? TokenType.EQUAL : TokenType.EQUAL); break;
            case '<': addToken(match('=') ? TokenType.LESS_EQUAL : TokenType.LESS); break;
            case '>': addToken(match('=') ? TokenType.GREATER_EQUAL : TokenType.GREATER); break;
            case '/':
                if (match('/')) {
                    while (peek() != '\n' && !isAtEnd()) advance();
                } else {
                    addToken(TokenType.SLASH);
                }
                break;
            case ':':
                if (match('=')) {
                    addToken(TokenType.ASSIGN);
                }
                break;
            case ' ':
            case '\r':
            case '\t':
            case '\n':
                // Skip whitespace
                break;
            case '"': string(); break;
            default:
                if (isDigit(c)) {
                    number();
                } else if (isAlpha(c)) {
                    identifier();
                } else {
                    System.err.println("Unexpected character: " + c);
                }
                break;
        }
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) advance();
        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) type = TokenType.IDENTIFIER;
        addToken(type);
    }

    private void number() {
        while (isDigit(peek())) advance();
        if (peek() == '.' && isDigit(peekNext())) {
            advance();
            while (isDigit(peek())) advance();
        }
        addToken(TokenType.NUMBER, source.substring(start, current));
    }

    private void string() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') line++;
            advance();
        }
        if (isAtEnd()) {
            System.err.println("Unterminated string.");
            return;
        }
        advance();
        String value = source.substring(start + 1, current - 1);
        addToken(TokenType.STRING, value);
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        return source.charAt(current++);
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }
    
    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.err.println("Usage: java Lexer <source> [<output file>]");
            System.exit(1);
        }

        String source = args[0];
        String outputFile = args.length == 2 ? args[1] : null;

        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();

        Gson gson = new Gson();
        String json = gson.toJson(tokens);

        if (outputFile == null) {
            System.out.println(json);
        } else {
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(json);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }
}