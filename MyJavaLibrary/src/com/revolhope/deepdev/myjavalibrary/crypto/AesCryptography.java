package com.revolhope.deepdev.myjavalibrary.crypto;

import java.io.Serializable;
import java.nio.charset.Charset;

import javax.crypto.SecretKey;

import com.revolhope.deepdev.myjavalibrary.util.Base64Util;

public class AesCryptography<T extends Serializable> implements SymmetricCryptography<T>
{
  
	private SecretKey key;
	private int keySize;
	
	private Mode mode;
	private Padding padding;
	
	private byte[] pwd;
	
	private boolean isPasswordBased = false;
	
	
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
	public boolean isPasswordBased() 
	{
		return this.isPasswordBased;
	}
	
	@Override
	public void setPassword(byte[] pwdBytes) 
	{
		this.pwd = pwdBytes;
		this.isPasswordBased = true;
	}
	
	@Override
	public void setPassword(String pwd) 
	{
		this.pwd = Base64Util.getBytes(pwd, "UTF-8");
		this.isPasswordBased = true;
	}
	
	@Override
	public void setKeySize(KeySizeEnum eKeySize) 
	{
		this.keySize = eKeySize;
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
