package com.revolhope.deepdev.myjavalibrary.crypto;

public enum Padding 
{
    AES_NoPadding("NoPadding"),
    AES_PKCS5Padding("PKCS7Padding"),
    AES_PKCS7Padding("PKCS7Padding");
    // TODO: Implement more?
    // TODO: RSA paddings
    
    private final String padding;
    
    Padding(final String padding)
    {
        this.padding = padding;
    }
    
    public String getValue()
    {
        return this.padding;
    }
}
