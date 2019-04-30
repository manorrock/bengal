/*
 * Copyright (c) 2002-2019 Veneni.com. All Rights Reserved.
 */
package com.veneni.m;

/**
 * A comment in the Veneni-M language.
 * 
 * @author Manfred Riem (mriem@veneni.com)
 */
public class MComment {
    
    /**
     * Stores the comment.
     */
    private String comment;
    
    /**
     * Constructor.
     */
    public MComment() {
        this.comment = "";
    }
    
    /**
     * Constructor.
     * 
     * @param comment the comment. 
     */
    public MComment(String comment) {
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
