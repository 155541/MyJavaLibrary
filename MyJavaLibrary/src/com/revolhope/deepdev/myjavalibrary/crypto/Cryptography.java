package com.revolhope.deepdev.myjavalibrary.crypto;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Cryptography
{
    private static Cryptography INSTANCE;
    
    private Cryptography()
    {
        
    }
    
    public static synchronized Cryptography GetInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Cryptography();
        }
        return INSTANCE;
    }
    
    public SymmetricCipher buildSymmetricCipher(Transformation transformation, int mode, Key key)
    {
        SymmetricCipher symCipher = new SymmetricCipher(transformation, mode, key);
        return symCipher;
    }
    
    public SymmetricCipher buildSymmetricCipher(String algorithm, String provider)
    {
        SymmetricCipher symCipher = new SymmetricCipher(algorithm, provider);
        return symCipher;
    }
    
    /**
     *
     */
    public class SymmetricCipher
    {
        private Cipher c;
        
        /**
         * 
         */
        private SymmetricCipher(Transformation transformation) throws NoSuchAlgorithmException, NoSuchPaddingException
        {
            c = Cipher.getInstance(transformation.toString());
        }
        
        /**
         * 
         */
        private SymmetricCipher(Transformation transformation, String provider) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException
        {
            c = Cipher.getInstance(transformation.toString(), provider);
        }
    }
    
    /**
     *
     */
    public class AsymmetricCipher
    {
        private AsymmetricCipher(){}
    }
}
