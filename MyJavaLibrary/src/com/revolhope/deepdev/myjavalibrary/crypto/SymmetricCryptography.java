package com.revolhope.deepdev.myjavalibrary.crypto;

import java.io.Serializable;

import javax.crypto.SecretKey;

/**
 * Interface to be implemented for all Symmetric cryptography classes
 */
public interface SymmetricCryptography<T extends Serializable>
{
    public byte[] encrypt(T object);
        
    public T decrypt(byte[] encryptedObject);
    
    public void setIV(byte[] iv);
        
    public void setIV(String ivStringBase64);
    
    public void setKey(byte[] key);
        
    public void setKey(String keyStringBase64);
        
    public void isPasswordBased(boolean isPasswordBased);
    
    public void setPassword(byte[] pwdBytes);
    
    public void setPassword(String pwd);
    
    public void setKeySize(KeySizeEnum eKeySize);
    
    public void setModeAndPadding(Mode mode, Padding padding);
    
    public byte[] getIV();
    
    public String getIVBase64();
    
    public SecretKey getSecretKey();
    
    public String getSecretKeyBase64();
     
    public int getKeySize();
    
    public KeySizeEnum getKeySizeEnum();
    
    public String getPassword();
    
    public byte[] getPasswordBytes();
    
    public Mode getMode();
    
    public Padding getPadding();
    
    public void initialize();
}
