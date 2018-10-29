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
    
    public SymmetricCipher buildSymmetricCipher(transformation, int mode, Key key)
    {
        SymmetricCipher symCipher = new SymmetricCipher(algorithm, mode, key);
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
        private SymmetricCipher(@NonNull Transformation transformation) throws NoSuchAlgorithmException, NoSuchPaddingException
        {
            c = Cipher.getInstance(transformation.toString());
        }
        
        /**
         * 
         */
        private SymmetricCipher(@NonNull Transformation transformation,@NonNull String provider) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException
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
