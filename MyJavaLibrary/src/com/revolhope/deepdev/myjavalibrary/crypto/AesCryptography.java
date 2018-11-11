package com.revolhope.deepdev.myjavalibrary.crypto;

import java.io.Serializable;

import javax.crypto.SecretKey;

public class AesCryptography<T extends Serializable> implements SymmetricCryptography<T>
{
  
	
	
	private AesCryptography()
	{}
	
	@Override
	public byte[] encrypt(T object) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T decrypt(byte[] encryptedObject) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setIV(byte[] iv) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setIV(String ivStringBase64) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setKey(byte[] key) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setKey(String keyStringBase64) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void isPasswordBased(boolean isPasswordBased) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPassword(byte[] pwdBytes) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPassword(String pwd) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setKeySize(KeySizeEnum eKeySize) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setModeAndPadding(Mode mode, Padding padding) 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public byte[] getIV() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getIVBase64() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SecretKey getSecretKey() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getSecretKeyBase64() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getKeySize() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public KeySizeEnum getKeySizeEnum() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public byte[] getPasswordBytes() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Mode getMode() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Padding getPadding() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void initialize() 
	{
		// TODO Auto-generated method stub
		
	}
}
