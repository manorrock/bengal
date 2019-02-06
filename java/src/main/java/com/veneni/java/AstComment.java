/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.java;

/**
 * An AST comment.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class AstComment {
    
    /**
     * Stores the comment.
     */
    private String comment;
    
    /**
     * Constructor.
     */
    public AstComment() {
        this.comment = "";
    }
    
    /**
     * Constructor.
     * 
     * @param comment the comment. 
     */
    public AstComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * Get the comment.
     * 
     * @return the comment.
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * Set the comment.
     * 
     * @param comment the comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
