package com.revolhope.deepdev.myjavalibrary.crypto;

import java.io.Serializable;
import java.nio.charset.Charset;

import javax.crypto.SecretKey;

import com.revolhope.deepdev.myjavalibrary.util.Base64Util;

public class AesCryptography<T extends Serializable> implements SymmetricCryptography<T>
{
	
	private Cipher cipher;
	private KeyGenerator keyGen;
	private SecretKeySpec spec;
	private SecretKey key;
	private byte[] IV;
	
	private int keySize = -1;
	private KeySizeEnum keySizeEnum;
	
	private Mode mode;
	private Padding padding;
	
	private String pwd;
	private byte[] pwdBytes;
	
	private boolean isPasswordBased = false;
	private boolean isInitialized = false;
	
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
		this.pwd = pwd;
		this.pwdBytes = Base64Util.getBytes(pwd, "UTF-8");
		this.isPasswordBased = true;
	}
	
	@Override
	public void setKeySize(KeySizeEnum eKeySize) 
	{
		this.keySizeEnum = eKeySize;
		this.keySize = eKeySize.getValue();
	}
	
	@Override
	public void setModeAndPadding(Mode mode, Padding padding) 
	{
		this.mode = mode.getValue();
		this.padding = padding.getValue();
	}
	
	@Override
	public byte[] getIV() 
	{
		return this.IV;
	}
	
	@Override
	public String getIVBase64() 
	{
		return Base64Util.to64String(this.IV);
	}
	
	@Override
	public SecretKey getSecretKey() 
	{
		return this.key;
	}
	
	@Override
	public String getSecretKeyBase64() 
	{
		return Base64Util.to64String(this.key.getEncoded());
	}
	
	@Override
	public int getKeySize() 
	{
		return this.keySize;
	}
	
	@Override
	public KeySizeEnum getKeySizeEnum() 
	{
		return this.keySizeEnum;
	}
	
	@Override
	public String getPassword() 
	{
		return this.pwd;
	}
	
	@Override
	public byte[] getPasswordBytes() 
	{
		return this.pwdBytes;
	}
	
	@Override
	public Mode getMode() 
	{
		return this.mode;
	}
	
	/**
	 * TODO
	 */
	@Override
	public Padding getPadding() 
	{
		return this.padding;
	}
	
	/**
	 * TODO
	 */
	@Override
	public void initialize() throws Exception
	{
		if (mode == null || padding == null || key == null)
		{
			throw new Exception("Not properly initialized, check documentation");
		}
		String transformation = "AES/" + mode.getValue() + "/" + padding.getValue();
		cipher = Cipher.getInstance(transformation);
		isInitialized = true;
	}
	
	/**
	 * TODO
	 */
	public void generateKey()
	{
		if (keySize == -1) throw new Exception("Key size not set, check documentation");
		keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(keySize);
		key = keyGen.generateKey();
	}
	
	/**
	 * TODO
	 */
	public void generateKeyPwdBased()
	{
		if (keySize == -1 || pwd == null) throw new Exception("Key size or password not set, check documentation");
		
	}
}
