package com.martin.portfolio.security;

public enum SecurityConstant {
    TOKEN_PREFIX("Bearer "),
    HEADER_AUTHORIZATION_KEY("Authorization");

    public final String label;

    private SecurityConstant(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

}
