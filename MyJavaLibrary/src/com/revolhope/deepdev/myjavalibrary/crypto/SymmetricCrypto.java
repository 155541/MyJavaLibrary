/**
     *
     */
    public class SymmetricCryptography
    {
        private Cipher c;
        private byte[] IV;
        private byte[] key;
        private String pwd;
        
        
        SymmetricCrypto()
        {
        }
        
        
        /**
         * 
         */
        private SymmetricCrypto(Transformation transformation) throws NoSuchAlgorithmException, NoSuchPaddingException
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
        
        public void setIV();
        
        public void setKey();
        
        public void setPassword();
        
        public void encrypt(){}
        
        public void decrypt(){}
        
        public void getIV();
        
        public void getKey();
    }
