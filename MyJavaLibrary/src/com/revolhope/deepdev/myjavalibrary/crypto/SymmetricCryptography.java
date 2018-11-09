/**
     *
     */
    public class SymmetricCryptography
    {
        private KeyGenerator keyGenerator;
        
        private Cipher c;
        private byte[] IV;
        
        private SecretKey key;
        private byte[] keyBytes;
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
        
        public String generatePassword()
        {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            password = Base64.getEncoder().encodeToString(keyGen.generateKey().getEncoded());
        }
        
        
        
        /**
         * Method to generate and set the secret key.
         * Param keySize Key bit size
         * Param algorithm Algorithm, i.e: AES, DES, etc.
         * return SecretKet generated
         * throws 
         */
        public SecretKey generateKey(int keySize, Algorithm algorithm)
        {
            keyGenerator = KeyGenerator.getInstance(algorithm.toString());
            keyGenerator.init(keySize, new SecureRandom());
            this.key = keyGenerator.generateKey();
            return this.key;
        }
        
        /**
         * Method to generate and set the secret key.
         * Param keySize Key bit size
         * Param algorithm Algorithm enum, i.e: AES, DES, etc.
         * Param password String password
         * return SecretKet generated
         * throws 
         */
        public void generateKey(int keySize, Algorithm algorithm, String password)
        {
            
        }
    }
