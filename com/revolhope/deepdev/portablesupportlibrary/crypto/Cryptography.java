package com.revolhope.deepdev.portablesupportlibrary.crypto;


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
    
    public SymmetricCipher buildSymmetricCipher(String algorithm)
    {
        SymmetricCipher symCipher = new SymmetricCipher();
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
        private SymmetricCipher(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException
        {
            c = Cipher.getInstance(algorithm);
        }
        
        /**
         * 
         */
        private SymmetricCipher(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException
        {
            c = Cipher.getInstance(algorithm, provider);
        }
        
        /**
         *
         */
        private void build(String algorithm)
        {
            
             c.init(Cipher.ENCRYPT_MODE, key);
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
